$(document).ready(function()
	{
		$('#formularioRfpRequerimento').validate(
				{
					//Definindo validação pelo nome de cada campo do form
					rules : {
						itensavaliacao : {
							required : true,
							minlength : 1
						},
						avaliacaorfp : {
							required : true,
							minlength : 1
						}
					},
					messages : {
						itensavaliacao : {
							required : "Item avaliação obrigatório.",
							minlength : "Digite o Item avaliação."
						},
						avaliacaorfp : {
							required : "Avaliação RFP obrigatório.",
							minlength : "Digite o RFP-Requerimento."
						},
					}
				});
			});

function validaCadastrarRfpRequerimento(){
    if(document.formularioRfpRequerimento.itensavaliacao.value==""){
        alert("Campo Item Avaliação esta vazio!");
        formularioRfpRequerimento.itensavaliacao.focus();
		return false;
    }
    if(document.formularioRfpRequerimento.avaliacaorfp.value==""){
        alert("Campo Avaliação RFP  esta vazio!");
        formularioRfpRequerimento.avaliacaorfp.focus();
		return false;
    }
}