package ejecutador;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.Logger;

public class LoggerConPropiedades extends JFrame implements ActionListener {
	
	JLabel titulo, lblnumerador, lbldenominador;
	JTextField txtnum1, txtnum2;
	JButton boton;
	private static final Logger log = Logger.getLogger("LoggerConPropiedades.class");
	

	public LoggerConPropiedades() {
		// TODO Auto-generated constructor stub
		super("Ejemplo Logger con propiedades");
		titulo = new JLabel("Ejemplo logger con propiedades especificas");
		lblnumerador = new JLabel("Inserte numerador");
		lbldenominador = new JLabel("Inserte denominador");
		txtnum1 = new JTextField(10);
		txtnum2 = new JTextField(10);
		boton = new JButton("Ejecutar");
		boton.addActionListener(this);
		getContentPane().setLayout(new FlowLayout());
		add(titulo);
		add(lblnumerador);
		add(txtnum1);
		add(lbldenominador);
		add(txtnum2);
		add(boton);
		setSize(300, 280);
		setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LoggerConPropiedades ob = new LoggerConPropiedades();
		ob.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		PropertyConfigurator.configure("log4j.properties");
		if(e.getSource() == boton) {
			log.info("Division de dos numeros");
			try {
				int num, denom, res;
				num = Integer.parseInt(txtnum1.getText());
				denom = Integer.parseInt(txtnum2.getText());
				if(denom==0) {
					throw new ArithmeticException();
				}
				res = num/denom;
				log.debug("El numerador es: " + num);
				log.debug("El denominador es: " + denom);
				log.debug("La divison de " + num + " entre " + denom + " es igual a " + res);
				log.info("Divion realizada");
			}
			catch(Exception ex) {
				log.fatal("Error: " + ex);
			}
		}
	}

}
