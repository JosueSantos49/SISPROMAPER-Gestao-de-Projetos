	$(document).ready(function()
	{
		$('#formulario').validate(
				{
					//Definindo validação pelo nome de cada campo do form
					rules : {
						codigoProjeto : {
							required : true,
							minlength : 1
						},
						itensProjeto : {
							required : true,
							minlength : 1
						},
						nomeRfpProjeto : {
							required : true,
							minlength : 1
						},
						nomeempresa : {
							required : true,
							minlength : 1
						},
						historicoempresa : {
							required : true,
							minlength : 1
						},
						produtoempresa : {
							required : true,
							minlength : 1
						},
						mercadoempresa:{
							required: true,
							minlength : 1	
						},
						valoresempresa : {
							required : true,
							minlength : 1
						},
						endereco : {
							required : true,
							minlength : 1
						},
						cidade : {
							required : true,
							minlength : 1
						},
						estado : {
							required : true,
							minlength : 1
						},
						numero : {
							required : true,
							minlength : 1
						},
						bairro : {
							required : true,
							minlength : 1
						},
						cep:{
							required: true,
							minlength : 1
						},
						representante : {
							required : true,
							minlength : 1
						},
						emailrepresentante:{
							required: true,
							email: true	
						},
						aquisicao : {
							required : true,
							minlength : 1
						},
						escopo : {
							required : true,
							minlength : 1
						},
						restricao : {
							required : true,
							minlength : 1
						},
						recurso : {
							required : true,
							minlength : 1
						},
						avaliacao : {
							required : true,
							minlength : 1
						},
						cronograma:{
							required: true,
							minlength : 1
						},
						proposta : {
							required : true,
							minlength : 1
						},
						condicaoproposta : {
							required : true,
							minlength : 1
						},
						observacao : {
							required : true,
							minlength : 1
						},
						data : {
							required : true,
							minlength : 1
						}						
					},
					messages : {
						codigoProjeto : {
							required : "",
							minlength : ""
						},
						itensProjeto : {
							required : "",
							minlength : ""
						},
						nomeRfpProjeto : {
							required : "",
							minlength : ""
						},
						nomeempresa : {
							required : "",
							minlength : ""
						},
						historicoempresa : {
							required : "",
							minlength : ""
						},
						produtoempresa : {
							required : "",
							minlength : ""
						},
						mercadoempresa : {
							required : "",
							minlength : ""
						},
						valoresempresa : {
							required : "",
							minlength : ""
						},
						endereco : {
							required : "",
							minlength : ""
						},
						cidade : {
							required : "",
							minlength : ""
						},
						estado : {
							required : "",
							minlength : ""
						},
						numero : {
							required : "",
							minlength : ""
						},
						bairro : {
							required : "",
							minlength : ""
						},
						cep : {
							required : "",
							minlength : ""
						},
						telefone : {
							required : "",
							minlength : ""
						},
						representante : {
							required : "",
							minlength : ""
						},
						emailrepresentante : {
							required : "",
							minlength : ""
						},
						aquisicao : {
							required : "",
							minlength : ""
						},
						escopo : {
							required : "",
							minlength : ""
						},
						avaliacao : {
							required : "",
							minlength : ""
						},
						cronograma : {
							required : "",
							minlength : ""
						},
						proposta : {
							required : "",
							minlength : ""
						},
						condicaoproposta : {
							required : "",
							minlength : ""
						},
						observacao : {
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
	
function validaCadastrarRfpProjeto(){
    if(document.formulario.codigoProjeto.value==""){
        alert("Campo Código Projeto esta vazio!");
        formulario.autorProjeto.focus();
		return false;
    }
    if(document.formulario.itensProjeto.value==""){
        alert("Campo Item Projeto esta vazio!");
        formulario.dataProjeto.focus();
		return false;
    }
    if(document.formulario.nomeRfpProjeto.value==""){
        alert("Campo nome Rfp-Projeto esta vazio!");
        formulario.nomeRfpProjeto.focus();
		return false;
    }
    if(document.formulario.nomeempresa.value==""){
        alert("Campo nome da empresa esta vazio!");
        formulario.nomeempresa.focus();
		return false;
    }
    if(document.formulario.historicoempresa.value==""){
        alert("Campo historico da empresa esta vazio!");
        formulario.historicoempresa.focus();
		return false;
    }
    if(document.formulario.telefone.value==""){
        alert("Campo telefone esta vazio!");
        formulario.telefone.focus();
		return false;
    }
    if(document.formulario.emailrepresentante.value==""){
        alert("Campo email representante esta vazio!");
        formulario.emailrepresentante.focus();
		return false;
    }
    if(document.formulario.endereco.value==""){
        alert("Campo endereço esta vazio!");
        formulario.endereco.focus();
		return false;
    }
    if(document.formulario.estado.value==""){
        alert("Campo estado esta vazio!");
        formulario.estado.focus();
		return false;
    }
    if(document.formulario.cidade.value==""){
        alert("Campo cidade esta vazio!");
        formulario.cidade.focus();
		return false;
    }
    if(document.formulario.numero.value==""){
        alert("Campo numero esta vazio!");
        formulario.numero.focus();
		return false;
    }
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
    }
}