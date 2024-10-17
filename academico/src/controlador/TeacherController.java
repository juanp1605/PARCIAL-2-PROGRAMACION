package controlador;

import modelo.Teacher;
import vista.ViewTeacher;

import java.util.List;

public class TeacherController {
    private ViewTeacher view;

    public TeacherController(ViewTeacher view) {
        this.view = view;
    }

    // Metodo para insertar un nuevo profesor
    public void insertNewTeacher(Teacher newTeacher) {
        Teacher.insertTeacher(newTeacher); //
        view.mostrarMensaje("\n¡Profesor guardado correctamente!");
    }

    // Metodo para mostrar todos los profesores
    public void displayAllTeachers() {
        List<Teacher> teachers = Teacher.getAllTeachers();
        view.displayListTeachers(teachers);
    }
}
