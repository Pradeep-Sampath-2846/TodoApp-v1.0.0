package lk.ijse.dep9.entity;

import lombok.*;
import org.hibernate.annotations.Generated;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data@NoArgsConstructor@AllArgsConstructor
public class Project implements SuperEntity{
    private int id;
    private String name;
    private String username;

    public Project(String name, String username) {
        this.name = name;
        this.username = username;
    }
}
