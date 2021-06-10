package IndexP;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

import Principal.GestionarDatos;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import java.awt.Color;

public class PanelIndexTablaGestion extends JPanel {
	private JTextField txtbuscar;
	private JTextField txtID;
	private JTextField txtNombre;
	private JTextField txtRol;
	private JTextField txtpass;
	private JTextField txtre2;
	private JTextField txtre1;
	private JTextField txtre3;
	private JLabel lblpregunta2;
	private JLabel lblpregunta1;
	private JLabel lblpregunta3;
	private JLabel lblRol;
	private JLabel lblPassword;
	private JLabel lblID;
	private ValidacionTXT  validartxtfiel;

	/**
	 * Create the panel.
	 */
	public PanelIndexTablaGestion(String Rol) {
		setBackground(new Color(255, 255, 255));
		setLayout(null);
		setBounds(100, 100, 944, 545);
		
		txtbuscar = new JTextField();
		validartxtfiel= new ValidacionTXT(txtbuscar, 40);
		txtbuscar.setFont(new Font("SansSerif", Font.PLAIN, 14));
		txtbuscar.setBounds(37, 74, 253, 24);
		add(txtbuscar);
		txtbuscar.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBackground(new Color(44, 201, 192));
		btnBuscar.setForeground(new Color(255, 255, 255));
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			if (!txtbuscar.getText().equals("")) {
				if(txtbuscar.getText().equals(GestionarDatos.getCorreoIniciado())) {
				lblID.setVisible(true);
				txtID.setVisible(true);
				txtID.setEditable(false);
				txtNombre.setEditable(true);
				lblRol.setVisible(true);
				txtRol.setVisible(true);
				txtRol.setEditable(false);
				lblPassword.setVisible(true);
				txtpass.setVisible(true);
				txtpass.setEditable(false);
				txtpass.setEnabled(true);
				lblsegundofactor.setVisible(true);
				cbsegundofactor.setVisible(true);
				cbsegundofactor.setEnabled(true);
				
				txtre1.setEditable(true);
				txtre2.setEditable(true);
				txtre3.setEditable(true);
				btnGuardarCambios.setEnabled(true);
				btnGuardarCambios.setVisible(true);
				}else {
					establecerRol(GestionarDatos.getRoliniciado());
				}
				GestionarDatos.buscarUsuario(txtbuscar.getText());
				establecerdatosBusqueda();
				
			}else {
				JOptionPane.showMessageDialog(null, "Debes ingresar un correo para continuar.","Información",JOptionPane.INFORMATION_MESSAGE);
			}
			
			
			
			}
		});
		btnBuscar.setFont(new Font("SansSerif", Font.BOLD, 16));
		btnBuscar.setBounds(300, 74, 99, 25);
		add(btnBuscar);
		
		JLabel lblInformacionRegistro = new JLabel("Cuando se encuentre el usuario buscado,los campos seran rellenados.");
		lblInformacionRegistro.setFont(new Font("SansSerif", Font.PLAIN, 14));
		lblInformacionRegistro.setBounds(36, 121, 450, 19);
		add(lblInformacionRegistro);
		
		lblID = new JLabel("ID Usuario");
		lblID.setFont(new Font("SansSerif", Font.PLAIN, 14));
		lblID.setBounds(37, 162, 77, 20);
		add(lblID);
		
		JLabel lblNombre = new JLabel("Nombre Usuario");
		lblNombre.setFont(new Font("SansSerif", Font.PLAIN, 14));
		lblNombre.setBounds(37, 227, 107, 20);
		add(lblNombre);
		
		lblRol = new JLabel("Rol Usuario");
		lblRol.setFont(new Font("SansSerif", Font.PLAIN, 14));
		lblRol.setBounds(37, 295, 73, 19);
		add(lblRol);
		
		lblPassword = new JLabel("Contrase\u00F1a Usuario");
		lblPassword.setFont(new Font("SansSerif", Font.PLAIN, 14));
		lblPassword.setBounds(37, 356, 126, 19);
		add(lblPassword);
		
		JLabel lblNewLabel_5 = new JLabel("Ingrese un correo registrado en el sistema.");
		lblNewLabel_5.setFont(new Font("SansSerif", Font.PLAIN, 17));
		lblNewLabel_5.setBounds(37, 40, 314, 23);
		add(lblNewLabel_5);
		
		txtID = new JTextField();
		txtID.setFont(new Font("SansSerif", Font.PLAIN, 14));
		txtID.setBounds(37, 184, 200, 24);
		add(txtID);
		txtID.setColumns(10);
		
		txtNombre = new JTextField();
		validartxtfiel= new ValidacionTXT(txtNombre, 49);
		txtNombre.setFont(new Font("SansSerif", Font.PLAIN, 14));
		txtNombre.setBounds(37, 246, 200, 24);
		add(txtNombre);
		txtNombre.setColumns(10);
		
		txtRol = new JTextField();
		validartxtfiel= new ValidacionTXT(txtRol, 10);
		txtRol.setFont(new Font("SansSerif", Font.PLAIN, 14));
		txtRol.setBounds(37, 314, 200, 24);
		add(txtRol);
		txtRol.setColumns(10);
		
		txtpass = new JTextField();
		txtpass.setFont(new Font("SansSerif", Font.PLAIN, 14));
		txtpass.setBounds(37, 377, 200, 24);
		add(txtpass);
		txtpass.setColumns(10);
		
		lblpregunta1 = new JLabel("");
		lblpregunta1.setFont(new Font("SansSerif", Font.PLAIN, 14));
		lblpregunta1.setBounds(279, 187, 357, 19);
		add(lblpregunta1);
		
		lblpregunta2 = new JLabel("");
		lblpregunta2.setFont(new Font("SansSerif", Font.PLAIN, 14));
		lblpregunta2.setBounds(279, 253, 357, 19);
		add(lblpregunta2);
		
		lblpregunta3 = new JLabel("");
		lblpregunta3.setFont(new Font("SansSerif", Font.PLAIN, 14));
		lblpregunta3.setBounds(279, 321, 357, 19);
		add(lblpregunta3);
		
		JLabel lblrespuesta1 = new JLabel("Respuesta:");
		lblrespuesta1.setFont(new Font("SansSerif", Font.PLAIN, 14));
		lblrespuesta1.setBounds(646, 162, 72, 19);
		add(lblrespuesta1);
		
		JLabel lblrespuesta2 = new JLabel("Respuesta:");
		lblrespuesta2.setFont(new Font("SansSerif", Font.PLAIN, 14));
		lblrespuesta2.setBounds(646, 227, 72, 19);
		add(lblrespuesta2);
		
		JLabel lblrespuesta3 = new JLabel("Respuesta:");
		lblrespuesta3.setFont(new Font("SansSerif", Font.PLAIN, 14));
		lblrespuesta3.setBounds(646, 294, 72, 19);
		add(lblrespuesta3);
		
		txtre2 = new JTextField();
		validartxtfiel= new ValidacionTXT(txtre2, 49);
		txtre2.setFont(new Font("SansSerif", Font.PLAIN, 14));
		txtre2.setBounds(646, 249, 200, 24);
		add(txtre2);
		txtre2.setColumns(10);
		
		txtre1 = new JTextField();
		validartxtfiel= new ValidacionTXT(txtre1, 49);
		txtre1.setFont(new Font("SansSerif", Font.PLAIN, 14));
		txtre1.setBounds(646, 183, 200, 24);
		add(txtre1);
		txtre1.setColumns(10);
		
		txtre3 = new JTextField();
		validartxtfiel= new ValidacionTXT(txtre3, 49);
		txtre3.setFont(new Font("SansSerif", Font.PLAIN, 14));
		txtre3.setBounds(646, 317, 200, 24);
		add(txtre3);
		txtre3.setColumns(10);
		btnGuardarCambios = new JButton("Guardar Cambios");
		btnGuardarCambios.setBackground(new Color(44, 201, 192));
		btnGuardarCambios.setForeground(new Color(255, 255, 255));
		btnGuardarCambios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			GestionarDatos.actualizardatosTabla(Integer.parseInt(txtID.getText()), txtNombre.getText(), txtRol.getText(), txtre1.getText(),txtre2.getText(),txtre3.getText(),cbsegundofactor.isSelected() );
			
			}
		});
		btnGuardarCambios.setFont(new Font("SansSerif", Font.BOLD, 16));
		btnGuardarCambios.setBounds(664, 463, 165, 41);
		add(btnGuardarCambios);
		
		lblsegundofactor = new JLabel("Segundo Factor");
		lblsegundofactor.setFont(new Font("SansSerif", Font.PLAIN, 14));
		lblsegundofactor.setBounds(37, 412, 126, 19);
		add(lblsegundofactor);
		
		cbsegundofactor = new JCheckBox("Activar");
		cbsegundofactor.setBackground(new Color(255, 255, 255));
		cbsegundofactor.setBounds(37, 435, 97, 23);
		add(cbsegundofactor);
		establecerRol(Rol);
	}
	
	private JButton btnGuardarCambios;
	private JLabel lblsegundofactor;
	private JCheckBox cbsegundofactor;
	private void establecerdatosBusqueda() {
		
		txtID.setText(GestionarDatos.getIDTabla());
		System.out.println(txtID.getText()+" ID");
		txtNombre.setText(GestionarDatos.getNombreTabla());
		txtRol.setText(GestionarDatos.getRolTabla());
		txtpass.setText(GestionarDatos.getPasswordTabla());
		txtre1.setText(GestionarDatos.getRespuesta1String());
		txtre2.setText(GestionarDatos.getRespuesta2String());
		txtre3.setText(GestionarDatos.getRespuesta3String());
		lblpregunta1.setText(GestionarDatos.getPregunta1String());
		lblpregunta2.setText(GestionarDatos.getPregunta2String());
		lblpregunta3.setText(GestionarDatos.getPregunta3String());
		cbsegundofactor.setSelected(GestionarDatos.isSegundoFTabla());
		
		
	}
	
	private void establecerRol(String rol) {
		 if(rol.equals("Admin")) {
			 txtID.setEditable(false);
			 txtpass.setEditable(false);
			 txtRol.setEditable(true);
			 
		 }else if (rol.equals("Normal")) {
			txtpass.setEnabled(false);
			txtpass.setVisible(false);
			lblPassword.setVisible(false);
			
			txtNombre.setEditable(false);
			txtRol.setEditable(false);
			txtre1.setEditable(false);
			txtre2.setEditable(false);
			txtre3.setEditable(false);
			
			txtID.setVisible(false);
			lblID.setVisible(false);
			btnGuardarCambios.setEnabled(false);
			btnGuardarCambios.setVisible(false);
			cbsegundofactor.setEnabled(false);
			cbsegundofactor.setVisible(false);
			lblsegundofactor.setVisible(false);
		} 
		
	}
	public JCheckBox getCbsegundofactor() {
		return cbsegundofactor;
	}
}
