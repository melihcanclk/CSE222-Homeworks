import java.util.ArrayList;
import java.util.Arrays;

public class FileSystemTree {
    FileNode root;

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
        String remove(String name) {
            String string = null;
            for(int i = 0; i< nameList.size(); ++i){
                if(nameList.get(i).equals(name)){
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
            for (String s : nameList) {
                stringBuilder.append(s).append(" -> ");
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
        if(!stringBefore.equals(root.nameList.get(0))){
            System.out.println(stringBefore + " is not " + root.nameList.get(0));
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
                path.append(node.parent.nameList.get(node.indexOfParent)).append("/");
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
    public void printFileSystem(FileNode node){
        if(node.equals(root)){
            System.out.println(node);
            printFileSystem(node.getNode(0));
        }else{

            System.out.print(node);
            for(int j = 0 ; j< node.size(); ++j){
                printFileSystem(node.getNode(j));
            }
        }

    }

}