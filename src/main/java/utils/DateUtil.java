package utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 */
public class DateUtil {

    public static String getDataAtual() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy"); // Fornato da data
        Date currentDate = new Date(); // Instanciando data atual
        return dateFormat.format(currentDate);
    }

    public static int getAnoAtual() {
        Date currentDate = new Date(); // Instanciando data atual
        Calendar c = Calendar.getInstance(); // convertendo o date para calendar
        c.setTime(currentDate);
        return c.get(Calendar.YEAR);
    }

    public static String getDataAtualMaisAnos(int qtdeAnos) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy"); // Fornato da data
        Calendar c = Calendar.getInstance(); // Convertendo o date para calendar
        c.add(Calendar.YEAR, qtdeAnos); // Adicionando X ano(s) à data atual
        Date currentDateMoreYears = c.getTime(); // Convertendo calendar para date
        return dateFormat.format(currentDateMoreYears);
    }
}
