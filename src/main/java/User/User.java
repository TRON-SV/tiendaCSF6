package User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor @NoArgsConstructor
@Data
public class User {
    protected String idUser;
    protected Integer userType;
    protected String name;
    protected String password;
    protected String email;
}
