//Tratamento 1 de erro no campo Textarea.

/*
� muito simples, primeiramente no textarea, temos o evento �onkeyup�, ou seja, ao soltarmos uma tecla, chamamos 2 fun��es:
Temos tamb�m 2 elementos �span� que servir�o para exibir os resultados referentes a quantidades de caracteres.
A primeira fun��o que chamamos � a mostrarResultado(), e nela passamos como argumentos:

O campo onde os caracteres s�o digitados;
O valor m�ximo de caracteres;
O id do elemento onde irei escrever os resultados.
No exemplo abaixo, utilizo como exemplo o n�mero m�ximo de 200 caracteres para serem digitados. 

A propriedade �length� calcula o tamanho do que lhe � determinado, neste caso do elemento textarea, de id �campo�.
E o que eu fa�o nesta fun��o toda?
Se o tamanho do valor que est� no campo, ou seja, a quantidade de caracteres for diferente de 0, escrever no elemento �span� o total de caracteres digitados.
Se for igual a 1, escrever a mesma frase, s� que no singular.
E se ultrapassar 140 caracteres, escrever a mensagem �Limite de caracteres excedido!�.
F�cil n�o? Esta fun��o est� 100% customiz�vel, apenas mude os argumentos passados a fun��o de acordo com a sua necessidade.
 * */
//Tratamento 2 de erro no campo Textarea.

/*
Agora vamos a fun��o que ir� me mostrar quantos caracteres ainda posso digitar, e quando ultrapassar este valor n�o deixar.
Para tal fa�anha, utilizaremos a fun��o contarCaracteres(), e passamos como argumento:

Novamente o campo onde os caracteres s�o digitados;
O valor limite de caracteres;
O id do elemento onde irei escrever os resultados.

Logo na primeira linha eu fa�o a simples conta de subtra��o, pego o valor limite, passado via argumentos, e subtraio dele a quantidade digitada,
 em seguida escrevo o resultado, exibindo quantos ainda restam para digitar.
E se este valor for maior ou igual ao meu valor limite, escrevo �Opss.. voc� n�o pode mais digitar..� e em seguida utilizo o m�todo
substr() para me trazer exatamente o valor limite (neste caso 140) no meu campo, fazendo com que n�o seja permitido digitar mais..
Esta fun��o est� 95% customiz�vel, apenas na linha 6 coloque o id (na propriedade getElementById()) relativo ao campo em que ir� ser contado e bloqueado os caracteres. 
 */
 
