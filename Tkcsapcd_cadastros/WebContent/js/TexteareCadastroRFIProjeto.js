//Tratamento 1 de erro no campo Textarea.

/*
É muito simples, primeiramente no textarea, temos o evento “onkeyup”, ou seja, ao soltarmos uma tecla, chamamos 2 funções:
Temos também 2 elementos “span” que servirão para exibir os resultados referentes a quantidades de caracteres.
A primeira função que chamamos é a mostrarResultado(), e nela passamos como argumentos:

O campo onde os caracteres são digitados;
O valor máximo de caracteres;
O id do elemento onde irei escrever os resultados.
No exemplo abaixo, utilizo como exemplo o número máximo de 200 caracteres para serem digitados. 

A propriedade “length” calcula o tamanho do que lhe é determinado, neste caso do elemento textarea, de id “campo”.
E o que eu faço nesta função toda?
Se o tamanho do valor que está no campo, ou seja, a quantidade de caracteres for diferente de 0, escrever no elemento “span” o total de caracteres digitados.
Se for igual a 1, escrever a mesma frase, só que no singular.
E se ultrapassar 140 caracteres, escrever a mensagem “Limite de caracteres excedido!”.
Fácil não? Esta função está 100% customizável, apenas mude os argumentos passados a função de acordo com a sua necessidade.
 * */
//Tratamento 2 de erro no campo Textarea.

/*
Agora vamos a função que irá me mostrar quantos caracteres ainda posso digitar, e quando ultrapassar este valor não deixar.
Para tal façanha, utilizaremos a função contarCaracteres(), e passamos como argumento:

Novamente o campo onde os caracteres são digitados;
O valor limite de caracteres;
O id do elemento onde irei escrever os resultados.

Logo na primeira linha eu faço a simples conta de subtração, pego o valor limite, passado via argumentos, e subtraio dele a quantidade digitada,
 em seguida escrevo o resultado, exibindo quantos ainda restam para digitar.
E se este valor for maior ou igual ao meu valor limite, escrevo “Opss.. você não pode mais digitar..” e em seguida utilizo o método
substr() para me trazer exatamente o valor limite (neste caso 140) no meu campo, fazendo com que não seja permitido digitar mais..
Esta função está 95% customizável, apenas na linha 6 coloque o id (na propriedade getElementById()) relativo ao campo em que irá ser contado e bloqueado os caracteres. 
 */
 
