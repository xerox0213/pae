package g61453.web.pae.service;

import g61453.web.pae.db.CourseRepository;
import g61453.web.pae.db.StudentRepository;
import g61453.web.pae.model.Course;
import g61453.web.pae.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PaeService {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private CourseRepository courseRepository;

    public Iterable<Student> getStudents() {
        return studentRepository.findAll();
    }

    public Optional<Student> getStudent(long number) {
        return studentRepository.findById(number);
    }

    public Iterable<Course> getCourses() {
        return courseRepository.findAll();
    }

    public Optional<Course> getCourse(String acronym) {
        return courseRepository.findById(acronym);
    }

    public void addCourse(Course course) {
        courseRepository.save(course);
    }
}
