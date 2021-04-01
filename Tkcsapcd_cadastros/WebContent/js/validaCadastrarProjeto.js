$(document).ready(function()
	{
		$('#formulario').validate(
			{
				//Definindo valida��o pelo nome de cada campo do form
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
						required: "Obrigat�rio.",
						minlength: "Digite!"
					},
					termoaberturaprojeto:{
						required: "Obrigat�rio.",
						minlength: "Digite!"
					},
					/*projeto:{
						required: "Obrigat�rio.",
						minlength: "Digite!"
					},*/
					versao:{
						required: "Obrigat�rio",
						minlength: "Digite!"
					},
					data:{
						required: "Obrigat�rio.",
						minlength: "Digite!"	
					},
					autor:{
						required: "Obrigat�rio.",
						minlength: "Digite!"
					},
					notarevisao:{
						required: "Obrigat�rio.",
						minlength: "Digite!"
					},
					aprovacao:{
						required: "Obrigat�rio",
						minlength: "Digite!"
					},			
					objetivo:{
						required: "Obrigat�rio.",
						minlength: "Digite!"	
					},
					justificativa:{
						required: "Obrigat�rio",
						minlength: "Digite!"	
					},
					smart:{
						required: "Obrigat�rio.",
						minlength: "Digite!"	
					},
					eap:{
						required: "Obrigat�rio.",
						minlength: "Digite!"
					},
					requisito:{
						required: "Obrigat�rio.",
						minlength: "Digite!"
					},
					marco:{
						required: "Obrigat�rio.",
						minlength: "Digite!"
					},
					parteinteressada:{
						required: "Obrigat�rio.",
						minlength: "Digite!"
					},
					restricao:{
						required: "Obrigat�rio.",
						minlength: "Digite!"
					},
					permissao:{
						required: "Obrigat�rio.",
						minlength: "Digite!"
					},
					risco:{
						required: "Obrigat�rio.",
						minlength: "Digite!"
					},
					orcamento:{
						required: "Obrigat�rio.",
						minlength: "Digite!"
					},
					concordo:{
						required: "Obrigat�rio.",
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