function validaPesquisarRelatorioRfiprojeto(){	
	if(document.formConsRfpProjeto.consRfiprojeto.value==""){
        alert("Campo c�digo esta vazio!\n\nDigite o c�digo para exibir o relat�rio. \n\nCode field is empty! Please enter the code to view the report.");
        formConsRfpProjeto.consRfiprojeto.focus();
		return false;
    }
}