package LabOO.Aulas.Aula_9.conversor_novo.src.conversor.distancias;

import LabOO.Aulas.Aula_9.conversor_novo.src.conversor.interfaces.ConversorDistancia;

public class ConversorMilhasParaKm implements ConversorDistancia {
    @Override
    public double converte(double distancia) {
        return distancia / 0.621371;
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