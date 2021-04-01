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
					nomeprojeto:{
						required: true,
						minlength: 1	
					},
					datadocumento:{
						required: true,
						minlength: 1
					},
					coordenador:{
						required: true,
						minlength: 1
					},
					tipoprojeto:{
						required: true,
						minlength: 1
					},
					gestor:{
						required: true,
						minlength: 1	
					},
					programa:{
						required: true,
						minlength: 1
					},
					statusconclusao:{
						required: true,
						minlength: 1
					},
					dataanaliseresultado:{
						required: true,
						minlength: 1
					},
					objetivoprojeto:{
						required: true,
						minlength: 1
					},
					justificativaprojeto:{
						required: true,
						minlength: 1
					},
					orcamentoprevisto:{
						required: true,
						minlength: 1
					},
					valorempenhado:{
						required: true,
						minlength: 1
					},
					valorpago:{
						required: true,
						minlength: 1	
					},
					saldo:{
						required: true,
						minlength: 1
					},
					resultadoprevisto:{
						required: true,
						minlength: 1
					},
					peso:{
						required: true,
						minlength: 1
					},
					progresso:{
						required: true,
						minlength: 1	
					},
					detalhamento:{
						required: true,
						minlength: 1
					},
					analiseefetividade:{
						required: true,
						minlength: 1
					},
					documentacaofisica:{
						required: true,
						minlength: 1
					},
					documentacaoeletronica:{
						required: true,
						minlength: 1
					},
					concideracaocoordenador:{
						required: true,
						minlength: 1
					},
					concideracaogestor:{
						required: true,
						minlength: 1
					},
					termo:{
						required: true,
						minlength: 1
					}
				},
				messages:{
					codigoprojeto:{
						required: "código do projeto obrigatório.",
						minlength: "Digite o código do projeto."
					},
					nomeprojeto:{
						required: "Nome do projeto obrigatório.",
						minlength: "Digite o nome do projeto."
					},
					datadocumento:{
						required: "",
						minlength: ""
					},
					coordenador:{
						required: "Coordenador obrigatório.",
						minlength: "Digite o nome do coordenador"
					},
					tipoprojeto:{
						required: "",
						minlength: "Digite o tipo de projeto."	
					},
					gestor:{
						required: "Gestor obrigatório.",
						minlength: "Digite o o nome do gestor."
					},
					programa:{
						required: "Programa obrigatório.",
						minlength: "Digite o nome do programa."
					},
					statusconclusao:{
						required: "",
						//minlength: "Digite o tipo."
					},			
					dataanaliseresultado:{
						required: "",
						minlength: ""	
					},
					objetivoprojeto:{
						required: "Objetivo do projeto obrigatório",
						minlength: "Digite o objetivo do projeto"	
					},
					justificativaprojeto:{
						required: "Campo justificativa do projeto obrigatório.",
						minlength: "Digite a justificativa do projeto."	
					},
					orcamentoprevisto:{
						required: "Orcamento previsto obrigatório.",
						minlength: "Digite o orcamento previsto."	
					},
					valorempenhado:{
						required: "Valor empenhado obrigatório.",
						minlength: "Digite o valor empenhado."	
					},
					valorpago:{
						required: "Valor obrigatório.",
						minlength: "Digite o valor pago."
					},
					saldo:{
						required: "Saldo obrigatório.",
						minlength: ""
					},
					resultadoprevisto:{
						required: "Resultado previsto obrigatório.",
						minlength: ""
					},
					peso:{
						required: "Peso obrigatório.",
						minlength: "Digite o peso."
					},
					progresso:{
						required: "Progresso obrigatório.",
						minlength: "Digite o Progresso."	
					},
					detalhamento:{
						required: "Detalhamento obrigatório.",
						minlength: "Digite o detalhamento."
					},
					analiseefetividade:{
						required: "Analise de efetividade obrigatório.",
						minlength: ""
					},
					documentacaofisica:{
						required: "Documentacão física obrigatório.",
						minlength: ""
					},			
					documentacaoeletronica:{
						required: "Documentação eletrônica obrigatório.",
						minlength: ""	
					},
					concideracaocoordenador:{
						required: "concideracaocoordenador obrigatório.",
						minlength: "Digite a consideração do coordenador."	
					},
					concideracaogestor:{
						required: "concideracaogestor obrigatório.",
						minlength: "Digite a concideração do gestor."	
					},
					termo:{
						required: "Termo obrigatório.",
						minlength: "Digite o termo."	
					}
				}
			}
		);	
	});

