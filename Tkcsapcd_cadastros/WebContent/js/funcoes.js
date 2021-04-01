$(document).ready(function(){
	$('#tabela').dataTable();
});

/*===========================================================================================================*/
//------------Fun��o para confirma��o de exclus�o---------------------	
		$(function(){
			$('.link_delete').click(function(){
				return confirm("Deseja realmente a exclus�o?");
			});
		});
//-------------Fun��o para confirma��o de atualiza��o------------------	
		$(function(){
			$('.link_atualizar').click(function(){
				return confirm("Deseja realmente a atualiza��o?");
			});
		});	
/*===========================================================================================================*/
//função para a criação de máscaras nos campos
function formata_mascara(campo_passado, mascara)
{
	var campo = campo_passado.value.length;
	var saida = mascara.substring(0,1);
	var texto = mascara.substring(campo);
	if(texto.substring(0,1) != saida)
	{
		campo_passado.value += texto.substring(0,1);
	}
}
/*===========================================================================================================*/
//Função para o usuário digitar somente numeros
//onkeypress="return Numero(event);"
function Numero(e)
{
	navegador = /msie/i.test(navigator.userAgent);
	if (navegador)
		var tecla = event.which;
	else
		var tecla = e.which;
		
	if(tecla > 47 && tecla < 58)//numeros de 0 a 9
		return true;
	else
		{
			if (tecla != 8)//backspace
				return false;
			else
				return true;
		}
}

/*===========================================================================================================*/
//Função para o usuário digitar somente letras [a-zA-Z]
//Atencao: para chamar a funcao deve colocar o comando dentro do input (onkeypress="return Letra(event);")
function Letra(e)
        {
                var expressao;

                expressao = /[A-Z,a-z, ,.,�,�,�,�,�,�,�,�,�,�,�,�,�]/ ;
                //expressao = /[A-Za-z\s]/;
                /*
                 [A-Z,a-z, ,.,�,�,�,�,�,�,�,�,�,�,�,�,�,-]                 
                 * */
                
                if(expressao.test(String.fromCharCode(e.which )))
                {
                        return true;
                }
                else
                {
                        return false;
                }
        }
/*===========================================================================================================*/
function numbers(evt)
{
    var key_code = evt.keyCode  ? evt.keyCode  :
                   evt.charCode ? evt.charCode :
                   evt.which    ? evt.which    : void 0;


    // Habilita teclas <DEL>, <TAB>, <ENTER>, <ESC> e <BACKSPACE>
    if (key_code == 8  ||  key_code == 9  ||  key_code == 13  ||  key_code == 27  ||  key_code == 46)
    {
        return true;
    }

    // Habilita teclas <HOME>, <END>, mais as quatros setas de navega��o (cima, baixo, direta, esquerda)
    else if ((key_code >= 35)  &&  (key_code <= 40))
    {
        return true
    }

    // Habilita n�meros de 0 a 9
    else if ((key_code >= 48)  &&  (key_code <= 57))
    {
        return true
    }

    return false;
}

//N�o permite numeros
function Letras(e)
{
	var expressao;

	expressao = /[0-9]/;

	if(expressao.test(String.fromCharCode(e.which)))
	{
		return false;
	}
	else
	{
		return true;
	}
}

function Mascara(tipo, campo, teclaPress) {
    if (window.event){
            var tecla = teclaPress.keyCode;
    }
        else {
            tecla = teclaPress.which;
    }
    var s = new String(campo.value);
    // Remove todos os caracteres � seguir: ( ) / - . e espa�o, para tratar a string denovo.
    s = s.replace(/(\.|\(|\)|\/|\-| )+/g,'');
    tam = s.length + 1;
     if ( tecla != 9 && tecla != 8 ) {
           switch (tipo){
               case 'cpf' :
                   if (tam > 3 && tam < 7){
                       campo.value = s.substr(0,3) + '.' + s.substr(3, tam);
                    }
                    if (tam >= 7 && tam < 10){
                       campo.value = s.substr(0,3) + '.' + s.substr(3,3) + '.' + s.substr(6,tam-6);
                    }
                    if (tam >= 10 && tam < 12){
                       campo.value = s.substr(0,3) + '.' + s.substr(3,3) + '.' + s.substr(6,3) + '-' + s.substr(9,tam-9);
                    }
                    break;
                case 'celular' ://telefone
                    if (tam > 2 && tam < 4){
                       campo.value = '(' + s.substr(0,2) + ') ' + s.substr(2,tam);
                    }
                    if (tam >= 7 && tam < 11){
                       campo.value = '(' + s.substr(0,2) + ') ' + s.substr(2,4) + '-' + s.substr(6,tam-6);
                    }
                    break;
                case 'datanascimento' :
                    if (tam > 2 && tam < 4){
                       campo.value = s.substr(0,2) + '/' + s.substr(2, tam);
                    }
                    if (tam > 4 && tam < 11){
                       campo.value = s.substr(0,2) + '/' + s.substr(2,2) + '/' + s.substr(4,tam-4);
                    }
                    break;
                case 'cep' :
                    if (tam > 5 && tam < 7){
                       campo.value = s.substr(0,5) + '-' + s.substr(5, tam);
                    }
                    break;
            }
    }
    }
    /*Fun��o para verificar se o valor digitado � n�mero..*/
   function digitos(event){
   if (window.event) {
           // IE
           key = event.keyCode;
   }
       else if ( event.which ) {
           // netscape
           key = event.which;
   }
   if ( key != 8 || key != 13 || key < 48 || key > 57 ){
            return ( ( ( key > 47 ) && ( key < 58 ) ) || ( key == 8 ) || ( key == 13 ) );
        return true;
    };
}


