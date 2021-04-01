$(document).ready(function()
	{
		$('#formulario').validate(
			{
				//Definindo valida��o pelo nome de cada campo do form
				rules:{
					empresa:{
						required: true,
						minlength: 1	
					},
					orgao:{
						required: true,
						minlength: 1	
					},
					setor:{
						required: true,
						minlength: 1
					},
					programa:{
						required: true,
						minlength: 1
					},
					projeto:{
						required: true,
						minlength: 1
					},
					gerente:{
						required: true,
						minlength: 1	
					},
					funcao:{
						required: true,
						minlength: 1
					},
					aprovado:{
						required: true,
						minlength: 1
					},
					versao:{
						required: true,
						minlength: 1
					},
					dataaprovacao:{
						required: true,
						minlength: 1
					},
					referencia:{
						required: true,
						minlength: 1
					},
					nome:{
						required: true,
						minlength: 1
					},
					empresaequipe:{
						required: true,
						minlength: 1
					},
					cargocompetencia:{
						required: true,
						minlength: 1
					},
					email:{
						required: true,
						minlength: 1
					},
					telefone:{
						required: true,
						minlength: 1
					},
					endereco:{
						required: true,
						minlength: 1
					}
				},
				messages:{
					codigoprojeto:{
						required: "c�digo do projeto obrigat�rio.",
						minlength: "Digite o c�digo do projeto."
					},
					empresa:{
						required: "Nome do cliente obrigat�rio.",
						minlength: "Digite o nome do cliente."
					},
					orgao:{
						required: "Org�o obrigat�rio.",
						minlength: "Digite o org�o."
					},
					setor:{
						required: "Digite o setor.",
						minlength: ""
					},
					programa:{
						required: "Programa obrigat�rio.",
						minlength: "Digite o programa."
					},
					projeto:{
						required: "Projeto obrigat�rio.",
						minlength: "Digite o projeto."	
					},					
					gerente:{
						required: "Gerente do projeto obrigat�rio.",
						minlength: "Digite o Gerente do projeto."
					},
					funcao:{
						required: "Elaborado por obrigat�rio.",
						minlength: "Digite o respons�vel."
					},			
					aprovado:{
						required: "Aprovado por obrigat�rio.",
						minlength: "Digite o respons�vel."	
					},
					versao:{
						required: "Digite a vers�o",
						minlength: ""	
					},
					dataaprovacao:{
						required: "Data de aprova��o obrigat�rio.",
						minlength: "Digite a Data de aprova��o."	
					},
					referencia:{
						required: "Refer�ncia obrigat�rio.",
						minlength: "Digite a refer�ncia."	
					},
					nome:{
						required: "Nome obrigat�rio.",
						minlength: "Digite o nome."	
					},
					empresaequipe:{
						required: "Empresa/Equipe obrigat�rio.",
						minlength: "Digite Empresa/Equipe."	
					},
					cargocompetencia:{
						required: "Cargo/Compet�ncia obrigat�rio.",
						minlength: "Digite Cargo/Compet�ncia."	
					},
					email:{
						required: "E-mail obrigat�rio.",
						minlength: "Digite e-mail."	
					},
					telefone:{
						required: "Telefone/Fax obrigat�rio.",
						minlength: "Digite Telefone/Fax."	
					},
					endereco:{
						required: "Endere�o obrigat�rio.",
						minlength: "Digite o endere�o."	
					}
				}
			}
		);	
	});

function validaCadastrarStakeholders(){
    if(document.formulario.empresa.value==""){
        alert("Campo empresa esta vazio!");
        formulario.empresa.focus();
		return false;
    }
    if(document.formulario.orgao.value==""){
        alert("Campo org�o esta vazio!");
        formulario.orgao.focus();
		return false;
    }
    if(document.formulario.setor.value==""){
        alert("Campo setor esta vazio!");
        formulario.setor.focus();
		return false;
    }
    if(document.formulario.programa.value==""){
        alert("Campo programa esta vazio!");
        formulario.programa.focus();
		return false;
    }
    if(document.formulario.codigoprojeto.value==""){
        alert("Campo c�digo do projeto  esta vazio!");
        formulario.codigoprojeto.focus();
		return false;
    }
    if(document.formulario.projeto.value==""){
        alert("Campo projeto esta vazio!");
        formulario.projeto.focus();
		return false;
    }
    if(document.formulario.gerente.value==""){
        alert("Campo gerente esta vazio!");
        formulario.gerente.focus();
		return false;
    }
    if(document.formulario.funcao.value==""){
        alert("Campo elaborado esta vazio!");
        formulario.funcao.focus();
		return false;
    }    
    if(document.formulario.aprovado.value==""){
        alert("Campo aprovado projeto esta vazio!");
        formulario.aprovado.focus();
		return false;
    }
    if(document.formulario.versao.value==""){
        alert("Campo vers�o esta vazio!");
        formulario.versao.focus();
		return false;
    }
    if(document.formulario.dataaprovacao.value==""){
        alert("Campo Data de Aprova��o esta vazio!");
        formulario.dataaprovacao.focus();
		return false;
    }
    if(document.formulario.referencia.value==""){
        alert("Campo refer�ncia esta vazio!");
        formulario.referencia.focus();
		return false;
    }
    if(document.formulario.nome.value==""){
        alert("Campo nome esta vazio!");
        formulario.nome.focus();
		return false;
    }
    if(document.formulario.empresaequipe.value==""){
        alert("Campo Empresa/Equipe  esta vazio!");
        formulario.empresaequipe.focus();
		return false;
    }
    if(document.formulario.cargocompetencia.value==""){
        alert("Campo Cargo/Compet�ncia esta vazio!");
        formulario.cargocompetencia.focus();
		return false;
    }
    if(document.formulario.email.value==""){
        alert("Campo e-mail esta vazio!");
        formulario.email.focus();
		return false;
    }
    if(document.formulario.telefone.value==""){
        alert("Campo telefone esta vazio!");
        formulario.telefone.focus();
		return false;
    }
    if(document.formulario.endereco.value==""){
        alert("Campo endere�o  esta vazio!");
        formulario.endereco.focus();
		return false;
    }
    
}