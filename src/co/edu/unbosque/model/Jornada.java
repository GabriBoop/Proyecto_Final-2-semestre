package co.edu.unbosque.model;

import java.time.LocalTime;

/**
 * Enumeración que define las jornadas del parqueadero.
 * La jornada diurna va de las 7:00 a las 21:00 y la nocturna el resto del día.
 */
public enum Jornada {
	
    DIURNA, NOCTURNA;

    private static final LocalTime INICIO_DIURNA = LocalTime.of(7, 0);
    private static final LocalTime INICIO_NOCTURNA = LocalTime.of(21, 0);

    /**
     * Determina la jornada a la que pertenece una hora del día.
     *
     * @param hora Hora a evaluar.
     * @return DIURNA si la hora está entre las 7:00 (inclusive) y las 21:00 (exclusive); NOCTURNA en otro caso.
     */
    public static Jornada de(LocalTime hora) {
        boolean diurna = !hora.isBefore(INICIO_DIURNA) && hora.isBefore(INICIO_NOCTURNA);
        if(diurna) return DIURNA;
        else return NOCTURNA;
    }
}