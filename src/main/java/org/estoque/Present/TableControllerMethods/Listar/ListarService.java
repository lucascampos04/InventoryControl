/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.estoque.Present.TableControllerMethods.Listar;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.estoque.Model.Connection.Conexao;
import org.estoque.Model.Entity.Estoque;
import org.estoque.Model.Entity.UsuarioDados;

/**
 *
 * @author campos
 */
public class ListarService {
    private final Conexao conexao;

    public ListarService(Conexao conexao) {
        this.conexao = conexao;
    }
    
    public List<Estoque> listEstoque() throws SQLException {
        String sql = "SELECT * FROM estoque";
        List<Estoque> estoques = new ArrayList<>();
        try {
            Statement statement = conexao.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                estoques.add(getDados(resultSet));
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return estoques;
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
