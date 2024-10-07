package g61453.web.pae.web;

import g61453.web.pae.model.Course;
import g61453.web.pae.service.PaeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Controller
public class CourseCtrl {
    @Autowired
    private PaeService paeService;

    @GetMapping("/courses")
    public String index(Model model) {
        Iterable<Course> courses = paeService.getCourses();
        model.addAttribute("courses", courses);
        return "courses";
    }

    @GetMapping("/courses/{acronym}")
    public String courseDetail(@PathVariable String acronym, Model model) {
        Optional<Course> optCourse = paeService.getCourse(acronym);
        model.addAttribute("course", optCourse.orElse(null));
        return "course-detail";
    }
}
