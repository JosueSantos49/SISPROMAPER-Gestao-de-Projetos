	$(function() {
				$("#avisoGravarNoticia")
						.dialog(
								{
									resizable : false,
									height : 140,
									modal : true,
									buttons : {
										"Aten��o preencha todos os campos. Clique aqui, ou abaixo para continuar." : function() {
											$(this).dialog("close");
										},
										Cancel : function() {
											$(this).dialog("close");
										}
									}
								});
			});