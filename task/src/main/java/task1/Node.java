package task1;

public class Node {
    private int nodeVal;
    private Node leftDes;
    private Node rightDes;

    public void setNodeVal(int nodeVal){
        this.nodeVal = nodeVal;
    }

    public void setLeftDes(Node leftDes){
        this.leftDes = leftDes;
    }

    public void setRightDes(Node rightDes){
        this.rightDes = rightDes;
    }

    public int getNodeVal(){
        return this.nodeVal;
    }

    public Node getLeftDes(){
        return this.leftDes;
    }

    public Node getRightDes(){
        return this.rightDes;
    }
}

