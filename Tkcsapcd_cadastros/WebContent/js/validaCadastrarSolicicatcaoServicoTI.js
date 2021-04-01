
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
					codigosolicitaoservico:{
						required: true,
						minlength: 1	
					},
					area:{
						required: true,
						minlength: 1
					},
					responsaveldemanda:{
						required: true,
						minlength: 1
					},
					telefonecontato:{
						required: true,
						minlength: 1
					},
					email:{
						required: true,
						email: true	
					},
					id:{
						required: true,
						minlength: 1
					},
					nomedemanda:{
						required: true,
						minlength: 1
					},
					objetivodemanda:{
						required: true,
						minlength: 1
					},
					decricaoproblema:{
						required: true,
						minlength: 1
					},
					desenhoprocesso:{
						required: true,
						minlength: 1
					},
					funcionalidade:{
						required: true,
						minlength: 1
					},
					parteenvolvida:{
						required: true,
						minlength: 1
					},
					parteenvolvidarepresentante:{
						required: true,
						minlength: 1
					},
					parteenvolvidaformacontato:{
						required: true,
						minlength: 1
					},
					estimativacustoglobal:{
						required: true,
						minlength: 1
					},
					fontefinanciamento:{
						required: true,
						minlength: 1
					},
					metodolevantamentocusto:{
						required: true,
						minlength: 1
					},
					numerousuarioprevisto:{
						required: true,
						minlength: 1
					},
					recursos:{
						required: true,
						minlength: 1
					},
					treinamentopessoal:{
						required: true,
						minlength: 1
					},
					materialapoio:{
						required: true,
						minlength: 1
					},
					restricaoprojeto:{
						required: true,
						minlength: 1
					},
					principaisusuarios:{
						required: true,
						minlength: 1
					},
					necessidadeusuario:{
						required: true,
						minlength: 1
					},
					prioridade:{
						required: true,
						minlength: 1
					},
					solucaoatual:{
						required: true,
						minlength: 1
					},
					problemasolucaoatual:{
						required: true,
						minlength: 1
					},
					solucaoproposta:{
						required: true,
						minlength: 1
					},
					status:{
						required: true,
						minlength: 1
					}
				},
				messages:{
					codigoprojeto:{
						required: "",
						minlength: ""
					},
					codigosolicitaoservico:{
						required: "",
						minlength: ""
					},
					area:{
						required: "",
						minlength: ""
					},
					responsaveldemanda:{
						required: "",
						minlength: ""
					},
					telefonecontato:{
						required: "",
						//minlength: "Obrigatório "	
					},
					email:{
						required: "",
						minlength: ""
					},
					id:{
						required: "",
						minlength: ""
					},
					datasolicitacao:{
						required: "",
						minlength: ""
					},			
					nomedemanda:{
						required: "",
						minlength: ""	
					},
					objetivodemanda:{
						required: "",
						minlength: ""	
					},
					decricaoproblema:{
						required: "",
						minlength: ""	
					},
					desenhoprocesso:{
						required: "",
						minlength: ""	
					},
					funcionalidade:{
						required: "",
						minlength: ""	
					},					
					parteenvolvida:{
						required: "",
						minlength: ""
					},			
					parteenvolvidarepresentante:{
						required: "",
						minlength: ""	
					},
					parteenvolvidaformacontato:{
						required: "",
						minlength: ""	
					},
					estimativacustoglobal:{
						required: "",
						minlength: ""	
					},
					fontefinanciamento:{
						required: "",
						minlength: ""	
					},
					metodolevantamentocusto:{
						required: "",
						minlength: ""	
					},					
					numerousuarioprevisto:{
						required: "",
						minlength: ""
					},			
					recursos:{
						required: "",
						minlength: ""	
					},
					treinamentopessoal:{
						required: "",
						minlength: ""	
					},
					materialapoio:{
						required: "",
						minlength: ""	
					},
					restricaoprojeto:{
						required: "",
						minlength: ""	
					},
					principaisusuarios:{
						required: "",
						minlength: ""	
					},
					
					necessidadeusuario:{
						required: "",
						minlength: ""
					},			
					prioridade:{
						required: "",
						minlength: ""	
					},
					solucaoatual:{
						required: "",
						minlength: ""	
					},
					problemasolucaoatual:{
						required: "",
						minlength: ""	
					},
					solucaoproposta:{
						required: "",
						minlength: ""	
					},
					status:{
						required: "",
						minlength: ""	
					}
				}
			}
		);	
	});

