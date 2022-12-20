package lk.ijse.dep9.app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

@Data@NoArgsConstructor@AllArgsConstructor
public class UserDTO implements Serializable {
    @NotBlank(message = "full name cannot be empty or null")
    @Pattern(regexp = "^[A-Za-z ]+$",message = "Invalid name")
    private String fullName;
    @NotBlank(message = "Username can't be empty or null")
    private String username;
    @NotEmpty(message = "password cannot be empty or null")
    @Length(min = 3,message = "Password should be at least 3 characters")
    private String password;
}
