package LabOO.Provas.Simulado_P3.src;

import java.util.ArrayList;
import java.util.List;

import carona.EstrategiaEscolhePrimeiro;
import carona.Usuario;
import carona.Viagem;

public class Gerenciador {
    // Padrão Singleton
    private static Gerenciador instancia = new Gerenciador();
    private List<Usuario> usuarios = new ArrayList<>();
    private List<Viagem> viagens = new ArrayList<>();

    private Gerenciador() {
    }

    static public Gerenciador pegarInstancia() {
        return instancia;
    }

    public void novoUsuario(String cpf, String nome) {
        usuarios.add(new Usuario(cpf, nome, new EstrategiaEscolhePrimeiro()));
    }

    public Usuario buscaUsuarioPorCPF(String cpf) {
        for (Usuario usuario : usuarios) {
            if (usuario.qualCPF().equals(cpf))
                return usuario;
        }
        return null;
    }

    public void novaViagem(Usuario motorista, String origem, String destino, int vagas, double valorPorPassageiro) {
        viagens.add(new Viagem(motorista, origem, destino, vagas, valorPorPassageiro));
    }

    public Viagem[] buscaViagemPorLocalidade(String de, String para) {
        List<Viagem> asViagens = new ArrayList<>();
        for (Viagem viagem : viagens) {
            if (viagem.aceitaCarona() && viagem.qualOrigem().equals(de) && viagem.qualDestino().equals(para))
                asViagens.add(viagem);
        }
        return asViagens.toArray(new Viagem[0]);
    }

    public void relatório() {
        int i = 1;
        for (Viagem viagem : viagens) {
            System.out.println(i + " -----");
            System.out.println(viagem);
            System.out.println("--------");
            i++;
        }
    }

    public static void main(String[] args) throws Exception {
        Gerenciador gerenciador = Gerenciador.pegarInstancia();

        gerenciador.novoUsuario("100.021.333-9", "João Maria");
        gerenciador.novoUsuario("321.123.404-5", "Maria João");
        gerenciador.novoUsuario("735.981.351-0", "Carlos Soares");
        gerenciador.novoUsuario("803.304.677-8", "Joana das Neves");

        // João oferece uma carona de São Paulo a Ponta Grossa
        Usuario joao = gerenciador.buscaUsuarioPorCPF("100.021.333-9");
        gerenciador.novaViagem(joao, "São Paulo", "Ponta Grossa", 4, 100);
        // Maria busca caronas de São Paulo a Ponta Grossa
        Usuario maria = gerenciador.buscaUsuarioPorCPF("321.123.404-5");
        Viagem[] resultadoMaria = gerenciador.buscaViagemPorLocalidade("São Paulo", "Ponta Grossa");
        // Maria usa estratégia de seleção para escolher viagens
        maria.escolheViagem(resultadoMaria);
        // Carlos busca caronas de São Paulo a Ponta Grossa
        Usuario carlos = gerenciador.buscaUsuarioPorCPF("735.981.351-0");
        Viagem[] resultadoCarlos = gerenciador.buscaViagemPorLocalidade("São Paulo", "Ponta Grossa");
        carlos.escolheViagem(resultadoCarlos);

        // Joana oferece carona de Ponta Grossa a São Paulo
        Usuario joana = gerenciador.buscaUsuarioPorCPF("803.304.677-8");
        gerenciador.novaViagem(joana, "Ponta Grossa", "São Paulo", 2, 150);

        // João busca carona de Ponta Grossa a São Paulo
        Viagem[] resultadoJoao = gerenciador.buscaViagemPorLocalidade("Ponta Grossa", "São Paulo");
        joao.escolheViagem(resultadoJoao);

        // Carlos busca carona de Ponta Grossa a São Paulo
        resultadoCarlos = gerenciador.buscaViagemPorLocalidade("Ponta Grossa", "São Paulo");
        carlos.escolheViagem(resultadoJoao);

        gerenciador.relatório();
    }
}
