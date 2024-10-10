package g61453.web.pae.web;

import g61453.web.pae.model.Gender;
import g61453.web.pae.model.Section;
import g61453.web.pae.model.Student;
import g61453.web.pae.service.PaeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
public class StudentCtrl {
    @Autowired
    private PaeService paeService;

    @GetMapping("/students")
    public String index(Model model) {
        Iterable<Student> students = paeService.getStudents();
        model.addAttribute("students", students);
        if (!model.containsAttribute("student")) {
            model.addAttribute("student", new Student());
        }
        model.addAttribute("genders", Gender.values());
        model.addAttribute("sections", Section.values());
        return "students";
    }

    @GetMapping("/students/{number}")
    public String getStudentDetail(@PathVariable long number, Model model) {
        Optional<Student> optStudent = paeService.getStudent(number);
        if (optStudent.isPresent()) {
            model.addAttribute("student", optStudent.get());
            return "student-detail";
        } else {
            model.addAttribute("errorMessage", "L'étudiant recherché n'existe pas !");
            return "error/404";
        }
    }

    @PostMapping("/students/add-student")
    public String addStudent(@Valid Student student, BindingResult br, RedirectAttributes ra) {
        if (!br.hasErrors()) {
            paeService.addStudent(student);
            ra.addFlashAttribute("success", student.getName() + " a été ajouté");
        } else {
            ra.addFlashAttribute("org.springframework.validation.BindingResult.student", br);
            ra.addFlashAttribute("student", student);
        }
        return "redirect:/students";
    }
}
