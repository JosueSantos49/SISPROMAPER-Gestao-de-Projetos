
	$(document).ready(function()
	{
		$('#formularioAlocacao').validate(
			{
				//Definindo validação pelo nome de cada campo do form
				rules:{
					data:{
						required: true,
						minlength: 1	
					},
					data0:{
						required: true,
						minlength: 1
					},
					metrica:{
						required: true,
						minlength: 1
					},
					metrica1:{
						required: true,
						minlength: 1
					},
					metrica2:{
						required: true,
						minlength: 1	
					},
					metrica3:{
						required: true,
						minlength: 1
					},
					metrica4:{
						required: true,
						minlength: 1
					},
					metrica5:{
						required: true,
						minlength: 1
					},
					metrica6:{
						required: true,
						minlength: 1	
					},
					metrica7:{
						required: true,
						minlength: 1
					},
					metrica8:{
						required: true,
						minlength: 1
					},
					metrica9:{
						required: true,
						minlength: 1
					},
					metrica10:{
						required: true,
						minlength: 1	
					},
					metrica11:{
						required: true,
						minlength: 1
					},
					metrica12:{
						required: true,
						minlength: 1
					},
					metrica13:{
						required: true,
						minlength: 1
					},
					metrica14:{
						required: true,
						minlength: 1	
					},
					metrica15:{
						required: true,
						minlength: 1
					},
					metrica16:{
						required: true,
						minlength: 1
					}
				},
				messages:{
					data:{
						required: "",
						minlength: ""
					},
					data0:{
						required: "",
						minlength: ""
					},
					metrica:{
						required: "",
						minlength: ""
					},
					metrica1:{
						required: "",
						minlength: ""	
					},
					metrica2:{
						required: "",
						minlength: ""
					},
					metrica3:{
						required: "",
						minlength: ""
					},
					metrica4:{
						required: "",
						minlength: ""
					},
					metrica5:{
						required: "",
						minlength: ""	
					},
					metrica6:{
						required: "",
						minlength: ""
					},
					metrica7:{
						required: "",
						minlength: ""
					},
					metrica8:{
						required: "",
						minlength: ""
					},
					metrica9:{
						required: "",
						minlength: ""	
					},
					metrica10:{
						required: "",
						minlength: ""
					},
					metrica11:{
						required: "",
						minlength: ""
					},
					metrica12:{
						required: "",
						minlength: ""
					},
					metrica13:{
						required: "",
						minlength: ""	
					},
					metrica14:{
						required: "",
						minlength: ""
					},
					metrica15:{
						required: "",
						minlength: ""
					},
					metrica16:{
						required: "",
						minlength: ""
					}
				}
			}
		);	
	});
	function validaalocacao(){	
		/*
		if(document.getElementById("projeto_codigo").selectedIndex == ""){
			window.alert("Campo projeto esta vazio.\n\nSelecione o projeto.");
			document.getElementById("projeto_codigo").focus();
			return false;
		}
		if(document.getElementById("recursoshumanos_codigo").selectedIndex == ""){
			window.alert("Campo recursos humanso esta vazio.\n\nSelecione o recursos humanso.");
			document.getElementById("recursoshumanos_codigo").focus();
			return false;
		}
		if(document.getElementById("profissao_codigo").selectedIndex == ""){
			window.alert("Campo profissão esta vazio.\n\nSelecione a profissão.");
			document.getElementById("profissao_codigo").focus();
			return false;
		}*/
		
		/*FY 14/15*/
		if(document.formularioAlocacao.data.value==""){
	        alert("Campo período inicial esta vazio!");
	        formularioAlocacao.data.focus();
			return false;
	    }
		if(document.formularioAlocacao.data0.value==""){
	        alert("Campo período final esta vazio!");
	        formularioAlocacao.data0.focus();
			return false;
	    }
		if(document.formularioAlocacao.metrica1.value==""){
	        alert("Campo Apr (FY14/15) esta vazio!");
	        formularioAlocacao.metrica1.focus();
			return false;
	    }
		if(document.formularioAlocacao.metrica2.value==""){
	        alert("Campo May (14/15) esta vazio!");
	        formularioAlocacao.metrica2.focus();
			return false;
	    }if(document.formularioAlocacao.metrica3.value==""){
	        alert("Campo Jun (14/15) esta vazio!");
	        formularioAlocacao.metrica3.focus();
			return false;
	    }if(document.formularioAlocacao.metrica4.value==""){
	        alert("Campo Jul (14/15) esta vazio!");
	        formularioAlocacao.metrica4.focus();
			return false;
	    }
	    if(document.formularioAlocacao.metrica5.value==""){
	        alert("Campo Aug (14/15) esta vazio!");
	        formularioAlocacao.metrica5.focus();
			return false;
	    }
	    if(document.formularioAlocacao.metrica6.value==""){
	        alert("Campo Sep (14/15) esta vazio!");
	        formularioAlocacao.metrica6.focus();
			return false;
	    }
	    /*FY 15/16*/
	    if(document.formularioAlocacao.metrica7.value==""){
	        alert("Campo Oct (FY15/16) esta vazio!");
	        formularioAlocacao.metrica7.focus();
			return false;
	    }
		if(document.formularioAlocacao.metrica8.value==""){
	        alert("Campo Nov (15/16) esta vazio!");
	        formularioAlocacao.metrica8.focus();
			return false;
	    }if(document.formularioAlocacao.metrica9.value==""){
	        alert("Campo Dec (15/16) esta vazio!");
	        formularioAlocacao.metrica9.focus();
			return false;
	    }if(document.formularioAlocacao.metrica10.value==""){
	        alert("Campo Jan (15/16) esta vazio!");
	        formularioAlocacao.metrica10.focus();
			return false;
	    }
	    if(document.formularioAlocacao.metrica11.value==""){
	        alert("Campo Feb (15/16) esta vazio!");
	        formularioAlocacao.metrica11.focus();
			return false;
	    }
	    if(document.formularioAlocacao.metrica12.value==""){
	        alert("Campo Mar (15/16) esta vazio!");
	        formularioAlocacao.metrica12.focus();
			return false;
	    }
	    if(document.formularioAlocacao.metrica13.value==""){
	        alert("Campo Apr (15/16) esta vazio!");
	        formularioAlocacao.metrica13.focus();
			return false;
	    }if(document.formularioAlocacao.metrica14.value==""){
	        alert("Campo May (15/16) esta vazio!");
	        formularioAlocacao.metrica14.focus();
			return false;
	    }
	    if(document.formularioAlocacao.metrica15.value==""){
	        alert("Campo Jun (15/16) esta vazio!");
	        formularioAlocacao.metrica15.focus();
			return false;
	    }
	    if(document.formularioAlocacao.metrica16.value==""){
	        alert("Campo Jul (15/16) esta vazio!");
	        formularioAlocacao.metrica16.focus();
			return false;
	    }
	}
	
	
