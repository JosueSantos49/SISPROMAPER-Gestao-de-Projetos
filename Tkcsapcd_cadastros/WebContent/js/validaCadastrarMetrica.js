$(document).ready(function() {
		$('#formulario').validate({
			//Definindo validação pelo nome de cada campo do form
			rules : {
				idMetricas : {
					required : true,
					minlength : 1
				},
				nomeMetrica : {
					required : true,
					minlength : 1
				},
				indiceMetrica : {
					required : true,
					minlength : 1
				},
				valorReferenciaHora : {
					required : true,
					minlength : 1
				},
				valorHoraCalculadaDia : {
					required : true,
					minlength : 1
				}
			},
			messages : {
				idMetricas : {
					required : "ID obrigatório.",
					minlength : "Digite o ID."
				},
				nomeMetrica : {
					required : "Nome métrica obrigatório.",
					minlength : "Digite o nome métrica."
				},
				indiceMetrica : {
					required : "Indice métrica obrigatório.",
					minlength : "Digite o indice da métrica."
				},
				valorReferenciaHora : {
					required : "Valor Referência - Hora obrigatório.",
					minlength : "Digite o valor Referência - Hora."
				},
				valorHoraCalculadaDia : {
					required : "Valor Hora Calculada - Dia obrigatório.",
					minlength : "Digite o valor Hora Calculada - Dia."
				},
				
			}
		});
	});

function validaCadastrarMetrica(){
    if(document.formulario.idMetricas.value==""){
        alert("Campo id métrica esta vazio!");
        formulario.idMetricas.focus();
		return false;
    }
    if(document.formulario.nomeMetrica.value==""){
        alert("Campo nome métrica esta vazio!");
        formulario.nomeMetrica.focus();
		return false;
    }
    if(document.formulario.indiceMetrica.value==""){
        alert("Campo indice métrica esta vazio!");
        formulario.indiceMetrica.focus();
		return false;
    }
    if(document.formulario.valorReferenciaHora.value==""){
        alert("Campo valor referência hora esta vazio!");
        formulario.valorReferenciaHora.focus();
		return false;
    }
    if(document.formulario.valorHoraCalculadaDia.value==""){
        alert("Campo valor hora calculada dia esta vazio!");
        formulario.valorHoraCalculadaDia.focus();
		return false;
    }
}