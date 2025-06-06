package LabOO.Aulas.Aula_9.conversor_novo.src.conversor.temperatura;

import LabOO.Aulas.Aula_9.conversor_novo.src.conversor.interfaces.Conversor;

public class ConversorFahrenheitParaCelsius implements Conversor {
    @Override
    public double converte(double temperatura) {
        return (temperatura - 32) * 5.0 / 9.0;
    }

    @Override
    public Object clone() {
        try {
            return super.clone();
        }
        catch (CloneNotSupportedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

}