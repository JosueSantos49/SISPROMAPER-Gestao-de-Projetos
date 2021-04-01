function validaPesquisarRelatorioUsuario(){	
	if(document.formConsUsuario.consUsuario.value==""){
        alert("Campo 8-ID esta vazio!\n\nDigite o 8-ID do usuário para exibir o relatório.");
        formConsUsuario.consUsuario.focus();
		return false;
    }
}