package com.biblioteca.util;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class DateUtils {

    public static LocalDate calcularDataRetorno(LocalDate dataEmprestimo, String tipoLivro) {
        LocalDate dataRetorno = dataEmprestimo;
        if ("recente".equalsIgnoreCase(tipoLivro)) {
            dataRetorno = dataEmprestimo.plusDays(30);
        } else if ("colecao".equalsIgnoreCase(tipoLivro)) {
            dataRetorno = dataEmprestimo.plusDays(60);
        }

        // Verifica se a data de retorno cai em período de fechamento da biblioteca
        if (dataRetorno.isAfter(LocalDate.of(dataRetorno.getYear(), 12, 24)) &&
            dataRetorno.isBefore(LocalDate.of(dataRetorno.getYear() + 1, 1, 3))) {
            return LocalDate.of(dataRetorno.getYear() + 1, 1, 2);
        }

        return dataRetorno;
    }

    public static long calcularDiasAtraso(LocalDate dataRetornoDevido, LocalDate dataDevolucao) {
        if (dataDevolucao.isAfter(dataRetornoDevido)) {
            return ChronoUnit.DAYS.between(dataRetornoDevido, dataDevolucao);
        }
        return 0;
    }

    public static LocalDate adicionarImpedimento(LocalDate dataDevolucao, long diasAtraso) {
        return dataDevolucao.plusDays(diasAtraso * 3);
    }
}