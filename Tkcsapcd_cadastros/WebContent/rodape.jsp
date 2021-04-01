<div class="container">	
		<div align="right" class="">
			<br><a href="#" id="subir" class="btn btn-mini btn-danger glyphicon glyphicon-menu-up" title="Topo da página!"></a>
	</div>
</div>

	</div><!-- Início Formação WOW em todas as páginas que possuem cabeçalho e rodapé. Esta fechando com a div no rodapé-->
</div><!-- Zoom da página -->
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

<!-- <div align="center" class="panel-footer">@Copyright © 2015 - Todos os direitos reservados. Proibida a cópia total ou parcial.</div> -->
<script src="js/modal_dialog.js"></script><!-- Configuração de animação de carregamento da página -->
<script src="js/menu_responsivo_bootstrap.js"></script>
<%@include file="menu_icon_geral.jsp" %>



