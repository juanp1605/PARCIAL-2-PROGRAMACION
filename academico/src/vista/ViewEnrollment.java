package vista;

import interfaces.IMostrarMensaje;
import modelo.Enrollment;

import java.util.List;

public class ViewEnrollment implements IMostrarMensaje {
    public void displayListEnrollments(List<Enrollment> enrollments) {
        System.out.println(" == Lista de Matrículas == ");
        for (Enrollment enrollment : enrollments) {
            System.out.println("Id Matrícula: " + enrollment.getId() +
                    ", ID Estudiante: " + enrollment.getStudentId() +
                    ", ID Curso: " + enrollment.getCourseId() +
                    ", Fecha de Creación: " + enrollment.getCreatedAt());
        }
    }
}