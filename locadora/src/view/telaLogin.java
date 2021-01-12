package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.DropMode;
import java.awt.Dimension;
import java.awt.Component;
import java.awt.Rectangle;
import java.awt.Cursor;
import java.awt.ComponentOrientation;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class telaLogin extends JFrame {

	private JPanel contentPane;
	private JTextField digitar_usuario;
	private JPasswordField digitar_senha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					telaLogin frame = new telaLogin();
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
	public telaLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 483, 344);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 204));
		contentPane.setForeground(new Color(222, 184, 135));
		contentPane.setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel hello = new JLabel("BEM VINDO!");
		hello.setBounds(5, 5, 457, 41);
		hello.setBackground(Color.LIGHT_GRAY);
		hello.setFont(new Font("Mistral", Font.PLAIN, 40));
		hello.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(hello);
		
		JLabel usuario = new JLabel("Usu\u00E1rio:");
		usuario.setBounds(15, 59, 93, 246);
		usuario.setVerticalAlignment(SwingConstants.TOP);
		usuario.setHorizontalAlignment(SwingConstants.CENTER);
		usuario.setFont(new Font("Gabriola", Font.PLAIN, 35));
		contentPane.add(usuario);
		
		digitar_usuario = new JTextField();
		digitar_usuario.setFont(new Font("Tahoma", Font.PLAIN, 15));
		digitar_usuario.setBounds(118, 78, 199, 25);
		contentPane.add(digitar_usuario);
		digitar_usuario.setColumns(10);
		
		JLabel senha = new JLabel("Senha:");
		senha.setFont(new Font("Gabriola", Font.PLAIN, 35));
		senha.setBounds(15, 124, 93, 25);
		contentPane.add(senha);
		
		digitar_senha = new JPasswordField();
		digitar_senha.setFont(new Font("Tahoma", Font.PLAIN, 15));
		digitar_senha.setBounds(118, 127, 199, 25);
		contentPane.add(digitar_senha);
		
		JButton acessar_sistema = new JButton("Acessar");
		acessar_sistema.setForeground(new Color(0, 128, 0));
		acessar_sistema.setBackground(Color.GREEN);
		acessar_sistema.setFont(new Font("Sitka Text", Font.PLAIN, 25));
		acessar_sistema.setBounds(42, 203, 121, 41);
		contentPane.add(acessar_sistema);
		
		JButton limpar_dados = new JButton("Limpar");
		limpar_dados.setForeground(new Color(255, 0, 0));
		limpar_dados.setBackground(new Color(255, 69, 0));
		limpar_dados.setFont(new Font("Sitka Display", Font.PLAIN, 25));
		limpar_dados.setBounds(213, 203, 121, 41);
		contentPane.add(limpar_dados);
	}
}
