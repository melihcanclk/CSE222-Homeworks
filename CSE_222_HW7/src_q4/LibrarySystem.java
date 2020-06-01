import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class LibrarySystem {
    
    /**
     * Set that keeps peoples
     */
    private Set<People> peoples;
    /**
     * Tree sorted by name
     */
    private Map<String,SearchTree<Specs>> nameSortedTree;
    /**
     * User that login to system
     */
    private People user;
  
    /**
     * Constructor of library Management System
     */
    LibrarySystem(){
        peoples = new HashSet<>();
        nameSortedTree = new HashMap<String, SearchTree<RevisedNode<String>>>();
        versionSortedTree = new BinarySearchTree<>();
        quantitySortedTree = new BinarySearchTree<>();
        priceSortedTree = new BinarySearchTree<>();

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
        for (int i = 0; i < arr.size(); i++) {
            admin.addSoftware(nameSortedTree,versionSortedTree ,quantitySortedTree, priceSortedTree, arr.get(i));
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
            final Scanner scanner = new Scanner(System.in);
            if(!isuserfound){
                System.out.print("Enter username : ");
                username = scanner.nextLine();
                username = username.trim();
                for(final People people:peoples){
                    if(people.getUsername().equals(username)){
                        if( people instanceof Admin){
                            System.out.print("Enter password : ");
                            final String password = scanner.next();
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
                final String input = scanner.next();
                if(isYes(input)){
                    //Create new user
                    peoples.add(new User(username));
                    isuserfound = true;
                }
            }
            System.out.println("Do you want to exit from library system(Y/N) : ");
            if(isYes(scanner.next())){
                exit = true;
            }if(!exit){
                System.out.println("Do you want to log out?(Y/N) : ");
                if(isYes(scanner.next())){
                    isuserfound = false;
                }
            }
            scanner.close();
        }while(!exit);
        
    }

    /**
     * Menu of Admin
     */
    private void adminMenu(){
        final Admin admin =(Admin) user;
        printadminMenu();
        System.out.println("8-)Exit");
        final Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        while(input < 0 || input >8){
            System.out.print("Wrong input. Enter selection again : ");
            printadminMenu();
            System.out.println("8-)Exit");
            input = scanner.nextInt();
        }/*
        if(input == 1){
            user.searchSoftwareByName(nameSortedTree);
        } else if(input == 2) {
            user.searchSoftwareByQuantity(quantitySortedTree);
        } else if(input == 3) {
            user.searchSoftwareByPrice(priceSortedTree);
        } else if(input == 4){
            admin.addSoftware(nameSortedTree, quantitySortedTree, priceSortedTree);
        } else if(input == 5){
            admin.removeSoftware(nameSortedTree, quantitySortedTree, priceSortedTree);
        } else if(input == 6){
            admin.updateSoftware(nameSortedTree, quantitySortedTree, priceSortedTree);
        } else if(input == 7){
            admin.printAllSoftwares(nameSortedTree);
        }*/
        scanner.close();
    }

    /**
     * Menu of User
     */
    private void userMenu(){
        printuserMenu();
        System.out.println("4-)Exit");
        final Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        while(input < 0 || input >4){
            System.out.print("Wrong input. Enter selection again : ");
            printuserMenu();
            System.out.println("4-)Exit");
            input = scanner.nextInt();
        }/*
        if(input == 1){
            user.searchSoftwareByName(nameSortedTree);
        }else if(input == 2){
            user.searchSoftwareByQuantity(quantitySortedTree);
        }else if(input == 3){
            user.searchSoftwareByPrice(priceSortedTree);
        }*/
        scanner.close();
    }

    /**
     * Printing Admin Menu
     */
    private static void printadminMenu(){
        printuserMenu();
        System.out.println("3-)Add Book");
        System.out.println("4-)Delete Book");
        System.out.println("5-)Update Location Of Book");
        System.out.println("6-)Print All Books");
    }

    /**
     * Printing User Menu
     */
    private static void printuserMenu(){
        System.out.println("1-)Search By Author");
        System.out.println("2-)Search By Title of the Book");
    }

    /**
     * Detect if input is y or n
     * @param input input that will be detected
     * @return if y or n, returns true, otherwise returns false
     */
    private boolean isYes(String input){
        final Scanner scanner = new Scanner(System.in);
        while (!(input.equals("y") || input.equals("Y") || input.equals("n") || input.equals("N"))){
            System.out.println("Wrong input. Do you want to create new user account(Y/N) : ");
            input = scanner.next();
        }
        scanner.close();
        return input.equals("y") || input.equals("Y");

    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */

    @Override
    public String toString() {
        return "[tree=\n" + nameSortedTree + "\n";
    }

    
}
