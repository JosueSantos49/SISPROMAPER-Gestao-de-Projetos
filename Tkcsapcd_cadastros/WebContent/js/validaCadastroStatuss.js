$(document).ready(function()
	{
		$('#formulario').validate(
			{
				//Definindo validação pelo nome de cada campo do form
				rules:{
					fase:{
						required: true,
						minlength: 1	
					},
					percentualevolucao:{
						required: true,
						minlength: 1
					},
					percentualplanejado:{
						required: true,
						minlength: 1
					},
					datastatus:{
						required: true,
						minlength: 1
					},
					descricao:{
						required: true,
						minlength: 1	
					},
					pontospositivos:{
						required: true,
						minlength: 1
					},
					pontosnegativos:{
						required: true,
						minlength: 1
					},
					tendencia:{
						required: true,
						minlength: 1
					},
					datainicio:{
						required: true,
						minlength: 1
					},
					datafim:{
						required: true,
						minlength: 1
					}
				},
				messages:{
					fase:{
						required: "Fase obrigatório.",
						minlength: "Digite a fase."
					},
					percentualevolucao:{
						required: "Percentual Evolucao obrigatório.",
						//minlength: "Digite o percentual evolucao."
					},
					percentualplanejado:{
						required: "Percentual Planejado obrigatório.",
						//minlength: "Digite o percentual planejado."	
					},
					datastatus:{
						required: "",
						minlength: ""	
					},
					descricao:{
						required: "Descrição obrigatório.",
						minlength: "Digite a descrição."
					},
					pontospositivos:{
						required: "Pontos Positivos obrigatório.",
						minlength: "Digite o ponto positivo"
					},
					pontosnegativos:{
						required: "Ponto negativo obrigatório.",
						minlength: "Digite o ponto negativo."
					},
					tendencia:{
						required: "Tendência obrigatório.",
						minlength: "Digite a tendência."
					},
					datainicio:{
						required: "",
						minlength: ""	
					},
					datafim:{
						required: "",
						minlength: ""	
					}
				}
			}
		);	
	});

function validaCadastroStatuss(){
    if(document.formulario.fase.value==""){
        alert("Campo fase esta vazio!");
        document.getElementById("fase").focus();
		return false;
    }
    if(document.formulario.percentualevolucao.value==""){
        alert("Campo percentual evolucao esta vazio!");
        document.getElementById("percentualevolucao").focus();
		return false;
    }
    if(document.formulario.percentualplanejado.value==""){
        alert("Campo percentual planejado esta vazio!");
        document.getElementById("percentualplanejado").focus();
		return false;
    }
    if(document.formulario.datastatus.value==""){
        alert("Campo data status esta vazio!");
        document.getElementById("datastatus").focus();
		return false;
    }
    if(document.formulario.descricao.value==""){
        alert("Campo descricao esta vazio!");
        document.getElementById("descricao").focus();
		return false;
    }
    if(document.formulario.pontospositivos.value==""){
        alert("Campo ponto positivo esta vazio!");
        document.getElementById("pontospositivos").focus();
		return false;
    }
    if(document.formulario.pontosnegativos.value==""){
        alert("Campo ponto negativo esta vazio!");
        document.getElementById("pontosnegativos").focus();
		return false;
    }
    if(document.formulario.tendencia.value==""){
        alert("Campo tendencia esta vazio!");
        document.getElementById("tendencia").focus();
		return false;
    }
    if(document.formulario.datainicio.value==""){
        alert("Campo data início esta vazio!");
        document.getElementById("datainicio").focus();
		return false;
    }
    if(document.formulario.datafim.value==""){
        alert("Campo data fim esta vazio!");
        document.getElementById("datafim").focus();
		return false;
    }
}