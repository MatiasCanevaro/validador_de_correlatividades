import domain.Alumno;
import domain.Inscripcion;
import domain.Materia;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class InscripcionTest {
    Materia algoritmos = new Materia();
    Materia discreta = new Materia();
    Materia paradigmas = new Materia();
    Materia disenio = new Materia();
    Alumno alumno1 = new Alumno();
    Inscripcion inscripcion1 = new Inscripcion(alumno1);

    @Test
    public void alumno1ApruebaLaInscripcionDeAlgoritmos() {
        inscripcion1.agregarMateriasAInscribirse(algoritmos);

        assertTrue(algoritmos.getMateriasCorrelativas().isEmpty());
        assertTrue(inscripcion1.aprobada());
    }
    @Test
    public void alumno1ApruebaLaInscripcionDeParadigmas() {
        paradigmas.agregarMateriasCorrelativas(algoritmos,discreta);
        alumno1.agregarMateriasAprobadas(algoritmos,discreta);
        inscripcion1.agregarMateriasAInscribirse(paradigmas);

        assertFalse(paradigmas.getMateriasCorrelativas().isEmpty());
        assertTrue(inscripcion1.aprobada());
    }
    @Test
    public void alumno1DesapruebaLaInscripcionDeParadigmas() {
        paradigmas.agregarMateriasCorrelativas(algoritmos,discreta);
        alumno1.agregarMateriasAprobadas(algoritmos);//le falta discreta
        inscripcion1.agregarMateriasAInscribirse(paradigmas);

        assertFalse(paradigmas.getMateriasCorrelativas().isEmpty());
        assertFalse(inscripcion1.aprobada());
    }
    @Test
    public void alumno1ApruebaLaInscripcionDeDisenio() {
        disenio.agregarMateriasCorrelativas(algoritmos,discreta,paradigmas);
        alumno1.agregarMateriasAprobadas(algoritmos,discreta,paradigmas);
        inscripcion1.agregarMateriasAInscribirse(disenio);

        assertFalse(disenio.getMateriasCorrelativas().isEmpty());
        assertTrue(inscripcion1.aprobada());
    }
    @Test
    public void alumno1DesapruebaLaInscripcionDeDisenio() {
        disenio.agregarMateriasCorrelativas(algoritmos,discreta,paradigmas);
        alumno1.agregarMateriasAprobadas(discreta,paradigmas);//le falta algoritmos
        inscripcion1.agregarMateriasAInscribirse(disenio);

        assertFalse(disenio.getMateriasCorrelativas().isEmpty());
        assertFalse(inscripcion1.aprobada());
    }
    @Test
    public void alumno1ApruebaLaInscripcionDeTodasLasMaterias() {
        disenio.agregarMateriasCorrelativas(algoritmos,discreta,paradigmas);
        alumno1.agregarMateriasAprobadas(algoritmos,discreta,paradigmas);
        inscripcion1.agregarMateriasAInscribirse(algoritmos,discreta,paradigmas,disenio);

        assertTrue(inscripcion1.aprobada());
    }
}
