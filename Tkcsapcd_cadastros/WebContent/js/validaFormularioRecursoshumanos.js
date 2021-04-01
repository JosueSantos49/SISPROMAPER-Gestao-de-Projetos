	$(document).ready(function() {
		$('#formulario').validate({
			//Definindo valida��o pelo nome de cada campo do form
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
					required : "ID obrigat�rio.",
					minlength : "Digite o ID."
				},
				nome : {
					required : "Nome obrigat�rio.",
					minlength : "Digite o nome."
				},
				profissao : {
					required : "Profiss�o obrigat�rio.",
					minlength : "Digite a profiss�o."
				},
				area : {
					required : "�rea obrigat�rio.",
					minlength : "Digite a �rea."
				},
				status : {
					required : "Status obrigat�rio.",
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
			window.alert("Campo profiss�o esta vazio.\n\nDigite a profiss�o!");
			document.getElementById("profissao").focus();
			return false;
		}
		
		if(document.getElementById("area").value == ""){
			window.alert("Campo �rea esta vazio. / Digite a �rea!");
			document.getElementById("area").focus();
			return false;
		}
		if(document.getElementById("status").checked == ""){
			window.alert("Campo status esta vazio. / Digite o status!");
			document.getElementById("status").focus();
			return false;
		}
	}
