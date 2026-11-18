package co.edu.unbosque.view;
import java.awt.BorderLayout;
import java.awt.Color;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
/**
 * Ventana principal del sistema del parqueadero UEB.
 * Actúa como contenedor de todos los paneles de la aplicación y permite
 * cambiar entre ellos para navegar por los menús y formularios.
 * La ventana se abre maximizada y centrada en pantalla.
 */
public class MainFrame extends JFrame{ 
	
	private static final long serialVersionUID = 2954269221207709216L;
	private static final int ANCHO = 800; //Dimensiones de Pantalla
	private static final int ALTO = 600;
	
	/**
	 * Constructor de la clase MainFrame. Configura el icono, el tamaño, el título,
	 * el diseño, el color de fondo y la operación de cierre de la ventana, y la abre maximizada.
	 */
	public MainFrame() {
	
		URL url = getClass().getResource("/co/edu/unbosque/images/icon.png");
		if (url != null) {
			setIconImage(new ImageIcon(url).getImage());
		}
		setBounds(0, 0, ANCHO, ALTO);
		
		setTitle("PARQUEADERO UEB: MENU");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		setBackground(new Color(15,0,50));
		setLocationRelativeTo(null); // Asegura que siempre salga en el cemtro de la pantalla del computador
		setExtendedState(JFrame.MAXIMIZED_BOTH);
	}
	 /**
	  * Reemplaza el panel actualmente visible en la ventana por uno nuevo.
	  * Elimina el contenido anterior, agrega el nuevo panel al centro y repinta la ventana.
	  *
	  * @param panel Panel que se desea mostrar en pantalla.
	  */
	 public void cambiarPanel(JPanel panel) {//Cambio de pameñ (EJ: Config a Juego)
	        getContentPane().removeAll();
	        getContentPane().add(panel, BorderLayout.CENTER);
	        revalidate(); //Revalida todo lo del Frame y no se gemerem errpres visuales
	        repaint();
	    }
	
	 /**
	  * Establece el título de la ventana.
	  *
	  * @param txt Nuevo título.
	  */
	 public void setTitulo(String txt) {
		    this.setTitle(txt); 
		}

	
		
}