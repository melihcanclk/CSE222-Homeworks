import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class SoftwareSystem {
    static Scanner scanner = new Scanner(System.in);
    static Scanner scannerOther = new Scanner(System.in);
    /**
     * Set that keeps peoples
     */
    private Set<People> peoples;
    /**
     * Tree sorted by name
     */
    private CustomSearchTree tree;
    /**
     * User that login to system
     */
    private People user;
  
    /**
     * Constructor of library Management System
     */
    SoftwareSystem() throws IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchMethodException {
        peoples = new HashSet<>();
        //User should give tree that implements SearchTree interface
        tree = new CustomSearchTree(new BinarySearchTree<>());
        //for testing
        final Admin admin = new Admin("admin", "1234");
        peoples.add(new Admin("admin", "1234"));
        peoples.add(new User("melihcan"));
        final ArrayList<Software> arr = new ArrayList<>();
        arr.add(new Software(new NameOfSoftware("Adobe PhotoShop", 6.0), 568, 175.84, Controller.NAME));
        arr.add(new Software(new NameOfSoftware("Adobe PhotoShop", 6.2), 489, 198.0, Controller.NAME));
        arr.add(new Software(new NameOfSoftware("Norton", 4.5), 125, 32.3, Controller.NAME));
        arr.add(new Software(new NameOfSoftware("Norton", 5.5), 235, 65.4, Controller.NAME));
        arr.add(new Software(new NameOfSoftware("Adobe Flash", 3.3), 635, 45.0, Controller.NAME));
        arr.add(new Software(new NameOfSoftware("Adobe Flash", 4.0), 235, 45.0, Controller.NAME));
        for (Software software : arr) {
            NameOfSoftware nameOfSoftware = new NameOfSoftware(software.getNameOfSoftware().getName().toLowerCase(),software.getNameOfSoftware().getVersion());
            software.setNameOfSoftware(nameOfSoftware);
            tree.searchNameTree.add(software);
            software.setController(Controller.PRICE_ADD);
            tree.searchPriceTree.add(software);
            software.setController(Controller.QUANTITY_ADD);
            tree.searchQuantityTree.add(software);
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
            user.searchSoftwareByName(tree.searchNameTree);
        } else if(input == 2){
            user.searchSoftwareByPrice(tree.searchPriceTree);
        } else if(input == 3){
            user.searchSoftwareByQuantity(tree.searchQuantityTree);
        }else if(input == 4){
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
            user.searchSoftwareByName(tree.searchNameTree);
        } else if(input == 2){
            user.searchSoftwareByPrice(tree.searchPriceTree);
        } else if(input == 3){
            user.searchSoftwareByQuantity(tree.searchQuantityTree);
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
        System.out.println("2-)Search By Software Price");
        System.out.println("3-)Search By Software Quantity");
    }

    /**
     * Detect if input is y or n
     * @param input input that will be detected
     * @return if y or n, returns true, otherwise returns false
     */
    public static boolean isYes(String input){
        while (!(input.equals("y") || input.equals("Y") || input.equals("n") || input.equals("N"))){
            System.out.print("Wrong input : ");
            input = scannerOther.next();
        }
        return input.equals("y") || input.equals("Y");
    }


    @Override
    public String toString() {
        return "[tree=\n" + tree + "\n";
    }

    
}
