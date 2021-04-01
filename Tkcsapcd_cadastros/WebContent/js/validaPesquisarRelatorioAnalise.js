function validaPesquisarRelatorioAnalise(){
	
    if(document.formConsaAnalise.consAnalise.value==""){
        alert("Campo Análise esta vazio. Digite a Análise, para pesquisar o relatório! \n\n Review this field empty. Type analysis, to find the report!");
        formConsaAnalise.consAnalise.focus();
		return false;
    }
}