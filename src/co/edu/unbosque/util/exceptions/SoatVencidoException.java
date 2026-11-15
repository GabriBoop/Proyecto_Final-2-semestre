package co.edu.unbosque.util.exceptions;

public class SoatVencidoException extends Exception {
    public SoatVencidoException() {
        super("El SOAT está vencido. La fecha de vencimiento debe ser posterior a hoy.");
    }
}