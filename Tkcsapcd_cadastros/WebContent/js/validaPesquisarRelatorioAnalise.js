function validaPesquisarRelatorioAnalise(){
	
    if(document.formConsaAnalise.consAnalise.value==""){
        alert("Campo An�lise esta vazio. Digite a An�lise, para pesquisar o relat�rio! \n\n Review this field empty. Type analysis, to find the report!");
        formConsaAnalise.consAnalise.focus();
		return false;
    }
}