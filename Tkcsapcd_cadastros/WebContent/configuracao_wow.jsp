</div><!-- Zoom da página. Fechando div do cabeçalho que configura o Zoom-->
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
	
