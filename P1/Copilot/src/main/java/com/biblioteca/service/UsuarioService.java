package com.biblioteca.service;

import com.biblioteca.model.Usuario;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UsuarioService {
    private List<Usuario> usuarios;
    private int nextId;

    public UsuarioService() {
        this.usuarios = new ArrayList<>();
        this.nextId = 1; // Start IDs from 1
    }

    public Usuario adicionarUsuario(String nome, String dataNascimento, String endereco, String identificacaoPessoal) {
        Usuario usuario = new Usuario(nextId++, nome, dataNascimento, endereco, identificacaoPessoal);
        usuarios.add(usuario);
        return usuario;
    }

    public Optional<Usuario> buscarUsuarioPorNome(String nome) {
        return usuarios.stream()
                .filter(usuario -> usuario.getNome().toLowerCase().startsWith(nome.toLowerCase()))
                .findFirst();
    }

    public Optional<Usuario> buscarUsuarioPorId(int id) {
        return usuarios.stream()
                .filter(usuario -> usuario.getId() == id)
                .findFirst();
    }

    public List<Usuario> listarUsuarios() {
        return new ArrayList<>(usuarios);
    }

    public boolean usuarioPodeEmprestar(Usuario usuario) {
        return !usuario.isImpedido() && usuario.getEmprestimosAtivos().size() < 3;
    }
}