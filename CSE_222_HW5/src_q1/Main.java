public class Main {
    private static FileSystemTree ftree;
    public static void main(String[] args) {
        //test1();
        //test2();
        //test3();
        //test4();
        //test5();
        //test6();
        //test7();
        //test8();
        //test9();
        //test10();
        //test11();
        //test12();
        test13();
    }

    public static void construct(){
        ftree = new FileSystemTree("root");

        ftree.addDir("root/first_directory");
        ftree.addDir("root/second_directory");
        ftree.addDir("root/second_directory/new_directory");
        ftree.addDir("root/third_directory/");
        ftree.addFile("root/third_directory/foo.txt");
        ftree.addFile("root/second_directory/new_directory/new_file.doc");

        ftree.addDir("root/second_directory/Codeshop");
        ftree.addDir("root/second_directory/Codeshop/FlutterShop");
        ftree.addDir("root/second_directory/Codeshop/FlutterShop/Larsca");
        ftree.addDir("root/second_directory/Codeshop/FlutterShop/Larsca/lib");
        ftree.addDir("root/second_directory/Codeshop/FlutterShop/Larsca/android");
        ftree.addDir("root/second_directory/Codeshop/FlutterShop/Larsca/ios");
        ftree.addFile("root/second_directory/Codeshop/FlutterShop/Larsca/.gitignore");
        ftree.addFile("root/second_directory/Codeshop/FlutterShop/Larsca/.metadata");
        ftree.addFile("root/second_directory/Codeshop/FlutterShop/Larsca/pubspec.lock");
        ftree.addFile("root/second_directory/Codeshop/FlutterShop/Larsca/pubspec.yaml");
        ftree.addFile("root/second_directory/Codeshop/FlutterShop/Larsca/README.md");

        ftree.addFile("root/second_directory/Codeshop/FlutterShop/Larsca/lib/app.dart");
        ftree.addFile("root/second_directory/Codeshop/FlutterShop/Larsca/lib/main.dart");
        ftree.addFile("root/second_directory/Codeshop/FlutterShop/Larsca/lib/app_theme.dart");
        ftree.addFile("root/second_directory/Codeshop/FlutterShop/Larsca/lib/router.dart");
        ftree.addDir("root/second_directory/Codeshop/FlutterShop/Larsca/lib/pages");
        ftree.addFile("root/second_directory/Codeshop/FlutterShop/Larsca/lib/pages/home.dart");

        System.out.println(ftree);
    }

    //Using addDir method without initiliazing root directory
    public static void test1(){
        ftree.addDir("root/first_directory");
    }
    //Creating file as root
    public static void test2(){
        ftree = new FileSystemTree("root.txt");
    }
    //Creating file as root and adding directory after it as its child
    public static void test3(){
        ftree = new FileSystemTree("root.txt");
        ftree.addDir("root.txt/first_directory");
    }
    //Creating file as root and adding file after it as its child
    public static void test4(){
        ftree = new FileSystemTree("root.txt");
        ftree.addFile("root.txt/first_directory.txt");
    }
    //Creating directory as addFile method
    public static void test5(){
        ftree = new FileSystemTree("root");
        ftree.addFile("root/first_directory");
    }
    //Creating directory as addFile method
    public static void test6(){
        ftree = new FileSystemTree("root");
        ftree.addDir("root/first_directory.txt");
    }
    //Search method for search file
    public static void test7(){
        construct();
        ftree.search("home.dart");
    }
    //Search method for search directory
    public static void test8(){
        construct();
        ftree.search("directory");
    }
    //Remove method for remove empty directory
    public static void test9(){
        construct();
        ftree.remove("");
    }
    //Remove method for remove file
    public static void test10(){
        construct();
        ftree.remove("root/second_directory/Codeshop/FlutterShop/Larsca/lib/pages/home.dart");
    }
    //Remove method for remove empty directory
    public static void test11(){
        construct();
        ftree.remove("root/first_directory");
    }

    //Remove method for remove non-empty directory
    public static void test12(){
        construct();
        ftree.remove("root/second_directory/Codeshop");
        System.out.println(ftree);
    }
    //Remove method for remove root
    public static void test13(){
        construct();
        ftree.remove("root");
        System.out.println(ftree);
    }
}
