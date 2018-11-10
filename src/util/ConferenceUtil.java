package util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class ConferenceUtil {

	/**
	 * Retorna a data formatada
	 * 
	 * @param data
	 * @return
	 */
	public static String dataFormatada(Date data) {
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		return formato.format(data);
	}
	
	/**
	 * Retorna a data formatada
	 * 
	 * @param data
	 * @return
	 */
	public static String HoraFormatada(Date data) {
		SimpleDateFormat formato = new SimpleDateFormat("hh:mm");
		return formato.format(data);
	}


	/**
	 * Este metodo acresenta um dia para a data passada
	 * 
	 * @param data
	 * @return
	 */
	public static Date somarUmDiaData(Date data) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(data);
		calendar.add(Calendar.DATE, +1);

		// Obtemos a data alterada
		data = calendar.getTime();

		return data;
	}

	public static Date adicionarHoraEvento(Date data, int hora, int minuto) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(data); 
		calendar.set(Calendar.HOUR_OF_DAY, hora);
		calendar.set(Calendar.MINUTE, minuto);
		
		data = calendar.getTime();
		
		return data;
	}

}