function validaPesquisarRelatorioStatuss(){
	
    if(document.formConsultaStatus.consStatuss.value==""){
        alert("Campo c�digo esta vazio. Digite o c�digo, para pesquisar o relat�rio! \n\n Application c�digo field is empty. Enter the Request, to search for the report!");
        formConsultaStatus.consStatuss.focus();
		return false;
    }
}