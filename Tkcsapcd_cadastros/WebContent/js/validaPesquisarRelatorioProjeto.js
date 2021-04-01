function validaPesquisarRelatorioProjeto(){
    if(document.formConsProjeto.consProjeto.value==""){
        alert("Campo Título esta vazio!");
        formConsProjeto.consProjeto.focus();
		return false;
    }
}