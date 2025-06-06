package LabOO.Aulas.Aula_9.conversor_novo.src.conversor.interfaces;

public class ConversorIdentidade implements Conversor {
    @Override
    public double converte(double valor) {
        return valor;
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