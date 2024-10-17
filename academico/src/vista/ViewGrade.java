package vista;

import modelo.Grade;

import java.util.List;

public class ViewGrade {

    public void displayListGrades(List<Grade> grades) {
        System.out.println(" == Lista de calificaciones == ");
        for (Grade grade : grades) {
            System.out.println("Id Calificación: " + grade.getId() +
                    ", Id Inscripción: " + grade.getEnrollment_id() +
                    ", Id Tipo de Calificación: " + grade.getGrade_type_id() +
                    ", Calificación: " + grade.getGrade());
        }
    }

    public void mostrarMensaje(String message) {
        System.out.println(message);
    }
}