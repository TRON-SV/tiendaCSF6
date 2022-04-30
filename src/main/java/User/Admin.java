package User;

import java.util.Scanner;

public class Admin extends User implements ILogInUser {
    public Admin() {
        this.idUser = "grupo3cfs";
        this.userType = 1;
        this.name = "Grupo 3";
        this.password = "12345";
        this.email = "grupo3@mail.com";
    }

    public Admin(String idUser, Integer userType, String name, String password, String email) {
        super(idUser, userType, name, password, email);
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
