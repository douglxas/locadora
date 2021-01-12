package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import model.bean.Cliente;
import model.bean.Filme;
import model.dao.ClienteDAO;
import model.dao.FilmeDAO;

import javax.swing.JButton;
import java.awt.Color;

public class JFListarClientes extends JFrame {

	private JPanel contentPane;
	private JTable jtCliente;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFListarClientes frame = new JFListarClientes();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JFListarClientes() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 339);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Listar Clientes");
		lblNewLabel.setFont(new Font("Tw Cen MT", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel.setBounds(10, 11, 95, 21);
		contentPane.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 38, 414, 212);
		contentPane.add(scrollPane);
		
		jtCliente = new JTable();
		jtCliente.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"IdCliente", "Nome", "Endereco", "Sexo"
			}
		));
		scrollPane.setViewportView(jtCliente);
		
		JButton btnCadastrar = new JButton("Cadastrar\r\n");
		btnCadastrar.setBackground(Color.GREEN);
		btnCadastrar.setForeground(Color.BLACK);
		btnCadastrar.setBounds(16, 266, 101, 23);
		contentPane.add(btnCadastrar);
		
		JButton btnAlterar = new JButton("Alterar Cliente");
		btnAlterar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if(jtCliente.getSelectedRow() != -1) {
						JFAtualizarClientes af = new JFAtualizarClientes((int)jtCliente.getValueAt(jtCliente.getSelectedRow(), 0));
						af.setVisible(true);
					} else {
						JOptionPane.showMessageDialog(null, "Selecione um cliente!");
					}
					readJTable();
				}
			});
	
			
	
		btnAlterar.setBackground(Color.ORANGE);
		btnAlterar.setBounds(164, 266, 89, 23);
		contentPane.add(btnAlterar);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				if(jtCliente.getSelectedRow() != -1) {
					int opcao = JOptionPane.showConfirmDialog(null, "Deseja excluir o filme selecionado?"
							,"Exclusão", JOptionPane.YES_NO_OPTION); 
					if (opcao == 0) {
						ClienteDAO dao = new ClienteDAO();
						Cliente f = new Cliente();
						f.setIdCliente((int) jtCliente.getValueAt(jtCliente.getSelectedRow(), 0));
						dao.delete(f);
					}
				} else {
					JOptionPane.showMessageDialog(null, "Selecione um filme");
				}
				readJTable();
			}
		});
		btnExcluir.setBackground(Color.RED);
		btnExcluir.setBounds(321, 266, 89, 23);
		contentPane.add(btnExcluir);
		
		readJTable();
	}
	
		
		public void readJTable() {
			DefaultTableModel modelo = (DefaultTableModel) jtCliente.getModel();
			modelo.setNumRows(0);
			ClienteDAO fdao = new ClienteDAO();
			for(Cliente f : fdao.read()) {
				modelo.addRow(new Object[] {
					f.getIdCliente(),
					f.getNome(),
					f.getEndereco(),
					f.isSexo()
				});
			}
		}
	
}
