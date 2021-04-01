function validaPesquisarRelatorioSolicitacaoServicoTI(){	
	if(document.formConsSSTI.consSSTI.value==""){
        alert("Campo código esta vazio!\n\nDigite o código para exibir o relatório.\n\nCode field is empty! Please enter the code to view the report.");
        formConsSSTI.consSSTI.focus();
		return false;
    }
}