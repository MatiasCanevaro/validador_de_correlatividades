package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Materia {
    private String nombre;
    private List<Materia> materiasCorrelativas;

    public Materia() {
        this.materiasCorrelativas = new ArrayList<>();
    }

    public void agregarMateriasCorrelativas(Materia ... materias) {
        Collections.addAll(this.materiasCorrelativas,materias);
    }

    public List<Materia> getMateriasCorrelativas() {
        return this.materiasCorrelativas;
    }
}
