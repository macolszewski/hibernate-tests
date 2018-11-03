package hibernate;

import hibernate.model.*;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App
{
    public static void main( String[] args ) {

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
//        Book book = new Book("Koń Rafał","1923","Bajka");
//        Book book2 = new Book("Koń Rafał II","1925","Bajka");
//        BookService bookService = new BookService(sessionFactory);
//        bookService.addBook(book);
//        bookService.addBook(book2);
//
//        Author author = new Author(new Human("Andrzej","Lęgarek"),
//                "Bajka","Lęgar"," ");
//        Author author2 = new Author(new Human("Robert","Roger"),
//                "Thriller"," "," ");
//
//        AuthorService authorService = new AuthorService(sessionFactory);
//        authorService.addAuthor(author);
//        authorService.addAuthor(author2);

        Departament departament = new Departament();
        departament.setCity("Szczecin");
        departament.setName("HR");

        Departament departament1 = new Departament();
        departament1.setCity("Warszawa");
        departament1.setName("HR");

        Employee janusz = new Employee();
        janusz.setName("Janusz");
        janusz.setLastname("Kowalski");
        janusz.setPosition("Prezes");
        janusz.setDepartament(departament);

        Employee zbigniew = new Employee();
        zbigniew.setName("Zbigniew");
        zbigniew.setLastname("Stonók");
        zbigniew.setPosition("Cieć");
        zbigniew.setDepartament(departament1);

        Project project = new Project();
        project.setName("Robo-Cop");
        project.setEmployee(janusz);
        Project project1 = new Project();
        project1.setName("Złoo");
        project1.setEmployee(zbigniew);
        Project project_zlom = new Project();
        project_zlom.setName("Robo-złom");
        project_zlom.setEmployee(zbigniew);

        DepartamentService departamentService = new DepartamentService(sessionFactory);
        EmployeeService employeeService = new EmployeeService(sessionFactory);
        ProjectService projectService = new ProjectService(sessionFactory);
        departamentService.addDepartament(departament);
        departamentService.addDepartament(departament1);
        employeeService.addEmployee(janusz);
        employeeService.addEmployee(zbigniew);
        projectService.addProject(project);
        projectService.addProject(project1);
        projectService.addProject(project_zlom);

//        employeeService.updateEmployee(4,project);
//        employeeService.updateEmployee(4,project_zlom);
//        employeeService.updateEmployee(3,project1);

        employeeService.getEmployees();
        departamentService.getDepartaments();
        projectService.getProjects();



//        bookService.getBooks();
//        authorService.getAuthors();
//
//        bookService.updateBook("ff80818166baf7340166baf736a90000","Zły tytuł");
////        authorService.updateAuthor("ff80818166baf7340166baf736d10003",new Human("Zygfyd","Naukowski"));
//        authorService.deleteAuthor("ff80818166baf7340166baf736d10003");

        sessionFactory.close();

    }
}
