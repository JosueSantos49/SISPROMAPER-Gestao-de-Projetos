$(document).ready(function()
	{
		$('#formularioRfpRequerimento').validate(
				{
					//Definindo valida��o pelo nome de cada campo do form
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
							required : "Item avalia��o obrigat�rio.",
							minlength : "Digite o Item avalia��o."
						},
						avaliacaorfp : {
							required : "Avalia��o RFP obrigat�rio.",
							minlength : "Digite o RFP-Requerimento."
						},
					}
				});
			});

function validaCadastrarRfpRequerimento(){
    if(document.formularioRfpRequerimento.itensavaliacao.value==""){
        alert("Campo Item Avalia��o esta vazio!");
        formularioRfpRequerimento.itensavaliacao.focus();
		return false;
    }
    if(document.formularioRfpRequerimento.avaliacaorfp.value==""){
        alert("Campo Avalia��o RFP  esta vazio!");
        formularioRfpRequerimento.avaliacaorfp.focus();
		return false;
    }
}