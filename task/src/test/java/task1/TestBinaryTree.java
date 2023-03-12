package task1;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestBinaryTree {
    @Test
    public void testAddElement(){
        BinaryTree tree = new BinaryTree();
        tree.addNode(5);
        tree.addNode(3);
        tree.addNode(7);
        tree.addNode(8);
        String curAnswer = tree.getRoot().getLeftDes().getNodeVal() + " " + tree.getRoot().getNodeVal() + " " + tree.getRoot().getRightDes().getNodeVal()+ " " + tree.getRoot().getRightDes().getRightDes().getNodeVal();
        assertEquals("3 5 7 8", curAnswer);
    }

    @Test
    public void testDeleteElement(){
        BinaryTree tree = new BinaryTree();
        Node rightAnswerRoot = new Node();
        Node rightAnswerLeftDes = new Node();
        rightAnswerRoot.setNodeVal(7);
        rightAnswerLeftDes.setNodeVal(3);
        rightAnswerRoot.setLeftDes(rightAnswerLeftDes);
        tree.addNode(5);
        tree.addNode(3);
        tree.addNode(7);
        tree.delNode(5);
        String rightAnswer = rightAnswerRoot.getNodeVal() + " " + rightAnswerRoot.getLeftDes().getNodeVal();
        String curAnswer = tree.getRoot().getNodeVal() + " " + tree.getRoot().getLeftDes().getNodeVal();
        assertEquals(rightAnswer, curAnswer);
    }

    @Test
    public void testDeleteElementTwoDes(){
        BinaryTree tree = new BinaryTree();
        tree.addNode(10);
        tree.addNode(3);
        tree.addNode(2);
        tree.addNode(1);
        tree.addNode(5);
        tree.addNode(4);
        tree.addNode(6);
        tree.addNode(16);
        tree.delNode(3);
        String curAnswer =
                "leftRootSide: " + tree.getRoot().getLeftDes().getLeftDes().getLeftDes().getNodeVal() + " " + tree.getRoot().getLeftDes().getLeftDes().getNodeVal() +
                        " " + tree.getRoot().getLeftDes().getNodeVal() + " " + tree.getRoot().getLeftDes().getRightDes().getNodeVal() +
                        " " + tree.getRoot().getLeftDes().getRightDes().getRightDes().getNodeVal() + " root: " + tree.getRoot().getNodeVal() +
                        " rightRootSide: " + tree.getRoot().getRightDes().getNodeVal();
        assertEquals("leftRootSide: 1 2 4 5 6 root: 10 rightRootSide: 16", curAnswer);
    }

    @Test
    public void testDeleteElementOneDes(){
        BinaryTree tree = new BinaryTree();
        tree.addNode(10);
        tree.addNode(3);
        tree.addNode(12);
        tree.addNode(16);
        tree.addNode(18);
        tree.delNode(12);
        String curAnswer = tree.getRoot().getLeftDes().getNodeVal()+ " " + tree.getRoot().getNodeVal() + " " +
                tree.getRoot().getRightDes().getNodeVal() + " " + tree.getRoot().getRightDes().getRightDes().getNodeVal();
        assertEquals("3 10 16 18", curAnswer);
    }

    @Test
    public void testDeleteLeafElement(){
        BinaryTree tree = new BinaryTree();
        tree.addNode(10);
        tree.addNode(3);
        tree.addNode(12);
        tree.addNode(16);
        tree.addNode(18);
        tree.delNode(3);
        assertEquals(null, tree.getRoot().getLeftDes());
    }

    @Test
    public void testSearchElement(){
        BinaryTree tree = new BinaryTree();
        tree.addNode(5);
        tree.addNode(3);
        tree.addNode(7);
        assertTrue(tree.findNode(3));
    }

    @Test
    public void testSearchNeighbour(){
        BinaryTree tree = new BinaryTree();
        tree.addNode(6);
        tree.addNode(5);
        tree.addNode(3);
        tree.addNode(4);
        tree.addNode(2);
        tree.addNode(1);
        List<Node> rightAnswer = new ArrayList<>();
        rightAnswer.add(tree.getRoot().getLeftDes());
        rightAnswer.add(tree.getRoot().getLeftDes().getLeftDes().getLeftDes());
        rightAnswer.add(tree.getRoot().getLeftDes().getLeftDes().getRightDes());
        assertEquals(rightAnswer, tree.findNeighbour(3));
    }

    @Test
    public void testLeftDescendant(){
        BinaryTree tree = new BinaryTree();
        Node rightAnswerRoot = new Node();
        Node rightAnswerLeftDes = new Node();
        Node rightAnswerRightDes = new Node();
        rightAnswerRoot.setNodeVal(5);
        rightAnswerLeftDes.setNodeVal(3);
        rightAnswerRightDes.setNodeVal(7);
        rightAnswerRoot.setLeftDes(rightAnswerLeftDes);
        rightAnswerRoot.setRightDes(rightAnswerRightDes);
        tree.addNode(5);
        tree.addNode(3);
        tree.addNode(7);
        assertEquals(rightAnswerRoot.getLeftDes().getNodeVal(), tree.getRoot().getLeftDes().getNodeVal());
    }

    @Test
    public void testRightDescendant(){
        BinaryTree tree = new BinaryTree();
        tree.addNode(6);
        tree.addNode(5);
        tree.addNode(3);
        tree.addNode(4);
        tree.addNode(2);
        tree.addNode(1);
        assertEquals(4, tree.getRoot().getLeftDes().getLeftDes().getRightDes().getNodeVal());
    }



}
