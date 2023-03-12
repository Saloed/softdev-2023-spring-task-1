package task1;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class BinaryTree {
    private Node root;

    public BinaryTree(){
        root = null;
    }

    public void addNode(int nodeVal) {
        Node newNode = new Node();
        newNode.setNodeVal(nodeVal);
        if (root == null) {
            root = newNode;
        }
        else{
            Node curNode = root;
            Node ancestorNode;
            while (true){
                ancestorNode = curNode;
                if (nodeVal == curNode.getNodeVal()) return;
                else if (curNode.getNodeVal() < nodeVal) {
                    curNode = curNode.getRightDes();
                    if (curNode == null) {
                        ancestorNode.setRightDes(newNode);
                        return;
                    }
                }
                else {
                    curNode = curNode.getLeftDes();
                    if (curNode == null) {
                        ancestorNode.setLeftDes(newNode);
                        return;
                    }
                }
            }
        }
    }

    public boolean delNode(int nodeVal) {
        Node curNode = root;
        Node ancestorNode = root;
        short leftOrRight = 0;
        while (nodeVal != curNode.getNodeVal()) {
            ancestorNode = curNode;
            if (nodeVal > curNode.getNodeVal()) {
                curNode = curNode.getRightDes();
                leftOrRight = 1;
            }
            else {
                curNode = curNode.getLeftDes();
                leftOrRight = 2;
            }
            if (curNode == null)
                return false;
        }

        if (curNode.getRightDes() == null && curNode.getLeftDes() == null) {
            if (curNode == root)
                root = null;
            else if (leftOrRight == 2)
                ancestorNode.setLeftDes(null);
            else
                ancestorNode.setRightDes(null);

        }
        else if (curNode.getRightDes() == null) {
            if (curNode == root)
                root = curNode.getLeftDes();
            if (leftOrRight == 1)
                ancestorNode.setRightDes(curNode.getLeftDes());
            else if (leftOrRight == 2)
                ancestorNode.setLeftDes(curNode.getLeftDes());
        }
        else if (curNode.getLeftDes() == null) {
            if (curNode == root)
                root = curNode.getRightDes();
            if (leftOrRight == 1)
                ancestorNode.setRightDes(curNode.getRightDes());
            else if (leftOrRight == 2)
                ancestorNode.setLeftDes(curNode.getRightDes());
        }
        else {
            Node replaceNode = curNode.getRightDes();
            Node parNode = curNode;
            while (replaceNode.getLeftDes() != null) {
                parNode = replaceNode;
                replaceNode = replaceNode.getLeftDes();
            }
            if (replaceNode != curNode.getRightDes()) {
                parNode.setLeftDes(replaceNode.getRightDes());
                replaceNode.setRightDes(curNode.getRightDes());
            }
            replaceNode.setLeftDes(curNode.getLeftDes());
            if (curNode == root)
                root = replaceNode;
            else if (leftOrRight == 1)
                ancestorNode.setRightDes(replaceNode);
            else
                ancestorNode.setLeftDes(replaceNode);
        }
        return true;
    }

    public Boolean findNode(int nodeVal) {
        Node curNode = root;
        Node ancestorNode = root;
        while (nodeVal != curNode.getNodeVal()) {
            ancestorNode = curNode;
            if (nodeVal > curNode.getNodeVal()) {
                curNode = curNode.getRightDes();
            }
            else {
                curNode = curNode.getLeftDes();
            }
            if (curNode == null) return false;
        }
        return true;

    }

    public List<Node> findNeighbour(int nodeVal) {
        List<Node> alr = new ArrayList<>();
        Node curNode = root;
        Node ancestorNode = root;
        while (nodeVal != curNode.getNodeVal()) {
            ancestorNode = curNode;
            if (nodeVal > curNode.getNodeVal()) {
                curNode = curNode.getRightDes();
            }
            else {
                curNode = curNode.getLeftDes();
            }
            if (curNode == null) return null;
        }
        if (curNode != ancestorNode) {
            alr.add(ancestorNode);
            alr.add(curNode.getLeftDes());
            alr.add(curNode.getRightDes());
        }
        else {
            alr.add(null);
            alr.add(curNode.getLeftDes());
            alr.add(curNode.getRightDes());
        }
        System.out.println(alr.toString());
        return alr;

    }

    public Node getRoot() {
        return root;
    }
}
