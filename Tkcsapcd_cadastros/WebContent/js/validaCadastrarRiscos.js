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
					etapa1:{
						required: true,
						minlength: 1
					},
					etapa2:{
						required: true,
						minlength: 1
					},
					etapa3:{
						required: true,
						minlength: 1
					},
					etapa4:{
						required: true,
						minlength: 1
					},
					codigoprojeto:{
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
					etapa1:{
						required: "1 Etapa: Identificação do Risco obrigatório.",
						minlength: "Digite 1 Etapa: Identificação do Risco."	
					},
					etapa2:{
						required: "2 Etapa: Avaliação do Risco obrigatório.",
						minlength: "Digite 2 Etapa: Avaliação do Risco."	
					},
					etapa3:{
						required: "3 Etapa: Desenvolvimento da Resposta obrigatório.",
						minlength: "Digite 3 Etapa: Desenvolvimento da Resposta."	
					},
					etapa4:{
						required: "4 Etapa: Acompanhamento do Risco obrigatório.",
						minlength: "Digite 4 Etapa: Acompanhamento do Risco."	
					}
				}
			}
		);	
	});

function validaCadastrarRiscos(){
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
    if(document.formulario.etapa1.value==""){
        alert("Campo 1- Etapa: Identificação do Risco esta vazio!");
        formulario.etapa1.focus();
		return false;
    }
    if(document.formulario.etapa2.value==""){
        alert("Campo 2- Etapa: Avaliação do Risco esta vazio!");
        formulario.etapa2.focus();
		return false;
    }
    if(document.formulario.etapa3.value==""){
        alert("Campo 3- Etapa: Desenvolvimento da Resposta  esta vazio!");
        formulario.etapa3.focus();
		return false;
    }
    if(document.formulario.etapa4.value==""){
        alert("Campo 4- Etapa: Acompanhamento do Risco esta vazio!");
        formulario.etapa4.focus();
		return false;
    }
    
}