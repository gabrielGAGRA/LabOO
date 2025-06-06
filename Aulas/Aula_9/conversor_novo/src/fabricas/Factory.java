package LabOO.Aulas.Aula_9.conversor_novo.src.fabricas;

public class Factory {
    public static FactoryConversor_Abstrato getFactory() {
        return new FactoryConversor_Concreto();
    }
}