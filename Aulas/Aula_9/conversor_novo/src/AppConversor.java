package LabOO.Aulas.Aula_9.conversor_novo.src;

import LabOO.Aulas.Aula_9.conversor_novo.src.conversor.interfaces.Conversor;
import LabOO.Aulas.Aula_9.conversor_novo.src.conversor.interfaces.ConversorDistancia;
import LabOO.Aulas.Aula_9.conversor_novo.src.fabricas.Factory;
import LabOO.Aulas.Aula_9.conversor_novo.src.fabricas.FactoryConversor_Abstrato;

public class AppConversor {
    public static void main(String[] args) {
        FactoryConversor_Abstrato factory = Factory.getFactory();

        System.out.println("Temperatura");
        Conversor conversorTemp = factory.getConversorTemperatura('C', 'K');
        double kelvin = conversorTemp.converte(25.0);
        System.out.printf("25.0C -> %.2fK\n", kelvin);

        System.out.println("\nDistância");
        ConversorDistancia conversorDist = factory.getConversorDistancia("KM", "MI");
        double milhas = conversorDist.converte(150.0);
        System.out.printf("150.0KM -> %.2f Milhas\n", milhas);
    }
}