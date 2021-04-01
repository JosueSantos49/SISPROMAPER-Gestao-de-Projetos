<script id="code">
  // These parameters need to be set before defining the templates.
  var MINLENGTH = 200;  // this controls the minimum length of any swimlane
  var MINBREADTH = 100;  // this controls the minimum breadth of any non-collapsed swimlane
  var groupColors = ['#E1F5FE', '#B3E5FC', '#81D4FA', '#4FC3F7', '#29B6F6', '#03A9F4', '#039BE5', '#0288D1', '#0277BD', '#01579B'];
  var noteColors = ['#FF8A80', '#C5E1A5', '#FFF176', '#CFD8DC', '#FFFFFF'];


  // some shared functions

  // this is called after nodes have been moved
  function relayoutDiagram() {
    myDiagram.selection.each(function(n) { n.invalidateLayout(); });
    myDiagram.layoutDiagram();
  }

  // compute the minimum size of the whole diagram needed to hold all of the Lane Groups
  function computeMinPoolSize() {
    var len = MINLENGTH;
    myDiagram.findTopLevelGroups().each(function(lane) {
      var holder = lane.placeholder;
      if (holder !== null) {
        var sz = holder.actualBounds;
        len = Math.max(len, sz.height);
      }
      var box = lane.selectionObject;
      // naturalBounds instead of actualBounds to disregard the shape's stroke width
      len = Math.max(len, box.naturalBounds.height);
    });
    return new go.Size(NaN, len);
  }

  // compute the minimum size for a particular Lane Group
  function computeLaneSize(lane) {
    // assert(lane instanceof go.Group);
    var sz = computeMinLaneSize(lane);
    if (lane.isSubGraphExpanded) {
      var holder = lane.placeholder;
      if (holder !== null) {
        var hsz = holder.actualBounds;
        sz.width = Math.max(sz.width, hsz.width);
      }
    }
    // minimum breadth needs to be big enough to hold the header
    var hdr = lane.findObject("HEADER");
    if (hdr !== null) sz.width = Math.max(sz.width, hdr.actualBounds.width);
    return sz;
  }

  // determine the minimum size of a Lane Group, even if collapsed
  function computeMinLaneSize(lane) {
    if (!lane.isSubGraphExpanded) return new go.Size(1, MINLENGTH);
    return new go.Size(MINBREADTH, MINLENGTH);
  }


  // define a custom grid layout that makes sure the length of each lane is the same
  // and that each lane is broad enough to hold its subgraph
  function PoolLayout() {
    go.GridLayout.call(this);
    this.cellSize = new go.Size(1, 1);
    this.wrappingColumn = Infinity;
    this.wrappingWidth = Infinity;
    this.spacing = new go.Size(0, 0);
    this.alignment = go.GridLayout.Position;
  }
  go.Diagram.inherit(PoolLayout, go.GridLayout);

  /** @override */
  PoolLayout.prototype.doLayout = function(coll) {
    var diagram = this.diagram;
    if (diagram === null) return;
    diagram.startTransaction("PoolLayout");
    // make sure all of the Group Shapes are big enough
    var minsize = computeMinPoolSize();
    diagram.findTopLevelGroups().each(function(lane) {
      if (!(lane instanceof go.Group)) return;
      var shape = lane.selectionObject;
      if (shape !== null) {  // change the desiredSize to be big enough in both directions
        var sz = computeLaneSize(lane);
        shape.width = (!isNaN(shape.width)) ? Math.max(shape.width, sz.width) : sz.width;
        shape.height = (isNaN(shape.height) ? minsize.height : Math.max(shape.height, minsize.height));
        var cell = lane.resizeCellSize;
        if (!isNaN(shape.width) && !isNaN(cell.width) && cell.width > 0) shape.width = Math.ceil(shape.width / cell.width) * cell.width;
        if (!isNaN(shape.height) && !isNaN(cell.height) && cell.height > 0) shape.height = Math.ceil(shape.height / cell.height) * cell.height;
      }
    });
    // now do all of the usual stuff, according to whatever properties have been set on this GridLayout
    go.GridLayout.prototype.doLayout.call(this, coll);
    diagram.commitTransaction("PoolLayout");
  };
  // end PoolLayout class


  function init() {
    if (window.goSamples) goSamples();  // init for these samples -- you don't need to call this
    var $ = go.GraphObject.make;

    myDiagram =
      $(go.Diagram, "myDiagramDiv",
        {
          // start everything in the middle of the viewport
          contentAlignment: go.Spot.Center,
          autoScale: go.Diagram.Uniform,
          "commandHandler.defaultScale": 1.5,
          minScale: 0.75,
          // use a simple layout to stack the top-level Groups next to each other
          layout: $(PoolLayout),
          allowDrop: true, // support drag-and-drop from the Palette
          // disallow nodes to be dragged to the diagram's background
          mouseDrop: function(e) {
            e.diagram.currentTool.doCancel();
          },
          // a clipboard copied node is pasted into the original node's group (i.e. lane).
          "commandHandler.copiesGroupKey": true,
          // automatically re-layout the swim lanes after dragging the selection
          "SelectionMoved": relayoutDiagram,  // this DiagramEvent listener is
          "SelectionCopied": relayoutDiagram, // defined above
          "animationManager.isEnabled": false,
          // enable undo & redo
          "undoManager.isEnabled": true
        });

    myDiagram.nodeTemplate =
      $(go.Node, "Auto",
        new go.Binding("location", "loc", go.Point.parse).makeTwoWay(go.Point.stringify),
        $(go.Shape, "Rectangle",
          { fill: "white", strokeWidth: 0 },
          new go.Binding("fill", "color", function(num) { return noteColors[num]; })),
        $(go.TextBlock,
          { margin: 6, font: 'bold 12px Lato, sans-serif', editable: true, stroke: "#000", maxSize: new go.Size(130, NaN) },
          new go.Binding("text", "text").makeTwoWay())
      );

    myDiagram.groupTemplate =
      $(go.Group, "Vertical",
        {
          selectionObjectName: "SHAPE",  // selecting a lane causes the body of the lane to be highlit, not the label
          layerName: "Background",  // all lanes are always behind all nodes and links
          background: "transparent",  // can grab anywhere in bounds
          movable: false,  // can't move lanes
          copyable: false,  // can't copy lanes
          deletable: false,  // can't delete lanes
          layout: $(go.GridLayout,  // automatically lay out the lane's subgraph
                    {
                      wrappingColumn: 1,
                      cellSize: new go.Size(1, 1),
                      spacing: new go.Size(5, 5),
                      alignment: go.GridLayout.Position,
                      comparer: function(a, b) {  // can re-order tasks within a lane
                        var ay = a.location.y;
                        var by = b.location.y;
                        if (isNaN(ay) || isNaN(by)) return 0;
                        if (ay < by) return -1;
                        if (ay > by) return 1;
                        return 0;
                      }
                    }),
          computesBoundsAfterDrag: true,  // needed to prevent recomputing Group.placeholder bounds too soon
          handlesDragDropForMembers: true,  // don't need to define handlers on member Nodes and Links
          mouseDrop: function(e, grp) {  // dropping a copy of some Nodes and Links onto this Group adds them to this Group
            // don't allow drag-and-dropping a mix of regular Nodes and Groups
            if (e.diagram.selection.all(function(n) { return !(n instanceof go.Group); })) {
              var ok = grp.addMembers(grp.diagram.selection, true);
              if (!ok) grp.diagram.currentTool.doCancel();
            }
          },
          subGraphExpandedChanged: function(grp) {
            var shp = grp.selectionObject;
            if (grp.diagram.undoManager.isUndoingRedoing) return;
            if (grp.isSubGraphExpanded) {
              shp.width = grp._savedBreadth;
            } else {
              grp._savedBreadth = shp.width;
              shp.width = NaN;
            }
          }
        },
        new go.Binding("location", "loc", go.Point.parse).makeTwoWay(go.Point.stringify),
        new go.Binding("isSubGraphExpanded", "expanded").makeTwoWay(),
        // the lane header consisting of a TextBlock and an expander button
        $(go.Panel, "Horizontal",
          { name: "HEADER",
            angle: 0,  // maybe rotate the header to read sideways going up
            alignment: go.Spot.Center },
          $(go.Panel, "Horizontal",  // this is hidden when the swimlane is collapsed
            new go.Binding("visible", "isSubGraphExpanded").ofObject(),
            $(go.TextBlock,  // the lane label
              { font: "bold 13pt sans-serif", editable: true, margin: new go.Margin(2, 0, 0, 0) },
              new go.Binding("text", "text").makeTwoWay())
          ),
          $("SubGraphExpanderButton", { margin: 5 })  // but this remains always visible!
        ),  // end Horizontal Panel
        $(go.Panel, "Auto",  // the lane consisting of a background Shape and a Placeholder representing the subgraph
          $(go.Shape, "Rectangle",  // this is the resized object
            { name: "SHAPE", fill: "white", stroke: "gray" },
            new go.Binding("fill", "color", function(num) { return groupColors[num]; }),
            new go.Binding("desiredSize", "size", go.Size.parse).makeTwoWay(go.Size.stringify)),
          $(go.Placeholder,
            { padding: 12, alignment: go.Spot.TopLeft }),
          $(go.TextBlock,  // this TextBlock is only seen when the swimlane is collapsed
            { name: "LABEL",
              font: "bold 13pt sans-serif", editable: true,
              angle: 90, alignment: go.Spot.TopLeft, margin: new go.Margin(4, 0, 0, 2) },
            new go.Binding("visible", "isSubGraphExpanded", function(e) { return !e; }).ofObject(),
            new go.Binding("text", "text").makeTwoWay())
        )  // end Auto Panel
      );  // end Group

    load();

    myPalette =
      $(go.Palette, "myPaletteDiv",
        {
          scale: 1.5,
          nodeTemplateMap: myDiagram.nodeTemplateMap,
          groupTemplateMap: myDiagram.groupTemplateMap,
          "model.nodeDataArray": [
            { text: "Add+\n texto", color: "0" },
            { text: "Add+\n texto", color: "1" },
            { text: "Add+\n texto", color: "2" },
            { text: "Add+\n texto", color: "3" },
            { text: "Add+\n texto", color: "4" }
          ]
        }
      );
  }  // end init

  // Show the diagram's model in JSON format
  function save() {
    document.getElementById("mySavedModel").value = myDiagram.model.toJson();
    myDiagram.isModified = false;
  }
  function load() {
    myDiagram.model = go.Model.fromJson(document.getElementById("mySavedModel").value);
    myDiagram.delayInitialization(relayoutDiagram);
  }
</script>