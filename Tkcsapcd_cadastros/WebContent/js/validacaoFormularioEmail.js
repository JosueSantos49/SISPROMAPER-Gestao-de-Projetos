$(document).ready(function() {
		$('#emailForm').validate(/*formularioAvaliacao*/
		{
			//Definindo validação pelo nome de cada campo do form
			rules : {
				recipient : {
					required : true,
					minlength : 1
				},
				subject : {
					required : true,
					minlength : 1
				},
			},
			messages : {
				recipient : {
					required : "",
					minlength : ""
				},
				subject : {
					required : "",
					minlength : ""
				}
			}
		});
	});