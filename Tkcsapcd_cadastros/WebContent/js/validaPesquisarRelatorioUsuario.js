function validaPesquisarRelatorioUsuario(){	
	if(document.formConsUsuario.consUsuario.value==""){
        alert("Campo 8-ID esta vazio!\n\nDigite o 8-ID do usu�rio para exibir o relat�rio.");
        formConsUsuario.consUsuario.focus();
		return false;
    }
}