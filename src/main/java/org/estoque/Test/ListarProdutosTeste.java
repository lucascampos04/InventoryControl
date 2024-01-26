/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.estoque.Test;

import java.sql.SQLException;
import java.util.List;
import org.estoque.Model.Connection.Conexao;
import org.estoque.Model.Connection.connection;
import org.estoque.Model.Entity.Estoque;
import org.estoque.Model.Entity.UsuarioDados;
import org.estoque.Present.ListUsuarios.ListUsuarios;
import org.estoque.Present.TableControllerMethods.Listar.ListarService;

/**
 *
 * @author campos
 */
public class ListarProdutosTeste {
    public static void main(String[] args) {
        try {
            Conexao conexao = new connection();
            ListarService listarService = new ListarService(conexao);
            List<Estoque> estoques = listarService.listEstoque();
            
            for (Estoque estoque : estoques) {
                System.out.println("ID: " + estoque.getId());
                System.out.println("Nome: " + estoque.getNome()); 
                System.out.println("Categoria: " + estoque.getCategoria()); 
                System.out.println("Fornecedor: " + estoque.getFornecedor()); 
                System.out.println("Quantidade: " + estoque.getQuantidade()); 
                System.out.println("Valor: " + estoque.getValor()); 
                System.out.println("Status: " + estoque.getStatus()); 
                System.out.println("ID USUARIO: " + estoque.getUsuario_id().getId());
                System.out.println("----------------------");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
