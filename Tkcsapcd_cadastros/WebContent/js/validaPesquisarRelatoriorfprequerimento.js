function validaPesquisarRelatoriorfprequerimento(){	
	if(document.formConsRFPRequerimento.consRFPRequerimento.value==""){
        alert("Campo c�digo esta vazio!\n\nDigite o c�digo para exibir o relat�rio. \n\nCode field is empty! Please enter the code to view the report.");
        formConsRFPRequerimento.consRFPRequerimento.focus();
		return false;
    }
}