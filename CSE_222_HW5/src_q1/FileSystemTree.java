import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class FileSystemTree {
    /**
     * Root directory
     */
    private DirNode root;

    /**
     * Node class that has common methods of DirNode and FileNode
     */
    static abstract class Node implements NodeInterface{
        /**
         * Parent Node
         */
        private Node parent;
        /**
         * Index of parent
         */
        private int indexOfParent;

        /**
         * Getting Node
         * @param index index
         * @return Node
         */
        Node getNode(int index){
            return null;
        }

        /**
         * Setting Parent Node
         * @param parent Parent node
         */
        public void setParent(Node parent) {
            this.parent = parent;
        }

        /**
         * Setting index of parent
         * @param indexOfParent index
         */
        public void setIndexOfParent(int indexOfParent) {
            this.indexOfParent = indexOfParent;
        }

        /**
         * Add First Path, Parent Node and Index of Parent
         * @param firstPath First Path
         * @param parent Parent Node
         * @param indexOfParent Index of Parent Node
         */
        void add(String firstPath, Node parent, int indexOfParent){ }

    }

    /**
     * Directory Node class
     */
    static class DirNode extends Node {
        /**
         * Arraylist For hold Names
         */
        private ArrayList<String> nameList;
        /**
         * Arraylist for holding nodes
         */
        private ArrayList<Node> nodeList;

        /**
         * No parameter constructor for construct ArrayLists
         */
        DirNode(){
            nodeList = new ArrayList<>();
            nameList = new ArrayList<>();
        }

        /**
         * Add method for adding First Path, Parent Node and Index of Parent
         * @param firstPath First Path
         * @param parent Parent Node
         * @param indexOfParent Index of Parent Node
         */
        @Override
        public void add(String firstPath, Node parent, int indexOfParent){
            if(isFile(firstPath)){
                nodeList.add(new FileNode(firstPath));
            } else{
                nodeList.add(new DirNode());
            }
            setIndexOfParent(indexOfParent);
            setParent(parent);
            nameList.add(firstPath);
        }

        /**
         * Getting index of name
         * @param string name that will be found
         * @return Index of name that is given as parameter
         */
        @Override
        public int indexOf(String string){
            return nameList.indexOf(string);
        }

        /**
         * remove node as given parameter
         * @param name name of node will be deleted
         * @return name of node that is deleted
         */
        public String remove(String name) {
            String string = null;
            for(int i = 0; i< nameList.size(); ++i){
                if(getName(i).equals(name)){
                    string = nameList.remove(i);
                    nodeList.remove(i);
                }
            }
            return string;
        }

        /**
         * Getting name of that given index
         * @param index Index will be looked at
         * @return Name of that index
         */
        public String getName(int index){
            return nameList.get(index);
        }

        /**
         * Getting node of that index
         * @param index index that will be returned
         * @return Node
         */
        @Override
        Node getNode(int index){
            return nodeList.get(index);
        }

        /**
         * Getting Size of Nodes
         * @return Size of nodes
         */
        public int size(){
            return nodeList.size();
        }

        /**
         * Printing Names
         * @return String that will be printed
         */
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

    /**
     * FileNode class
     */
    private static class FileNode extends Node{
        /**
         * Name of file
         */
        private String name;

        /**
         * Constructor that take name
         * @param name name that will be set
         */
        FileNode(String name){
            this.name = name;

        }

        /**
         * Getting File Node
         * @param index Getting Node of that index
         * @return FileNode
         */
        @Override
        Node getNode(int index) {
            return this;
        }

        /**
         * Remove with that string
         * @param s string that will be deleted
         * @return deleted string
         */
        @Override
        public String remove(String s) {
            return null;
        }

        /**
         * Size of File Node
         * @return returns 1
         */
        @Override
        public int size() {
            return 1;
        }

        /**
         * Getting name at that index
         * @param i index that will be returned
         * @return Name of that file
         */
        @Override
        public String getName(int i) {
            return name;
        }

        /**
         * Index of name
         * @param string name of node
         * @return if string equals file node, return 0, otherwise, return -1
         */
        @Override
        public int indexOf(String string){
            if(string.equals(name))
                return 0;
            else
                return -1;
        }
    }

    /**
     * File System Tree Constructor
     * @param root Root name
     */
    FileSystemTree(String root){
        this.root = new DirNode();
        this.root.add(root,null, 0);
    }

    /**
     * Transition method for determine file or directory
     * @param path Path
     * @param reason if reason equals file, this method add file,
     *               if reason equals directory, this method add directory
     */
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

    /**
     * Add directory method
     * @param path Path
     */
    public void addDir(String path){
        crossRoad(path,"directory");
    }

    /**
     * Add file method
     * @param path Path
     */
    public void addFile(String path){
        crossRoad(path,"file");
    }

    /**
     * Method for adding directory or file
     * @param parsedArray String Array that is parsed by "/"s
     */
    private void add(String [] parsedArray){
        Node tempNode = root;
        String stringBefore = parsedArray[0];
        Node prevNode = root;
        int indexOfParent = 0;
        if(!stringBefore.equals(root.getName(0))){
            System.out.println(stringBefore + " is not " + root.getName(0));
            return;
        }
        while(parsedArray.length != 0){
            String firstPath = parsedArray[0];
            if(isFile(stringBefore) && isFile(firstPath)){
                System.out.println("It cannot be added after " + stringBefore);
                return;
            }
            int index = tempNode.indexOf(firstPath);
            if(index != -1){
                prevNode = tempNode;
                indexOfParent = index;
                tempNode = tempNode.getNode(index);
            }else{
                if(parsedArray.length == 1){
                    tempNode.add(firstPath,prevNode,indexOfParent);
                }
            }
            stringBefore = parsedArray[0];

            parsedArray = Arrays.copyOfRange(parsedArray, 1, parsedArray.length);
        }
    }

    /**
     * Search method for search file or directory
     * @param stringWillBeSearched Path
     */
    public void search(String stringWillBeSearched){
        Node node = root;
        searchRecursive(node,stringWillBeSearched);
    }

    /**
     * Recursive Search Function
     * @param node Root at the beginning
     * @param stringWillBeSearched Path
     */
    private void searchRecursive(Node node, String stringWillBeSearched) {
        ArrayList<Integer> indexes = find(node,stringWillBeSearched);
        if (indexes.size() > 0){
            Node tempNode = node;
            for (Integer index : indexes) {
                String nameOfString = node.getName(index);
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
                node = tempNode;
            }
        }
        for(int j = 0 ; j< node.size(); ++j)
            if(node.getNode(j) instanceof DirNode)
                searchRecursive(node.getNode(j), stringWillBeSearched);

    }

    /**
     * Finding Node with given name
     * @param node Node that will be searched
     * @param searchString name that will be searched
     * @return Arraylist Integer with all indexes that has same name at that directory
     */
    private static ArrayList<Integer> find(Node node, String searchString) {
        ArrayList<Integer> indexes = new ArrayList<>();
        for(int i=0 ; i < node.size() ; ++i){
            if (node.getName(i).contains(searchString)) {
                indexes.add(i);
            }
        }
        return indexes;
    }

    /**
     * Return if input is file or not
     * @param input name of Node
     * @return returns true if input is file, returns false if input is directory
     */
    private static boolean isFile(String input){
        return input.indexOf('.') != -1;
    }

    /**
     * Remove Node that in that path
     * @param path path will be removed
     */
    public void remove(String path){
        traverseFileSystem(root,path.split("/"));
    }

    /**
     * Recursive function for traverse FileSystemTree
     * and find if path is true or not and remove file
     * at the end of the string
     * @param node Node that will be traversed
     * @param parsedArray parsed array that will be find its path
     * @return String filename or directory name that is deleted
     */
    private String traverseFileSystem(Node node,String [] parsedArray){
        for(int j = 0 ; j< node.size(); ++j) {
            if (node.getName(j).equals(parsedArray[0])) {
                if (parsedArray.length == 1) {
                    if (node.getNode(j).size() == 0 || (node.getNode(j).size() == 1 && node.getNode(0) instanceof FileNode)) {
                    } else {
                        System.out.println("Do you want to delete all subdirectories and subfiles connected to " + parsedArray[0] + "?");

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

    /**
     * Overriden toString method
     * @return empty string
     */
    @Override
    public String toString(){
        printFileSystem(root);
        return "";
    }

    /**
     * Printing file system
     * @param node root
     */
    private void printFileSystem(Node node){
        if(node.equals(root)){
            System.out.print(node);
            if(node.size() != 0)
                printFileSystem(node.getNode(0));
        }else{
            for(int j = 0 ; j< node.size(); ++j) {
                Node temp= node;
                int length = 0;
                while(!node.equals(root)){
                    length = node.parent.getName(node.indexOfParent).length();
                    for(int a = 0; a < length;++a)
                        System.out.print("-");
                    node = node.parent;
                }
                node = temp;
                System.out.println(node.getName(j));
                if(node.getNode(j).size() > 0 && node.getNode(j) instanceof DirNode){
                    printFileSystem(node.getNode(j));
                }
            }
        }
    }
}