import domain.Alumno;
import domain.Materia;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class AlumnoTest {
    Materia algoritmos = new Materia();
    Materia discreta = new Materia();
    Materia paradigmas = new Materia();
    Materia disenio = new Materia();
    Alumno alumno1 = new Alumno();

    @Before
    public void init() {
        this.inicializarAlumnos();
        this.inicializarMaterias();
    }

    private void inicializarAlumnos(){
        alumno1.agregarMateriasAprobadas(algoritmos,discreta);
    }

    private void inicializarMaterias(){
        paradigmas.agregarMateriasCorrelativas(algoritmos,discreta);
        disenio.agregarMateriasCorrelativas(algoritmos,discreta,paradigmas);
    }

    @Test
    public void alumno1ApruebaLasCorrelativasParaAlgoritmos() {
        assertTrue(algoritmos.getMateriasCorrelativas().isEmpty());
        assertTrue(alumno1.aproboLasCorrelativas(algoritmos));
    }
    @Test
    public void alumno1ApruebaLasCorrelativasParaParadigmas() {
        assertFalse(paradigmas.getMateriasCorrelativas().isEmpty());
        assertTrue(alumno1.aproboLasCorrelativas(paradigmas));
    }
    @Test
    public void alumno1DesapruebaLasCorrelativasParaDisenio() {
        assertFalse(disenio.getMateriasCorrelativas().isEmpty());
        assertFalse(alumno1.aproboLasCorrelativas(disenio));
    }
}
