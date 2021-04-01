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
function mostrarResultadoJustificativa(box0,num_max0,campospan0){
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
function contarCaracteresJustificativa(box0,valor0,campospan0){
	var conta0 = valor0 - box0.length;
	document.getElementById(campospan0).innerHTML = "Você ainda pode digitar " + conta0 + " caracteres";
	if(box0.length >= valor0){
		document.getElementById(campospan0).innerHTML = "Opss.. você não pode mais digitar..";
		document.getElementById("justificativa").value = document.getElementById("justificativa").value.substr(0,valor0);
	}	
}
//---------------------------------------------------------------------------------------------------------------------------------------
//
function mostrarResultadoObjetivo(box,num_max,campospan){
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
function contarCaracteresObjetivo(box,valor,campospan){
	var conta = valor - box.length;
	document.getElementById(campospan).innerHTML = "Você ainda pode digitar " + conta + " caracteres";
	if(box.length >= valor){
		document.getElementById(campospan).innerHTML = "Opss.. você não pode mais digitar..";
		document.getElementById("objetivo").value = document.getElementById("objetivo").value.substr(0,valor);
	}	
}
//------------------------------------------------------------------------------------------------------------------------------------------------------
//1
function mostrarResultadoBeneficio(box1,num_max1,campospan1){
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
function contarCaracteresBeneficio(box1,valor1,campospan1){
	var conta1 = valor1 - box1.length;
	document.getElementById(campospan1).innerHTML = "Você ainda pode digitar " + conta1 + " caracteres";
	if(box1.length >= valor1){
		document.getElementById(campospan1).innerHTML = "Opss.. você não pode mais digitar..";
		document.getElementById("beneficio").value = document.getElementById("beneficio").value.substr(0,valor1);
	}	
}
//------------------------------------------------------------------------------------------------------------------------------------------------------
//2
function mostrarResultadoProduto(box2,num_max2,campospan2){
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
function contarCaracteresProduto(box2,valor2,campospan2){
	var conta2 = valor2 - box2.length;
	document.getElementById(campospan2).innerHTML = "Você ainda pode digitar " + conta2 + " caracteres";
	if(box2.length >= valor2){
		document.getElementById(campospan2).innerHTML = "Opss.. você não pode mais digitar..";
		document.getElementById("produto").value = document.getElementById("produto").value.substr(0,valor2);
	}	
}
//------------------------------------------------------------------------------------------------------------------------------------------------------
//3
function mostrarResultadoRequisito(box3,num_max3,campospan3){
	var contagem_carac3 = box3.length;
	if (contagem_carac3 != 0){
		//document.getElementById(campospan2).innerHTML = contagem_carac2 + " caracteres digitados (Obs: espaços contam como caracteres).";
		if (contagem_carac3 == 1){
			//document.getElementById(campospan2).innerHTML = contagem_carac2 + " caracter digitado";
		}
		if (contagem_carac3 >= num_max3){
			//document.getElementById(campospan2).innerHTML = "Limite de caracteres excedido!";
		}
	}else{
		//document.getElementById(campospan2).innerHTML = "Ainda não temos nada digitado..";
	}
}
function contarCaracteresRequisito(box3,valor3,campospan3){
	var conta3 = valor3 - box3.length;
	document.getElementById(campospan3).innerHTML = "Você ainda pode digitar " + conta3 + " caracteres";
	if(box3.length >= valor3){
		document.getElementById(campospan3).innerHTML = "Opss.. você não pode mais digitar..";
		document.getElementById("requisito").value = document.getElementById("requisito").value.substr(0,valor3);
	}	
}
//------------------------------------------------------------------------------------------------------------------------------------------------------
//5
function mostrarResultadoRestricao(box4,num_max4,campospan4){
	var contagem_carac4 = box4.length;
	if (contagem_carac4 != 0){
		//document.getElementById(campospan2).innerHTML = contagem_carac2 + " caracteres digitados (Obs: espaços contam como caracteres).";
		if (contagem_carac4 == 1){
			//document.getElementById(campospan2).innerHTML = contagem_carac2 + " caracter digitado";
		}
		if (contagem_carac4 >= num_max4){
			//document.getElementById(campospan2).innerHTML = "Limite de caracteres excedido!";
		}
	}else{
		//document.getElementById(campospan2).innerHTML = "Ainda não temos nada digitado..";
	}
}
function contarCaracteresRestricao(box4,valor4,campospan4){
	var conta4 = valor4 - box4.length;
	document.getElementById(campospan4).innerHTML = "Você ainda pode digitar " + conta4 + " caracteres";
	if(box4.length >= valor4){
		document.getElementById(campospan4).innerHTML = "Opss.. você não pode mais digitar..";
		document.getElementById("restricao").value = document.getElementById("restricao").value.substr(0,valor4);
	}	
}
//------------------------------------------------------------------------------------------------------------------------------------------------------
//5
function mostrarResultadoPermicao(box5,num_max5,campospan5){
	var contagem_carac5 = box5.length;
	if (contagem_carac5 != 0){
		//document.getElementById(campospan2).innerHTML = contagem_carac2 + " caracteres digitados (Obs: espaços contam como caracteres).";
		if (contagem_carac5 == 1){
			//document.getElementById(campospan2).innerHTML = contagem_carac2 + " caracter digitado";
		}
		if (contagem_carac5 >= num_max5){
			//document.getElementById(campospan2).innerHTML = "Limite de caracteres excedido!";
		}
	}else{
		//document.getElementById(campospan2).innerHTML = "Ainda não temos nada digitado..";
	}
}
function contarCaracteresPermicao(box5,valor5,campospan5){
	var conta5 = valor5 - box5.length;
	document.getElementById(campospan5).innerHTML = "Você ainda pode digitar " + conta5 + " caracteres";
	if(box5.length >= valor5){
		document.getElementById(campospan5).innerHTML = "Opss.. você não pode mais digitar..";
		document.getElementById("permissao").value = document.getElementById("permissao").value.substr(0,valor5);
	}	
}
//------------------------------------------------------------------------------------------------------------------------------------------------------
//5
function mostrarResultadoRiscos(box6,num_max6,campospan6){
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
function contarCaracteresRiscos(box6,valor6,campospan6){
	var conta6 = valor6 - box6.length;
	document.getElementById(campospan6).innerHTML = "Você ainda pode digitar " + conta6 + " caracteres";
	if(box6.length >= valor6){
		document.getElementById(campospan6).innerHTML = "Opss.. você não pode mais digitar..";
		document.getElementById("risco").value = document.getElementById("risco").value.substr(0,valor6);
	}	
}