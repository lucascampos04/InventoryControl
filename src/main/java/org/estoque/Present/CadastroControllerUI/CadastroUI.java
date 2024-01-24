package org.estoque.Present.CadastroControllerUI;

import org.estoque.Model.Connection.Conexao;
import org.estoque.Model.Connection.connection;
import org.estoque.Model.Entity.UsuarioDados;
import org.estoque.Model.Enum.Status;
import org.estoque.Present.CadastrarUsuario.CadastrarUsuarioService;
import org.estoque.View.FormularioCadastro.CadastraFormularioView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CadastroUI implements ActionListener {
    private final CadastraFormularioView cadastraFormularioView;
    public CadastroUI(CadastraFormularioView cadastraFormularioView) {
        this.cadastraFormularioView = cadastraFormularioView;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        switch (command){
            case "Salvar":
                cadastrarUsuario();
                break;
            default:
                System.out.println("Erro desconhecido");
        }
    }

    private void cadastrarUsuario(){
        String nome = this.cadastraFormularioView.getInputNome().getText();
        String email = this.cadastraFormularioView.getInputEmail().getText();
        String username = this.cadastraFormularioView.getInputUsername1().getText();
        String senha = this.cadastraFormularioView.getInputSenha().getText();
        String telefone = this.cadastraFormularioView.getInputTelefone().getText();

        String[] dads = {nome, email, username, senha, telefone};
        for (String dado : dads){
            if (dado == null || dado.isEmpty()){
                this.cadastraFormularioView.getMessage().setText("Erro : os campos não podem ser nulos");
                return;
            }
        }

        Conexao conexao = new connection();
        UsuarioDados usuarioDados = new UsuarioDados();
        usuarioDados.setUsername(username);
        usuarioDados.setSenha(senha);
        usuarioDados.setNome(nome);
        usuarioDados.setEmail(email);
        usuarioDados.setTelefone(telefone);
        usuarioDados.setStatus(Status.USER);
        CadastrarUsuarioService cadastrarUsuarioService = new CadastrarUsuarioService(conexao);
        String resultado = cadastrarUsuarioService.addUsuario(usuarioDados);
        System.out.println(resultado);
    }
}