/*############# ATENÇAÕ INICIO DE TRATRAMENTO DE ERRO DO TEXTARE DA PÁGINA CADASTRO DE PROJETO (TAMBÉM É DEFINIDA EM ATUALIZAR PROJETO)##################*/
//0
function mostrarResultadoProdutoservico(box0,num_max0,campospan0){
	var contagem_carac0 = box0.length;
	if (contagem_carac0 != 0){
		//document.getElementById(campospan0).innerHTML = contagem_carac0 + " caracteres digitados (Obs: espaços contam como caracteres).";
		if (contagem_carac0 == 1){
			//document.getElementById(campospan0).innerHTML = contagem_carac0 + " caracter digitado";
		}
		if (contagem_carac0 >= num_max0){
			//document.getElementById(campospan0).innerHTML = "Limite de caracteres excedido!";
		}
	}else{
		//document.getElementById(campospan0).innerHTML = "Ainda não temos nada digitado..";
	}
}
function contarCaracteresProdutoservico(box0,valor0,campospan0){
	var conta0 = valor0 - box0.length;
	document.getElementById(campospan0).innerHTML = "Você ainda pode digitar " + conta0 + " caracteres";
	if(box0.length >= valor0){
		document.getElementById(campospan0).innerHTML = "Opss.. você não pode mais digitar..";
		document.getElementById("produtoservico").value = document.getElementById("produtoservico").value.substr(0,valor0);
	}	
}
//---------------------------------------------------------------------------------------------------------------------------------------
//1
function mostrarObjetivoMercadocliente(box1,num_max1,campospan1){
	var contagem_carac1 = box1.length;
	if (contagem_carac1 != 0){
		//document.getElementById(campospan0).innerHTML = contagem_carac0 + " caracteres digitados (Obs: espaços contam como caracteres).";
		if (contagem_carac1 == 1){
			//document.getElementById(campospan0).innerHTML = contagem_carac0 + " caracter digitado";
		}
		if (contagem_carac1 >= num_max1){
			//document.getElementById(campospan0).innerHTML = "Limite de caracteres excedido!";
		}
	}else{
		//document.getElementById(campospan0).innerHTML = "Ainda não temos nada digitado..";
	}
}
function contarCaracteresMercadocliente(box1,valor1,campospan1){
	var conta1 = valor1 - box1.length;
	document.getElementById(campospan1).innerHTML = "Você ainda pode digitar " + conta1 + " caracteres";
	if(box1.length >= valor1){
		document.getElementById(campospan1).innerHTML = "Opss.. você não pode mais digitar..";
		document.getElementById("mercadocliente").value = document.getElementById("mercadocliente").value.substr(0,valor1);
	}	
}
//---------------------------------------------------------------------------------------------------------------------------------------
//3
function mostrarResultadoDescricaoEstruturapropriedade(box,num_max,campospan3){
	var contagem_carac = box.length;
	if (contagem_carac != 0){
		//document.getElementById(campospan).innerHTML = contagem_carac + "caracteres digitados (Obs: espaços contam como caracteres). ";
		if (contagem_carac == 1){
			//document.getElementById(campospan).innerHTML = contagem_carac + " caracter digitado";
		}
		if (contagem_carac >= num_max){
			//document.getElementById(campospan).innerHTML = "Limite de caracteres excedido!";
		}
	}else{
		//document.getElementById(campospan).innerHTML = "Ainda não temos nada digitado..";
	}
}
function contarCaracteresDescricaoEstruturapropriedade(box,valor,campospan3){
	var conta = valor - box.length;
	document.getElementById(campospan3).innerHTML = "Você ainda pode digitar " + conta + " caracteres";
	if(box.length >= valor){
		document.getElementById(campospan3).innerHTML = "Opss.. você não pode mais digitar..";
		document.getElementById("estruturapropriedade").value = document.getElementById("estruturapropriedade").value.substr(0,valor);
	}	
}
//------------------------------------------------------------------------------------------------------------------------------------------------------
//4
function mostrarResultadoEstruturaempresa(box1,num_max1,campospan4){
	var contagem_carac1 = box1.length;
	if (contagem_carac1 != 0){
		//document.getElementById(campospan1).innerHTML = contagem_carac1 + " caracteres digitados (Obs: espaços contam como caracteres).";
		if (contagem_carac1 == 1){
			//document.getElementById(campospan1).innerHTML = contagem_carac1 + " caracter digitado";
		}
		if (contagem_carac1 >= num_max1){
			//document.getElementById(campospan1).innerHTML = "Limite de caracteres excedido!";
		}
	}else{
		//document.getElementById(campospan1).innerHTML = "Ainda não temos nada digitado..";
	}
}
function contarCaracteresEstruturaempresa(box1,valor1,campospan4){
	var conta1 = valor1 - box1.length;
	document.getElementById(campospan4).innerHTML = "Você ainda pode digitar " + conta1 + " caracteres";
	if(box1.length >= valor1){
		document.getElementById(campospan4).innerHTML = "Opss.. você não pode mais digitar..";
		document.getElementById("estruturaempresa").value = document.getElementById("estruturaempresa").value.substr(0,valor1);
	}	
}
//------------------------------------------------------------------------------------------------------------------------------------------------------
//5
function mostrarResultadoGestaoambiental(box2,num_max2,campospan5){
	var contagem_carac2 = box2.length;
	if (contagem_carac2 != 0){
		//document.getElementById(campospan2).innerHTML = contagem_carac2 + " caracteres digitados (Obs: espaços contam como caracteres).";
		if (contagem_carac2 == 1){
			//document.getElementById(campospan2).innerHTML = contagem_carac2 + " caracter digitado";
		}
		if (contagem_carac2 >= num_max2){
			//document.getElementById(campospan2).innerHTML = "Limite de caracteres excedido!";
		}
	}else{
		//document.getElementById(campospan2).innerHTML = "Ainda não temos nada digitado..";
	}
}
function contarCaracteresGestaoambiental(box2,valor2,campospan5){
	var conta2 = valor2 - box2.length;
	document.getElementById(campospan5).innerHTML = "Você ainda pode digitar " + conta2 + " caracteres";
	if(box2.length >= valor2){
		document.getElementById(campospan5).innerHTML = "Opss.. você não pode mais digitar..";
		document.getElementById("gestaoambiental").value = document.getElementById("gestaoambiental").value.substr(0,valor2);
	}	
}
//------------------------------------------------------------------------------------------------------------------------------------------------------
//6
function mostrarResultadoGestaoqualidade(box6,num_max6,campospan6){
	var contagem_carac6 = box6.length;
	if (contagem_carac6 != 0){
		//document.getElementById(campospan2).innerHTML = contagem_carac2 + " caracteres digitados (Obs: espaços contam como caracteres).";
		if (contagem_carac6 == 1){
			//document.getElementById(campospan2).innerHTML = contagem_carac2 + " caracter digitado";
		}
		if (contagem_carac6 >= num_max6){
			//document.getElementById(campospan2).innerHTML = "Limite de caracteres excedido!";
		}
	}else{
		//document.getElementById(campospan2).innerHTML = "Ainda não temos nada digitado..";
	}
}
function contarCaracteresGestaoqualidade(box6,valor6,campospan6){
	var conta6 = valor6 - box6.length;
	document.getElementById(campospan6).innerHTML = "Você ainda pode digitar " + conta6 + " caracteres";
	if(box6.length >= valor6){
		document.getElementById(campospan6).innerHTML = "Opss.. você não pode mais digitar..";
		document.getElementById("gestaoqualidade").value = document.getElementById("gestaoqualidade").value.substr(0,valor6);
	}	
}
//------------------------------------------------------------------------------------------------------------------------------------------------------
//7
function mostrarResultadoGestaonegocio(box7,num_max7,campospan7){
	var contagem_carac7 = box7.length;
	if (contagem_carac7 != 0){
		//document.getElementById(campospan2).innerHTML = contagem_carac2 + " caracteres digitados (Obs: espaços contam como caracteres).";
		if (contagem_carac7 == 1){
			//document.getElementById(campospan2).innerHTML = contagem_carac2 + " caracter digitado";
		}
		if (contagem_carac7 >= num_max7){
			//document.getElementById(campospan2).innerHTML = "Limite de caracteres excedido!";
		}
	}else{
		//document.getElementById(campospan2).innerHTML = "Ainda não temos nada digitado..";
	}
}
function contarCaracteresGestaonegocio(box7,valor7,campospan7){
	var conta7 = valor7 - box7.length;
	document.getElementById(campospan7).innerHTML = "Você ainda pode digitar " + conta7 + " caracteres";
	if(box7.length >= valor7){
		document.getElementById(campospan7).innerHTML = "Opss.. você não pode mais digitar..";
		document.getElementById("gestaonegocio").value = document.getElementById("gestaonegocio").value.substr(0,valor7);
	}	
}
//------------------------------------------------------------------------------------------------------------------------------------------------------
//8
function mostrarResultadoFuncionario(box8,num_max8,campospan8){
	var contagem_carac8 = box8.length;
	if (contagem_carac8 != 0){
		//document.getElementById(campospan2).innerHTML = contagem_carac2 + " caracteres digitados (Obs: espaços contam como caracteres).";
		if (contagem_carac8 == 1){
			//document.getElementById(campospan2).innerHTML = contagem_carac2 + " caracter digitado";
		}
		if (contagem_carac8 >= num_max8){
			//document.getElementById(campospan2).innerHTML = "Limite de caracteres excedido!";
		}
	}else{
		//document.getElementById(campospan2).innerHTML = "Ainda não temos nada digitado..";
	}
}
function contarCaracteresFuncionario(box8,valor8,campospan8){
	var conta8 = valor8 - box8.length;
	document.getElementById(campospan8).innerHTML = "Você ainda pode digitar " + conta8 + " caracteres";
	if(box8.length >= valor8){
		document.getElementById(campospan8).innerHTML = "Opss.. você não pode mais digitar..";
		document.getElementById("funcionario").value = document.getElementById("funcionario").value.substr(0,valor8);
	}	
}
//------------------------------------------------------------------------------------------------------------------------------------------------------
//9
function mostrarResultadoProducao(box9,num_max9,campospan9){
	var contagem_carac9 = box9.length;
	if (contagem_carac9 != 0){
		//document.getElementById(campospan2).innerHTML = contagem_carac2 + " caracteres digitados (Obs: espaços contam como caracteres).";
		if (contagem_carac9 == 1){
			//document.getElementById(campospan2).innerHTML = contagem_carac2 + " caracter digitado";
		}
		if (contagem_carac9 >= num_max9){
			//document.getElementById(campospan2).innerHTML = "Limite de caracteres excedido!";
		}
	}else{
		//document.getElementById(campospan2).innerHTML = "Ainda não temos nada digitado..";
	}
}
function contarCaracteresProducao(box9,valor9,campospan9){
	var conta9 = valor9 - box9.length;
	document.getElementById(campospan9).innerHTML = "Você ainda pode digitar " + conta9 + " caracteres";
	if(box9.length >= valor9){
		document.getElementById(campospan9).innerHTML = "Opss.. você não pode mais digitar..";
		document.getElementById("producao").value = document.getElementById("producao").value.substr(0,valor9);
	}	
}
//------------------------------------------------------------------------------------------------------------------------------------------------------
//10
function mostrarResultadoMarketingvendas(box10,num_max10,campospan10){
	var contagem_carac10 = box10.length;
	if (contagem_carac10 != 0){
		//document.getElementById(campospan2).innerHTML = contagem_carac2 + " caracteres digitados (Obs: espaços contam como caracteres).";
		if (contagem_carac10 == 1){
			//document.getElementById(campospan2).innerHTML = contagem_carac2 + " caracter digitado";
		}
		if (contagem_carac10 >= num_max10){
			//document.getElementById(campospan2).innerHTML = "Limite de caracteres excedido!";
		}
	}else{
		//document.getElementById(campospan2).innerHTML = "Ainda não temos nada digitado..";
	}
}
function contarCaracteresMarketingvendas(box10,valor10,campospan10){
	var conta10 = valor10 - box10.length;
	document.getElementById(campospan10).innerHTML = "Você ainda pode digitar " + conta10 + " caracteres";
	if(box10.length >= valor10){
		document.getElementById(campospan10).innerHTML = "Opss.. você não pode mais digitar..";
		document.getElementById("marketingvendas").value = document.getElementById("marketingvendas").value.substr(0,valor10);
	}	
}
//------------------------------------------------------------------------------------------------------------------------------------------------------
//11
function mostrarResultadoDepartamentoqualidade(box11,num_max11,campospan11){
	var contagem_carac11 = box11.length;
	if (contagem_carac11 != 0){
		//document.getElementById(campospan2).innerHTML = contagem_carac2 + " caracteres digitados (Obs: espaços contam como caracteres).";
		if (contagem_carac11 == 1){
			//document.getElementById(campospan2).innerHTML = contagem_carac2 + " caracter digitado";
		}
		if (contagem_carac11 >= num_max11){
			//document.getElementById(campospan2).innerHTML = "Limite de caracteres excedido!";
		}
	}else{
		//document.getElementById(campospan2).innerHTML = "Ainda não temos nada digitado..";
	}
}
function contarCaracteresDepartamentoqualidade(box11,valor11,campospan11){
	var conta11 = valor11 - box11.length;
	document.getElementById(campospan11).innerHTML = "Você ainda pode digitar " + conta11 + " caracteres";
	if(box11.length >= valor11){
		document.getElementById(campospan11).innerHTML = "Opss.. você não pode mais digitar..";
		document.getElementById("departamentoqualidade").value = document.getElementById("departamentoqualidade").value.substr(0,valor11);
	}	
}
//------------------------------------------------------------------------------------------------------------------------------------------------------
//12
function mostrarResultadoInformacaofinanceira(box12,num_max12,campospan12){
	var contagem_carac12 = box12.length;
	if (contagem_carac12 != 0){
		//document.getElementById(campospan2).innerHTML = contagem_carac2 + " caracteres digitados (Obs: espaços contam como caracteres).";
		if (contagem_carac12 == 1){
			//document.getElementById(campospan2).innerHTML = contagem_carac2 + " caracter digitado";
		}
		if (contagem_carac12 >= num_max12){
			//document.getElementById(campospan2).innerHTML = "Limite de caracteres excedido!";
		}
	}else{
		//document.getElementById(campospan2).innerHTML = "Ainda não temos nada digitado..";
	}
}
function contarCaracteresInformacaofinanceira(box12,valor12,campospan12){
	var conta12 = valor12 - box12.length;
	document.getElementById(campospan12).innerHTML = "Você ainda pode digitar " + conta12 + " caracteres";
	if(box12.length >= valor12){
		document.getElementById(campospan12).innerHTML = "Opss.. você não pode mais digitar..";
		document.getElementById("informacaofinanceira").value = document.getElementById("informacaofinanceira").value.substr(0,valor12);
	}	
}
//------------------------------------------------------------------------------------------------------------------------------------------------------
//13
function mostrarResultadoVolumenegocio(box13,num_max13,campospan13){
	var contagem_carac13 = box13.length;
	if (contagem_carac13 != 0){
		//document.getElementById(campospan2).innerHTML = contagem_carac2 + " caracteres digitados (Obs: espaços contam como caracteres).";
		if (contagem_carac13 == 1){
			//document.getElementById(campospan2).innerHTML = contagem_carac2 + " caracter digitado";
		}
		if (contagem_carac13 >= num_max13){
			//document.getElementById(campospan2).innerHTML = "Limite de caracteres excedido!";
		}
	}else{
		//document.getElementById(campospan2).innerHTML = "Ainda não temos nada digitado..";
	}
}
function contarCaracteresVolumenegocio(box13,valor13,campospan13){
	var conta13 = valor13 - box13.length;
	document.getElementById(campospan13).innerHTML = "Você ainda pode digitar " + conta13 + " caracteres";
	if(box13.length >= valor13){
		document.getElementById(campospan13).innerHTML = "Opss.. você não pode mais digitar..";
		document.getElementById("volumenegocio").value = document.getElementById("volumenegocio").value.substr(0,valor13);
	}	
}
//------------------------------------------------------------------------------------------------------------------------------------------------------
//6
function mostrarResultadoMercadoacoes(box14,num_max14,campospan14){
	var contagem_carac14 = box14.length;
	if (contagem_carac14 != 0){
		//document.getElementById(campospan2).innerHTML = contagem_carac2 + " caracteres digitados (Obs: espaços contam como caracteres).";
		if (contagem_carac14 == 1){
			//document.getElementById(campospan2).innerHTML = contagem_carac2 + " caracter digitado";
		}
		if (contagem_carac14 >= num_max14){
			//document.getElementById(campospan2).innerHTML = "Limite de caracteres excedido!";
		}
	}else{
		//document.getElementById(campospan2).innerHTML = "Ainda não temos nada digitado..";
	}
}
function contarCaracteresMercadoacoes(box14,valor14,campospan14){
	var conta14 = valor14 - box14.length;
	document.getElementById(campospan14).innerHTML = "Você ainda pode digitar " + conta14 + " caracteres";
	if(box14.length >= valor14){
		document.getElementById(campospan14).innerHTML = "Opss.. você não pode mais digitar..";
		document.getElementById("mercadoacoes").value = document.getElementById("mercadoacoes").value.substr(0,valor14);
	}	
}
//------------------------------------------------------------------------------------------------------------------------------------------------------
//7
function mostrarResultadoCapacidadehoje(box15,num_max15,campospan15){
	var contagem_carac15 = box15.length;
	if (contagem_carac15 != 0){
		//document.getElementById(campospan2).innerHTML = contagem_carac2 + " caracteres digitados (Obs: espaços contam como caracteres).";
		if (contagem_carac15 == 1){
			//document.getElementById(campospan2).innerHTML = contagem_carac2 + " caracter digitado";
		}
		if (contagem_carac15 >= num_max15){
			//document.getElementById(campospan2).innerHTML = "Limite de caracteres excedido!";
		}
	}else{
		//document.getElementById(campospan2).innerHTML = "Ainda não temos nada digitado..";
	}
}
function contarCaracteresCapacidadehoje(box15,valor15,campospan15){
	var conta15 = valor15 - box15.length;
	document.getElementById(campospan15).innerHTML = "Você ainda pode digitar " + conta15 + " caracteres";
	if(box15.length >= valor15){
		document.getElementById(campospan15).innerHTML = "Opss.. você não pode mais digitar..";
		document.getElementById("capacidadehoje").value = document.getElementById("capacidadehoje").value.substr(0,valor15);
	}	
}
//------------------------------------------------------------------------------------------------------------------------------------------------------
//8
function mostrarResultadoCapacidadeantecipada(box16,num_max16,campospan16){
	var contagem_carac16 = box16.length;
	if (contagem_carac16 != 0){
		//document.getElementById(campospan2).innerHTML = contagem_carac2 + " caracteres digitados (Obs: espaços contam como caracteres).";
		if (contagem_carac16 == 1){
			//document.getElementById(campospan2).innerHTML = contagem_carac2 + " caracter digitado";
		}
		if (contagem_carac16 >= num_max16){
			//document.getElementById(campospan2).innerHTML = "Limite de caracteres excedido!";
		}
	}else{
		//document.getElementById(campospan2).innerHTML = "Ainda não temos nada digitado..";
	}
}
function contarCaracteresCapacidadeantecipada(box16,valor16,campospan16){
	var conta16 = valor16 - box16.length;
	document.getElementById(campospan16).innerHTML = "Você ainda pode digitar " + conta16 + " caracteres";
	if(box16.length >= valor16){
		document.getElementById(campospan16).innerHTML = "Opss.. você não pode mais digitar..";
		document.getElementById("capacidadeantecipada").value = document.getElementById("capacidadeantecipada").value.substr(0,valor16);
	}	
}
//------------------------------------------------------------------------------------------------------------------------------------------------------
//9
function mostrarResultadocondicaonaoatendida(box17,num_max17,campospan17){
	var contagem_carac17 = box17.length;
	if (contagem_carac17 != 0){
		//document.getElementById(campospan2).innerHTML = contagem_carac2 + " caracteres digitados (Obs: espaços contam como caracteres).";
		if (contagem_carac17 == 1){
			//document.getElementById(campospan2).innerHTML = contagem_carac2 + " caracter digitado";
		}
		if (contagem_carac17 >= num_max17){
			//document.getElementById(campospan2).innerHTML = "Limite de caracteres excedido!";
		}
	}else{
		//document.getElementById(campospan2).innerHTML = "Ainda não temos nada digitado..";
	}
}
function contarCaracteresResultadocondicaonaoatendida(box17,valor17,campospan17){
	var conta17 = valor17 - box17.length;
	document.getElementById(campospan17).innerHTML = "Você ainda pode digitar " + conta17 + " caracteres";
	if(box17.length >= valor17){
		document.getElementById(campospan17).innerHTML = "Opss.. você não pode mais digitar..";
		document.getElementById("condicaonaoatendida").value = document.getElementById("condicaonaoatendida").value.substr(0,valor17);
	}	
}
//------------------------------------------------------------------------------------------------------------------------------------------------------
//10
function mostrarResultadoProdutosentregues(box18,num_max18,campospan18){
	var contagem_carac18 = box18.length;
	if (contagem_carac18 != 0){
		//document.getElementById(campospan2).innerHTML = contagem_carac2 + " caracteres digitados (Obs: espaços contam como caracteres).";
		if (contagem_carac18 == 1){
			//document.getElementById(campospan2).innerHTML = contagem_carac2 + " caracter digitado";
		}
		if (contagem_carac18 >= num_max18){
			//document.getElementById(campospan2).innerHTML = "Limite de caracteres excedido!";
		}
	}else{
		//document.getElementById(campospan2).innerHTML = "Ainda não temos nada digitado..";
	}
}
function contarCaracteresProdutosentregues(box18,valor18,campospan18){
	var conta18 = valor18 - box18.length;
	document.getElementById(campospan18).innerHTML = "Você ainda pode digitar " + conta18 + " caracteres";
	if(box18.length >= valor18){
		document.getElementById(campospan18).innerHTML = "Opss.. você não pode mais digitar..";
		document.getElementById("produtosentregues").value = document.getElementById("produtosentregues").value.substr(0,valor18);
	}	
}
//------------------------------------------------------------------------------------------------------------------------------------------------------
//11
function mostrarResultadoClientereferenciacomparaveis(box19,num_max19,campospan19){
	var contagem_carac19 = box19.length;
	if (contagem_carac19 != 0){
		//document.getElementById(campospan2).innerHTML = contagem_carac2 + " caracteres digitados (Obs: espaços contam como caracteres).";
		if (contagem_carac19 == 1){
			//document.getElementById(campospan2).innerHTML = contagem_carac2 + " caracter digitado";
		}
		if (contagem_carac19 >= num_max19){
			//document.getElementById(campospan2).innerHTML = "Limite de caracteres excedido!";
		}
	}else{
		//document.getElementById(campospan2).innerHTML = "Ainda não temos nada digitado..";
	}
}
function contarCaracteresClientereferenciacomparaveis(box19,valor19,campospan19){
	var conta19 = valor19 - box19.length;
	document.getElementById(campospan19).innerHTML = "Você ainda pode digitar " + conta19 + " caracteres";
	if(box19.length >= valor19){
		document.getElementById(campospan19).innerHTML = "Opss.. você não pode mais digitar..";
		document.getElementById("clientereferenciacomparaveis").value = document.getElementById("clientereferenciacomparaveis").value.substr(0,valor19);
	}	
}
//------------------------------------------------------------------------------------------------------------------------------------------------------
//12
function mostrarResultadoClientereferencianaocomparaveis(box20,num_max20,campospan20){
	var contagem_carac20 = box20.length;
	if (contagem_carac20 != 0){
		//document.getElementById(campospan2).innerHTML = contagem_carac2 + " caracteres digitados (Obs: espaços contam como caracteres).";
		if (contagem_carac20 == 1){
			//document.getElementById(campospan2).innerHTML = contagem_carac2 + " caracter digitado";
		}
		if (contagem_carac20 >= num_max20){
			//document.getElementById(campospan2).innerHTML = "Limite de caracteres excedido!";
		}
	}else{
		//document.getElementById(campospan2).innerHTML = "Ainda não temos nada digitado..";
	}
}
function contarCaracteresClientereferencianaocomparaveis(box20,valor20,campospan20){
	var conta20 = valor20 - box20.length;
	document.getElementById(campospan20).innerHTML = "Você ainda pode digitar " + conta20 + " caracteres";
	if(box20.length >= valor20){
		document.getElementById(campospan20).innerHTML = "Opss.. você não pode mais digitar..";
		document.getElementById("clientereferencianaocomparaveis").value = document.getElementById("clientereferencianaocomparaveis").value.substr(0,valor20);
	}	
}
//------------------------------------------------------------------------------------------------------------------------------------------------------
//13
function mostrarResultadoDisponivelentrega(box21,num_max21,campospan21){
	var contagem_carac21 = box21.length;
	if (contagem_carac21 != 0){
		//document.getElementById(campospan2).innerHTML = contagem_carac2 + " caracteres digitados (Obs: espaços contam como caracteres).";
		if (contagem_carac21 == 1){
			//document.getElementById(campospan2).innerHTML = contagem_carac2 + " caracter digitado";
		}
		if (contagem_carac21 >= num_max21){
			//document.getElementById(campospan2).innerHTML = "Limite de caracteres excedido!";
		}
	}else{
		//document.getElementById(campospan2).innerHTML = "Ainda não temos nada digitado..";
	}
}
function contarCaracteresDisponivelentrega(box21,valor21,campospan21){
	var conta21 = valor21 - box21.length;
	document.getElementById(campospan21).innerHTML = "Você ainda pode digitar " + conta21 + " caracteres";
	if(box21.length >= valor21){
		document.getElementById(campospan21).innerHTML = "Opss.. você não pode mais digitar..";
		document.getElementById("disponivelentrega").value = document.getElementById("disponivelentrega").value.substr(0,valor21);
	}	
}
//------------------------------------------------------------------------------------------------------------------------------------------------------
function mostrarResultadoDisponibilidade(box22,num_max22,campospan22){
	var contagem_carac22 = box22.length;
	if (contagem_carac22 != 0){
		//document.getElementById(campospan2).innerHTML = contagem_carac2 + " caracteres digitados (Obs: espaços contam como caracteres).";
		if (contagem_carac22 == 1){
			//document.getElementById(campospan2).innerHTML = contagem_carac2 + " caracter digitado";
		}
		if (contagem_carac22 >= num_max22){
			//document.getElementById(campospan2).innerHTML = "Limite de caracteres excedido!";
		}
	}else{
		//document.getElementById(campospan2).innerHTML = "Ainda não temos nada digitado..";
	}
}
function contarCaracteresDisponibilidade(box22,valor22,campospan22){
	var conta22 = valor22 - box22.length;
	document.getElementById(campospan22).innerHTML = "Você ainda pode digitar " + conta22 + " caracteres";
	if(box22.length >= valor22){
		document.getElementById(campospan22).innerHTML = "Opss.. você não pode mais digitar..";
		document.getElementById("disponibilidade").value = document.getElementById("disponibilidade").value.substr(0,valor22);
	}	
}
//------------------------------------------------------------------------------------------------------------------------------------------------------
