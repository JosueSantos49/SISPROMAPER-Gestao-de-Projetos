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
//Projeto Descricao
function mostrarResultadoEtapa1(box0,num_max0,campospan0){
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
function contarCaracteresEtapa1(box0,valor0,campospan0){
	var conta0 = valor0 - box0.length;
	document.getElementById(campospan0).innerHTML = "Você ainda pode digitar " + conta0 + " caracteres";
	if(box0.length >= valor0){
		document.getElementById(campospan0).innerHTML = "Opss.. você não pode mais digitar..";
		document.getElementById("especificacao").value = document.getElementById("especificacao").value.substr(0,valor0);
	}	
}
//---------------------------------------------------------------------------------------------------------------------------------------
//Projeto Compulsório 
function mostrarResultadoEtapa2(box,num_max,campospan){
	var contagem_carac = box.length;
	if (contagem_carac != 0){
		//document.getElementById(campospan).innerHTML = contagem_carac + " caracteres digitados (Obs: espaços contam como caracteres).";
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
function contarCaracteresEtapa2(box,valor,campospan){
	var conta = valor - box.length;
	document.getElementById(campospan).innerHTML = "Você ainda pode digitar " + conta + " caracteres";
	if(box.length >= valor){
		document.getElementById(campospan).innerHTML = "Opss.. você não pode mais digitar..";
		document.getElementById("nivel").value = document.getElementById("nivel").value.substr(0,valor);
	}	
}
//------------------------------------------------------------------------------------------------------------------------------------------------------
//Projeto Qualitativo 
function mostrarResultadoEtapa3(box1,num_max1,campospan1){
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
function contarCaracteresEtapa3(box1,valor1,campospan1){
	var conta1 = valor1 - box1.length;
	document.getElementById(campospan1).innerHTML = "Você ainda pode digitar " + conta1 + " caracteres";
	if(box1.length >= valor1){
		document.getElementById(campospan1).innerHTML = "Opss.. você não pode mais digitar..";
		document.getElementById("acao").value = document.getElementById("acao").value.substr(0,valor1);
	}	
}
//------------------------------------------------------------------------------------------------------------------------------------------------------
//Projeto  Quantitativo
function mostrarResultadoEtapa4(box2,num_max2,campospan2){
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
function contarCaracteresEtapa4(box2,valor2,campospan2){
	var conta2 = valor2 - box2.length;
	document.getElementById(campospan2).innerHTML = "Você ainda pode digitar " + conta2 + " caracteres";
	if(box2.length >= valor2){
		document.getElementById(campospan2).innerHTML = "Opss.. você não pode mais digitar..";
		document.getElementById("responsavel").value = document.getElementById("responsavel").value.substr(0,valor2);
	}	
}
/*
//------------------------------------------------------------------------------------------------------------------------------------------------------
//---------------------------------------------------------------------------------------------------------------------------------------
//3
function mostrarResultadoEtapa5(box,num_max,campospan3){
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
function contarCaracteresEtapa5(box,valor,campospan3){
	var conta = valor - box.length;
	document.getElementById(campospan3).innerHTML = "Você ainda pode digitar " + conta + " caracteres";
	if(box.length >= valor){
		document.getElementById(campospan3).innerHTML = "Opss.. você não pode mais digitar..";
		document.getElementById("metrica").value = document.getElementById("metrica").value.substr(0,valor);
	}	
}
//------------------------------------------------------------------------------------------------------------------------------------------------------
//4
function mostrarResultadoEtapa6(box1,num_max1,campospan4){
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
function contarCaracteresEtapa6(box1,valor1,campospan4){
	var conta1 = valor1 - box1.length;
	document.getElementById(campospan4).innerHTML = "Você ainda pode digitar " + conta1 + " caracteres";
	if(box1.length >= valor1){
		document.getElementById(campospan4).innerHTML = "Opss.. você não pode mais digitar..";
		document.getElementById("ferramentaqualidade").value = document.getElementById("ferramentaqualidade").value.substr(0,valor1);
	}	
}
//------------------------------------------------------------------------------------------------------------------------------------------------------
//5
function mostrarResultadoEtapa7(box2,num_max2,campospan5){
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
function contarCaracteresEtapa7(box2,valor2,campospan5){
	var conta2 = valor2 - box2.length;
	document.getElementById(campospan5).innerHTML = "Você ainda pode digitar " + conta2 + " caracteres";
	if(box2.length >= valor2){
		document.getElementById(campospan5).innerHTML = "Opss.. você não pode mais digitar..";
		document.getElementById("entregaprojetoaceitacao").value = document.getElementById("entregaprojetoaceitacao").value.substr(0,valor2);
	}	
}
//------------------------------------------------------------------------------------------------------------------------------------------------------
//6
function mostrarResultadoEtapa8(box6,num_max6,campospan6){
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
function contarCaracteresEtapa8(box6,valor6,campospan6){
	var conta6 = valor6 - box6.length;
	document.getElementById(campospan6).innerHTML = "Você ainda pode digitar " + conta6 + " caracteres";
	if(box6.length >= valor6){
		document.getElementById(campospan6).innerHTML = "Opss.. você não pode mais digitar..";
		document.getElementById("garantiaqualidade").value = document.getElementById("garantiaqualidade").value.substr(0,valor6);
	}	
}
//------------------------------------------------------------------------------------------------------------------------------------------------------
//7
function mostrarResultadoEtapa9(box7,num_max7,campospan7){
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
function contarCaracteresEtapa9(box7,valor7,campospan7){
	var conta7 = valor7 - box7.length;
	document.getElementById(campospan7).innerHTML = "Você ainda pode digitar " + conta7 + " caracteres";
	if(box7.length >= valor7){
		document.getElementById(campospan7).innerHTML = "Opss.. você não pode mais digitar..";
		document.getElementById("auditoria").value = document.getElementById("auditoria").value.substr(0,valor7);
	}	
}
//------------------------------------------------------------------------------------------------------------------------------------------------------
//8
function mostrarResultadoEtapa10(box8,num_max8,campospan8){
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
function contarCaracteresEtapa10(box8,valor8,campospan8){
	var conta8 = valor8 - box8.length;
	document.getElementById(campospan8).innerHTML = "Você ainda pode digitar " + conta8 + " caracteres";
	if(box8.length >= valor8){
		document.getElementById(campospan8).innerHTML = "Opss.. você não pode mais digitar..";
		document.getElementById("processomelhoria").value = document.getElementById("processomelhoria").value.substr(0,valor8);
	}	
}
//------------------------------------------------------------------------------------------------------------------------------------------------------
//9
function mostrarResultadoEtapa11(box9,num_max9,campospan9){
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
function contarCaracteresEtapa11(box9,valor9,campospan9){
	var conta9 = valor9 - box9.length;
	document.getElementById(campospan9).innerHTML = "Você ainda pode digitar " + conta9 + " caracteres";
	if(box9.length >= valor9){
		document.getElementById(campospan9).innerHTML = "Opss.. você não pode mais digitar..";
		document.getElementById("responsabilidadequalidade").value = document.getElementById("responsabilidadequalidade").value.substr(0,valor9);
	}	
}
//------------------------------------------------------------------------------------------------------------------------------------------------------
//10
function mostrarResultadoEtapa12(box10,num_max10,campospan10){
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
function contarCaracteresEtapa12(box10,valor10,campospan10){
	var conta10 = valor10 - box10.length;
	document.getElementById(campospan10).innerHTML = "Você ainda pode digitar " + conta10 + " caracteres";
	if(box10.length >= valor10){
		document.getElementById(campospan10).innerHTML = "Opss.. você não pode mais digitar..";
		document.getElementById("logauditoria").value = document.getElementById("logauditoria").value.substr(0,valor10);
	}	
}
//------------------------------------------------------------------------------------------------------------------------------------------------------
//11
function mostrarResultadoEtapa13(box11,num_max11,campospan11){
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
function contarCaracteresEtapa13(box11,valor11,campospan11){
	var conta11 = valor11 - box11.length;
	document.getElementById(campospan11).innerHTML = "Você ainda pode digitar " + conta11 + " caracteres";
	if(box11.length >= valor11){
		document.getElementById(campospan11).innerHTML = "Opss.. você não pode mais digitar..";
		document.getElementById("auditoria").value = document.getElementById("auditoria").value.substr(0,valor11);
	}	
}
//------------------------------------------------------------------------------------------------------------------------------------------------------
//12
function mostrarResultadoEtapa14(box12,num_max12,campospan12){
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
function contarCaracteresEtapa14(box12,valor12,campospan12){
	var conta12 = valor12 - box12.length;
	document.getElementById(campospan12).innerHTML = "Você ainda pode digitar " + conta12 + " caracteres";
	if(box12.length >= valor12){
		document.getElementById(campospan12).innerHTML = "Opss.. você não pode mais digitar..";
		document.getElementById("processomelhoria").value = document.getElementById("processomelhoria").value.substr(0,valor12);
	}	
}
//------------------------------------------------------------------------------------------------------------------------------------------------------
//13
function mostrarResultadoEtapa15(box14,num_max14,campospan14){
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
function contarCaracteresEtapa15(box14,valor14,campospan14){
	var conta14 = valor14 - box14.length;
	document.getElementById(campospan14).innerHTML = "Você ainda pode digitar " + conta14 + " caracteres";
	if(box14.length >= valor14){
		document.getElementById(campospan14).innerHTML = "Opss.. você não pode mais digitar..";
		document.getElementById("responsabilidadequalidade").value = document.getElementById("responsabilidadequalidade").value.substr(0,valor14);
	}	
}
//------------------------------------------------------------------------------------------------------------------------------------------------------
//6
function mostrarResultadoEtapa16(box14,num_max14,campospan14){
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
function contarCaracteresEtapa16(box14,valor14,campospan14){
	var conta14 = valor14 - box14.length;
	document.getElementById(campospan14).innerHTML = "Você ainda pode digitar " + conta14 + " caracteres";
	if(box14.length >= valor14){
		document.getElementById(campospan14).innerHTML = "Opss.. você não pode mais digitar..";
		document.getElementById("controlequalidade").value = document.getElementById("controlequalidade").value.substr(0,valor14);
	}	
}
//------------------------------------------------------------------------------------------------------------------------------------------------------
//7
function mostrarResultadoEtapa17(box15,num_max15,campospan15){
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
function contarCaracteresEtapa17(box15,valor15,campospan15){
	var conta15 = valor15 - box15.length;
	document.getElementById(campospan15).innerHTML = "Você ainda pode digitar " + conta15 + " caracteres";
	if(box15.length >= valor15){
		document.getElementById(campospan15).innerHTML = "Opss.. você não pode mais digitar..";
		document.getElementById("procedimentoinspecao").value = document.getElementById("procedimentoinspecao").value.substr(0,valor15);
	}	
}
//------------------------------------------------------------------------------------------------------------------------------------------------------
//7
function mostrarResultadoEtapa18(box15,num_max15,campospan15){
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
function contarCaracteresEtapa18(box15,valor15,campospan15){
	var conta15 = valor15 - box15.length;
	document.getElementById(campospan15).innerHTML = "Você ainda pode digitar " + conta15 + " caracteres";
	if(box15.length >= valor15){
		document.getElementById(campospan15).innerHTML = "Opss.. você não pode mais digitar..";
		document.getElementById("procedimentomonitoramento").value = document.getElementById("procedimentomonitoramento").value.substr(0,valor15);
	}	
}*/
//------------------------------------------------------------------------------------------------------------------------------------------------------
//7
function mostrarResultadoEtapa19(box15,num_max15,campospan15){
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
function contarCaracteresEtapa19(box15,valor15,campospan15){
	var conta15 = valor15 - box15.length;
	document.getElementById(campospan15).innerHTML = "Você ainda pode digitar " + conta15 + " caracteres";
	if(box15.length >= valor15){
		document.getElementById(campospan15).innerHTML = "Opss.. você não pode mais digitar..";
		document.getElementById("aprovacao").value = document.getElementById("aprovacao").value.substr(0,valor15);
	}	
}
//------------------------------------------------------------------------------------------------------------------------------------------------------
/*#####ATENÇÃO FIM DE TRATRAMENTO DE ERRO DO TEXARE DA PÁGINA CADASTRO DE PROJETO (cadastro_projeto.jsp), E TAMBÉM É DEFINIDA EM ATUALIZAR PROJETO)##################*/
