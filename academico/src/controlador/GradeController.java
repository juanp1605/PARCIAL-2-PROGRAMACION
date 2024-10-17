package controlador;

import modelo.Grade;
import vista.ViewGrade;

import java.util.List;

public class GradeController {
    private ViewGrade view;

    public GradeController(ViewGrade view) {
        this.view = view;
    }

    public void insertNewGrade(Grade newGrade) {
        Grade.insertGrade(newGrade);
        view.mostrarMensaje("\nGrado guardado correctamente!");
    }

    public void displayAllGrades() {
        List<Grade> grades = Grade.getAllGrades();
        view.displayListGrades(grades);
    }
}