$(document).ready(function()
			{
				$('#formulario').validate(
					{
						//Definindo valida��o pelo nome de cada campo do form
						rules:{
							nome:{
								required: true,
								minlength: 1	
							},
							id:{
								required: true,
								minlength: 1
							},
							gestorimediato:{
								required: true,
								minlength: 1
							},
							departamento:{
								required: true,
								minlength: 1	
							},
							email:{
								required: true,
								email: true
							},
							telefone:{
								required: true,
								minlength: 1
							},
							usuario:{
								required: true,
								minlength: 1	
							},
							senha:{
								required: true,
								minlength: 1
							},
							nivel:{
								required: true,
								minlength: 1
							}
						},
						messages:{							
							nome : {
								required: " Digite o nome completo do usu�rio!",
								minlength : " Digite o nome completo!"
								},
							id : {
								required: " Digite o 8-ID corretamente para v�lida��o do registro!",
								minlength : "O 8-ID, � composto por oito digito!"
								},
							gestorimediato : {
								required: " Digite o gestor imediato respons�vel vigente!",
								minlength : ""
								},
							departamento : {
								required: " Digite o departamento respons�vel vigente!",
								minlength : ""
								},
							email : {
								required: " Digite um endere�o de e-mail v�lido!",
								minlength : ""
								},
							telefone:{
								required: " Digite um telefone v�lido para contatato!",
								minlength: ""
							},
							usuario:{
								required: "",
								minlength: ""
							},
							senha:{
								required: "",
								minlength: ""
							},
							nivel:{
								required: "",
								minlength: ""
							},
						}
					}
				);	
			});
