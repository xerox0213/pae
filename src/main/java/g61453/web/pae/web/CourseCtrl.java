package g61453.web.pae.web;

import g61453.web.pae.model.Course;
import g61453.web.pae.service.PaeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller
public class CourseCtrl {
    @Autowired
    private PaeService paeService;

    @GetMapping("/courses")
    public String index(Model model) {
        Iterable<Course> courses = paeService.getCourses();
        model.addAttribute("courses", courses);
        model.addAttribute("course", new Course());
        return "courses";
    }

    @GetMapping("/courses/{acronym}")
    public String courseDetail(@PathVariable String acronym, Model model, ModelMap modelMap) {
        Optional<Course> optCourse = paeService.getCourse(acronym);
        if (optCourse.isPresent()) {
            model.addAttribute("course", optCourse.orElse(null));
            return "course-detail";
        } else {
            model.addAttribute("errorMessage", "Le cours recherché n'existe pas !");
            return "error/404";
        }
    }

    @PostMapping("/courses/add-course")
    public String addCourse(Course course) {
        paeService.addCourse(course);
        return "redirect:/courses";
    }
}
