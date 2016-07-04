package br.edu.utfpr.cm.es2.cvlates.view;

import java.awt.FlowLayout;
import java.awt.HeadlessException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;

import br.edu.utfpr.cm.es2.cvlates.entity.Usuario;

public class UsuarioView extends JFrame {
    /**
     * 
     */
    private static final long serialVersionUID = -7688538029712625507L;
    private JButton jButtonNovo;
    private JButton jButonSalvar;
    private JButton jButtonCancelar;
    private JButton jButtonEditar;
    private JButton jButtonPesquisar;

    private JList<Usuario> jListUsuarios;

    private JPanel jPanelCampos;
    private JPanel jPanelPrincipal;

    public UsuarioView() throws HeadlessException {
        super("Usuário");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 724, 507);
        criaPanelPrincipal();
        criaPanelCampos();

    }

    private void criaPanelCampos() {

    }

    private void criaPanelPrincipal() {
        this.jPanelPrincipal = new JPanel(new FlowLayout());

        
        jButtonNovo = new JButton("Novo usuário");
        jButtonNovo.setEnabled(true);
        jButtonNovo.setVisible(true);
        jPanelPrincipal.add(jButtonNovo);
        
        setContentPane(jPanelPrincipal);
    }

}