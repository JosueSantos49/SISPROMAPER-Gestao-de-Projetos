function validalogin(){
    if(document.loginForm.usuario.value==""){
        alert("Campo usuário esta vazio!\n\nEntre com o usuário o campo é obrigatório!\n\nCaso ainda não tenha cadastro no sistema poderá solicitar através do link solicitação acesso.\n\nPara recuperar usuário e senha acesse o link recuperar acesso. \n\n User field is empty! Please with the user field is required! If not have registration in the system may also request through the link request access. For recover username and password to access the link regain access.");
        formlogin.usuario.focus();
		return false;
    }
    if(document.loginForm.senha.value==""){
        alert("Campo senha esta vazio!\n\nEntre com a senha o campo é obrigatório!\n\nCaso ainda não tenha cadastro no sistema poderá solicitar através do link solicitação acesso.\n\nPara recuperar usuário e senha acesse o link recuperar acesso. \n\n Password field is empty! Please with the password field is required! If you have not yet joined the system may request through the link request access. For recover username and password to access the link regain access.");
        document.getElementById("senha").focus();
		return false;
    }
}