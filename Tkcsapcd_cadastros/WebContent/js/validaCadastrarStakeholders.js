$(document).ready(function()
	{
		$('#formulario').validate(
			{
				//Definindo validação pelo nome de cada campo do form
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
						required: "código do projeto obrigatório.",
						minlength: "Digite o código do projeto."
					},
					empresa:{
						required: "Nome do cliente obrigatório.",
						minlength: "Digite o nome do cliente."
					},
					orgao:{
						required: "Orgão obrigatório.",
						minlength: "Digite o orgão."
					},
					setor:{
						required: "Digite o setor.",
						minlength: ""
					},
					programa:{
						required: "Programa obrigatório.",
						minlength: "Digite o programa."
					},
					projeto:{
						required: "Projeto obrigatório.",
						minlength: "Digite o projeto."	
					},					
					gerente:{
						required: "Gerente do projeto obrigatório.",
						minlength: "Digite o Gerente do projeto."
					},
					funcao:{
						required: "Elaborado por obrigatório.",
						minlength: "Digite o responsável."
					},			
					aprovado:{
						required: "Aprovado por obrigatório.",
						minlength: "Digite o responsável."	
					},
					versao:{
						required: "Digite a versão",
						minlength: ""	
					},
					dataaprovacao:{
						required: "Data de aprovação obrigatório.",
						minlength: "Digite a Data de aprovação."	
					},
					referencia:{
						required: "Referência obrigatório.",
						minlength: "Digite a referência."	
					},
					nome:{
						required: "Nome obrigatório.",
						minlength: "Digite o nome."	
					},
					empresaequipe:{
						required: "Empresa/Equipe obrigatório.",
						minlength: "Digite Empresa/Equipe."	
					},
					cargocompetencia:{
						required: "Cargo/Competência obrigatório.",
						minlength: "Digite Cargo/Competência."	
					},
					email:{
						required: "E-mail obrigatório.",
						minlength: "Digite e-mail."	
					},
					telefone:{
						required: "Telefone/Fax obrigatório.",
						minlength: "Digite Telefone/Fax."	
					},
					endereco:{
						required: "Endereço obrigatório.",
						minlength: "Digite o endereço."	
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
        alert("Campo orgão esta vazio!");
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
        alert("Campo código do projeto  esta vazio!");
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
        alert("Campo versão esta vazio!");
        formulario.versao.focus();
		return false;
    }
    if(document.formulario.dataaprovacao.value==""){
        alert("Campo Data de Aprovação esta vazio!");
        formulario.dataaprovacao.focus();
		return false;
    }
    if(document.formulario.referencia.value==""){
        alert("Campo referência esta vazio!");
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
        alert("Campo Cargo/Competência esta vazio!");
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
        alert("Campo endereço  esta vazio!");
        formulario.endereco.focus();
		return false;
    }
    
}