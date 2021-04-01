package br.com.tkcsapcd.model.util;


public class MainPerformance {

	private double puitem1 = 2.50;
	private Integer qtd1 = 2;	
	private double s1 = puitem1 * qtd1;	
	double rstd1 = s1;
	
	private double puitem2 = 2.50;
	private Integer qtd2 = 2;	
	private double s2 = puitem2 * qtd2;	
	double rstd2 = s2;
	
	private double puitem3 = 2.50;
	private Integer qtd3 = 2;	
	private double s3 = puitem3 * qtd3;	
	double rstd3 = s3;
	
	private double puitem4 = 2.50;
	private Integer qtd4 = 2;	
	private double s4 = puitem4 * qtd4;	
	double rstd4 = s4;
	
	private double puitem5 = 2.50;
	private Integer qtd5 = 2;	
	private double s5 = puitem5 * qtd5;	
	double rstd5 = s5;
	
	private double puitem6 = 2.50;
	private Integer qtd6 = 2;	
	private double s6 = puitem6 * qtd6;	
	double rstd6 = s6;
	
	
	
	double total = (rstd1 + rstd2 + rstd3 + rstd4 + rstd5 + rstd6);
	
	public static void main(String[] args) {
		
		 MainPerformance m = new MainPerformance();
		 System.out.println(m.total);

	}

}
