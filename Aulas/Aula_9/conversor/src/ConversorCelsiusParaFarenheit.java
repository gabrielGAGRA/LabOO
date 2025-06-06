package LabOO.Aulas.Aula_9.conversor.src;

public class ConversorCelsiusParaFarenheit implements Conversor {

    @Override
    public double converte(double temperatura) {
        return 9 * temperatura / 5 + 32;
    }

}
