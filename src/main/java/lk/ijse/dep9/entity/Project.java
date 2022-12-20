package lk.ijse.dep9.entity;

import lombok.*;
import org.hibernate.annotations.Generated;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data@NoArgsConstructor@AllArgsConstructor
@Entity
@ToString(exclude = "taskSet")
@EqualsAndHashCode(exclude = "taskSet")
public class Project implements SuperEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private String name;
    @ManyToOne
    @JoinColumn(name = "username",referencedColumnName = "username",nullable = false)
    private User username;
    @OneToMany(mappedBy = "project",fetch =FetchType.EAGER,cascade = CascadeType.REMOVE)
    @Setter(AccessLevel.NONE)
    private Set<Task> taskSet =new HashSet<>();

    public Project(String name, User username) {
        this.name = name;
        this.username = username;
    }


}
