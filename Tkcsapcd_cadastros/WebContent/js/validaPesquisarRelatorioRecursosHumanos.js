function validaPesquisarRelatorioRecursosHumanos(){	
	if(document.formConsRH.consRH.value==""){
        alert("Campo ID esta vazio!\n\nDigite o ID para exibir o relat�rio. \n\nID field is empty! Please enter the ID to view the report.");
        formConsRH.consRH.focus();
		return false;
    }
}