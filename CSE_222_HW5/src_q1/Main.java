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
        //myFileSystem.search("Dir");
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

    }
}
