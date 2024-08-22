package problems;

import java.util.ArrayList;
import java.util.TreeMap;

public class LevelOrderBTree {

    
    private void traverseLevelOrder(Node root, TreeMap<Integer, ArrayList<Integer>> levelOrder, int level) {

        if (root == null) {
            return;
        }

        ArrayList<Integer> a;
        if (levelOrder.get(level) == null) {
            a = new ArrayList<Integer>();            
        } else {
            a = levelOrder.get(level);
        }

        a.add(root.data);
        levelOrder.put(level, a);

        traverseLevelOrder(root.left, levelOrder, level + 1);
        traverseLevelOrder(root.right, levelOrder, level + 1);
    } 

    public static void main(String[] ar) {

        Node root_2 = new Node(10);
        root_2.left = new Node(8);
        root_2.right = new Node(15);
        root_2.left.left = new Node(4);
        root_2.left.left.right = new Node(5);
        root_2.left.left.right.right = new Node(6);
        root_2.right.left = new Node(14);
        root_2.right.right = new Node(16);

        LevelOrderBTree lo = new LevelOrderBTree();

        TreeMap<Integer, ArrayList<Integer>> levelOrder = new TreeMap<>();
        lo.traverseLevelOrder(root_2, levelOrder, 1);

        System.out.println(levelOrder.toString());
    }
}

class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}