import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class LibrarySystem {
    static Scanner scanner = new Scanner(System.in);
    static Scanner scannerOther = new Scanner(System.in);
    /**
     * Set that keeps peoples
     */
    private Set<People> peoples;
    /**
     * Tree sorted by name
     */
    private CustomTree tree;
    /**
     * User that login to system
     */
    private People user;
  
    /**
     * Constructor of library Management System
     */
    LibrarySystem(){
        peoples = new HashSet<>();
        tree = new CustomTree();
        //for testing
        final Admin admin = new Admin("admin", "1234");
        peoples.add(new Admin("admin", "1234"));
        peoples.add(new User("melihcan"));
        final ArrayList<Software> arr = new ArrayList<>();
        arr.add(new Software("Adobe PhotoShop", 6.0, 568, 175.84));
        arr.add(new Software("Adobe PhotoShop", 6.2, 489, 198.0));
        arr.add(new Software("Norton", 4.5, 125, 32.3));
        arr.add(new Software("Norton", 5.5, 235, 65.4));
        arr.add(new Software("Adobe Flash", 3.3, 635, 45.0));
        arr.add(new Software("Adobe Flash", 4.0, 235, 65.0));
        for (Software software : arr) {
            software.setName(software.getName().toLowerCase());
            tree.add(software);
        }
    }

    /**
     * Login method
     */
    public void login(){
        boolean exit = false;
        boolean isuserfound = false;
        String username = null;
        do{
            if(!isuserfound){
                System.out.print("Enter username : ");
                username = scanner.nextLine();
                username = username.trim();
                for(final People people:peoples){
                    if(people.getUsername().equals(username)){
                        if( people instanceof Admin){
                            System.out.print("Enter password : ");
                            String password = scannerOther.next();
                            if(((Admin) people).getPassword().equals(password)){
                                this.user = new Admin(username,((Admin) people).getPassword());
                                isuserfound = true;
                            }else{
                                isuserfound = false;
                            }
                        }else {
                            this.user = new User(username);
                            isuserfound = true;
                        }
                    }
                }
            }if(isuserfound){
                if ((user instanceof Admin)) {
                    adminMenu();
                } else {
                    userMenu();
                }
            }
            if(!isuserfound){
                System.out.println("No such person named " + username + ", Do you want to create new account with name "+ username +" (Y/N) : ");
                String input = scannerOther.next();
                if(isYes(input)){
                    //Create new user
                    user = new User(username);
                    peoples.add(user);
                    isuserfound = true;
                }
            }
            //Logout olmak dediğinde y yazınca no such person diyor (DONE)
            System.out.print("Do you want to exit from library system(Y/N) : ");
            String word = "";
            word = scannerOther.next();
            boolean isyes = false;
            if (word != null) {
                isyes = isYes(word);
            }
            if(isyes){
                exit = true;
            }if(!exit && isuserfound){
                System.out.print("Do you want to log out?(Y/N) : ");
                if(isYes(scannerOther.next())){
                    isuserfound = false;
                }
            }
        }while(!exit);
        
    }

    /**
     * Menu of Admin
     */
    private void adminMenu(){
        final Admin admin =(Admin) user;
        printadminMenu();
        System.out.println("8-)Exit");
        int input = scannerOther.nextInt();
        while(input < 0 || input >8){
            System.out.print("Wrong input. Enter selection again : ");
            printadminMenu();
            System.out.println("8-)Exit");
            input = scannerOther.nextInt();
        }
        if(input == 1){
            user.searchSoftwareByName(tree);
        } else if(input == 2) {
            user.searchSoftwareByQuantity(tree);
        } else if(input == 3) {
            user.searchSoftwareByPrice(tree);
        } else if(input == 4){
            admin.addSoftware(tree);
        } else if(input == 5){
            admin.removeSoftware(tree);
        } else if(input == 6){
            admin.updateSoftware(tree);
        } else if(input == 7){
            admin.printAllSoftwares(tree);
        }
    }

    /**
     * Menu of User
     */
    private void userMenu(){
        printuserMenu();
        System.out.println("4-)Exit");
        int input = scannerOther.nextInt();
        while(input < 0 || input >4){
            System.out.print("Wrong input. Enter selection again : ");
            printuserMenu();
            System.out.println("4-)Exit");
            input = scannerOther.nextInt();
        }
        if(input == 1){
            user.searchSoftwareByName(tree);
        }else if(input == 2){
            user.searchSoftwareByQuantity(tree);
        }else if(input == 3){
            user.searchSoftwareByPrice(tree);
        }
    }

    /**
     * Printing Admin Menu
     */
    private static void printadminMenu(){
        printuserMenu();
        System.out.println("4-)Add Software");
        System.out.println("5-)Delete Software");
        System.out.println("6-)Update Software");
        System.out.println("7-)Print All Softwares");
    }

    /**
     * Printing User Menu
     */
    private static void printuserMenu(){
        System.out.println("1-)Search By Software Name");
        System.out.println("2-)Search By Software Quantity");
        System.out.println("3-)Search By Software Price");
    }

    /**
     * Detect if input is y or n
     * @param input input that will be detected
     * @return if y or n, returns true, otherwise returns false
     */
    public static boolean isYes(String input){
        while (!(input.equals("y") || input.equals("Y") || input.equals("n") || input.equals("N"))){
            System.out.println("Wrong input : ");
            input = scannerOther.next();
        }
        return input.equals("y") || input.equals("Y");
    }


    @Override
    public String toString() {
        return "[tree=\n" + tree + "\n";
    }

    
}
