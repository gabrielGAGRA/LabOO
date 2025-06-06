package LabOO.Aulas.Aula_9.conversor_novo.src.conversor.temperatura;

import LabOO.Aulas.Aula_9.conversor_novo.src.conversor.interfaces.Conversor;

public class ConversorKelvinParaFahrenheit implements Conversor {
    @Override
    public double converte(double temperatura) {
        return (temperatura - 273.15) * 9.0 / 5.0 + 32;
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