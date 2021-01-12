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

import model.bean.Filme;
import model.dao.FilmeDAO;


public class JFAtualizarFilme extends JFrame {
	
	private JPanel contentPane;
	private JTextField txtTitulo;
	private JTextField txtCategoria;

	private static int id;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFAtualizarFilme frame = new JFAtualizarFilme(id);
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
	public JFAtualizarFilme(int id) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 497, 344);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	
	JLabel lblNewLabel = new JLabel("Editar Filmes");
	lblNewLabel.setFont(new Font("Ebrima", Font.ITALIC, 25));
	lblNewLabel.setForeground(Color.BLACK);
	lblNewLabel.setBackground(Color.GRAY);
	lblNewLabel.setBounds(135, 2, 157, 54);
	contentPane.add(lblNewLabel);
	
	JLabel lblNewLabel_1 = new JLabel("Titulo:");
	lblNewLabel_1.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
	lblNewLabel_1.setBounds(28, 67, 46, 14);
	contentPane.add(lblNewLabel_1);
	
	FilmeDAO fdao = new FilmeDAO();
	Filme f = fdao.read(id);
	
	JLabel lblNewLabel_4 = new JLabel("ID do Filme");
	lblNewLabel_4.setBounds(374, 39, 71, 14);
	contentPane.add(lblNewLabel_4);
	
	JLabel lblId = new JLabel("New label");
	lblId.setBounds(384, 55, 46, 14);
	contentPane.add(lblId);
	
	txtTitulo = new JTextField();
	txtTitulo.setBounds(99, 67, 249, 20);
	contentPane.add(txtTitulo);
	txtTitulo.setColumns(10);
	
	JLabel lblNewLabel_2 = new JLabel("Sinopse:");
	lblNewLabel_2.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
	lblNewLabel_2.setBounds(28, 101, 65, 20);
	contentPane.add(lblNewLabel_2);
	
	JTextArea textArea = new JTextArea();
	textArea.setBounds(326, 116, -223, 53);
	contentPane.add(textArea);
	
	JScrollPane scrollPane = new JScrollPane();
	scrollPane.setBounds(99, 154, 249, -53);
	contentPane.add(scrollPane);
	
	JScrollPane scrollPane_1 = new JScrollPane();
	scrollPane_1.setBounds(99, 98, 249, 54);
	contentPane.add(scrollPane_1);
	
	JTextArea txtSinopse = new JTextArea();
	scrollPane_1.setViewportView(txtSinopse);

	
	JLabel lblNewLabel_3 = new JLabel("Categoria:");
	lblNewLabel_3.setFont(new Font("Tw Cen MT", Font.PLAIN, 18));
	lblNewLabel_3.setBounds(26, 167, 93, 20);
	contentPane.add(lblNewLabel_3);
	
	txtCategoria = new JTextField();
	txtCategoria.setBounds(109, 167, 239, 20);
	contentPane.add(txtCategoria);
	txtCategoria.setColumns(10);
	
	JLabel lblTempo = new JLabel("Tempo:\r\n");
	lblTempo.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
	lblTempo.setBounds(28, 194, 65, 23);
	contentPane.add(lblTempo);
	
	JSpinner spTempo = new JSpinner();
	spTempo.setBounds(28, 228, 46, 37);
	contentPane.add(spTempo);
	
	JLabel lblImagem = new JLabel("Imagem\r\n");
	lblImagem.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
	lblImagem.setBounds(115, 188, 74, 35);
	contentPane.add(lblImagem);
	
	JRadioButton rdbtn2d = new JRadioButton("2D\r\n");
	rdbtn2d.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
	rdbtn2d.setBounds(115, 228, 65, 23);
	contentPane.add(rdbtn2d);
	
	JRadioButton rdbtn3d = new JRadioButton("3D\r\n");
	rdbtn3d.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
	rdbtn3d.setBounds(115, 254, 59, 30);
	contentPane.add(rdbtn3d);
	
	ButtonGroup imagem = new ButtonGroup();
	imagem.add(rdbtn2d);
	imagem.add(rdbtn3d);
	
	JLabel lblAudio = new JLabel("\u00C1udio");
	lblAudio.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
	lblAudio.setBounds(212, 196, 59, 19);
	contentPane.add(lblAudio);
	
	JRadioButton rdbtnDublado = new JRadioButton("Dublado");
	rdbtnDublado.setFont(new Font("Tw Cen MT", Font.PLAIN, 18));
	rdbtnDublado.setBounds(199, 228, 93, 23);
	contentPane.add(rdbtnDublado);
	
	JRadioButton rdbtnLegendado = new JRadioButton("Legendado");
	rdbtnLegendado.setFont(new Font("Tw Cen MT", Font.PLAIN, 18));
	rdbtnLegendado.setBounds(199, 259, 109, 23);
	contentPane.add(rdbtnLegendado);
	
	ButtonGroup audio = new ButtonGroup();
	audio.add(rdbtnDublado);
	audio.add(rdbtnLegendado);
	
	lblId.setText(String.valueOf(f.getIdFilme()));
	txtTitulo.setText(f.getTitulo());
	txtSinopse.setText(f.getSinopse());
	txtCategoria.setText(f.getCategoria());
	spTempo.setValue(f.getTempo());
	if (f.isImagem3d() == true) {
		rdbtn3d.setSelected(true);
	} else if(f.isImagem3d() == false) {
		rdbtn2d.setSelected(true);
	}
	if (f.isDublado() == true) {
		rdbtnDublado.setSelected(true);		
	} else if(f.isDublado() == false) {
		rdbtnLegendado.setSelected(true);
	}
	
	JButton btnAlterar = new JButton("Alterar");
	btnAlterar.addActionListener(new ActionListener() {

		public void actionPerformed(ActionEvent e) {
			Filme f = new Filme();
			FilmeDAO dao = new FilmeDAO();	
			
			f.setIdFilme(Integer.parseInt(lblId.getText()));
			f.setTitulo(txtTitulo.getText());
			f.setSinopse(txtSinopse.getText());
			f.setCategoria(txtCategoria.getText());
			f.setTempo(Integer.parseInt(spTempo.getValue().toString()));
			if (rdbtn2d.isSelected()) {
				f.setImagem3d(false);
			} else if (rdbtn3d.isSelected()) {
				f.setImagem3d(true);
			}
			if (rdbtnDublado.isSelected()) {
				f.setDublado(true);
			} else if (rdbtnLegendado.isSelected()) {
				f.setDublado(false);
			}
			dao.update(f);
		
			
		}
	});
	btnAlterar.setBackground(Color.GREEN);
	btnAlterar.setForeground(Color.WHITE);
	btnAlterar.setFont(new Font("Tw Cen MT", Font.PLAIN, 14));
	btnAlterar.setBounds(352, 214, 93, 23);
	contentPane.add(btnAlterar);
	
	
	JButton btnLimpar = new JButton("Limpar");
	btnLimpar.setFont(new Font("Tw Cen MT", Font.PLAIN, 14));
	btnLimpar.setBackground(Color.ORANGE);
	btnLimpar.setForeground(Color.WHITE);
	btnLimpar.setBounds(352, 242, 93, 23);
	contentPane.add(btnLimpar);
	
	JButton btnCancelar = new JButton("Cancelar\r\n");
	btnCancelar.setFont(new Font("Tw Cen MT", Font.PLAIN, 14));
	btnCancelar.setForeground(Color.WHITE);
	btnCancelar.setBackground(Color.RED);
	btnCancelar.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
		}
	});
	btnCancelar.setBounds(352, 271, 93, 23);
	contentPane.add(btnCancelar);
	
}
}

