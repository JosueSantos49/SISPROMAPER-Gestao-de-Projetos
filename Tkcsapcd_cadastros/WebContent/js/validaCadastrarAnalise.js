	$(document).ready(function() {
		$('#formularioAnalise').validate({
			//Definindo valida��o pelo nome de cada campo do form
			rules : {
				tipoanalise : {
					required : true,
					minlength : 1
				},
				investimento : {
					required : true,
					minlength : 1
				}
			},
			messages : {
				tipoanalise : {
					required : "Tipo An�lise obrigat�rio.",
					minlength : "Digite o Tipo An�lise."
				},
				investimento : {
					required : "Investimento obrigat�rio.",
					minlength : "Digite o Investimento."
				},
				
			}
		});
	});
function validaCadastrarAnalise(){
    if(document.formularioAnalise.tipoanalise.value==""){
        alert("Campo Tipo An�lise esta vazio!");
        document.getElementById("tipoanalise").focus();
		return false;
    }
    if(document.formularioAnalise.investimento.value==""){
        alert("Campo Investimento esta vazio!");
        document.getElementById("email").focus();
		return false;
    }
    
}