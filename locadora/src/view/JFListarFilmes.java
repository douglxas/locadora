package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import model.bean.Filme;
import model.dao.FilmeDAO;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JFListarFilmes extends JFrame {

	private JPanel contentPane;
	private JTable jtFilme;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFListarFilmes frame = new JFListarFilmes();
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
	public JFListarFilmes() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 339);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Listar Filmes");
		lblNewLabel.setFont(new Font("Tw Cen MT", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel.setBounds(10, 11, 95, 21);
		contentPane.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 38, 414, 212);
		contentPane.add(scrollPane);
		
		jtFilme = new JTable();
		jtFilme.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"IdFilme", "T\u00EDtulo", "Categoria", "Tempo"
			}
		));
		scrollPane.setViewportView(jtFilme);
		
		JButton btnCadastrar = new JButton("Cadastrar\r\n");
		btnCadastrar.setBackground(Color.GREEN);
		btnCadastrar.setForeground(Color.BLACK);
		btnCadastrar.setBounds(16, 266, 101, 23);
		contentPane.add(btnCadastrar);
		
		JButton btnAlterar = new JButton("Alterar Filme");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(jtFilme.getSelectedRow() != -1) {
					JFAtualizarFilme af = new JFAtualizarFilme((int)jtFilme.getValueAt(jtFilme.getSelectedRow(), 0));
					af.setVisible(true);
				} else {
					JOptionPane.showMessageDialog(null, "Selecione um filme!");
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
				if(jtFilme.getSelectedRow() != -1) {
					int opcao = JOptionPane.showConfirmDialog(null, "Deseja excluir o filme selecionado?"
							,"Exclusão", JOptionPane.YES_NO_OPTION); 
					if (opcao == 0) {
						FilmeDAO = new FilmeDAO();
						Filme f = new Filme();
						f.setIdFilme((int) jtFilme.getValueAt(jtFilme.getSelectedRow(), 0));
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
			DefaultTableModel modelo = (DefaultTableModel) jtFilme.getModel();
			modelo.setNumRows(0);
			FilmeDAO fdao = new FilmeDAO();
			for(Filme f : fdao.read()) {
				modelo.addRow(new Object[] {
					f.getIdFilme(),
					f.getTitulo(),
					f.getCategoria(),
					f.getTempo()
				});
			}
		}
	
}
