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
						required: "c�digo do projeto obrigat�rio.",
						minlength: "Digite o c�digo do projeto."
					},
					nomeprojeto:{
						required: "Nome do projeto obrigat�rio.",
						minlength: "Digite o nome do projeto."
					},
					datadocumento:{
						required: "",
						minlength: ""
					},
					coordenador:{
						required: "Coordenador obrigat�rio.",
						minlength: "Digite o nome do coordenador"
					},
					tipoprojeto:{
						required: "",
						minlength: "Digite o tipo de projeto."	
					},
					gestor:{
						required: "Gestor obrigat�rio.",
						minlength: "Digite o o nome do gestor."
					},
					programa:{
						required: "Programa obrigat�rio.",
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
						required: "Objetivo do projeto obrigat�rio",
						minlength: "Digite o objetivo do projeto"	
					},
					justificativaprojeto:{
						required: "Campo justificativa do projeto obrigat�rio.",
						minlength: "Digite a justificativa do projeto."	
					},
					orcamentoprevisto:{
						required: "Orcamento previsto obrigat�rio.",
						minlength: "Digite o orcamento previsto."	
					},
					valorempenhado:{
						required: "Valor empenhado obrigat�rio.",
						minlength: "Digite o valor empenhado."	
					},
					valorpago:{
						required: "Valor obrigat�rio.",
						minlength: "Digite o valor pago."
					},
					saldo:{
						required: "Saldo obrigat�rio.",
						minlength: ""
					},
					resultadoprevisto:{
						required: "Resultado previsto obrigat�rio.",
						minlength: ""
					},
					peso:{
						required: "Peso obrigat�rio.",
						minlength: "Digite o peso."
					},
					progresso:{
						required: "Progresso obrigat�rio.",
						minlength: "Digite o Progresso."	
					},
					detalhamento:{
						required: "Detalhamento obrigat�rio.",
						minlength: "Digite o detalhamento."
					},
					analiseefetividade:{
						required: "Analise de efetividade obrigat�rio.",
						minlength: ""
					},
					documentacaofisica:{
						required: "Documentac�o f�sica obrigat�rio.",
						minlength: ""
					},			
					documentacaoeletronica:{
						required: "Documenta��o eletr�nica obrigat�rio.",
						minlength: ""	
					},
					concideracaocoordenador:{
						required: "concideracaocoordenador obrigat�rio.",
						minlength: "Digite a considera��o do coordenador."	
					},
					concideracaogestor:{
						required: "concideracaogestor obrigat�rio.",
						minlength: "Digite a concidera��o do gestor."	
					},
					termo:{
						required: "Termo obrigat�rio.",
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
        alert("Campo c�digo do projeto esta vazio!");
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
        alert("Campo status da conclus�o esta vazio!");
        formulario.statusconclusao.focus();
		return false;
    }    
    if(document.formulario.dataanaliseresultado.radio==""){
        alert("Campo data de an�lise dos resultados esta vazio!");
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
        alert("Campo documentacao f�sica esta vazio!");
        formulario.documentacaofisica.focus();
		return false;
    }
    if(document.formulario.documentacaoeletronica.checked==""){
        alert("Campo documentacao eletr�nica esta vazio!");
        formulario.documentacaoeletronica.focus();
		return false;
    }    
    if(document.formulario.concideracaocoordenador.value==""){
        alert("Campo concidera��o do coordenador esta vazio!");
        formulario.concideracaocoordenador.focus();
		return false;
    }
    if(document.formulario.concideracaogestor.value==""){
        alert("Campo conciderac�o do gestor esta vazio!");
        formulario.concideracaogestor.focus();
		return false;
    }
    if(document.formulario.termo.checked==""){
        alert("Campo termo esta vazio!");
        formulario.termo.focus();
		return false;
    }
}