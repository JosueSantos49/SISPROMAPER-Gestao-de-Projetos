	$(document).ready(function() {
		$('#formularioAnalise').validate({
			//Definindo validação pelo nome de cada campo do form
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
					required : "Tipo Análise obrigatório.",
					minlength : "Digite o Tipo Análise."
				},
				investimento : {
					required : "Investimento obrigatório.",
					minlength : "Digite o Investimento."
				},
				
			}
		});
	});
function validaCadastrarAnalise(){
    if(document.formularioAnalise.tipoanalise.value==""){
        alert("Campo Tipo Análise esta vazio!");
        document.getElementById("tipoanalise").focus();
		return false;
    }
    if(document.formularioAnalise.investimento.value==""){
        alert("Campo Investimento esta vazio!");
        document.getElementById("email").focus();
		return false;
    }
    
}