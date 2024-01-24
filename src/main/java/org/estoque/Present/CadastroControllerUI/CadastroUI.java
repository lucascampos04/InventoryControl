package org.estoque.Present.CadastroControllerUI;

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
                String nome = this.cadastraFormularioView.getInputNome().getText();
                String email = this.cadastraFormularioView.getInputEmail().getText();
                String username = this.cadastraFormularioView.getInputUsername1().getText();
                String senha = this.cadastraFormularioView.getInputSenha().getText();

                String[] dads = {nome, email, username, senha};

                for (String dado : dads){
                    if (dado == null || dado.isEmpty()){
                        this.cadastraFormularioView.getMessage().setText("Erro : os campos não podem ser nulos");
                        return;
                    }
                    this.cadastraFormularioView.getMessage().setText("Cadastro realizado com sucesso.");
                }

                break;
            default:
                System.out.println("Erro desconhecido");
        }
    }
}
