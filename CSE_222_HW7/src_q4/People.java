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
    public void searchSoftwareByName(SearchTree<Software> searchTreeByName){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Name of Software : ");
        String input = scanner.nextLine();
        System.out.println("Version of Software : ");
        String vers = scanner.next();
        Software software = searchTreeByName.find(new Software(new NameOfSoftware(input,Double.valueOf(vers)),null,null, Controller.NAME));
        System.out.println(Admin.capitalizeWord(software.toString()));
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

    public void searchSoftwareByQuantity(SearchTree<Software> searchTreeByQuantity) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Quantity of Software : ");
        Integer input = scanner.nextInt();
        Software software = new Software(null,input,null, Controller.QUANTITY_FIND);
        System.out.println(searchTreeByQuantity.find(software));
    }

    public void searchSoftwareByPrice(SearchTree<Software> searchTreeByPrice) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Price of Software : ");
        String input = scanner.next();
        Software software = new Software(null,null,Double.valueOf(input), Controller.PRICE_FIND);
        System.out.println(searchTreeByPrice.find(software));
    }
}
