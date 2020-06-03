import java.util.Scanner;

public abstract class People {
    /**
     * Username
     */
    private String username;

    /**
     * Constructor of People Abstract class
     * @param username username
     */
    public People(String username) {
        this.username = username;
    }

    /**
     * Getting username of People
     * @return Username of People
     */
   public String getUsername() {
        return username;
    }

    /**
     * Search Book By Author Name
     */
    public void searchSoftwareByName(CustomTree tree){
        System.out.print("Please enter name of software : ");
        Scanner scanner = new Scanner(System.in);
        String nameOfSoftware = scanner.nextLine();
        nameOfSoftware = nameOfSoftware.toLowerCase();
        System.out.print("Do you want to enter version? : ");
        String input = scanner.next();
        if(LibrarySystem.isYes(input)){
            System.out.print("Please enter version of software : ");
            scanner.nextLine();
            String versionOfSoftware = scanner.nextLine();
            tree.findName(tree.root,nameOfSoftware,Double.valueOf(versionOfSoftware));
        }else{
            tree.findName(tree.root,nameOfSoftware);
        }
    }

    /**
     * Search Quantities of software
     */
    public void searchSoftwareByQuantity(CustomTree tree){
        
        System.out.print("Please enter number of quantity of software : ");
        Scanner scanner = new Scanner(System.in);
        Integer quantity = scanner.nextInt();
        tree.findQuantity(tree.root,quantity);
    }

    /**
     * Search Prices of softwares
     */
    public void searchSoftwareByPrice(CustomTree tree){
        System.out.print("Please enter price of software : ");
        Scanner scanner = new Scanner(System.in);
        String price = scanner.nextLine();
        tree.findPrice(tree.root,Double.valueOf(price));
    }

    /**
     * Equals method that controls if two people has same name or not
     * @param obj Other People object
     * @return if two people has same name or not
     */
    @Override
    public boolean equals(Object obj) {
        return this.getUsername().equals(((People)obj).getUsername());
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */

    @Override
    public String toString() {
        return "People [username=" + username + "]";
    }
    
}
