package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Alumno {
    private String nombre;
    private String apellido;
    private String legajo;
    private List<Materia> materiasAprobadas;

    public Alumno() {
        this.materiasAprobadas = new ArrayList<>();
    }

    public List<Materia> getMateriasAprobadas() {
        return this.materiasAprobadas;
    }

    public void agregarMateriasAprobadas(Materia ... materias) {
        Collections.addAll(this.materiasAprobadas,materias);
    }

    public Boolean aproboLasCorrelativas(Materia materia){
        return materiasAprobadas.containsAll(materia.getMateriasCorrelativas());
    }
}
