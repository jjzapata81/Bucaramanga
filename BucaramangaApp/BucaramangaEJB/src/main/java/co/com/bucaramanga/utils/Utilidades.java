package co.com.bucaramanga.utils;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jasypt.util.password.StrongPasswordEncryptor;


public final class Utilidades {
	
	private Utilidades(){}

	public static String dateToString(Date fecha) {
		if (null !=fecha){
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");	
			return df.format(fecha);
		}
		return "";
	}

	public static Date stringToDate(String fecha) {
		if(null != fecha){
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			try {
				return df.parse(fecha);
			} catch (ParseException e) {
				return null;
			}
		}
		return null;
	}
	
	public static String formatoMoneda(Long valor){
		NumberFormat format = NumberFormat.getCurrencyInstance();
		return format.format(valor);
		
	}
	
	public static Date fechaMasDias(Date fecha, int dias) {
		Calendar c = Calendar.getInstance();
		c.setTime(fecha);
		c.add(Calendar.DAY_OF_MONTH, dias);
		return c.getTime();
	}

	public static Date fechaPrimerDia(Date fecha) {
		Calendar c = Calendar.getInstance();
		c.setTime(fecha);
		c.set(Calendar.DAY_OF_MONTH, 1);
		c.set(Calendar.HOUR, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		c.set(Calendar.MILLISECOND, 0);
		return c.getTime();
	}

	public static boolean emailNoValido(String email) {
		if(email == null || email.trim().isEmpty())
			return false;
		Pattern pattern = Pattern.compile(Constantes.PATTERN_EMAIL);
        Matcher matcher = pattern.matcher(email);
        return !matcher.matches();	
	}
	
	public static String encriptar(String password) {
		return new StrongPasswordEncryptor ().encryptPassword(password);
	}
	
	public static boolean validar(String password, String encryptedPassword){
		return new StrongPasswordEncryptor().checkPassword(password, encryptedPassword);
	}

}

