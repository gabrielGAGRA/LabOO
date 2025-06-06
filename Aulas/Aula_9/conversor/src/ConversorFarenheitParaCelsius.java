package LabOO.Aulas.Aula_9.conversor.src;

public class ConversorFarenheitParaCelsius implements Conversor {

    @Override
    public double converte(double temperatura) {
        return 5 * (temperatura - 32) / 9;
    }

}
