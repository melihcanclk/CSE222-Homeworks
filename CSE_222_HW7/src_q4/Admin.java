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
//bütün tree'ler verilecek
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
     *  Remove book from Maps
     * @return
     * @param tree
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
//Bütün tree'lerdeki bilgiler değiştirilecek
    /**
     * Update locations of the books
     * @param tree
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
     * @param tree
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

    public static String capitalizeWord(String str){
        String[] words =str.split("\\s");
        String capitalizeWord="";
        for(String w:words){
            String first=w.substring(0,1);
            String afterfirst=w.substring(1);
            capitalizeWord+=first.toUpperCase()+afterfirst+" ";
        }
        return capitalizeWord.trim();
    }
}
