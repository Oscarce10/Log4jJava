package ejecutador;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.io.*;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

public class LoggerConClase extends JFrame implements ActionListener {
	JLabel titulo, lblnum1, lblnum2;
	JTextField txtnum1, txtnum2;
	JButton boton;
	static final Logger log = Logger.getLogger("LoggerConClase.class");
	
		
	public LoggerConClase(){
		super("Ejemplo Logger con clase propia");
		getContentPane().setLayout(new FlowLayout());
		titulo = new JLabel("Ejemplo de una clase con su propia Logger");
		lblnum1 = new JLabel("Ingrese primer numero");
		lblnum2 = new JLabel("Ingrese segundo numero");
		txtnum1 = new JTextField(20);
		txtnum2 = new JTextField(20);
		boton = new JButton("Visualizar mensajes log");
		boton.addActionListener(this);
		add(titulo);
		add(lblnum1);
		add(txtnum1);
		add(lblnum2);
		add(txtnum2);
		add(boton);
		setSize(300, 280);
		setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LoggerConClase ob = new LoggerConClase();
		ob.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e){
		BasicConfigurator.configure();
		if(e.getSource() == boton) {
			try {
				log.info("Producto de dos numeros con Logger");
				int d1 = Integer.parseInt(txtnum1.getText());
				int d2 = Integer.parseInt(txtnum2.getText());
				log.debug("Primer numero capturado: " + d1);
				log.debug("Segundo numero capturado: " + d2);
				log.debug("El producto de " + d1 + " * " + d2 + " es igual a " + (d1*d2));
				log.info("Mensaje de producto realizado");
			}
			catch(Exception ex) {
				log.warn("Error: " + ex.getMessage());
			}
		}
		
	}

}
