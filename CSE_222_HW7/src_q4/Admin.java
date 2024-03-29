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

    /**
     * Adding Software to tree
     * @param tree Tree that software will be added
     */
    public void addSoftware(CustomSearchTree tree){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Name of Software : ");
        String input = scanner.nextLine();
        System.out.print("Version of Software : ");
        String vers = scanner.next();
        System.out.print("Quantity of Software : ");
        Integer qua = scanner.nextInt();
        System.out.print("Price of Software : ");
        String pri = scanner.next();
        //name, version, quantity, price
        input = input.toLowerCase();
        Software software = new Software(new NameOfSoftware(input,Double.valueOf(vers)),qua,Double.valueOf(pri), Controller.NAME);
        tree.searchNameTree.add(software);
        software.setController(Controller.QUANTITY_ADD);
        tree.searchQuantityTree.add(software);
        software.setController(Controller.PRICE_ADD);
        tree.searchPriceTree.add(software);
    }

    /**
     *  Remove software from tree
     * @return Removed software
     * @param tree Tree that will be deleted from
     */
    public Software removeSoftware(CustomSearchTree tree){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Name of Software : ");
        String input = scanner.nextLine();
        System.out.println("Version of Software : ");
        String vers = scanner.next();
        Software software = tree.searchNameTree.find(new Software(new NameOfSoftware(input,Double.valueOf(vers)),null,null,Controller.NAME));
        if(software != null){
            software.setController(Controller.NAME);
            tree.searchNameTree.remove(software);
            software.setController(Controller.QUANTITY_FIND);
            tree.searchQuantityTree.remove(software);
            software.setController(Controller.PRICE_FIND);
            tree.searchPriceTree.remove(software);
        }
        return software;
    }

    /**
     * Update Quantity or price of a software
     * @param tree Tree that will be updated from
     */
    public void updateSoftware(CustomSearchTree tree){
        Scanner scanner = new Scanner(System.in);
        Software software = removeSoftware(tree);
        if(software == null){
            System.out.println("No Software");
            return;
        }
        System.out.println(software);
        Integer quantity = software.getQuantity();
        String price = String.valueOf(software.getPrice());
        System.out.print("Do you want to enter new price to change it? : ");
        String input = scanner.next();
        if(SoftwareSystem.isYes(input)){
            System.out.println("New price of software : ");
            price = scanner.next();
            System.out.print("Do you want to enter new quantity to change it? : ");
            input = scanner.next();
            if(SoftwareSystem.isYes(input)){
                System.out.println("New quantity of software : ");
                quantity = scanner.nextInt();
            }
        }
        software = new Software(new NameOfSoftware(software.getNameOfSoftware().getName(),software.getNameOfSoftware().getVersion()),quantity,Double.valueOf(price),Controller.NAME);
        tree.searchNameTree.add(software);
        software.setController(Controller.QUANTITY_ADD);
        tree.searchQuantityTree.add(software);
        software.setController(Controller.PRICE_ADD);
        tree.searchPriceTree.add(software);
        System.out.println(software + " added to tree");
    }

    /**
     * Printing All books
     * @param tree Tree that will be printed
     */
    public void printAllSoftwares(CustomSearchTree tree){
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
