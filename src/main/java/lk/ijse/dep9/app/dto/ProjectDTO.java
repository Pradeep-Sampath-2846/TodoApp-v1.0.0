package lk.ijse.dep9.app.dto;

import lk.ijse.dep9.app.util.ValidationGroups;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjectDTO {
    @Null(groups = ValidationGroups.Create.class,message = "Project id can't be specified")
    private Integer id;
    @NotBlank(message = "project name can't be null or empty")
    @Length(min = 3,message = "project name should be at least three characters")
    private String name;

    private String username;
}

