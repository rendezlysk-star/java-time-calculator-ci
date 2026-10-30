package gt.edu.umes.proy.calculo;

public class LogicaDelNegocio {

    private static final int TOTAL_PARAMETROS_REQUERIDOS = 5;
    private static final int DIAS_POR_MES = 30;
    private static final int DIAS_POR_SEMANA = 7;
    private static final int HORAS_POR_DIA = 24;
    private static final int MINUTOS_POR_HORA = 60;
    private static final int SEGUNDOS_POR_MINUTO = 60;

    public boolean validarParametros(String[] argumentos) {
        if (argumentos == null || argumentos.length != TOTAL_PARAMETROS_REQUERIDOS) {
            System.err.println("Error: Por favor ingresa exactamente 5 parámetros enteros.");
            return false;
        }

        for (int i = 0; i < argumentos.length; i++) {
            try {
                Integer.parseInt(argumentos[i]);
            } catch (NumberFormatException ex) {
                System.err.println("Error: El parámetro en la posición: " + (i + 1) + " ('" + argumentos[i] + "') no es un número entero válido.");
                return false;
            }
        }

        return true;
    }
 
    public long calcularTiempoEnSegundos(int mesesIngresados, int semanasIngresadas, int diasIngresados, int horasIngresadas, int minutosIngresados) {
        long totalDias = ((long) mesesIngresados * DIAS_POR_MES) + ((long) semanasIngresadas * DIAS_POR_SEMANA) + diasIngresados;
        long totalHoras = (totalDias * HORAS_POR_DIA) + horasIngresadas;
        long totalMinutos = (totalHoras * MINUTOS_POR_HORA) + minutosIngresados;
        return totalMinutos * SEGUNDOS_POR_MINUTO;
    }
    
    public void procesarCalculo(String[] argumentos) {
        if (!validarParametros(argumentos)) {
            return;
        }

        int meses = Integer.parseInt(argumentos[0]);
        int semanas = Integer.parseInt(argumentos[1]);
        int dias = Integer.parseInt(argumentos[2]);
        int horas = Integer.parseInt(argumentos[3]);
        int minutos = Integer.parseInt(argumentos[4]);

        long totalSegundos = calcularTiempoEnSegundos(meses, semanas, dias, horas, minutos);
        System.out.println("Total en segundos: " + totalSegundos);
        System.out.println("Calificacion 23 de Octubre - Ingeniería de Sofware II" );
        
    }
    
    public long calcularDesdeArgumentos(String[] argumentos) {
        if (argumentos == null || argumentos.length != TOTAL_PARAMETROS_REQUERIDOS) {
            throw new IllegalArgumentException("Se requieren exactamente 5 parámetros enteros.");
        }

        int meses = Integer.parseInt(argumentos[0]);
        int semanas = Integer.parseInt(argumentos[1]);
        int dias = Integer.parseInt(argumentos[2]);
        int horas = Integer.parseInt(argumentos[3]);
        int minutos = Integer.parseInt(argumentos[4]);

        return calcularTiempoEnSegundos(meses, semanas, dias, horas, minutos);
    }
}