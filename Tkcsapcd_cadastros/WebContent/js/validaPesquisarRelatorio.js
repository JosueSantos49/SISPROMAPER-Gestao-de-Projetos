function validaPesquisarRelatorio(){
	 if(document.formConsProjeto.consProjeto.value==""){
	        alert("Campo C�digo do Projeto esta vazio. Digite o C�digo do Projeto, para pesquisar o relat�rio! \n\n Project Code field is empty. Enter Code Project, to search for the report!");
	        formConsProjeto.consProjeto.focus();
			return false;
	}
    if(document.formConsRequerimento.consRequerimento.value==""){
        alert("Campo Requerimento Nome esta vazio!");
        formConsRequerimento.consRequerimento.focus();
		return false;
    }
    if(document.formConsaAnalise.consAnalise.value==""){
        alert("Campo Tipo An�lise esta vazio!");
        formConsaAnalise.consAnalise.focus();
		return false;
    }
    if(document.formConsultaStatus.consStatuss.value==""){
        alert("Campo Fase esta vazio!");
        formConsultaStatus.consStatuss.focus();
		return false;
    }
    if(document.formConsRfpProjeto.pesqRfpprojeto.value==""){
        alert("Campo Nome RFP esta vazio!");
        formConsRfpProjeto.pesqRfpprojeto.focus();
		return false;
    }
}