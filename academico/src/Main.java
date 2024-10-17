
import controlador.*;
import db.connection;
import modelo.*;
import vista.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Bienvenido a nuestro sistema academico!");

        // Inicializar vistas
        ViewStudent viewStudent = new ViewStudent();
        ViewTeacher viewTeacher = new ViewTeacher();
        ViewCourse viewCourse = new ViewCourse();
        ViewEnrollment viewEnrollment = new ViewEnrollment();
        ViewGrade viewGrade = new ViewGrade();
        ViewGradeType viewGradeType = new ViewGradeType();

        // Inicializar controladores
        StudentController studentController = new StudentController(viewStudent);
        TeacherController teacherController = new TeacherController(viewTeacher);
        CourseController courseController = new CourseController(viewCourse);
        EnrollmentController enrollmentController = new EnrollmentController(viewEnrollment);
        GradeController gradeController = new GradeController(viewGrade);
        GradeTypeController gradeTypeController = new GradeTypeController(viewGradeType);


        // Inicializar objeto estudiante
        Student newStudent = new Student(1, "Esteban", "Esteban@gmail.com");
        studentController.insertNewStudent(newStudent);
        studentController.displayAllStudents();

        // Inicializar objeto profesor
        Teacher newTeacher = new Teacher(1, "Gabriel", "Ingenieria");
        teacherController.insertNewTeacher(newTeacher);
        teacherController.displayAllTeachers();

        // Inicializar objeto curso
        //Course newCourse = new Course(1, "Tecnologia", "...", true, newTeacher.getId());
        //courseController.insertNewCourse(newCourse);
        courseController.displayAllCourses();

        // Inicializar objeto enrollment
       // Enrollment newEnrollment = new Enrollment(1, "1", "1");
       // enrollmentController.insertNewEnrollment(newEnrollment);
        enrollmentController.displayAllEnrollments();

        // Inicializar objeto GradeTypes

       // GradeType newGradeType1 = new GradeType(1, "Parcial", 0.50);
       // gradeTypeController.insertNewGradeType(newGradeType1);
        gradeTypeController.displayAllGradeTypes();

        // Inicializar objeto grades

       // Grade newGrade = new Grade(1, 1, 1, 11);
       // gradeController.insertNewGrade(newGrade);
        gradeController.displayAllGrades();



    }
}
