$(document).ready(function()
	{
		$('#formulario').validate(
			{
				//Definindo valida��o pelo nome de cada campo do form
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
						required: "C�digo do Projeto obrigat�rio.",
						minlength: "Digite o C�digo do Projeto."
					},
					justificativa:{
						required: "Justificativa obrigat�rio.",
						minlength: "Digite a Justificativa."
					},
					objetivo:{
						required: "Objetivo obrigat�rio.",
						minlength: "Digite o Objetivo."
					},
					beneficio:{
						required: "Benef�cio obrigat�rio.",
						minlength: "Digite o Benef�cio."	
					},
					produto:{
						required: "Produto obrigat�rio.",
						minlength: "Digite o Produto."
					},
					requisito:{
						required: "Requisito obrigat�rio.",
						minlength: "Digite o Requisito."
					},restricao:{
						required: "Restri��o obrigat�rio.",
						minlength: "Digite a Restri��o."	
					},
					permissao:{
						required: "Permiss�o obrigat�rio.",
						minlength: "Digite a Permiss�o."	
					},
					risco:{
						required: "Risco obrigat�rio.",
						minlength: "Digite o Risco."	
					}
				}
			}
		);	
	});

function validaDetalharCadastrarProjeto(){
    if(document.formulario.codigodoprojeto.value==""){
        alert("Campo c�digo do projeto esta vazio!");
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
        alert("Campo t�tulo esta vazio!");
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
        alert("Campo �rea esta vazio!");
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