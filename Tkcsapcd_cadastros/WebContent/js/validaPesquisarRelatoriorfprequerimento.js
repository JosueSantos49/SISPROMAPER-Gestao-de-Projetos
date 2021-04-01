function validaPesquisarRelatoriorfprequerimento(){	
	if(document.formConsRFPRequerimento.consRFPRequerimento.value==""){
        alert("Campo código esta vazio!\n\nDigite o código para exibir o relatório. \n\nCode field is empty! Please enter the code to view the report.");
        formConsRFPRequerimento.consRFPRequerimento.focus();
		return false;
    }
}