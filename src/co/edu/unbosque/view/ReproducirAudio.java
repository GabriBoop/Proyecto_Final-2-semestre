package co.edu.unbosque.view;

import javax.sound.sampled.*;
import java.net.URL;
/**
 * Clase para la reproducción y control de audio del sistema.
 * Gestiona la música de fondo y los efectos de sonido de forma estática,
 * permitiendo reproducir y detener audios desde cualquier parte del código.
 * Los archivos se buscan en la carpeta de recursos {@code /co/edu/unbosque/sounds/}.
 */
public class ReproducirAudio {

    // Guardamos el clip de manera estática para poder controlarlo desde cualquier método
    private static Clip clip;
    private static final String RUTA = "/co/edu/unbosque/sounds/";
    
    /**
     * Reproduce un archivo de audio como música de fondo.
     * Si ya hay una pista sonando, la detiene y libera antes de reproducir la nueva.
     * El audio se inicia en segundo plano sin bloquear el hilo principal.
     *
     * @param nombreArchivo Nombre del archivo de audio dentro de la carpeta de sonidos del classpath.
     */
    public static void reproducir(String nombreArchivo) {
        try {
            // Si ya hay algo sonando, lo detenemos antes de reproducir el siguiente
            detener();

            URL url = ReproducirAudio.class.getResource(RUTA + nombreArchivo);
            
            if (url == null) {
                System.out.println("No se encontró el archivo: " + nombreArchivo);
                return;
            }

            AudioInputStream audioStream = AudioSystem.getAudioInputStream(url);
            clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start(); // Suena directo en segundo plano

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    /**
     * Reproduce un efecto de sonido corto de forma independiente a la música de fondo.
     * Cada llamada crea un clip separado para no interferir con la música principal.
     *
     * @param nombreArchivo Nombre del archivo de audio dentro de la carpeta de sonidos del classpath.
     */
    public static void reproducirSFX(String nombreArchivo) {
        try {
            URL url = ReproducirAudio.class.getResource(RUTA + nombreArchivo);
            
            if (url == null) {
                System.out.println("No se encontró el archivo de efecto: " + nombreArchivo);
                return;
            }

            AudioInputStream audioStream = AudioSystem.getAudioInputStream(url);
            Clip clipEfecto = AudioSystem.getClip();
            clipEfecto.open(audioStream);
            clipEfecto.start();

        } catch (Exception e) {
            System.out.println("Error al reproducir efecto: " + e.getMessage());
        }
    }

    
    /**
     * Detiene y libera el clip de música de fondo que se está reproduciendo.
     */
    public static void detener() {
        try {
            if (clip != null && clip.isRunning()) {
                clip.stop();  // Detiene la reproducción
                clip.close(); // Libera la memoria del archivo de audio
            }
        } catch (Exception e) {
            System.out.println("Error al detener el audio: " + e.getMessage());
        }
    }

    /**
     * Método de prueba que reproduce el efecto de sonido {@code Click.wav}.
     *
     * @param args Argumentos de línea de comandos (no se utilizan).
     */
    public static void main(String[] args) {	        
    	reproducirSFX("Click.wav");        	      
    }
}