$(document).ready(function()
	{
		$('#formulario').validate(
			{
				//Definindo validação pelo nome de cada campo do form
				rules:{
					codigodoprojeto:{
						required: true,
						minlength: 1	
					},
					justificativa:{
						required: true,
						minlength: 1
					},
					objetivo:{
						required: true,
						minlength: 1
					},
					beneficio:{
						required: true,
						minlength: 1
					},
					produto:{
						required: true,
						minlength: 1	
					},
					requisito:{
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
					}
				},
				messages:{
					codigodoprojeto:{
						required: "Código do Projeto obrigatório.",
						minlength: "Digite o Código do Projeto."
					},
					justificativa:{
						required: "Justificativa obrigatório.",
						minlength: "Digite a Justificativa."
					},
					objetivo:{
						required: "Objetivo obrigatório.",
						minlength: "Digite o Objetivo."
					},
					beneficio:{
						required: "Benefício obrigatório.",
						minlength: "Digite o Benefício."	
					},
					produto:{
						required: "Produto obrigatório.",
						minlength: "Digite o Produto."
					},
					requisito:{
						required: "Requisito obrigatório.",
						minlength: "Digite o Requisito."
					},restricao:{
						required: "Restrição obrigatório.",
						minlength: "Digite a Restrição."	
					},
					permissao:{
						required: "Permissão obrigatório.",
						minlength: "Digite a Permissão."	
					},
					risco:{
						required: "Risco obrigatório.",
						minlength: "Digite o Risco."	
					}
				}
			}
		);	
	});

function validaDetalharCadastrarProjeto(){
    if(document.formulario.codigodoprojeto.value==""){
        alert("Campo código do projeto esta vazio!");
        formulario.codigodoprojeto.focus();
		return false;
    }
    if(document.formulario.justificativa.value==""){
        alert("Campo justificativa esta vazio!");
        formulario.justificativa.focus();
		return false;
    }
    if(document.formulario.dataProjeto.value==""){
        alert("Campo data esta vazio!");
        formulario.dataProjeto.focus();
		return false;
    }
    if(document.formulario.tituloProjeto.value==""){
        alert("Campo título esta vazio!");
        formulario.tituloProjeto.focus();
		return false;
    }
    if(document.formulario.descricaoProjeto.value==""){
        alert("Campo descricao esta vazio!");
        formulario.descricaoProjeto.focus();
		return false;
    }
    if(document.formulario.responsavel.value==""){
        alert("Campo responsavel esta vazio!");
        formulario.responsavel.focus();
		return false;
    }
    if(document.formulario.area.value==""){
        alert("Campo área esta vazio!");
        formulario.area.focus();
		return false;
    }    
    if(document.formulario.tipoprojeto.radio==""){
        alert("Campo tipo projeto esta vazio!");
        formulario.tipoprojeto.focus();
		return false;
    }
    if(document.formulario.pgstatus.selectedIndex==""){
        alert("Campo status esta vazio!");
        formulario.pgstatus.focus();
		return false;
    }
    if(document.formulario.dataimplantacaoprevista.value==""){
        alert("Campo data implantacao prevista esta vazio!");
        formulario.dataimplantacaoprevista.focus();
		return false;
    }
    if(document.formulario.custototalprojeto.value==""){
        alert("Campo custo total projeto esta vazio!");
        formulario.custototalprojeto.focus();
		return false;
    }
    if(document.formulario.keyuser.value==""){
        alert("Campo key user esta vazio!");
        formulario.keyuser.focus();
		return false;
    }
    if(document.formulario.concordo.checked==""){
        alert("Campo concordo esta vazio!");
        formulario.concordo.focus();
		return false;
    }
}