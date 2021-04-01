function validaPesquisarRelatorioCliente(){	
	if(document.formConsultaCliente.consCliente.value==""){
        alert("Campo CPF esta vazio!\n\nDigite o CPF do cliente para exibir o relatório. \n\nCPF field is empty! Please enter the customer's CPF to view the report.");
        formConsCliente.consCliente.focus();
		return false;
    }
}