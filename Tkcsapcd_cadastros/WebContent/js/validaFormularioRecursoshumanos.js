	$(document).ready(function() {
		$('#formulario').validate({
			//Definindo validação pelo nome de cada campo do form
			rules : {
				idRecursosHumanos : {
					required : true,
					minlength : 1
				},
				nome : {
					required : true,
					minlength : 1
				},
				profissao : {
					required : true,
					minlength : 1
				},
				area : {
					required : true,
					minlength : 1
				},
				status : {
					required : true,
					minlength : 1
				}
			},
			messages : {
				idRecursosHumanos : {
					required : "ID obrigatório.",
					minlength : "Digite o ID."
				},
				nome : {
					required : "Nome obrigatório.",
					minlength : "Digite o nome."
				},
				profissao : {
					required : "Profissão obrigatório.",
					minlength : "Digite a profissão."
				},
				area : {
					required : "Área obrigatório.",
					minlength : "Digite a área."
				},
				status : {
					required : "Status obrigatório.",
					minlength : "Digite o status."
				},				
			}
		});
	});
	
	function validaRecursosHumanos(){	
		
		if(document.getElementById("idRecursosHumanos").value== ""){
			window.alert("Campo ID esta vazio.\n\nDigite o ID!");
			document.getElementById("idRecursosHumanos").focus();
			return false;
		}
		if(document.getElementById("nome").value == ""){
			window.alert("Campo nome esta vazio.\n\nDigite o nome!");
			document.getElementById("nome").focus();
			return false;
		}
		if(document.getElementById("profissao").value == ""){
			window.alert("Campo profissão esta vazio.\n\nDigite a profissão!");
			document.getElementById("profissao").focus();
			return false;
		}
		
		if(document.getElementById("area").value == ""){
			window.alert("Campo área esta vazio. / Digite a área!");
			document.getElementById("area").focus();
			return false;
		}
		if(document.getElementById("status").checked == ""){
			window.alert("Campo status esta vazio. / Digite o status!");
			document.getElementById("status").focus();
			return false;
		}
	}
