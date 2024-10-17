package controlador;

import modelo.GradeType;
import vista.ViewGradeType;

import java.util.List;

public class GradeTypeController {
    private ViewGradeType view;

    public GradeTypeController(ViewGradeType view) {
        this.view = view;
    }

    // Metodo para insertar un nuevo tipo de grado
    public void insertNewGradeType(GradeType newGradeType) {
        GradeType.insertGradeType(newGradeType);
        view.mostrarMensaje("\n¡Tipo de grado guardado correctamente!");
    }

    // Metodo para mostrar todos los tipos de grado
    public void displayAllGradeTypes() {
        List<GradeType> gradeTypes = GradeType.getAllGradeTypes();
        view.displayListGradeTypes(gradeTypes);
    }
}