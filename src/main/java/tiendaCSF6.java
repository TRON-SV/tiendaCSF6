public class tiendaCSF6 {
    public static void printMenu(String[] options){
        for (String option : options){
            System.out.println(option);
        }
        System.out.print("Choose your option : ");
    }
    public static void main(String[] args) {
        String[] options = {
                "------------------",
                "1- Insert Console Product",
                "2- Insert TV Produt",
                "3- Exit",
        };
        Console consoleProduct = new Console(2,true);
        //Tv TvProduct = new Tv();
        ConsoleProductArchiever consoleProductArchiever = new ConsoleProductArchiever();

        Scanner scanner = new Scanner(System.in);
        int option = 1;
        while (option!=3){
            printMenu(options);
            try {
                option = scanner.nextInt();
                switch (option){
                    case 1: console(consoleProduct, consoleProductArchiever); break;
                    case 2: tv(TvProduct, consoleProductArchiever); break;
                    case 3: exit(0);
                }
            }
            catch (Exception ex){
                System.out.println("Please enter an integer value between 1 and " + options.length);
                scanner.next();
            }
        }
    }
}
