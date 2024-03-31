import domain.Alumno;
import domain.Materia;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AlumnoTest {
    Materia algoritmos = new Materia();
    Materia discreta = new Materia();
    Materia paradigmas = new Materia();
    Materia disenio = new Materia();
    Alumno alumno1 = new Alumno();

    @Test
    public void alumno1ApruebaLasCorrelativasParaAlgoritmos() {
        paradigmas.agregarMateriasCorrelativas(algoritmos,discreta);
        alumno1.agregarMateriasAprobadas(algoritmos,discreta);

        assertTrue(algoritmos.getMateriasCorrelativas().isEmpty());
        assertTrue(alumno1.aproboLasCorrelativas(algoritmos));
    }
    @Test
    public void alumno1ApruebaLasCorrelativasParaParadigmas() {
        paradigmas.agregarMateriasCorrelativas(algoritmos,discreta);
        alumno1.agregarMateriasAprobadas(algoritmos,discreta);

        assertFalse(paradigmas.getMateriasCorrelativas().isEmpty());
        assertTrue(alumno1.aproboLasCorrelativas(paradigmas));
    }
    @Test
    public void alumno1DesapruebaLasCorrelativasParaDisenio() {
        disenio.agregarMateriasCorrelativas(algoritmos,discreta,paradigmas);
        alumno1.agregarMateriasAprobadas(algoritmos,discreta);

        assertFalse(alumno1.aproboLasCorrelativas(disenio));
    }
}
