package LabOO.Aulas.Aula_9.conversor_novo.src.fabricas;

import LabOO.Aulas.Aula_9.conversor_novo.src.conversor.interfaces.Conversor;
import LabOO.Aulas.Aula_9.conversor_novo.src.conversor.interfaces.ConversorDistancia;

public interface FactoryConversor_Abstrato {
    Conversor getConversorTemperatura(char de, char para);

    ConversorDistancia getConversorDistancia(String de, String para);
}