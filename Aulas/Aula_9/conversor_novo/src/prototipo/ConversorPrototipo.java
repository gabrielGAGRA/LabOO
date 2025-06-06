package LabOO.Aulas.Aula_9.conversor_novo.src.prototipo;

import java.util.HashMap;
import java.util.Map;

import LabOO.Aulas.Aula_9.conversor_novo.src.conversor.interfaces.Conversor;
import LabOO.Aulas.Aula_9.conversor_novo.src.conversor.interfaces.ConversorIdentidade;
import LabOO.Aulas.Aula_9.conversor_novo.src.conversor.temperatura.ConversorCelsiusParaFahrenheit;
import LabOO.Aulas.Aula_9.conversor_novo.src.conversor.temperatura.ConversorCelsiusParaKelvin;
import LabOO.Aulas.Aula_9.conversor_novo.src.conversor.temperatura.ConversorFahrenheitParaCelsius;
import LabOO.Aulas.Aula_9.conversor_novo.src.conversor.temperatura.ConversorFahrenheitParaKelvin;
import LabOO.Aulas.Aula_9.conversor_novo.src.conversor.temperatura.ConversorKelvinParaCelsius;
import LabOO.Aulas.Aula_9.conversor_novo.src.conversor.temperatura.ConversorKelvinParaFahrenheit;

public class ConversorPrototipo {
    private Map<String, Conversor> prototipos = new HashMap<>();

    public ConversorPrototipo() {
        prototipos.put("CF", new ConversorCelsiusParaFahrenheit());
        prototipos.put("FC", new ConversorFahrenheitParaCelsius());
        prototipos.put("CK", new ConversorCelsiusParaKelvin());
        prototipos.put("KC", new ConversorKelvinParaCelsius());
        prototipos.put("FK", new ConversorFahrenheitParaKelvin());
        prototipos.put("KF", new ConversorKelvinParaFahrenheit());
        prototipos.put("=", new ConversorIdentidade());
    }

    public Conversor getConversor(String chave) {
        return (Conversor) prototipos.get(chave).clone();
    }
}