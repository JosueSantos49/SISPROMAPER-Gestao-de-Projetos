package br.com.tkcsapcd.model.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DataFormat {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Date date = new Date();
		SimpleDateFormat strDate = new SimpleDateFormat("dd/MM/yyyy");
		System.out.println(strDate.format(date));
		
		
	}
}
