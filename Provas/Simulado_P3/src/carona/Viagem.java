package LabOO.Provas.Simulado_P3.src.carona;

import java.util.ArrayList;
import java.util.List;

public class Viagem {
    private String origem;
    private String destino;
    private double valorPorPassageiro;
    private int vagasDisponíveis;

    private Usuario motorista;
    private List<Usuario> passageiros = new ArrayList<>();
    private EstadoViagem estado;

    public Viagem(Usuario motorista, String origem, String destino, int vagas, double valorPorPassageiro) {
        this.motorista = motorista;
        this.origem = origem;
        this.destino = destino;
        this.vagasDisponíveis = vagas;
        this.valorPorPassageiro = valorPorPassageiro;
        this.estado = new EstadoViagemAceitando(this);
    }

    public String qualOrigem() {
        return origem;
    }

    public String qualDestino() {
        return destino;
    }

    public boolean aceitaCarona() {
        return estado.aceitaPassageiro();
    }

    public void pedirCarona(Usuario passageiro) {
        estado.adicionarPassageiro(passageiro);
    }

    public void cancelarCarona(Usuario passageiro) {
        estado.removerPassageiro(passageiro);
    }

    public void adicionarPassageiro(Usuario passageiro) {
        passageiros.add(passageiro);
    }

    public boolean removerPassageiro(Usuario passageiro) {
        return passageiros.remove(passageiro);
    }

    public void iniciar() {
        estado.iniciar(); // {aceitando,lotado} -> em andamento
    }

    public void concluir() { // em andamento -> concluir
        estado.concluir();
    }

    public void cancelar() { // {aceitando,lotado} -> cancelado
        estado.cancelar();
    }

    public void alterarEstado(EstadoViagem estado) {
        this.estado = estado;
    }

    public EstadoViagem qualEstado() {
        return this.estado;
    }

    public void relatório() {
        System.out.println(this.toString());
    }

    public int quantasVagasDisponíveis() {
        return vagasDisponíveis;
    }

    public void alterarVagasDisponíveis(int vagasDisponíveis) {
        this.vagasDisponíveis = vagasDisponíveis;
    }

    @Override
    public String toString() {
        String txt = "Motorista: " + motorista.getNome();
        txt += "\nOrigem: " + origem;
        txt += "\nDestino: " + destino;
        txt += "\nVagas: " + vagasDisponíveis;
        txt += "\nPassageiros: ";
        for (Usuario passageiro : passageiros) {
            txt += "\n - " + passageiro.getNome();
        }
        txt += "\nValor por passageiro: " + valorPorPassageiro;
        txt += "\nEstado: " + estado.relatório();
        return txt;
    }
}
