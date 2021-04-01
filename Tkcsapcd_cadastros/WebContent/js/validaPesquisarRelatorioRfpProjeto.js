function validaPesquisarRelatorioRfpProjeto(){
	
    if(document.formConsRfpProjeto.consRfpprojeto.value==""){
        alert("Campo Código do Projeto esta vazio. Digite o Código do Projeto, para pesquisar o relatório! \n\n Project Code field is empty. Enter Code Project, to search for the report!");
        formConsRfpProjeto.consRfpprojeto.focus();
		return false;
    }
}