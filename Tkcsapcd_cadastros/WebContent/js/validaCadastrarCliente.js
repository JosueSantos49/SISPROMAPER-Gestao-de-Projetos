$(document).ready(function()
	{
		$('#formulario').validate(
			{
				//Definindo validação pelo nome de cada campo do form
				rules:{
					nome:{
						required: true,
						minlength: 1
					},
					nascimento:{
						required: true,
						minlength: 1
					},
					profissao:{
						required: true,
						minlength: 1
					},
					renda:{
						required: true,
						minlength: 1
					},
					email:{
						required: true,
						email: true
					},						
					endereco:{
						required: true,
						minlength: 1
					},
					bairro:{
						required: true,
						minlength: 1
					},
					cargo:{
						required: true,
						minlength: 1
					},
					sexo:{
						required: true,
						minlength: 1
					},
					rg : {
						required : true,
						minlength : 9
					},
					orgaorg : {
						required : true,
						minlength : 1
					},
					cpf : {
						required : true,
						minlength : 11
					},
					cep : {
						required : true,
						minlength : 8
					},
					cnpj : {
						required : true,
						minlength : 14
					},
					empresa : {
						required : true,
						minlength : 1
					},
					desde : {
						required : true,
						minlength : 1
					}
				},
				messages:{
					nome:{
						required: "Nome obrigatório.",
						minlength: "Digite o nome completo."
					},
					nascimento:{
						required: "",
						//minlength: "Digite o nascimento."
					},
					profissao:{
						required: "Profissão obrigatório.",
						minlength: "Digite a profissão."
					},
					renda:{
						required: "Renda obrigatório.",
						minlength: "Digite a renda."
					},
					email:{
						required: "E-mail obrigatório.",
						email: "Digite um e-mail válido."
					},						
					endereco:{
						required: "Endereço brigatório.",
						minlength: "Digite o endereço."
					},
					bairro:{
						required: "Bairro obrigatório",
						minlength: "Digite o bairro."
					},
					cargo:{
						required: "Cargo obrigatório.",
						minlength: "Digite o cargo."
					},
					rg : {
						required : ""
					},
					orgaorg : {
						required : "Orgão emissor obrigatório.",
						minlength: "Digite o orgão emissor."
					},
					cpf : {
						required : ""
					},
					cep : {
						required : ""
					},
					cnpj : {
						required : ""
					},
					empresa : {
						required : "Empresa é obrigatório.",
						minlength: "Digite a empres."
					},
					desde : {
						required : "",
						minlength: ""
					},
				}
			}
		);	
	});
function validaCadastrarCliente(){
    if(document.formulario.nome.value==""){
        alert("Campo nome esta vazio!");
        formulario.nome.focus();
		return false;
    }
    if(document.formulario.nascimento.value==""){
        alert("Campo nascimento esta vazio!");
        formulario.nascimento.focus();
		return false;
    }
    if(document.formulario.profissao.value==""){
        alert("Campo profissão esta vazio!");
        formulario.profissao.focus();
		return false;
    }
    if(document.formulario.renda.value==""){
        alert("Campo renda esta vazio!");
        formulario.renda.focus();
		return false;
    }
    if(document.formulario.rg.value==""){
        alert("Campo RG esta vazio!");
        formulario.rg.focus();
		return false;
    }
    if(document.formulario.orgaorg.value==""){
        alert("Campo Orgão Emissor  esta vazio!");
        formulario.orgaorg.focus();
		return false;
    }
    if(document.formulario.endereco.value==""){
        alert("Campo endereço esta vazio!");
        formulario.endereco.focus();
		return false;
    }
    if(document.formulario.bairro.value==""){
        alert("Campo bairro esta vazio!");
        formulario.bairro.focus();
		return false;
    }
    if(document.formulario.cep.value==""){
        alert("Campo CEP esta vazio!");
        formulario.cep.focus();
		return false;
    }
    if(document.formulario.cpf.value==""){
        alert("Campo CPF esta vazio!");
        formulario.cpf.focus();
		return false;
    }
    
    if(document.formulario.cnpj.value==""){
        alert("Campo CNPJ esta vazio!");
        formulario.cnpj.focus();
		return false;
    }
    if(document.formulario.desde.value==""){
        alert("Campo desde esta vazio!");
        formulario.desde.focus();
		return false;
    }
    if(document.formulario.email.value==""){
        alert("Campo e-mail esta vazio!");
        formulario.email.focus();
		return false;
    }
    if(document.formulario.empresa.value==""){
        alert("Campo empresa esta vazio!");
        formulario.empresa.focus();
		return false;
    }
}

//valida o CPF digitado
function ValidarCPF(Objcpf){
	var cpf = Objcpf.value;
	exp = /\.|\-/g
	cpf = cpf.toString().replace( exp, "" ); 
	var digitoDigitado = eval(cpf.charAt(9)+cpf.charAt(10));
	var soma1=0, soma2=0;
	var vlr =11;
	
	for(i=0;i<9;i++){
		soma1+=eval(cpf.charAt(i)*(vlr-1));
		soma2+=eval(cpf.charAt(i)*vlr);
		vlr--;
	}	
	soma1 = (((soma1*10)%11)==10 ? 0:((soma1*10)%11));
	soma2=(((soma2+(2*soma1))*10)%11);
	
	var digitoGerado=(soma1*10)+soma2;
	if(digitoGerado!=digitoDigitado)	
		alert('CPF Invalido!');		
}

