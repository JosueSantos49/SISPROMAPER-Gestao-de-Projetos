

		var tamanhotexto = new Number();
		var tamanhotexto = 13;
		function tamanhooriginal(){
			document.getElementById("conteudo").style.fontSize=tamanhotexto+'px';
		}
		function fonte(e){
			var elemento=document.getElementById("conteudo");
			var atual=elemento.style.fontSize;
			if(e == 'a'){
				atual = parseInt(atual)+2+'px';
			}else if(e == 'b'){
				atual = parseInt(atual)-2+'px';
			}else if(e == 'c'){
				atual = 13+'px';
			}
			elemento.style.fontSize=atual;
		}

