function validaPesquisarRelatorioStatuss(){
	
    if(document.formConsultaStatus.consStatuss.value==""){
        alert("Campo código esta vazio. Digite o código, para pesquisar o relatório! \n\n Application código field is empty. Enter the Request, to search for the report!");
        formConsultaStatus.consStatuss.focus();
		return false;
    }
}