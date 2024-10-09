package g61453.web.pae.web;

import g61453.web.pae.model.Student;
import g61453.web.pae.service.PaeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Controller
public class StudentCtrl {
    @Autowired
    private PaeService paeService;

    @GetMapping("/students")
    public String index(Model model) {
        Iterable<Student> students = paeService.getStudents();
        model.addAttribute("students", students);
        return "students";
    }

    @GetMapping("/students/{number}")
    public String getStudentDetail(@PathVariable long number, Model model) {
        Optional<Student> optStudent = paeService.getStudent(number);
        model.addAttribute("student", optStudent.orElse(null));
        return "student-detail";
    }
}
