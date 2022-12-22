package lk.ijse.dep9.app.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lk.ijse.dep9.app.util.ValidationGroups;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.*;
import java.io.Serializable;

@JsonIgnoreProperties(value = "password",allowSetters = true)
@Data@NoArgsConstructor@AllArgsConstructor
public class UserDTO implements Serializable {
    @NotBlank(message = "full name cannot be empty or null")
    @Pattern(regexp = "^[A-Za-z ]+$",message = "Invalid name")
    private String fullName;
    @Null(groups = ValidationGroups.Update.class,message = "Username can't be updated")
    @NotBlank(message = "Username can't be empty or null",groups = ValidationGroups.Create.class)
    private String username;
    @NotEmpty(message = "password cannot be empty or null")
    @Length(min = 3,message = "Password should be at least 3 characters")
    private String password;

//    @JsonIgnore
//    public String getPassword() {
//        return password;
//    }
}
