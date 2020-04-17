import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class FileSystemTree {
    private FileNode root;

    FileNode getRoot(){
        return root;
    }

    private static class FileNode{
        private ArrayList<String> nameList;
        private FileNode parent;
        private int indexOfParent;
        private ArrayList<FileNode> directoryList;

        FileNode(){
            directoryList = new ArrayList<>();
            nameList = new ArrayList<>();
        }
        void add(String firstPath, FileNode parent, int indexOfParent){
            directoryList.add(new FileNode());
            nameList.add(firstPath);
            this.parent = parent;
            this.indexOfParent = indexOfParent;
        }

        /**
         * remove node as given parameter
         * @param name name of node will be deleted
         * @return name of node that is deleted
         */
        String remove(String name) {
            String string = null;
            for(int i = 0; i< nameList.size(); ++i){
                if(getName(i).equals(name)){
                    string = nameList.remove(i);
                    directoryList.remove(i);
                }
            }
            return string;
        }
        String getName(int index){
            return nameList.get(index);
        }
        FileNode getNode(int index){
            return directoryList.get(index);
        }
        int size(){
            return directoryList.size();
        }

        @Override
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            for(int i = 0; i< size(); ++i){
                if(i != size() - 1){
                    stringBuilder.append(getName(i)).append(" -> ");
                }else{
                    stringBuilder.append(getName(i)).append("\n");
                }
            }
            return stringBuilder.toString();
        }
    }
    FileSystemTree(String root){
        this.root = new FileNode();
        this.root.add(root,null, 0);
    }

    private void crossRoad(String path, String reason) {
        String[] parsedArray = path.split("/");

        if (reason.equals("file") && isFile(parsedArray[parsedArray.length - 1]) ) {
            add(parsedArray);
        } else if(reason.equals("directory") && !isFile(parsedArray[parsedArray.length - 1])){
            add(parsedArray);
        } else{
            System.out.println(parsedArray[parsedArray.length - 1] + " is not a " + reason);
        }
    }
    public void addDir(String path){
        crossRoad(path,"directory");
    }
    public void addFile(String path){
        crossRoad(path,"file");
    }

    private void add(String [] parsedArray){
        FileNode tempFileNode = root;
        String stringBefore = parsedArray[0];
        FileNode prevNode = root;
        int indexOfParent = 0;
        if(!stringBefore.equals(root.getName(0))){
            System.out.println(stringBefore + " is not " + root.getName(0));
            return;
        }
        while(parsedArray.length != 0){
            String firstPath = parsedArray[0];
            if(isFile(stringBefore) && isFile(firstPath)){
                System.out.println(firstPath + " directory cannot be added after " + stringBefore);
                return;
            }
            int index = tempFileNode.nameList.indexOf(firstPath);
            if(index != -1){
                prevNode = tempFileNode;
                indexOfParent = index;
                tempFileNode = tempFileNode.directoryList.get(index);
            }else{
                if(parsedArray.length == 1){
                    tempFileNode.add(firstPath,prevNode,indexOfParent);
                }
            }
            stringBefore = parsedArray[0];

            parsedArray = Arrays.copyOfRange(parsedArray, 1, parsedArray.length);
        }
    }

    public void search(String stringWillBeSearched){
        FileNode node = root;
        searchRecursive(node,stringWillBeSearched);
    }

    private void searchRecursive(FileNode node, String stringWillBeSearched) {
        int index = find(node.nameList,stringWillBeSearched);
        FileNode tempNode = node;
        if(index != -1){
            String nameOfString = node.nameList.get(index);
            StringBuilder path = new StringBuilder();
            while(!node.equals(root)){
                path.append(node.parent.getName(node.indexOfParent)).append("/");
                node = node.parent;
            }
            String temp = path.toString();
            path = new StringBuilder(ReverseString.reverseString(temp,new StringBuilder()));
            path.append(nameOfString).append("\n");
            if(isFile(nameOfString))
                path.insert(0,"file - ");
            else
                path.insert(0, "dir - ");
            System.out.print(path.toString());
        }
        node = tempNode;
        if(node.size() > 0){
            for(int j = 0 ; j< node.size(); ++j)
                searchRecursive(node.getNode(j), stringWillBeSearched);
        }

    }
    private static int find(ArrayList<String> list, String searchString) {
        for(int i=0 ; i < list.size() ; ++i){
            if (list.get(i).contains(searchString)) {
                return i;
            }
        }
        return -1;
    }
    private boolean isFile(String input){
        return input.indexOf('.') != -1;
    }

    public void remove(String path){
        traverseFileSystem(root,path.split("/"));
    }

    /**
     * Recursive function for traverse FileSystemTree
     * and find if path is true or not and remove file
     * at the end of the string
     * @param node FileNode that will be traversed
     * @param parsedArray parsed array that will be find its path
     * @return String filename or directory name that is deleted
     */
    private String traverseFileSystem(FileNode node,String [] parsedArray){
        for(int j = 0 ; j< node.size(); ++j) {
            if (node.getName(j).equals(parsedArray[0])) {
                if (parsedArray.length == 1) {
                    switch (node.getNode(j).nameList.size()) {
                        case 0:
                            break;
                        default:
                            System.out.println("Do you want to delete all directories and files connected to " + parsedArray[0] + "?");
                            Scanner scanner = new Scanner(System.in);
                            char val = scanner.next().toCharArray()[0];
                            while (true) {
                                if (val == 'N' || val == 'n') {
                                    System.out.println(parsedArray[0] + " is not deleted");
                                    return "";
                                } else if (val == 'Y' || val == 'y') {
                                    node.remove(parsedArray[0]);
                                    System.out.println(parsedArray[0] + " is deleted");
                                    return parsedArray[0];
                                } else {
                                    System.out.println("Wrong input");
                                    val = scanner.next().toCharArray()[0];
                                }
                            }
                    }
                    node.remove(parsedArray[0]);
                    System.out.println(parsedArray[0] + " is deleted");
                    return parsedArray[0];
                }
                parsedArray = Arrays.copyOfRange(parsedArray, 1, parsedArray.length);
                return traverseFileSystem(node.getNode(j), parsedArray);
            }
        }
        if(isFile(parsedArray[0]))
            System.out.println("No such file named " + parsedArray[0]);
        else
            System.out.println("No such directory named " + parsedArray[0]);
        return parsedArray[0];
    }

    @Override
    public String toString(){
        printFileSystem(root);
        return "";
    }
    private void printFileSystem(FileNode node){
        if(node.equals(root)){
            System.out.print(node);
            if(node.size() != 0)
                printFileSystem(node.getNode(0));
        }else{
            for(int j = 0 ; j< node.size(); ++j) {
                FileNode temp= node;
                int length = 0;
                while(!node.equals(root)){
                    length = node.parent.getName(node.indexOfParent).length();
                    for(int a = 0; a < length;++a)
                        System.out.print("-");
                    node = node.parent;
                }
                node = temp;
                System.out.println(node.getName(j));
                if(node.getNode(j).size() > 0){
                    printFileSystem(node.getNode(j));
                }
            }
        }
    }
}