function validaPesquisarRelatorioRequerimento(){
	
    if(document.formConsRequerimento.consRequerimento.value==""){
        alert("Campo c�digo esta vazio. Digite o Requerimento, para pesquisar o relat�rio! \n\n Application c�digo field is empty. Enter the Request, to search for the report!");
        formConsRequerimento.consRequerimento.focus();
		return false;
    }
}