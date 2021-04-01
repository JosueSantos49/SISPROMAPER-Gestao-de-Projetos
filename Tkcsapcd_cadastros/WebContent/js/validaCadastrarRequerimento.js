	$(document).ready(function()
	{
		$('#formulario').validate(
			{
				//Definindo validação pelo nome de cada campo do form
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
						minlength: 1	//Atenção: aqui sempre será 1, porque é type="checkbox" (No BD também).
					}
				},
				messages:{
					nome:{
						required: "Nome obrigatório.",
						minlength: "Digite o nome."
					},
					descricao:{
						required: "Descrição obrigatório.",
						minlength: "Digite a descrição."
					},
					resumo:{
						required: "Resumo obrigatório.",
						minlength: "Digite a descrição."
					},
					rqfuncional:{
						required: "Funcional obrigatório.",
						minlength: "Digite o requerimento funcional."	
					},
					rqtecnologico:{
						required: "Tecnologico obrigatório.",
						minlength: "Digite o requerimento tecnologico."	
					},
					rqstatus:{
						required: "Status obrigatório.",
						minlength: "Digite o requerimento status."	
					},
					concordo:{
						required: "Concordar com o termo obrigatório.",
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
