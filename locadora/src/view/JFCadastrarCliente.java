package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.JTextComponent;

import model.bean.Cliente;
import model.bean.Filme;
import model.dao.ClienteDAO;
import model.dao.FilmeDAO;

import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionEvent;

import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JRadioButton;
import javax.swing.AbstractButton;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;

public class JFCadastrarCliente extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextComponent txtEndereco;
	private AbstractButton rdbtnMasculino;
	private AbstractButton rdbtnFeminino;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFCadastrarCliente frame = new JFCadastrarCliente();
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
	public JFCadastrarCliente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Cadastro de Clientes\r\n");
		lblNewLabel.setFont(new Font("Gill Sans MT", Font.BOLD, 25));
		lblNewLabel.setBounds(76, 11, 247, 32);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nome:");
		lblNewLabel_1.setFont(new Font("Tw Cen MT", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(45, 66, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		txtNome = new JTextField();
		txtNome.setBounds(112, 65, 231, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Endereco:");
		lblNewLabel_2.setFont(new Font("Tw Cen MT", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(36, 112, 81, 14);
		contentPane.add(lblNewLabel_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(112, 112, 231, 60);
		contentPane.add(scrollPane);
		
		JTextArea txtEndereco = new JTextArea();
		scrollPane.setViewportView(txtEndereco);
		
		JLabel lblNewLabel_3 = new JLabel("Sexo:");
		lblNewLabel_3.setFont(new Font("Tw Cen MT", Font.PLAIN, 18));
		lblNewLabel_3.setBounds(36, 210, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		JRadioButton rdbtnMasculino = new JRadioButton("Masculino");
		rdbtnMasculino.setFont(new Font("Tw Cen MT", Font.PLAIN, 15));
		rdbtnMasculino.setBounds(83, 201, 109, 23);
		contentPane.add(rdbtnMasculino);
		
		JRadioButton rdbtnFeminino = new JRadioButton("Feminino\r\n");
		rdbtnFeminino.setFont(new Font("Tw Cen MT", Font.PLAIN, 15));
		rdbtnFeminino.setBounds(83, 231, 109, 23);
		contentPane.add(rdbtnFeminino);
			
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Tw Cen MT", Font.PLAIN, 13));
		btnCancelar.setBackground(Color.RED);
		btnCancelar.setBounds(296, 208, 89, 23);
		contentPane.add(btnCancelar);
			
		JButton btnLimpar = new JButton("Limpar\r\n");
		btnLimpar.setBackground(Color.ORANGE);
		btnLimpar.setFont(new Font("Tw Cen MT", Font.PLAIN, 13));
		btnLimpar.setBounds(250, 238, 89, 23);
		contentPane.add(btnLimpar);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					Cliente f = new Cliente();
					ClienteDAO dao = new ClienteDAO();		
					f.setNome(txtNome.getText());
					f.setEndereco(txtEndereco.getText());
						if (rdbtnMasculino.isSelected()) {
							f.setSexo(false);
						} else if (rdbtnFeminino.isSelected()) {
							f.setSexo(true);
						}
						dao.create(f);
								
			}
			
		});
		btnCadastrar.setBackground(Color.GREEN);
		btnCadastrar.setFont(new Font("Tw Cen MT", Font.PLAIN, 13));
		btnCadastrar.setBounds(198, 208, 89, 23);
		contentPane.add(btnCadastrar);
				
	}
	}