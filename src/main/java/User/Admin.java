package User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Scanner;
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = false)
public class Admin extends User implements ILogInUser {
    @Builder
    public Admin(String userId, Integer userType, String userName, String userPassword, String userEmail) {
        super(userId,userType,userName,userPassword,userEmail);
    }

    @Override
    public void logInUser() {
        Scanner scan = new Scanner(System.in);
        String userId, pass;
        boolean stop = true;
        while(stop) {
            System.out.println("Please enter your ID User");
            userId = scan.nextLine();
            System.out.println("Please enter your password");
            pass = scan.nextLine();
            if (this.idUser.equals(userId) && this.password.equals(pass)) {
                System.out.println("Welcome to your session: " + this.name);
                stop = false;
            } else {
                System.out.println("Invalid ID user or password ");
            }
        }
    }
}
