package co.edu.unbosque.model;

import java.time.LocalTime;

public enum Jornada {
	
    DIURNA, NOCTURNA;

    private static final LocalTime INICIO_DIURNA = LocalTime.of(7, 0);
    private static final LocalTime INICIO_NOCTURNA = LocalTime.of(21, 0);

    public static Jornada de(LocalTime hora) {
        boolean diurna = !hora.isBefore(INICIO_DIURNA) && hora.isBefore(INICIO_NOCTURNA);
        if(diurna) return DIURNA;
        else return NOCTURNA;
    }
}