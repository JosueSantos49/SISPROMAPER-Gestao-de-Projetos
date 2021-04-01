	$(document).ready(function()
	{
		$('#formulario').validate(
				{
					//Definindo validação pelo nome de cada campo do form
					rules : {
						nome : {
							required : true,
							minlength : 1
						},
						endereco : {
							required : true,
							minlength : 1
						},
						paginaweb : {
							required : true,
							minlength : 1
						},
						produtoservico : {
							required : true,
							minlength : 1
						},
						mercadocliente : {
							required : true,
							minlength : 1
						},
						estruturapropriedade : {
							required : true,
							minlength : 1
						},
						estruturaempresa:{
							required: true,
							minlength : 1	
						},
						anosmercado : {
							required : true,
							minlength : 1
						},
						localizacao : {
							required : true,
							minlength : 1
						},
						gestaoambiental : {
							required : true,
							minlength : 1
						},
						gestaoqualidade : {
							required : true,
							minlength : 1
						},
						gestaonegocio : {
							required : true,
							minlength : 1
						},
						funcionario : {
							required : true,
							minlength : 1
						},
						producao:{
							required: true,
							minlength : 1
						},
						marketingvendas : {
							required : true,
							minlength : 1
						},
						email:{
							required: true,
							email: true	
						},
						departamentoqualidade : {
							required : true,
							minlength : 1
						},
						informacaofinanceira : {
							required : true,
							minlength : 1
						},
						volumenegocio : {
							required : true,
							minlength : 1
						},
						ultimolucroano : {
							required : true,
							minlength : 1
						},
						mercadoacoes : {
							required : true,
							minlength : 1
						},
						pessoacontato:{
							required: true,
							minlength : 1
						},
						telefone : {
							required : true,
							minlength : 1
						},
						capacidadehoje : {
							required : true,
							minlength : 1
						},
						capacidadeantecipada : {
							required : true,
							minlength : 1
						},
						condicaonaoatendida : {
							required : true,
							minlength : 1
						},
						produtosentregues : {
							required : true,
							minlength : 1
						},
						clientereferenciacomparaveis : {
							required : true,
							minlength : 1
						},
						clientereferencianaocomparaveis : {
							required : true,
							minlength : 1
						},
						disponivelentrega:{
							required: true,
							minlength : 1
						},
						disponibilidade : {
							required : true,
							minlength : 1
						},
						suportemundial : {
							required : true,
							minlength : 1
						},
						data : {
							required : true,
							minlength : 1
						}						
					},
					messages : {
						nome : {
							required : "",
							minlength : ""
						},
						endereco : {
							required : "",
							minlength : ""
						},
						paginaweb : {
							required : "",
							minlength : ""
						},
						produtoservico : {
							required : "",
							minlength : ""
						},
						mercadocliente : {
							required : "",
							minlength : ""
						},
						estruturapropriedade : {
							required : "",
							minlength : ""
						},
						estruturaempresa : {
							required : "",
							minlength : ""
						},
						anosmercado : {
							required : "",
							minlength : ""
						},
						localizacao : {
							required : "",
							minlength : ""
						},
						gestaoambiental : {
							required : "",
							minlength : ""
						},
						gestaoqualidade : {
							required : "",
							minlength : ""
						},
						gestaonegocio : {
							required : "",
							minlength : ""
						},
						funcionario : {
							required : "",
							minlength : ""
						},
						producao : {
							required : "",
							minlength : ""
						},
						marketingvendas : {
							required : "",
							minlength : ""
						},
						departamentoqualidade : {
							required : "",
							minlength : ""
						},
						email : {
							required : "",
							minlength : ""
						},
						informacaofinanceira : {
							required : "",
							minlength : ""
						},
						volumenegocio : {
							required : "",
							minlength : ""
						},
						ultimolucroano : {
							required : "",
							minlength : ""
						},
						mercadoacoes : {
							required : "",
							minlength : ""
						},
						pessoacontato : {
							required : "",
							minlength : ""
						},
						telefone : {
							required : "",
							minlength : ""
						},
						capacidadehoje : {
							required : "",
							minlength : ""
						},
						capacidadeantecipada : {
							required : "",
							minlength : ""
						},
						condicaonaoatendida : {
							required : "",
							minlength : ""
						},
						produtosentregues : {
							required : "",
							minlength : ""
						},
						clientereferenciacomparaveis : {
							required : "",
							minlength : ""
						},
						clientereferencianaocomparaveis : {
							required : "",
							minlength : ""
						},
						disponivelentrega : {
							required : "",
							minlength : ""
						},
						disponibilidade : {
							required : "",
							minlength : ""
						},
						suportemundial : {
							required : "",
							minlength : ""
						},
						data : {
							required : "",
							minlength : ""
						},
					}
				});
			});
	
function validaCadastrarRfiProjeto(){
    if(document.formulario.nome.value==""){
        alert("Campo nome esta vazio!");
        formulario.nome.focus();
		return false;
    }
    if(document.formulario.endereco.value==""){
        alert("Campo endereço esta vazio!");
        formulario.endereco.focus();
		return false;
    }
    if(document.formulario.paginaweb.value==""){
        alert("Campo pagina da web esta vazio!");
        formulario.paginaweb.focus();
		return false;
    }
    if(document.formulario.anosmercado.value==""){
        alert("Campo ano no mercado esta vazio!");
        formulario.anosmercado.focus();
		return false;
    }
    if(document.formulario.telefone.value==""){
        alert("Campo telefone esta vazio!");
        formulario.telefone.focus();
		return false;
    }
    if(document.formulario.email.value==""){
        alert("Campo e-mail esta vazio!");
        formulario.email.focus();
		return false;
    }
    if(document.formulario.localizacao.value==""){
        alert("Campo localização esta vazio!");
        formulario.localizacao.focus();
		return false;
    }
    if(document.formulario.ultimolucroano.value==""){
        alert("Campo ultimo lucro do ano esta vazio!");
        formulario.ultimolucroano.focus();
		return false;
    }
    if(document.formulario.pessoacontato.value==""){
        alert("Campo pessoa para contato esta vazio!");
        formulario.pessoacontato.focus();
		return false;
    }
    if(document.formulario.suportemundial.value==""){
        alert("Campo pessoa para contato esta vazio!");
        formulario.suportemundial.focus();
		return false;
    }
    if(document.formulario.data.value==""){
        alert("Campo data esta vazio!");
        formulario.data.focus();
		return false;
    }
    /*
    if(document.formulario.bairro.value==""){
        alert("Campo bairro esta vazio!");
        formulario.bairro.focus();
		return false;
    }
    if(document.formulario.data.value==""){
        alert("Campo data esta vazio!");
        formulario.data.focus();
		return false;
    }
    if(document.formulario.cep.value==""){
        alert("Campo cep esta vazio!");
        formulario.cep.focus();
		return false;
    }
    if(document.formulario.representante.value==""){
        alert("Campo representante esta vazio!");
        formulario.representante.focus();
		return false;
    }*/
}