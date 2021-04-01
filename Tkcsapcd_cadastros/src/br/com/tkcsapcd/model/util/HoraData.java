package br.com.tkcsapcd.model.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class HoraData {
		
	public void getHoraData() {
		
				//Implementando Data e Hora
				Date data = new Date();//criando objeto tipo Date e inicializando 
				SimpleDateFormat data_formatada = new SimpleDateFormat("dd/MM/yyyy");//Mascara para a data yyyy/MM/dd
				String mostra_data = data_formatada.format(data); //Variável para armazenar a data
				
				System.out.print(mostra_data);
			
				SimpleDateFormat hora_formatada = new SimpleDateFormat("HH:mm");//Mascara para a hora
				String mostra_hora = hora_formatada.format(data); //Variável para armazenar a hora(aproveitando o mesmo objeto data)	
				
				System.out.print(mostra_hora);
	}

}
