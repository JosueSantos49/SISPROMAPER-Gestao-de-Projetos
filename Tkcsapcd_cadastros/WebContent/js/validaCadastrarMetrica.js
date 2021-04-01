$(document).ready(function() {
		$('#formulario').validate({
			//Definindo valida��o pelo nome de cada campo do form
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
					required : "ID obrigat�rio.",
					minlength : "Digite o ID."
				},
				nomeMetrica : {
					required : "Nome m�trica obrigat�rio.",
					minlength : "Digite o nome m�trica."
				},
				indiceMetrica : {
					required : "Indice m�trica obrigat�rio.",
					minlength : "Digite o indice da m�trica."
				},
				valorReferenciaHora : {
					required : "Valor Refer�ncia - Hora obrigat�rio.",
					minlength : "Digite o valor Refer�ncia - Hora."
				},
				valorHoraCalculadaDia : {
					required : "Valor Hora Calculada - Dia obrigat�rio.",
					minlength : "Digite o valor Hora Calculada - Dia."
				},
				
			}
		});
	});

function validaCadastrarMetrica(){
    if(document.formulario.idMetricas.value==""){
        alert("Campo id m�trica esta vazio!");
        formulario.idMetricas.focus();
		return false;
    }
    if(document.formulario.nomeMetrica.value==""){
        alert("Campo nome m�trica esta vazio!");
        formulario.nomeMetrica.focus();
		return false;
    }
    if(document.formulario.indiceMetrica.value==""){
        alert("Campo indice m�trica esta vazio!");
        formulario.indiceMetrica.focus();
		return false;
    }
    if(document.formulario.valorReferenciaHora.value==""){
        alert("Campo valor refer�ncia hora esta vazio!");
        formulario.valorReferenciaHora.focus();
		return false;
    }
    if(document.formulario.valorHoraCalculadaDia.value==""){
        alert("Campo valor hora calculada dia esta vazio!");
        formulario.valorHoraCalculadaDia.focus();
		return false;
    }
}