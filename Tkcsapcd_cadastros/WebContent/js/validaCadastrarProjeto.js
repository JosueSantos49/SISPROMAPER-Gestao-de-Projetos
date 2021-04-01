$(document).ready(function()
	{
		$('#formulario').validate(
			{
				//Definindo validação pelo nome de cada campo do form
				rules:{
					codigoprojeto:{
						required: true,
						minlength: 1	
					},
					termoaberturaprojeto:{
						required: true,
						minlength: 1	
					},
					/*projeto:{
						required: true,
						minlength: 1
					},*/
					versao:{
						required: true,
						minlength: 1
					},
					data:{
						required: true,
						minlength: 1
					},
					autor:{
						required: true,
						minlength: 1	
					},
					notarevisao:{
						required: true,
						minlength: 1
					},
					aprovacao:{
						required: true,
						minlength: 1
					},
					objetivo:{
						required: true,
						minlength: 1
					},
					justificativa:{
						required: true,
						minlength: 1
					},
					smart:{
						required: true,
						minlength: 1
					},
					eap:{
						required: true,
						minlength: 1
					},
					requisito:{
						required: true,
						minlength: 1
					},
					marco:{
						required: true,
						minlength: 1
					},
					parteinteressada:{
						required: true,
						minlength: 1
					},
					restricao:{
						required: true,
						minlength: 1
					},
					permissao:{
						required: true,
						minlength: 1
					},
					risco:{
						required: true,
						minlength: 1
					},
					orcamento:{
						required: true,
						minlength: 1
					},
					concordo:{
						required: true,
						minlength: 1
					}
				},
				messages:{
					codigoprojeto:{
						required: "Obrigatório.",
						minlength: "Digite!"
					},
					termoaberturaprojeto:{
						required: "Obrigatório.",
						minlength: "Digite!"
					},
					/*projeto:{
						required: "Obrigatório.",
						minlength: "Digite!"
					},*/
					versao:{
						required: "Obrigatório",
						minlength: "Digite!"
					},
					data:{
						required: "Obrigatório.",
						minlength: "Digite!"	
					},
					autor:{
						required: "Obrigatório.",
						minlength: "Digite!"
					},
					notarevisao:{
						required: "Obrigatório.",
						minlength: "Digite!"
					},
					aprovacao:{
						required: "Obrigatório",
						minlength: "Digite!"
					},			
					objetivo:{
						required: "Obrigatório.",
						minlength: "Digite!"	
					},
					justificativa:{
						required: "Obrigatório",
						minlength: "Digite!"	
					},
					smart:{
						required: "Obrigatório.",
						minlength: "Digite!"	
					},
					eap:{
						required: "Obrigatório.",
						minlength: "Digite!"
					},
					requisito:{
						required: "Obrigatório.",
						minlength: "Digite!"
					},
					marco:{
						required: "Obrigatório.",
						minlength: "Digite!"
					},
					parteinteressada:{
						required: "Obrigatório.",
						minlength: "Digite!"
					},
					restricao:{
						required: "Obrigatório.",
						minlength: "Digite!"
					},
					permissao:{
						required: "Obrigatório.",
						minlength: "Digite!"
					},
					risco:{
						required: "Obrigatório.",
						minlength: "Digite!"
					},
					orcamento:{
						required: "Obrigatório.",
						minlength: "Digite!"
					},
					concordo:{
						required: "Obrigatório.",
						minlength: "Digite!"	
					}
				}
			}
		);	
	});

function validaCadastrarProjeto(){
    if(document.formulario.termoaberturaprojeto.value==""){
    	alert("Campo vazio!");
        formulario.termoaberturaprojeto.focus();
		return false;
    }
    if(document.formulario.projeto.value==""){
        alert("Campo vazio!");
        formulario.projeto.focus();
		return false;
    }
    if(document.formulario.codigoprojeto.value==""){
    	alert("Campo vazio!");
        formulario.codigoprojeto.focus();
		return false;
    }
    if(document.formulario.versao.value==""){
    	alert("Campo vazio!");
        formulario.versao.focus();
		return false;
    }
    if(document.formulario.data.value==""){
    	alert("Campo vazio!");
        formulario.data.focus();
		return false;
    }
    if(document.formulario.autor.value==""){
        alert("Campo responsavel esta vazio!");
        formulario.autor.focus();
		return false;
    }
    if(document.formulario.notarevisao.value==""){
    	alert("Campo vazio!");
        formulario.notarevisao.focus();
		return false;
    }    
    if(document.formulario.aprovacao.radio==""){
    	alert("Campo vazio!");
        formulario.aprovacao.focus();
		return false;
    }
    if(document.formulario.objetivo.selectedIndex==""){
    	alert("Campo vazio!");
        formulario.objetivo.focus();
		return false;
    }
    if(document.formulario.justificativa.value==""){
    	alert("Campo vazio!");
        formulario.justificativa.focus();
		return false;
    }
    if(document.formulario.smart.value==""){
    	alert("Campo vazio!");
        formulario.smart.focus();
		return false;
    }
    if(document.formulario.eap.value==""){
    	alert("Campo vazio!");
        formulario.eap.focus();
		return false;
    }
    if(document.formulario.requisito.value==""){
    	alert("Campo vazio!");
        formulario.requisito.focus();
		return false;
    }
    if(document.formulario.marco.value==""){
    	alert("Campo vazio!");
        formulario.marco.focus();
		return false;
    }
    if(document.formulario.parteinteressada.value==""){
    	alert("Campo vazio!");
        formulario.parteinteressada.focus();
		return false;
    }
    if(document.formulario.restricao.value==""){
    	alert("Campo vazio!");
        formulario.restricao.focus();
		return false;
    }
    if(document.formulario.permissao.value==""){
    	alert("Campo vazio!");
        formulario.permissao.focus();
		return false;
    }
    if(document.formulario.risco.value==""){
    	alert("Campo vazio!");
        formulario.risco.focus();
		return false;
    }
    if(document.formulario.orcamento.value==""){
    	alert("Campo vazio!");
        formulario.orcamento.focus();
		return false;
    }
    if(document.formulario.concordo.checked==""){
    	alert("Campo vazio!");
        formulario.concordo.focus();
		return false;
    }
}