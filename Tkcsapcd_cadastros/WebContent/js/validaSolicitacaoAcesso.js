$(document).ready(function()
	{
		$('#formSolicitacaoCadastro').validate(
			{
				//Definindo validação pelo nome de cada campo do form
				rules:{
					nome:{
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
					area : {
						required : true,
						minlength : 1
					},
					
					funcao:{
						required: true,
						minlength: 1
					},
					responsavel : {
						required : true,
						minlength : 1
					},
					telefone : {
						required : true,
						minlength : 1
					},
					obs : {
						required : true,
						minlength : 1
					},
					status : {
						required : true,
						minlength : 1
					},
										
					
				},
				messages:{
					nome:{
						required: "",
						minlength: ""
					},

					email:{
						required: "",
						email: ""
					},
					id:{
						required: "",
						email: ""
					},
					area:{
						required: "",
						minlength: ""
					},
					funcao:{
						required: "",
						minlength: ""
					},
					responsavel : {
						required : "",
						minlength: ""
					},
					telefone : {
						required : "",
						minlength: ""
					},
					obs : {
						required : "",
						minlength: ""
					},
					data : {
						required : "",
						minlength: ""
					},
					status : {
						required : "",
						minlength: ""
					},
				}
			}
		);	
	});

function validaSolicitacaoAcesso(){
	
    if(document.formSolicitacaoCadastro.nome.value==""){
        alert("Campo nome esta vazio!");
        document.getElementById("nome").focus();
		return false;
    }
    if(document.formSolicitacaoCadastro.email.value==""){
        alert("Campo email esta vazio!");
        document.getElementById("email").focus();
		return false;
    }
    if(document.formSolicitacaoCadastro.id.value==""){
        alert("Campo ID esta vazio!");
        document.getElementById("id").focus();
		return false;
    }
    if(document.formSolicitacaoCadastro.area.value==""){
        alert("Campo área esta vazio!");
        document.getElementById("area").focus();
		return false;
    }
    if(document.formSolicitacaoCadastro.funcao.value==""){
        alert("Campo funcao esta vazio!");
        document.getElementById("funcao").focus();
		return false;
    }
    if(document.formSolicitacaoCadastro.responsavel.value==""){
        alert("Campo responsavel esta vazio!");
        document.getElementById("responsavel").focus();
		return false;
    }
    if(document.formSolicitacaoCadastro.telefone.value==""){
        alert("Campo telefone esta vazio!");
        document.getElementById("telefone").focus();
		return false;
    }
    if(document.formSolicitacaoCadastro.data.value==""){
        alert("Campo data esta vazio!");
        document.getElementById("data").focus();
		return false;
    }
    if(document.formSolicitacaoCadastro.status.selectedIndex==""){
        alert("Campo status esta vazio!");
        formSolicitacaoCadastro.status.focus();
		return false;
    }
}


