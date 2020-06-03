import java.util.Scanner;

public class Admin extends People{
    private final String password;

    /**
     * Constructor of Admin Class
     * @param username Username of Admin
     * @param password Password of Admin
     */
    Admin(String username, String password){
        super(username);
        this.password = password;
    }

    public void addSoftware(SearchTree<Software> tree){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Name of Software : ");
        String input = scanner.nextLine();
        System.out.println("Version of Software : ");
        String vers = scanner.next();
        System.out.println("Quantity of Software : ");
        Integer qua = scanner.nextInt();
        System.out.println("Price of Software : ");
        String pri = scanner.next();
        //name, version, quantity, price
        input = input.toLowerCase();
        Software software = new Software(input,Double.valueOf(vers),qua,Double.valueOf(pri));
        tree.add(software);
    }

    /**
     *  Remove book from Maps
     * @return
     */
    public Software removeSoftware(CustomTree tree){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Name of Software : ");
        String input = scanner.nextLine();
        System.out.print("Version of Software : ");
        String vers = scanner.next();
        return tree.delete(tree.find(new Software(input,Double.valueOf(vers),null,null)));
    }

    /**
     * Update locations of the books
     */
    public void updateSoftware(CustomTree tree){
        Scanner scanner = new Scanner(System.in);
        Software software = removeSoftware(tree);
        if(software == null){
            System.out.println("No Software named " + software);
            return;
        }
        System.out.println(software);
        Integer quantity = software.getQuantity();
        String price = String.valueOf(software.getPrice());
        System.out.print("Do you want to enter new price to change it? : ");
        String input = scanner.next();
        if(LibrarySystem.isYes(input)){
            System.out.println("New price of software : ");
            price = scanner.next();
            System.out.print("Do you want to enter new quantity to change it? : ");
            input = scanner.next();
            if(LibrarySystem.isYes(input)){
                System.out.println("New quantity of software : ");
                quantity = scanner.nextInt();
            }
        }
        tree.add(new Software(software.getName(),software.getVersion(),quantity,Double.valueOf(price)));
    }

    /**
     * Printing All books
     */
    public void printAllSoftwares(SearchTree<Software> tree){
        System.out.println(tree);
    }

    /**
     * Getting password of the Admin
     * @return password
     */
    public String getPassword() {
        return password;
    }
    
}
