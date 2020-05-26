import java.util.Scanner;
import java.util.Set;

public class LibrarySystem {
    private Set<People> peoples;
    NestedMap map = new NestedMap();
    private People user;
    LibrarySystem(){
        peoples = new CustomHashSet();
<<<<<<< HEAD
        //for testing
=======
>>>>>>> origin/master
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
<<<<<<< HEAD
                username = scanner.nextLine();
                username = username.trim();
=======
                username = scanner.next();
>>>>>>> origin/master
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
<<<<<<< HEAD
                if ((user instanceof Admin)) {
                    adminMenu();
                } else {
=======
                if( user instanceof Admin){
                    //admin part
                    adminMenu();
                }else {
                    //user part
>>>>>>> origin/master
                    userMenu();
                }
            }
            if(!isuserfound){
<<<<<<< HEAD
                System.out.println("No such person named " + username + ", Do you want to create new account with name "+ username +" (Y/N) : ");
                String input = scanner.next();
                if(isYes(input)){
                    //Create new user
                    peoples.add(new User(username));
                    isuserfound = true;
=======
                System.out.println("No such person, Do you want to create new user account(Y/N) : ");
                String input = scanner.next();
                if(isYes(input)){
                    //Create new user
                    System.out.println("--User Creation--");
                    System.out.print("Enter username : ");
                    peoples.add(new User(scanner.next()));
>>>>>>> origin/master
                }
            }
            System.out.println("Do you want to exit from library system(Y/N) : ");
            if(isYes(scanner.next())){
                exit = true;
<<<<<<< HEAD
            }if(!exit){
                System.out.println("Do you want to log out?(Y/N) : ");
                if(isYes(scanner.next())){
                    isuserfound = false;
                }
=======
>>>>>>> origin/master
            }
        }while(!exit);

    }
    private void adminMenu(){
<<<<<<< HEAD
        Admin admin =(Admin) user;
        printadminMenu();
        System.out.println("7-)Exit");
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        while(input < 0 || input >7){
            System.out.print("Wrong input. Enter selection again : ");
            printadminMenu();
            System.out.println("7-)Exit");
=======
        //TODO : Admin menu
        Admin admin =(Admin) user;
        printadminMenu();
        System.out.println("6-)Exit");
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        while(input < 0 || input >6){
            System.out.print("Wrong input. Enter selection again : ");
            printadminMenu();
            System.out.println("6-)Exit");
>>>>>>> origin/master
            input = scanner.nextInt();
        }
        if(input == 1){
            user.searchBookByAuthorName(map);
        } else if(input == 2) {
            user.searchBookByTitle(map);
        } else if(input == 3){
<<<<<<< HEAD
            admin.addBook(map);
        } else if(input == 4){
            admin.removeBook(map);
        } else if(input == 5){
            admin.updateLocation(map);
        } else if(input == 6){
            admin.printAllBooks(map);
=======
            scanner = new Scanner(System.in);
            System.out.print("Enter name of the author : ");
            String nameOfAuthor = scanner.nextLine();
            System.out.print("Enter title of the book : ");
            String title = scanner.nextLine();
            System.out.print("Enter shelf, corridor and queue of the book that you will put respectively : ");
            int shelf = scanner.nextInt();
            int corridor = scanner.nextInt();
            int queue = scanner.nextInt();
            admin.addBook(map,new Book(nameOfAuthor,title,new Location(shelf,corridor,queue)));
        } else if(input == 4){
            System.out.print("Enter shelf, corridor and queue of the book that you will put respectively : ");
            int shelf = scanner.nextInt();
            int corridor = scanner.nextInt();
            int queue = scanner.nextInt();
            admin.removeBook(map,new Book(null,null,new Location(shelf,corridor,queue)));
        } else if(input == 5){
            System.out.println(map);
            System.out.print("Enter shelf, corridor and queue of the book that you will change position respectively : ");
            int shelf1 = scanner.nextInt();
            int corridor1 = scanner.nextInt();
            int queue1 = scanner.nextInt();
            System.out.print("Enter shelf, corridor and queue of the book that you will put new position respectively : ");
            int shelf2 = scanner.nextInt();
            int corridor2 = scanner.nextInt();
            int queue2 = scanner.nextInt();
            admin.updateLocation(map,new Location(shelf1,corridor1,queue1), new Location(shelf2,corridor2,queue2));
>>>>>>> origin/master
        }
    }

    private void userMenu(){
<<<<<<< HEAD
=======
        //TODO : User Menu
>>>>>>> origin/master
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
<<<<<<< HEAD
        System.out.println("6-)Print All Books");
=======
>>>>>>> origin/master
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
