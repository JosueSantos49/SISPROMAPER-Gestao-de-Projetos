function validaPesquisarRelatorioProjeto(){
    if(document.formConsProjeto.consProjeto.value==""){
        alert("Campo T�tulo esta vazio!");
        formConsProjeto.consProjeto.focus();
		return false;
    }
}