function validaPesquisarRelatorioSolicitacao(){	
	if(document.formConsSolicitacao.consSolicitacao.value==""){
        alert("Campo ID esta vazio!\n\nDigite o ID do usuário para exibir o relatório. \n\nID field is empty! Please enter the user ID to view the report.");
        formConsSolicitacao.consSolicitacao.focus();
		return false;
    }
}