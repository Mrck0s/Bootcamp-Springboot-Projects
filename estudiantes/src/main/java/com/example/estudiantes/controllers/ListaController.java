package com.example.estudiantes.controllers;

import com.example.estudiantes.models.Contacto;
import com.example.estudiantes.models.Estudiantes;
import com.example.estudiantes.services.ContactoServicio;
import com.example.estudiantes.services.EstudiantesServicio;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ListaController {

    private final ContactoServicio contactoServicio;
    private final EstudiantesServicio estudiantesServicio;

    public ListaController(EstudiantesServicio estudiantesServicio, ContactoServicio contactoServicio) {
        this.contactoServicio = contactoServicio;
        this.estudiantesServicio = estudiantesServicio;
    }


    //Main
    @GetMapping("/")
    public String index() {
        return "index";
    }

    //Estudiantes
    @GetMapping("/students/new")
    public String studentsNew(Model model) {
        model.addAttribute("NuevosEstudiantes", new Estudiantes());
        return "students";
    }

    @PostMapping("/students/new")
    public String createStudents(@Valid @ModelAttribute("newStudent") Estudiantes newStudent, BindingResult result) {
        if (result.hasErrors()) {
            return "/";
        } else {
            estudiantesServicio.CrearEstudiante(newStudent);
        }
        return "redirect:/";
    }


    //Contacto
    @GetMapping("/contact/new")
    public String contactNew(Model model) {
        model.addAttribute("NuevoContacto", new Contacto());
        List<Estudiantes> todosLosEstudiantes = estudiantesServicio.TraerEstudiantes();
        model.addAttribute("todosLosEstudiantes", todosLosEstudiantes);
        return "contact";
    }

    @PostMapping("/contact/new")
    public String createContact(@RequestParam("estudianteNombre") Long estudianteNombre,
                                @RequestParam("address") String a,
                                @RequestParam("city") String c,
                                @RequestParam("state") String s) {
        Contacto contacto = new Contacto();
        Estudiantes estudiantes = estudiantesServicio.buscarPorId(estudianteNombre);

        if (estudiantes != null) {
            contacto.setEstudiantes(estudiantes);
        }

        contacto.setAddress(a);
        contacto.setCity(c);
        contacto.setState(s);
        contactoServicio.CrearContacto(contacto);


        return "redirect:/";
    }

    //Todos
    @GetMapping("/students")
    public String allStudents(Model model) {
        List<Estudiantes> todosLosEstudiantes = estudiantesServicio.TodosLosEstudiantes();
        List<Contacto> todosLosContactos = contactoServicio.TodosLosContactos();
        model.addAttribute("TodosLosEstudiantes", todosLosEstudiantes);
        model.addAttribute("TodosLosContactos", todosLosContactos);
        return "all";
    }

    //Actividades
    @GetMapping("/students/create") // /students/create?firstName=John&lastName=Doe&age=35 (Se crean 3 con un for)
    public String a(
            @RequestParam("firstName") String firstName,
            @RequestParam("lastName") String lastName,
            @RequestParam("age") String age
    ) {
        for (int i = 1; i <= 3; i++) {
            Estudiantes newStudent = new Estudiantes();
            newStudent.setFirst_name(firstName + " " + i);
            newStudent.setLast_name(lastName);
            newStudent.setAge(age);
            estudiantesServicio.CrearEstudiante(newStudent);
        }
        return "redirect:/";
    }

    @GetMapping("/contacts/create") // /contacts/create?student=1&address=1234%20Some%20Street&city=Los%20Angeles&state=CA
    public String b(
            @RequestParam("student") Long studentId,
            @RequestParam("address") String address,
            @RequestParam("city") String city,
            @RequestParam("state") String state
    ) {
        Estudiantes student = estudiantesServicio.buscarPorId(studentId);

        if (student != null) {
            Contacto contacto = new Contacto();
            contacto.setEstudiantes(student);
            contacto.setAddress(address);
            contacto.setCity(city);
            contacto.setState(state);
            contactoServicio.CrearContacto(contacto);
        }

        return "redirect:/";
    }



}
