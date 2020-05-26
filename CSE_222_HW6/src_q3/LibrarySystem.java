import java.util.Scanner;
import java.util.Set;

public class LibrarySystem {
    private Set<People> peoples;
    NestedMap map = new NestedMap();
    private People user;
    LibrarySystem(){
        peoples = new CustomHashSet();
        //for testing
        peoples.add(new Admin("admin", "1234"));
        peoples.add(new User("melihcan"));
    }

    public void login(){
        boolean exit = false;
        boolean isuserfound = false;
        String username = null;
        do{
            Scanner scanner = new Scanner(System.in);
            if(!isuserfound){
                System.out.print("Enter username : ");
                username = scanner.nextLine();
                username = username.trim();
                for(People people:peoples){
                    if(people.getUsername().equals(username)){
                        if( people instanceof Admin){
                            System.out.print("Enter password : ");
                            String password = scanner.next();
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
                String input = scanner.next();
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
        }while(!exit);

    }
    private void adminMenu(){
        Admin admin =(Admin) user;
        printadminMenu();
        System.out.println("7-)Exit");
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        while(input < 0 || input >7){
            System.out.print("Wrong input. Enter selection again : ");
            printadminMenu();
            System.out.println("7-)Exit");
            input = scanner.nextInt();
        }
        if(input == 1){
            user.searchBookByAuthorName(map);
        } else if(input == 2) {
            user.searchBookByTitle(map);
        } else if(input == 3){
            admin.addBook(map);
        } else if(input == 4){
            admin.removeBook(map);
        } else if(input == 5){
            admin.updateLocation(map);
        } else if(input == 6){
            admin.printAllBooks(map);
        }
    }

    private void userMenu(){
        printuserMenu();
        System.out.println("3-)Exit");
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        while(input < 0 || input >3){
            System.out.print("Wrong input. Enter selection again : ");
            printuserMenu();
            System.out.println("3-)Exit");
            input = scanner.nextInt();
        }
        if(input == 1){
            user.searchBookByAuthorName(map);
        }else if(input == 2){
            user.searchBookByTitle(map);
        }
    }
    private static void printadminMenu(){
        printuserMenu();
        System.out.println("3-)Add Book");
        System.out.println("4-)Delete Book");
        System.out.println("5-)Update Location Of Book");
        System.out.println("6-)Print All Books");
    }
    private static void printuserMenu(){
        System.out.println("1-)Search By Author");
        System.out.println("2-)Search By Title of the Book");
    }
    private boolean isYes(String input){
        Scanner scanner = new Scanner(System.in);
        while (!(input.equals("y") || input.equals("Y") || input.equals("n") || input.equals("N"))){
            System.out.println("Wrong input. Do you want to create new user account(Y/N) : ");
            input = scanner.next();
        }
        return input.equals("y") || input.equals("Y");

    }
}
