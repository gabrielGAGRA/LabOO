package LabOO.Aulas.Aula_9.conversor_novo.src.conversor.interfaces;

public interface Conversor extends Cloneable {
    double converte(double valor);

    Object clone();
}