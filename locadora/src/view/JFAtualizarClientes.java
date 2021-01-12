package view;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import model.bean.Cliente;
import model.bean.Filme;
import model.dao.ClienteDAO;
import model.dao.FilmeDAO;


public class JFAtualizarClientes extends JFrame {
	
	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtEndereco;

	private static int id;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFAtualizarClientes frame = new JFAtualizarClientes(id);
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
	public JFAtualizarClientes(int id) {
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
		
		ClienteDAO fdao = new ClienteDAO();
		Cliente f = fdao.read(id);
		
		JLabel lblNewLabel_4 = new JLabel("ID do Cliente");
		lblNewLabel_4.setBounds(353, 66, 71, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblId = new JLabel("New label");
		lblId.setBounds(363, 81, 46, 14);
		contentPane.add(lblId);
		
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
		
		lblId.setText(String.valueOf(f.getIdCliente()));
		txtNome.setText(f.getNome());
		txtEndereco.setText(f.getEndereco());
		if (f.isSexo() == true) {
			rdbtnMasculino.setSelected(true);
		} else if(f.isSexo() == false) {
			rdbtnFeminino.setSelected(true);
		}
		
		
			
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
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					Cliente f = new Cliente();
					ClienteDAO dao = new ClienteDAO();
					f.setIdCliente(Integer.parseInt(lblId.getText()));
					f.setNome(txtNome.getText());
					f.setEndereco(txtEndereco.getText());
						if (rdbtnMasculino.isSelected()) {
							f.setSexo(false);
						} else if (rdbtnFeminino.isSelected()) {
							f.setSexo(true);
						}
						dao.update(f);
								
			}
			
		});
		btnAlterar.setBackground(Color.GREEN);
		btnAlterar.setFont(new Font("Tw Cen MT", Font.PLAIN, 13));
		btnAlterar.setBounds(198, 208, 89, 23);
		contentPane.add(btnAlterar);
		
		
				
	}
	}