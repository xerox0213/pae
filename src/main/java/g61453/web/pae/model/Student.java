package g61453.web.pae.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Entity
@NoArgsConstructor
@Data
@AllArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long number;
    @NotBlank(message = "Le nom de étudiant est obligatoire")
    private String name;
    @Enumerated(EnumType.STRING)
    @NotNull
    private Gender gender;
    @Enumerated(EnumType.STRING)
    @NotNull
    private Section section;
    @ManyToMany
    private Collection<Course> courses;
}
