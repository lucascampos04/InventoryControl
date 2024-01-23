package org.estoque.Test;

import org.estoque.Model.Connection.Conexao;
import org.estoque.Model.Connection.connection;
import org.estoque.Model.Connection.connection;
import org.estoque.Model.Entity.Logradouro;
import org.estoque.Model.Entity.UsuarioDados;
import org.estoque.Model.Enum.Status;
import org.estoque.Present.CadastrarUsuario.CadastrarUsuarioService;

public class CadastrarUsuarioTest {
    public static void main(String[] args) {
        Conexao conexao = new connection();

        UsuarioDados usuarioDados = new UsuarioDados();
        usuarioDados.setUsername("testusesssdwsrww");
        usuarioDados.setSenha("testpasswodede12r12d");
        usuarioDados.setNome("Test Userww");
        usuarioDados.setEmail("luc4scamposoli04@gmail.com");
        usuarioDados.setTelefone("12345672112189");
        usuarioDados.setStatus(Status.USER);
        Logradouro logradouro = new Logradouro();
        logradouro.setId(1L);
        usuarioDados.setLogradouro(logradouro);

        CadastrarUsuarioService cadastrarUsuarioService = new CadastrarUsuarioService(conexao);

        String resultado = cadastrarUsuarioService.addUsuario(usuarioDados);
        System.out.println(resultado);
    }
}
