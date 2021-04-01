
<!doctype html>

<html lang="en">
<head>
  <meta charset="utf-8">
  <title>WOW</title>
  <link rel="stylesheet" href="wow/css/animate.css"><!-- wow -->
  <link rel="stylesheet" href="wow/css/site.css">
  <style>
    .wow:first-child {
      visibility: hidden;
    }
  </style>
  <!--[if IE]>
    <script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
  <![endif]-->
</head>

<body>
  <div id="container">
    <header>
      <h1>WOW.js</h1>
    </header>
    <div id="main">
      <section class="wow fadeInDown" style="background-color: #f1c40f;"></section>
      <section class="wow pulse" style="background-color: #e74c3c;" data-wow-iteration="infinite" data-wow-duration="1500ms"></section>
      <section class="section--purple wow slideInRight" data-wow-delay="2s"></section>
      <section class="section--blue wow bounceInLeft" data-wow-offset="300"></section>
      <section class="section--green wow slideInLeft" data-wow-duration="4s"></section>
      <button id="moar">LOAD MOAR!!</button>
    </div>
  </div>
  <script src="wow/js/wow.js"></script>
  <script>
    wow = new WOW(
      {
        animateClass: 'animated',
        offset:       100,
        callback:     function(box) {
          console.log("WOW: animating <" + box.tagName.toLowerCase() + ">")
        }
      }
    );
    wow.init();
    document.getElementById('moar').onclick = function() {
      var section = document.createElement('section');
      section.className = 'section--purple wow fadeInDown';
      this.parentNode.insertBefore(section, this);
    };
  </script>
</body>
</html>