/*############# ATEN�A� INICIO DE TRATRAMENTO DE ERRO DO TEXTARE DA P�GINA CADASTRO DE PROJETO (TAMB�M � DEFINIDA EM ATUALIZAR PROJETO)##################*/
//Projeto Descricao
function mostrarResultadoDescricao(box0,num_max0,campospan0){
	var contagem_carac0 = box0.length;
	if (contagem_carac0 != 0){
		//document.getElementById(campospan0).innerHTML = contagem_carac0 + " caracteres digitados (Obs: espa�os contam como caracteres).";
		if (contagem_carac0 == 1){
			//document.getElementById(campospan0).innerHTML = contagem_carac0 + " caracter digitado";
		}
		if (contagem_carac0 >= num_max0){
			//document.getElementById(campospan0).innerHTML = "Limite de caracteres excedido!";
		}
	}else{
		//document.getElementById(campospan0).innerHTML = "Ainda n�o temos nada digitado..";
	}
}
function contarCaracteresDescricao(box0,valor0,campospan0){
	var conta0 = valor0 - box0.length;
	document.getElementById(campospan0).innerHTML = "Voc� ainda pode digitar " + conta0 + " caracteres";
	if(box0.length >= valor0){
		document.getElementById(campospan0).innerHTML = "Opss.. voc� n�o pode mais digitar..";
		document.getElementById("objetivoprojeto").value = document.getElementById("objetivoprojeto").value.substr(0,valor0);
	}	
}
//---------------------------------------------------------------------------------------------------------------------------------------
//Projeto Compuls�rio 
function mostrarResultadoJustificativa(box,num_max,campospan){
	var contagem_carac = box.length;
	if (contagem_carac != 0){
		//document.getElementById(campospan).innerHTML = contagem_carac + " caracteres digitados (Obs: espa�os contam como caracteres).";
		if (contagem_carac == 1){
			//document.getElementById(campospan).innerHTML = contagem_carac + " caracter digitado";
		}
		if (contagem_carac >= num_max){
			//document.getElementById(campospan).innerHTML = "Limite de caracteres excedido!";
		}
	}else{
		//document.getElementById(campospan).innerHTML = "Ainda n�o temos nada digitado..";
	}
}
function contarCaracteresJustificativa(box,valor,campospan){
	var conta = valor - box.length;
	document.getElementById(campospan).innerHTML = "Voc� ainda pode digitar " + conta + " caracteres";
	if(box.length >= valor){
		document.getElementById(campospan).innerHTML = "Opss.. voc� n�o pode mais digitar..";
		document.getElementById("justificativaprojeto").value = document.getElementById("justificativaprojeto").value.substr(0,valor);
	}	
}
//------------------------------------------------------------------------------------------------------------------------------------------------------
//Projeto Qualitativo 
function mostrarResultadoResultado(box1,num_max1,campospan1){
	var contagem_carac1 = box1.length;
	if (contagem_carac1 != 0){
		//document.getElementById(campospan1).innerHTML = contagem_carac1 + " caracteres digitados (Obs: espa�os contam como caracteres).";
		if (contagem_carac1 == 1){
			//document.getElementById(campospan1).innerHTML = contagem_carac1 + " caracter digitado";
		}
		if (contagem_carac1 >= num_max1){
			//document.getElementById(campospan1).innerHTML = "Limite de caracteres excedido!";
		}
	}else{
		//document.getElementById(campospan1).innerHTML = "Ainda n�o temos nada digitado..";
	}
}
function contarCaracteresResultado(box1,valor1,campospan1){
	var conta1 = valor1 - box1.length;
	document.getElementById(campospan1).innerHTML = "Voc� ainda pode digitar " + conta1 + " caracteres";
	if(box1.length >= valor1){
		document.getElementById(campospan1).innerHTML = "Opss.. voc� n�o pode mais digitar..";
		document.getElementById("resultadoprevisto").value = document.getElementById("resultadoprevisto").value.substr(0,valor1);
	}	
}
//------------------------------------------------------------------------------------------------------------------------------------------------------
//Projeto  Quantitativo
function mostrarResultadoDetalhamento(box2,num_max2,campospan2){
	var contagem_carac2 = box2.length;
	if (contagem_carac2 != 0){
		//document.getElementById(campospan2).innerHTML = contagem_carac2 + " caracteres digitados (Obs: espa�os contam como caracteres).";
		if (contagem_carac2 == 1){
			//document.getElementById(campospan2).innerHTML = contagem_carac2 + " caracter digitado";
		}
		if (contagem_carac2 >= num_max2){
			//document.getElementById(campospan2).innerHTML = "Limite de caracteres excedido!";
		}
	}else{
		//document.getElementById(campospan2).innerHTML = "Ainda n�o temos nada digitado..";
	}
}
function contarCaracteresDetalhamento(box2,valor2,campospan2){
	var conta2 = valor2 - box2.length;
	document.getElementById(campospan2).innerHTML = "Voc� ainda pode digitar " + conta2 + " caracteres";
	if(box2.length >= valor2){
		document.getElementById(campospan2).innerHTML = "Opss.. voc� n�o pode mais digitar..";
		document.getElementById("detalhamento").value = document.getElementById("detalhamento").value.substr(0,valor2);
	}	
}
//------------------------------------------------------------------------------------------------------------------------------------------------------
//3
function mostrarResultadoEfetividade(box,num_max,campospan3){
	var contagem_carac = box.length;
	if (contagem_carac != 0){
		//document.getElementById(campospan).innerHTML = contagem_carac + "caracteres digitados (Obs: espa�os contam como caracteres). ";
		if (contagem_carac == 1){
			//document.getElementById(campospan).innerHTML = contagem_carac + " caracter digitado";
		}
		if (contagem_carac >= num_max){
			//document.getElementById(campospan).innerHTML = "Limite de caracteres excedido!";
		}
	}else{
		//document.getElementById(campospan).innerHTML = "Ainda n�o temos nada digitado..";
	}
}
function contarCaracteresEfetividade(box,valor,campospan3){
	var conta = valor - box.length;
	document.getElementById(campospan3).innerHTML = "Voc� ainda pode digitar " + conta + " caracteres";
	if(box.length >= valor){
		document.getElementById(campospan3).innerHTML = "Opss.. voc� n�o pode mais digitar..";
		document.getElementById("analiseefetividade").value = document.getElementById("analiseefetividade").value.substr(0,valor);
	}	
}
//------------------------------------------------------------------------------------------------------------------------------------------------------
//4
function mostrarResultadoDocumentacao(box1,num_max1,campospan4){
	var contagem_carac1 = box1.length;
	if (contagem_carac1 != 0){
		//document.getElementById(campospan1).innerHTML = contagem_carac1 + " caracteres digitados (Obs: espa�os contam como caracteres).";
		if (contagem_carac1 == 1){
			//document.getElementById(campospan1).innerHTML = contagem_carac1 + " caracter digitado";
		}
		if (contagem_carac1 >= num_max1){
			//document.getElementById(campospan1).innerHTML = "Limite de caracteres excedido!";
		}
	}else{
		//document.getElementById(campospan1).innerHTML = "Ainda n�o temos nada digitado..";
	}
}
function contarCaracteresDocumentacao(box1,valor1,campospan4){
	var conta1 = valor1 - box1.length;
	document.getElementById(campospan4).innerHTML = "Voc� ainda pode digitar " + conta1 + " caracteres";
	if(box1.length >= valor1){
		document.getElementById(campospan4).innerHTML = "Opss.. voc� n�o pode mais digitar..";
		document.getElementById("documentacaofisica").value = document.getElementById("documentacaofisica").value.substr(0,valor1);
	}	
}
//------------------------------------------------------------------------------------------------------------------------------------------------------
//5
function mostrarResultadoDocumentacaoeletronica(box2,num_max2,campospan5){
	var contagem_carac2 = box2.length;
	if (contagem_carac2 != 0){
		//document.getElementById(campospan2).innerHTML = contagem_carac2 + " caracteres digitados (Obs: espa�os contam como caracteres).";
		if (contagem_carac2 == 1){
			//document.getElementById(campospan2).innerHTML = contagem_carac2 + " caracter digitado";
		}
		if (contagem_carac2 >= num_max2){
			//document.getElementById(campospan2).innerHTML = "Limite de caracteres excedido!";
		}
	}else{
		//document.getElementById(campospan2).innerHTML = "Ainda n�o temos nada digitado..";
	}
}
function contarCaracteresDocumentacaoeletronica(box2,valor2,campospan5){
	var conta2 = valor2 - box2.length;
	document.getElementById(campospan5).innerHTML = "Voc� ainda pode digitar " + conta2 + " caracteres";
	if(box2.length >= valor2){
		document.getElementById(campospan5).innerHTML = "Opss.. voc� n�o pode mais digitar..";
		document.getElementById("documentacaoeletronica").value = document.getElementById("documentacaoeletronica").value.substr(0,valor2);
	}	
}
//------------------------------------------------------------------------------------------------------------------------------------------------------
//6
function mostrarResultadoCoordenador(box6,num_max6,campospan6){
	var contagem_carac6 = box6.length;
	if (contagem_carac6 != 0){
		//document.getElementById(campospan2).innerHTML = contagem_carac2 + " caracteres digitados (Obs: espa�os contam como caracteres).";
		if (contagem_carac6 == 1){
			//document.getElementById(campospan2).innerHTML = contagem_carac2 + " caracter digitado";
		}
		if (contagem_carac6 >= num_max6){
			//document.getElementById(campospan2).innerHTML = "Limite de caracteres excedido!";
		}
	}else{
		//document.getElementById(campospan2).innerHTML = "Ainda n�o temos nada digitado..";
	}
}
function contarCaracteresCoordenador(box6,valor6,campospan6){
	var conta6 = valor6 - box6.length;
	document.getElementById(campospan6).innerHTML = "Voc� ainda pode digitar " + conta6 + " caracteres";
	if(box6.length >= valor6){
		document.getElementById(campospan6).innerHTML = "Opss.. voc� n�o pode mais digitar..";
		document.getElementById("concideracaocoordenador").value = document.getElementById("concideracaocoordenador").value.substr(0,valor6);
	}	
}
//------------------------------------------------------------------------------------------------------------------------------------------------------
//7
function mostrarResultadoGestor(box7,num_max7,campospan7){
	var contagem_carac7 = box7.length;
	if (contagem_carac7 != 0){
		//document.getElementById(campospan2).innerHTML = contagem_carac2 + " caracteres digitados (Obs: espa�os contam como caracteres).";
		if (contagem_carac7 == 1){
			//document.getElementById(campospan2).innerHTML = contagem_carac2 + " caracter digitado";
		}
		if (contagem_carac7 >= num_max7){
			//document.getElementById(campospan2).innerHTML = "Limite de caracteres excedido!";
		}
	}else{
		//document.getElementById(campospan2).innerHTML = "Ainda n�o temos nada digitado..";
	}
}
function contarCaracteresGestor(box7,valor7,campospan7){
	var conta7 = valor7 - box7.length;
	document.getElementById(campospan7).innerHTML = "Voc� ainda pode digitar " + conta7 + " caracteres";
	if(box7.length >= valor7){
		document.getElementById(campospan7).innerHTML = "Opss.. voc� n�o pode mais digitar..";
		document.getElementById("concideracaogestor").value = document.getElementById("concideracaogestor").value.substr(0,valor7);
	}	
}
//------------------------------------------------------------------------------------------------------------------------------------------------------
/*#####ATEN��O FIM DE TRATRAMENTO DE ERRO DO TEXARE DA P�GINA CADASTRO DE PROJETO (cadastro_projeto.jsp), E TAMB�M � DEFINIDA EM ATUALIZAR PROJETO)##################*/
