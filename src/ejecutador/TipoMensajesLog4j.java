package ejecutador;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.io.*;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;


public class TipoMensajesLog4j extends JFrame implements ActionListener {
	JLabel titulo;
	JButton boton;
	
	

	public TipoMensajesLog4j() {
		super("Ejemplo mensajes Log con Log4j");
		getContentPane().setLayout(new FlowLayout());
		titulo = new JLabel("Tipos de mensajes Log usando Logj4");
		boton = new JButton("Visualizar mensajes log");
		boton.addActionListener(this);
		add(titulo);
		add(boton);
		setSize(300, 250);
		setVisible(true);
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		BasicConfigurator.configure();
		Logger log = Logger.getLogger("Logger de Ejemplo");
		if(e.getSource() == boton) {
			try {
				log.trace("Mensaje log - trace");
				log.debug("Mensaje log - debug");
				log.info("Mensaje log - info");
				log.warn("Mensaje log - warn");
				log.error("Mensaje log - error");
				log.fatal("Mensaje log - fatal");
			}
			catch(Exception ex) {
				log.warn("Error: " + ex.getMessage());
			}
		}
	}
	
	public static void main(String [] args) {
		TipoMensajesLog4j ob = new TipoMensajesLog4j();
		ob.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}
