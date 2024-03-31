package domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Inscripcion {
    private LocalDate fechaInscripcion;
    private Alumno alumno;
    private List<Materia> materiasAInscribirse;

    public Inscripcion(Alumno alumno) {
        this.alumno = alumno;
        this.materiasAInscribirse = new ArrayList<>();
    }

    public void agregarMateriasAInscribirse(Materia ... materias) {
        Collections.addAll(this.materiasAInscribirse,materias);
    }

    public Boolean aprobada(){
        return materiasAInscribirse.stream().allMatch(m -> alumno.aproboLasCorrelativas(m));
    }
}
