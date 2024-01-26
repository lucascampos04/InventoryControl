/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.estoque.Test;

import org.estoque.Model.Connection.Conexao;
import org.estoque.Model.Connection.connection;
import org.estoque.Model.Entity.Estoque;
import org.estoque.Model.Entity.UsuarioDados;
import org.estoque.Present.TableControllerMethods.Adicionar.AdicionarService;

/**
 *
 * @author campos
 */
public class CadastrarProdutoTeste {
    public static void main(String[] args) {
        Conexao conexao = new connection();
        Estoque estoque = new Estoque();
        
        estoque.setNome("Refrigerante");
        estoque.setCategoria("Bebida");
        estoque.setFornecedor("Coca cola");
        estoque.setValor(8.0);
        estoque.setQuantidade(1L);
        estoque.setStatus("EM ESTOQUE");
        UsuarioDados usuarioDados = new UsuarioDados();
        usuarioDados.setId(10L);
        estoque.setUsuario_id(usuarioDados);
        
        AdicionarService adicionarService = new AdicionarService(conexao);
        String resultado = adicionarService.adicionar(estoque);
        System.out.println(resultado);
    }
    
}
