function validaPesquisarRelatorioRfpProjeto(){
	
    if(document.formConsRfpProjeto.consRfpprojeto.value==""){
        alert("Campo C�digo do Projeto esta vazio. Digite o C�digo do Projeto, para pesquisar o relat�rio! \n\n Project Code field is empty. Enter Code Project, to search for the report!");
        formConsRfpProjeto.consRfpprojeto.focus();
		return false;
    }
}