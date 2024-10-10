package g61453.web.pae.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
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
    @NotBlank(message = "Le sigle du cours est obligatoire")
    private String acronym;
    @NotBlank(message = "Le titre du cours est obligatoire")
    private String title;
    @Min(value = 1, message = "Le nombre de crédits doit être supérieur à 0")
    @Max(value = 7, message = "Le nombre de crédits doit être inférieur à 8")
    private int credits;
    @ManyToMany(mappedBy = "courses")
    private Collection<Student> students;
}
