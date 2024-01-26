/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.estoque.Present.TableControllerMethods.Adicionar;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import org.estoque.Model.Connection.Conexao;
import org.estoque.Model.Entity.Estoque;
import org.estoque.Model.Entity.UsuarioDados;

/**
 *
 * @author campos
 */
public class AdicionarService {
    private final Conexao conexao;

    public AdicionarService(Conexao conexao) {
        this.conexao = conexao;
    }
    
    public String adicionar(Estoque estoque){
        String sql = "INSERT INTO estoque(nome, categoria, quantidade, fornecedor, valor, status, usuario_id) VALUES (?, ?, ?, ?, ?, ?, ?)";
        Estoque e = searchId(estoque.getId());
        
        if (estoque == null){
            return String.format("Erro: produto não encontrado ou ID inválido");
        }
        
        try {
            PreparedStatement preparedStatement = conexao.getConnection().prepareStatement(sql);
            preencherValores(preparedStatement, estoque);
            int result = preparedStatement.executeUpdate();
            if (result == 1){
                System.out.println("Produto adicionado com sucesso");
                return "produto adicionado com sucesso";
            } else {
                return "Erro ao cadastrar o produto";
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            return String.format("Erro : %s ", ex.getMessage());
        }
    }
    
    public Estoque searchId(Long id){
        String sql = String.format("SELECT * FROM estoque WHERE id = '%s'", id);

        try {
            PreparedStatement preparedStatement = conexao.getConnection().prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()){
                return getDados(resultSet);
            }
        } catch (SQLException e) {
           e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return null;
    }
    
    private void preencherValores(PreparedStatement preparedStatement, Estoque estoque) throws SQLException {
        preparedStatement.setString(1, estoque.getNome());
        preparedStatement.setString(2, estoque.getCategoria());
        preparedStatement.setLong(3, estoque.getQuantidade());
        preparedStatement.setString(4, estoque.getFornecedor());
        preparedStatement.setDouble(5, estoque.getValor());
        preparedStatement.setString(6, estoque.getStatus());
        preparedStatement.setLong(7, estoque.getUsuario_id().getId());
        
    }
    
   private Estoque getDados(ResultSet resultSet) throws SQLException {
        Estoque estoque = new Estoque();
        estoque.setId(resultSet.getLong("id"));
        estoque.setNome(resultSet.getString("nome"));
        estoque.setStatus(resultSet.getString("status"));
        estoque.setCategoria(resultSet.getString("categoria"));
        estoque.setFornecedor(resultSet.getString("fornecedor"));
        estoque.setQuantidade(resultSet.getLong("quantidade"));
        estoque.setValor(resultSet.getDouble("valor"));
        long userId = resultSet.getLong("usuario_id");
        UsuarioDados us = new UsuarioDados(userId);
        estoque.setUsuario_id(us);
        
        return estoque;
    }

}
