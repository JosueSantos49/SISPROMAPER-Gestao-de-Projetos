function validaPesquisarRelatorioAlocacao(){	
	if(document.formConsAlocacao.consAlocacao.value==""){
        alert("Campo R.H esta vazio!\n\nDigite o R.H para exibir o relatório. \n\nHR field is empty! Please enter the HR to view the report.");
        formConsAlocacao.consAlocacao.focus();
		return false;
    }
}