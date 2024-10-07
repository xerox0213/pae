package g61453.web.pae.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Course {
    @Id
    private String acronym;
    private String title;
    private int credits;
    @ManyToMany(mappedBy = "courses")
    private Collection<Student> students;
}
