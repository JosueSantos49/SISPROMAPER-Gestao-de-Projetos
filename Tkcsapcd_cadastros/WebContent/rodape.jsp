<div class="container">	
		<div align="right" class="">
			<br><a href="#" id="subir" class="btn btn-mini btn-danger glyphicon glyphicon-menu-up" title="Topo da p�gina!"></a>
	</div>
</div>

	</div><!-- In�cio Forma��o WOW em todas as p�ginas que possuem cabe�alho e rodap�. Esta fechando com a div no rodap�-->
</div><!-- Zoom da p�gina -->
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

<!-- <div align="center" class="panel-footer">@Copyright � 2015 - Todos os direitos reservados. Proibida a c�pia total ou parcial.</div> -->
<script src="js/modal_dialog.js"></script><!-- Configura��o de anima��o de carregamento da p�gina -->
<script src="js/menu_responsivo_bootstrap.js"></script>
<%@include file="menu_icon_geral.jsp" %>



