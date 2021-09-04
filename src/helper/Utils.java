package helper;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

/**
 * Classe para formatar datas e moedas para o formato utilizado no Brasil
 */
public class Utils {
	static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	static NumberFormat nf = new DecimalFormat("R$ #,##0.00", new DecimalFormatSymbols(new Locale("pt", "BR")));
	
	
	/**
	 * Formata tipo de dado Date para uma string
	 */
	public static String data_string(Date data) {
		return sdf.format(data);
	}
	
	/**
	 * Transforma o tipo de dado double em uma string
	 */
	public static String double_string(double valor) {
		return nf.format(valor);
	}
	
	/**
	 * Transforma o tipo de dado string em um double
	 */
	public static Double string_double(String valor) {
		try {
			return (Double)nf.parse(valor);
		}catch(ParseException e) {
			return null;
		}
	}
	
	/**
	 * Pausa o console por alguns segundos
	 */
	public static void pausar(int segundos) {
		try {
			TimeUnit.SECONDS.sleep(segundos);
		}catch(InterruptedException e) {
			System.out.println("Erro ao pausar por " + segundos);
		}
	}

}
