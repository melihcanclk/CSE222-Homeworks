import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class FileSystemTree {
    private DirNode root;

    static abstract class Node implements NodeInterface{
        private Node parent;
        private int indexOfParent;

        Node getNode(int index){
            return null;
        }

        public void setParent(Node parent) {
            this.parent = parent;
        }

        public void setIndexOfParent(int indexOfParent) {
            this.indexOfParent = indexOfParent;
        }

        void add(String firstPath, Node parent, int indexOfParent){ }

    }

    static class DirNode extends Node {
        private ArrayList<String> nameList;
        private ArrayList<Node> nodeList;

        DirNode(){
            nodeList = new ArrayList<>();
            nameList = new ArrayList<>();
        }
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

        public String getName(int index){
            return nameList.get(index);
        }

        @Override
        Node getNode(int index){
            return nodeList.get(index);
        }

        public int size(){
            return nodeList.size();
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

    private static class FileNode extends Node{
        private String name;

        FileNode(String name){
            this.name = name;

        }

        @Override
        Node getNode(int index) {
            return this;
        }

        @Override
        public String remove(String s) {
            return null;
        }

        @Override
        public int size() {
            return 1;
        }

        @Override
        public String getName(int i) {
            return name;
        }

        @Override
        public int indexOf(String string){
            if(string.equals(name))
                return 0;
            else
                return -1;
        }
    }


    FileSystemTree(String root){
        this.root = new DirNode();
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

    public void search(String stringWillBeSearched){
        Node node = root;
        searchRecursive(node,stringWillBeSearched);
    }

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
    private static ArrayList<Integer> find(Node node, String searchString) {
        ArrayList<Integer> indexes = new ArrayList<>();
        for(int i=0 ; i < node.size() ; ++i){
            if (node.getName(i).contains(searchString)) {
                indexes.add(i);
            }
        }
        return indexes;
    }
    private static boolean isFile(String input){
        return input.indexOf('.') != -1;
    }

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

    @Override
    public String toString(){
        printFileSystem(root);
        return "";
    }
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