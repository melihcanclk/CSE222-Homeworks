public class Main {
    public static void main(String[] args) {
        FileSystemTree myFileSystem = new FileSystemTree("root");
        myFileSystem.addDir("root/firstDir");
        myFileSystem.addDir("root/secondDir");
        myFileSystem.addFile("root/firstFile.txt");
        //myFileSystem.addDir("root/firstFile.txt/a");
        myFileSystem.addDir("root/secondDir/thirdDir");
        myFileSystem.addDir("root/secondDir/thirdDir/fourthDir");
        myFileSystem.addFile("root/firstDir/a.js");
        //myFileSystem.addFile("a/x.txt");
        //myFileSystem.printFileSystem(myFileSystem.getRoot());
        myFileSystem.search("Dir");
        System.out.println(myFileSystem);
        myFileSystem.remove("root/firstDir/a.js");
        System.out.println(myFileSystem);
        myFileSystem.remove("root/secondDir");
        System.out.println(myFileSystem);

/*
//Create a file system with root directory
        FileSystemTree myFileSystem = new FileSystemTree("root");
//Add directories and files using paths
        myFileSystem.addDir("root/first_directory");
        myFileSystem.addDir("root/second_directory");
        myFileSystem.addFile("root/first_directory/new_file.txt");
        myFileSystem.addDir("root/second_directory/new_directory");
        myFileSystem.addFile("root/second_directory/new_directory/new_file.doc");

        System.out.println(myFileSystem);
        myFileSystem.search("new");

        myFileSystem.remove("root/first_directory/new_file.txt");
        System.out.println(myFileSystem);

        myFileSystem.remove("root/second_directory/new_directory");
        System.out.println(myFileSystem);
*/

/*
        FileSystemTree ftree = new FileSystemTree("root");

        ftree.addDir("root/first_directory");
        ftree.addDir("root/second_directory");
        ftree.addDir("root/first_directory/new_file.txt");
        ftree.addDir("root/second_directory/new_directory");
        ftree.addDir("root/third_directory/");
        ftree.addFile("root/third_directory/foo.txt");
        ftree.addFile("root/second_directory/new_directory/new_file.doc");

        ftree.addDir("root/second_directory/Codeshop");
        ftree.addDir("root/second_directory/Codeshop/FlutterShop");
        ftree.addDir("root/second_directory/Codeshop/FlutterShop/Larsca");
        ftree.addDir("root/second_directory/Codeshop/FlutterShop/Larsca/lib");
        ftree.addDir("root/second_directory/Codeshop/FlutterShop/Larsca/.git");
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

        ftree.remove("root/second_directory");

        System.out.println(ftree);

 */
    }
}
