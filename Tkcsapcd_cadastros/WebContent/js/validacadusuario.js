
function validacadusuario(){
	
	var x=document.forms["formulario"]["email"].value;
	var atpos=x.indexOf("@");
	var dotpos=x.lastIndexOf(".");
	if (atpos<1 || dotpos<atpos+2 || dotpos+2>=x.length)
	{
	alert("N�o � um endere�o de e-mail v�lido!\n\nEntre com um endere�o de e-mail v�lido.");
	return false;
	}
	return true;
	
	if(document.formulario.nome.value==""){
        alert("Campo nome esta vazio!\n\nDigite o nome. \n\nName field is empty! Please enter the name.");
        document.getElementById("usuario").focus();
		return false;
    }
    if(document.formulario.id.value==""){
        alert("Campo ID esta vazio!\n\nDigite o ID. \n\nDI field is empty! Please enter the DI.");
        document.getElementById("id").focus();
		return false;
    }
    if(document.formulario.gestorimediato.value==""){
        alert("Campo gestor imediato esta vazio!\n\nDigite o gestor imediato. \n\nNimmediate manager field is empty! Please enter the immediate manager.");
        document.getElementById("gestorimediato").focus();
		return false;
    }
    if(document.formulario.usuario.value==""){
        alert("Campo usu�rio esta vazio!\n\nDigite o usu�rio. \n\nUser field is empty! Please enter the user.");
        document.getElementById("usuario").focus();
		return false;
    }
    if(document.formulario.senha.value==""){
        alert("Campo senha esta vazio!\n\nDigite a senha. \n\nType the password.");
        document.getElementById("senha").focus();
		return false;
    }
    if(document.formulario.nivel.selectedIndex == ""){
        alert("Campo n�vel acesso esta vazio.\n\nSelecione o n�vel acesso. \n\nSelect the access level.");
        document.getElementById("nivel").focus();
		return false;
    }
    if(document.getElementById("nivel").selectedIndex == ""){
		window.alert("Campo n�vel esta vazio.\n\nSelecione o n�vel. \n\nSelect the access level.");
		document.getElementById("nivel").focus();
		return false;
	}
    if(document.formulario.cpf.value==""){
        alert("Campo CPF esta vazio!\n\nDigite o CPF. \n\nEnter the CPF.");
        document.getElementById("cpf").focus();
		return false;
    }
    if(document.formulario.datacadastro.value==""){
        alert("Campo data cadastro esta vazio!\n\nDigite a data de cadastro. \n\nEnter the registration date.");
        document.getElementById("datacadastro").focus();
		return false;
    }
}