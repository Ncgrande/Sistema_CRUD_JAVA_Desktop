package view;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import dao.ClienteDAO;
import model.Cliente;

public class ClienteForm extends JFrame {

    private JTextField tfNome, tfEmail;
    private JButton btnInserir, btnAlterar, btnExcluir;
    private JTable table;
    private ClienteDAO clienteDAO;

    public ClienteForm() {
        setTitle("Cadastro de Clientes");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        clienteDAO = new ClienteDAO();

        JPanel panelDados = new JPanel(new GridLayout(2, 2, 10, 10));
        panelDados.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Adiciona um respiro
        panelDados.add(new JLabel("Nome:"));
        tfNome = new JTextField();
        panelDados.add(tfNome);
        panelDados.add(new JLabel("Email:"));
        tfEmail = new JTextField();
        panelDados.add(tfEmail);

        JPanel panelBotoes = new JPanel(new FlowLayout(FlowLayout.CENTER));
        btnInserir = new JButton("Inserir");
        btnAlterar = new JButton("Alterar");
        btnExcluir = new JButton("Excluir");
        panelBotoes.add(btnInserir);
        panelBotoes.add(btnAlterar);
        panelBotoes.add(btnExcluir);

        JPanel panelSuperior = new JPanel(new BorderLayout());
        panelSuperior.add(panelDados, BorderLayout.CENTER);
        panelSuperior.add(panelBotoes, BorderLayout.SOUTH);

        table = new JTable();
        JScrollPane scrollPane = new JScrollPane(table);


        add(panelSuperior, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER); 


        btnInserir.addActionListener(e -> inserirCliente());
        btnAlterar.addActionListener(e -> alterarCliente());
        btnExcluir.addActionListener(e -> excluirCliente());

        carregarTabela();
    }

    private void carregarTabela() {
        try {
            List<Cliente> clientes = clienteDAO.listar();
            String[] colunas = {"ID", "Nome", "Email"};
            Object[][] dados = new Object[clientes.size()][3];

            for (int i = 0; i < clientes.size(); i++) {
                dados[i][0] = clientes.get(i).getId();
                dados[i][1] = clientes.get(i).getNome();
                dados[i][2] = clientes.get(i).getEmail();
            }

            table.setModel(new javax.swing.table.DefaultTableModel(dados, colunas));
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Erro ao carregar dados: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void inserirCliente() {
        String nome = tfNome.getText();
        String email = tfEmail.getText();
        if (!nome.isEmpty() && !email.isEmpty()) {
            Cliente cliente = new Cliente(nome, email);
            try {
                clienteDAO.inserir(cliente);
                carregarTabela();
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Erro ao inserir cliente: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Nome e email são obrigatórios!", "Erro", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void alterarCliente() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow != -1) {
            int id = (Integer) table.getValueAt(selectedRow, 0);
            String nome = tfNome.getText();
            String email = tfEmail.getText();
            Cliente cliente = new Cliente(id, nome, email);
            try {
                clienteDAO.atualizar(cliente);
                carregarTabela();
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Erro ao alterar cliente: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Selecione um cliente para alterar.", "Aviso", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void excluirCliente() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow != -1) {
            int id = (Integer) table.getValueAt(selectedRow, 0);
            try {
                clienteDAO.excluir(id);
                carregarTabela();
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Erro ao excluir cliente: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Selecione um cliente para excluir.", "Aviso", JOptionPane.WARNING_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ClienteForm().setVisible(true));
    }
}