function validaCadastrarProjetoTermoEncerramento(){
	if(document.formulario.nomeprojeto.value==""){
        alert("Campo nome do projeto esta vazio!");
        formulario.nomeprojeto.focus();
		return false;
    }
	if(document.formulario.codigoprojeto.value==""){
        alert("Campo código do projeto esta vazio!");
        formulario.codigoprojeto.focus();
		return false;
    }
    if(document.formulario.datadocumento.value==""){
        alert("Campo data do documento esta vazio!");
        formulario.datadocumento.focus();
		return false;
    }
    if(document.formulario.coordenador.value==""){
        alert("Campo coordenador esta vazio!");
        formulario.coordenador.focus();
		return false;
    }
    if(document.formulario.tipoprojeto.value==""){
        alert("Campo tipo de projeto esta vazio!");
        formulario.tipoprojeto.focus();
		return false;
    }
    if(document.formulario.gestor.value==""){
        alert("Campo gestor esta vazio!");
        formulario.gestor.focus();
		return false;
    }
    if(document.formulario.programa.value==""){
        alert("Campo programa esta vazio!");
        formulario.programa.focus();
		return false;
    }
    if(document.formulario.statusconclusao.value==""){
        alert("Campo status da conclusão esta vazio!");
        formulario.statusconclusao.focus();
		return false;
    }    
    if(document.formulario.dataanaliseresultado.radio==""){
        alert("Campo data de análise dos resultados esta vazio!");
        formulario.dataanaliseresultado.focus();
		return false;
    }
    if(document.formulario.objetivoprojeto.selectedIndex==""){
        alert("Campo objetivo do projeto esta vazio!");
        formulario.objetivoprojeto.focus();
		return false;
    }
    if(document.formulario.justificativaprojeto.value==""){
        alert("Campo justificativa do projeto esta vazio!");
        formulario.justificativaprojeto.focus();
		return false;
    }
    if(document.formulario.orcamentoprevisto.value==""){
        alert("Campo orcamentoprevisto esta vazio!");
        formulario.orcamentoprevisto.focus();
		return false;
    }
    if(document.formulario.valorempenhado.value==""){
        alert("Campo valor empenhado esta vazio!");
        formulario.valorempenhado.focus();
		return false;
    }
    if(document.formulario.valorpago.checked==""){
        alert("Campo valor pago esta vazio!");
        formulario.valorpago.focus();
		return false;
    }
    if(document.formulario.saldo.value==""){
        alert("Campo saldo esta vazio!");
        formulario.saldo.focus();
		return false;
    }
    if(document.formulario.resultadoprevisto.value==""){
        alert("Campo resultado previsto esta vazio!");
        formulario.resultadoprevisto.focus();
		return false;
    }    
    if(document.formulario.peso.radio==""){
        alert("Campo peso esta vazio!");
        formulario.peso.focus();
		return false;
    }
    if(document.formulario.progresso.selectedIndex==""){
        alert("Campo progresso esta vazio!");
        formulario.progresso.focus();
		return false;
    }
    if(document.formulario.detalhamento.value==""){
        alert("Campo detalhamento esta vazio!");
        formulario.detalhamento.focus();
		return false;
    }
    if(document.formulario.analiseefetividade.value==""){
        alert("Campo analise de efetividade esta vazio!");
        formulario.analiseefetividade.focus();
		return false;
    }
    if(document.formulario.documentacaofisica.value==""){
        alert("Campo documentacao física esta vazio!");
        formulario.documentacaofisica.focus();
		return false;
    }
    if(document.formulario.documentacaoeletronica.checked==""){
        alert("Campo documentacao eletrônica esta vazio!");
        formulario.documentacaoeletronica.focus();
		return false;
    }    
    if(document.formulario.concideracaocoordenador.value==""){
        alert("Campo concideração do coordenador esta vazio!");
        formulario.concideracaocoordenador.focus();
		return false;
    }
    if(document.formulario.concideracaogestor.value==""){
        alert("Campo concideracão do gestor esta vazio!");
        formulario.concideracaogestor.focus();
		return false;
    }
    if(document.formulario.termo.checked==""){
        alert("Campo termo esta vazio!");
        formulario.termo.focus();
		return false;
    }
}