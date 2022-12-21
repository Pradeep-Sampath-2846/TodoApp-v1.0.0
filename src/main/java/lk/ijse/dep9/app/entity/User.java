package lk.ijse.dep9.app.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data@AllArgsConstructor@NoArgsConstructor
public class User  implements SuperEntity{

    private String username;
    private String password;
    private String fullName;
}
