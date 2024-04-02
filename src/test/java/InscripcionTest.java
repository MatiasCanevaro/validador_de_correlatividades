import domain.Alumno;
import domain.Inscripcion;
import domain.Materia;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class InscripcionTest {
    Materia algoritmos = new Materia();
    Materia discreta = new Materia();
    Materia paradigmas = new Materia();
    Materia disenio = new Materia();
    Alumno alumno1 = new Alumno();
    Inscripcion inscripcion1 = new Inscripcion(alumno1);

    @Before
    public void init() {
        this.inicializarMaterias();
    }

    private void inicializarMaterias(){
        paradigmas.agregarMateriasCorrelativas(algoritmos,discreta);
        disenio.agregarMateriasCorrelativas(algoritmos,discreta,paradigmas);
    }

    @Test
    public void alumno1ApruebaLaInscripcionDeAlgoritmos() {
        inscripcion1.agregarMateriasAInscribirse(algoritmos);

        assertTrue(algoritmos.getMateriasCorrelativas().isEmpty());
        assertTrue(inscripcion1.aprobada());
    }
    @Test
    public void alumno1ApruebaLaInscripcionDeParadigmas() {
        alumno1.agregarMateriasAprobadas(algoritmos,discreta);
        inscripcion1.agregarMateriasAInscribirse(paradigmas);

        assertFalse(paradigmas.getMateriasCorrelativas().isEmpty());
        assertTrue(inscripcion1.aprobada());
    }
    @Test
    public void alumno1DesapruebaLaInscripcionDeParadigmas() {
        alumno1.agregarMateriasAprobadas(algoritmos);//le falta discreta
        inscripcion1.agregarMateriasAInscribirse(paradigmas);

        assertFalse(paradigmas.getMateriasCorrelativas().isEmpty());
        assertFalse(inscripcion1.aprobada());
    }
    @Test
    public void alumno1ApruebaLaInscripcionDeDisenio() {
        alumno1.agregarMateriasAprobadas(algoritmos,discreta,paradigmas);
        inscripcion1.agregarMateriasAInscribirse(disenio);

        assertFalse(disenio.getMateriasCorrelativas().isEmpty());
        assertTrue(inscripcion1.aprobada());
    }
    @Test
    public void alumno1DesapruebaLaInscripcionDeDisenio() {
        alumno1.agregarMateriasAprobadas(discreta,paradigmas);//le falta algoritmos
        inscripcion1.agregarMateriasAInscribirse(disenio);

        assertFalse(disenio.getMateriasCorrelativas().isEmpty());
        assertFalse(inscripcion1.aprobada());
    }
    @Test
    public void alumno1ApruebaLaInscripcionDeTodasLasMaterias() {
        alumno1.agregarMateriasAprobadas(algoritmos,discreta,paradigmas);
        inscripcion1.agregarMateriasAInscribirse(algoritmos,discreta,paradigmas,disenio);

        assertTrue(inscripcion1.aprobada());
    }
}
