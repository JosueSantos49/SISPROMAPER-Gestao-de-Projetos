//não permite letras
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

    // Habilita teclas <HOME>, <END>, mais as quatros setas de navegação (cima, baixo, direta, esquerda)
    else if ((key_code >= 35)  &&  (key_code <= 40))
    {
        return true
    }

    // Habilita números de 0 a 9
    else if ((key_code >= 48)  &&  (key_code <= 57))
    {
        return true
    }

    return false;
}

//Não permite numeros
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