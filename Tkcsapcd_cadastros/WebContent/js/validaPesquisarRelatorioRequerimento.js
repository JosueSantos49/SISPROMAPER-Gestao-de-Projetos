function validaPesquisarRelatorioRequerimento(){
	
    if(document.formConsRequerimento.consRequerimento.value==""){
        alert("Campo código esta vazio. Digite o Requerimento, para pesquisar o relatório! \n\n Application código field is empty. Enter the Request, to search for the report!");
        formConsRequerimento.consRequerimento.focus();
		return false;
    }
}