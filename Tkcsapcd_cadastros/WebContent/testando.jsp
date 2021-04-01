
<!doctype html>
<html>
<head>
	<meta charset="utf-8">
	<title>jQuery Youtube-like Ajax Loading Bar by Pete R. | The Pete Design</title>

	<script type="text/javascript" src="http://code.jquery.com/jquery-1.9.1.js"></script>
	<script type="text/javascript" src="js/jquery.loadingbar.js"></script>
	<link rel="stylesheet" type="text/css" href="css/loadingbar.css" />
	
	<script>
	  $(document).ready(function(){
      $("#clickme").loadingbar({
        done: function(data) {
          $.each( data.shots, function( i, item ) {
            $( "<img/>" ).attr( "src", item.image_teaser_url ).prependTo( $("#frame") );
            if ( i === 11 ) {
              return false;
            }
          });
        }
      });
		});		
	</script>
</head>
<body>
  <div class="wrapper"> 
	  <div class="main">
	    <div class="btns">
	      <a href="" data-datatype="json" data-type="GET" data-target="#frame" class="reload" id="clickme"><i class="customicon-download-alt"></i> Click Me</a>
	    </div>
      <div class="frame" id="frame">
      </div>
    </div>
  </div>
</body>
</html>
