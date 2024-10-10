package g61453.web.pae.web;

import g61453.web.pae.model.Course;
import g61453.web.pae.service.PaeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
public class CourseCtrl {
    @Autowired
    private PaeService paeService;

    @GetMapping("/courses")
    public String index(Model model) {
        Iterable<Course> courses = paeService.getCourses();
        model.addAttribute("courses", courses);
        if (!model.containsAttribute("course")) {
            // Les erreurs sont lié à un objet cours spécifique donc si il change Spring ne trouvera pas les erreurs
            // puisque c'est un nouvel objet et donc ne seront pas affiché dans notre vue thymeleaf
            model.addAttribute("course", new Course());
        }
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
    public String addCourse(@Valid Course course, BindingResult br, RedirectAttributes ra) {
        if (!br.hasErrors()) {
            paeService.addCourse(course);
            ra.addFlashAttribute("success", course.getTitle() + " a été ajouté");
        } else {
            ra.addFlashAttribute("org.springframework.validation.BindingResult.course", br);
            ra.addFlashAttribute("course", course);
        }
        return "redirect:/courses";
    }
}
