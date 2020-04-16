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
    }
}
