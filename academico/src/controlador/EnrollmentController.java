package controlador;

import modelo.Enrollment;
import vista.ViewEnrollment;

import java.util.List;

public class EnrollmentController {
    private ViewEnrollment view;

    public EnrollmentController(ViewEnrollment view) {
        this.view = view;
    }

    // Metodo para insertar una nueva matrícula
    public void insertNewEnrollment(Enrollment newEnrollment) {
        Enrollment.insertEnrollment(newEnrollment);
        view.mostrarMensaje("\n¡Matrícula guardada correctamente!");
    }

    // Metodo para mostrar todas las matrículas
    public void displayAllEnrollments() {
        List<Enrollment> enrollments = Enrollment.getAllEnrollments();
        view.displayListEnrollments(enrollments);
    }

}
