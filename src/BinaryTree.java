import java.nio.file.NotDirectoryException;

public class BinaryTree {

    Node root;

    public void addNode(int key,String name){
        Node newNode = new Node(key,name);
        if(root==null){ //如果第一个根节点为空
            root=newNode;
        }else{
            Node focusNode=root;
            Node parent;
            while(true){
                parent =focusNode; // ==root
                if(key<focusNode.key){ //key < 根节点的值
                    focusNode = focusNode.leftChild;
                    if(focusNode == null){
                        parent.leftChild=newNode;
                        return;
                    }
                }else{ //key > 根节点的值
                    focusNode = focusNode.rightChild;
                    if(focusNode== null){
                        parent.rightChild=newNode;
                        return;
                    }
                }
            }
        }
    }

    public void inOrderTraverseTree(Node foucsNode){
        if(foucsNode != null){
            inOrderTraverseTree(foucsNode.leftChild);
            System.out.println(foucsNode);
            inOrderTraverseTree(foucsNode.rightChild);
        }
    }

    public void preOrderTraverseTree(Node foucsNode){
        if(foucsNode != null){
            System.out.println(foucsNode);
            preOrderTraverseTree(foucsNode.leftChild);
            preOrderTraverseTree(foucsNode.rightChild);
        }
    }

    public void postOrderTraverseTree(Node foucsNode){
        if(foucsNode != null){
            postOrderTraverseTree(foucsNode.leftChild);
            postOrderTraverseTree(foucsNode.rightChild);
            System.out.println(foucsNode);
        }
    }

    public Node findNode(int key){
        Node focusNode = root;
        while( focusNode.key !=key){
            if(key<focusNode.key){
                focusNode=focusNode.leftChild;
            }else {
                focusNode=focusNode.rightChild;
            }
            if(focusNode == null){
                return null;
            }
        }

            return focusNode;
    }

    public static void main(String[] args){
        BinaryTree theTree = new BinaryTree();
        theTree.addNode(50,"Boss");
        theTree.addNode(25,"VP");
        theTree.addNode(15,"Office Manager");
        theTree.addNode(70,"Secretary");
        theTree.addNode(90,"Stuff");
        theTree.postOrderTraverseTree(theTree.root);
        System.out.println("AAAAA: "+theTree.findNode(15));
    }
}

class Node{
    int key;
    String name;
    Node leftChild;
    Node rightChild;

    Node(int key, String name){
        this.key=key;
        this.name=name;
    }

    public String toString(){
        return name + " has a key "+ key;
    }

}