function validaCadastrarSolicicatcaoServicoTI(){
    if(document.formulario.codigoprojeto.value==""){
        alert("Campo código do projeto esta vazio!");
        formulario.codigoprojeto.focus();
		return false;
    }
    if(document.formulario.codigosolicitaoservico.value==""){
        alert("Campo código da solicitação de serviço esta vazio!");
        formulario.codigosolicitaoservico.focus();
		return false;
    }
    if(document.formulario.area.value==""){
        alert("Campo área esta vazio!");
        formulario.area.focus();
		return false;
    }
    if(document.formulario.responsaveldemanda.value==""){
        alert("Campo Responsável pela demanda esta vazio!");
        formulario.responsaveldemanda.focus();
		return false;
    }
    if(document.formulario.telefonecontato.value==""){
        alert("Campo Telefone de contato esta vazio!");
        formulario.telefonecontato.focus();
		return false;
    }
    if(document.formulario.email.value==""){
        alert("Campo E-mail esta vazio!");
        formulario.email.focus();
		return false;
    }
    if(document.formulario.datasolicitacao.value==""){
        alert("Campo Data de Solicitação esta vazio!");
        formulario.datasolicitacao.focus();
		return false;
    }    
    if(document.formulario.id.value==""){
        alert("Campo ID esta vazio!");
        formulario.id.focus();
		return false;
    }
    if(document.formulario.nomedemanda.value==""){
        alert("Campo Nome da Demanda  esta vazio!");
        formulario.nomedemanda.focus();
		return false;
    }
    if(document.formulario.objetivodemanda.value==""){
        alert("Campo Objetivo da Demanda  esta vazio!");
        formulario.objetivodemanda.focus();
		return false;
    }
    if(document.formulario.decricaoproblema.value==""){
        alert("Campo Decrição do Problema esta vazio!");
        formulario.decricaoproblema.focus();
		return false;
    }
    if(document.formulario.desenhoprocesso.value==""){
        alert("Campo Desenho do Processo esta vazio!");
        formulario.desenhoprocesso.focus();
		return false;
    }
    if(document.formulario.funcionalidade.value==""){
        alert("Campo Funcionalidade esta vazio!");
        formulario.funcionalidade.focus();
		return false;
    }    
    if(document.formulario.parteenvolvida.value==""){
        alert("Campo Partes Envolvidas esta vazio!");
        formulario.parteenvolvida.focus();
		return false;
    }
    if(document.formulario.parteenvolvidarepresentante.value==""){
        alert("Campo Parte Envolvida Representante esta vazio!");
        formulario.parteenvolvidarepresentante.focus();
		return false;
    }
    if(document.formulario.parteenvolvidaformacontato.value==""){
        alert("Campo Parte Envolvida/Forma Contato esta vazio!");
        formulario.parteenvolvidaformacontato.focus();
		return false;
    }
    if(document.formulario.estimativacustoglobal.value==""){
        alert("Campo Estimativa de Custo Global esta vazio!");
        formulario.estimativacustoglobal.focus();
		return false;
    }
    if(document.formulario.fontefinanciamento.value==""){
        alert("Campo Fonte de Finaciamento esta vazio!");
        formulario.fontefinanciamento.focus();
		return false;
    }
    if(document.formulario.metodolevantamentocusto.value==""){
        alert("Campo Método Levantamento de Custo esta vazio!");
        formulario.metodolevantamentocusto.focus();
		return false;
    }
    if(document.formulario.numerousuarioprevisto.value==""){
        alert("Campo Numero de Usuário Previsto  esta vazio!");
        formulario.numerousuarioprevisto.focus();
		return false;
    }    
    if(document.formulario.recursos.value==""){
        alert("Campo recursos esta vazio!");
        formulario.recursos.focus();
		return false;
    }
    if(document.formulario.treinamentopessoal.value==""){
        alert("Campo treinamento do pessoal  esta vazio!");
        formulario.treinamentopessoal.focus();
		return false;
    }
    if(document.formulario.materialapoio.value==""){
        alert("Campo material de Apoio  esta vazio!");
        formulario.materialapoio.focus();
		return false;
    }
    if(document.formulario.restricaoprojeto.value==""){
        alert("Campo restrição do projeto esta vazio!");
        formulario.restricaoprojeto.focus();
		return false;
    }
    if(document.formulario.principaisusuarios.value==""){
        alert("Campo principais usuários  esta vazio!");
        formulario.principaisusuarios.focus();
		return false;
    }
    if(document.formulario.necessidadeusuario.value==""){
        alert("Campo necessidade dos usuários  esta vazio!");
        formulario.necessidadeusuario.focus();
		return false;
    }       
    if(document.formulario.prioridade.value==""){
        alert("Campo proposta esta vazio!");
        formularioSolicitacaoServicoTI.prioridade.focus();
		return false;
    }
    if(document.formulario.solucaoatual.value==""){
        alert("Campo solução atual esta vazio!");
        formulario.solucaoatual.focus();
		return false;
    }
    if(document.formulario.problemasolucaoatual.value==""){
        alert("Campo problema c/ solucao atual esta vazio!");
        formulario.problemasolucaoatual.focus();
		return false;
    }
    if(document.formulario.solucaoproposta.value==""){
        alert("Campo solução proposta esta vazio!");
        formulario.solucaoproposta.focus();
		return false;
    }
    if(document.formulario.status.value==""){
        alert("Campo staus esta vazio!");
        formulario.status.focus();
		return false;
    }

}