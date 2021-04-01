	$(document).ready(function()
	{
		$('#formulario').validate(
			{
				//Definindo valida��o pelo nome de cada campo do form
				rules:{
					nome:{
						required: true,
						minlength: 1	
					},
					descricao:{
						required: true,
						minlength: 1
					},
					resumo:{
						required: true,
						minlength: 1
					},
					rqfuncional:{
						required: true,
						minlength: 1
					},
					rqtecnologico:{
						required: true,
						minlength: 1
					},
					rqstatus:{
						required: true,
						minlength: 1
					},
					concordo:{
						required: true,
						minlength: 1	//Aten��o: aqui sempre ser� 1, porque � type="checkbox" (No BD tamb�m).
					}
				},
				messages:{
					nome:{
						required: "Nome obrigat�rio.",
						minlength: "Digite o nome."
					},
					descricao:{
						required: "Descri��o obrigat�rio.",
						minlength: "Digite a descri��o."
					},
					resumo:{
						required: "Resumo obrigat�rio.",
						minlength: "Digite a descri��o."
					},
					rqfuncional:{
						required: "Funcional obrigat�rio.",
						minlength: "Digite o requerimento funcional."	
					},
					rqtecnologico:{
						required: "Tecnologico obrigat�rio.",
						minlength: "Digite o requerimento tecnologico."	
					},
					rqstatus:{
						required: "Status obrigat�rio.",
						minlength: "Digite o requerimento status."	
					},
					concordo:{
						required: "Concordar com o termo obrigat�rio.",
						minlength: ""	
					}
				}
			}
		);	
	});
	function validaCadastrarRequerimento(){
	    if(document.formulario.nome.value==""){
	        alert("Campo nome esta vazio!");
	        formulario.itensavaliacao.focus();
			return false;
	    }
	    if(document.formulario.rqstatus.value==""){
	        alert("Campo requerimento status  esta vazio!");
	        formulario.avaliacaorfp.focus();
			return false;
	    }
	    if(document.formulario.concordo.checked==""){
	        alert("Campo concordo esta vazio!");
	        formulario.concordo.focus();
			return false;
	    }
	}
