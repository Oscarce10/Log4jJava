package ejecutador2;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.io.*;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.Logger;


public class LoggerArchivo extends JFrame implements ActionListener{
	private JLabel titulo, lblbase, lblexponente;
	private JTextField txtbase, txtexponente, info;
	private double base, exponente, resultado;
	private JButton boton;
	private static final Logger log = Logger.getLogger("LoggerArchivo.class");
	public LoggerArchivo() {
		// TODO Auto-generated constructor stub
		super("Ejemplo Logger enviados a un archivo");
		titulo = new JLabel("Ejemplo Logger enviados a un archivo");
		lblbase = new JLabel("Ingrese base");
		lblexponente = new JLabel("Ingrese exponente");
		txtbase = new JTextField(20);
		txtexponente = new JTextField(20);
		info = new JTextField(20);
		base = exponente = resultado = 0;
		boton = new JButton("Obtener potencia");
		boton.addActionListener(this);
		getContentPane().setLayout(new FlowLayout());
		add(titulo);
		add(lblbase);
		add(txtbase);
		add(lblexponente);
		add(txtexponente);
		add(boton);
		add(info);
		setSize(280, 280);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		PropertyConfigurator.configure("log4j2.properties");
		if(e.getSource() == boton) {
			log.info("Potencia de dos numeros");
			try {
				base = Double.parseDouble(txtbase.getText());
				exponente = Double.parseDouble(txtexponente.getText());
				resultado = Math.pow(base, exponente);
				log.debug("La base es: " + base);
				log.debug("El exponente es: " + exponente);
				log.debug("La potencia de los dos numeros es: " + resultado);
				log.debug("Operacion potencia realizada");
				info.setText("Log's enviados al archivo prueba.log");
			}
			catch(Exception ex) {
				log.error("Error: " + ex);
			}
		}
	}
	
	public static void main (String [] args) {
		LoggerArchivo ob = new LoggerArchivo();
		ob.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
