package User;

import java.util.Scanner;

public class Customer extends User implements ILogInUser{
    public Customer() {
        this.idUser = "CGroup3cfs";
        this.userType = 2;
        this.name = "Alan Brito";
        this.password = "12345";
        this.email = "alanbrito@mail.com";
    }

    public Customer(String idUser, Integer userType, String name, String password, String email) {
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
