package problems;

import java.util.ArrayList;

/*
 * Find the lowest common ancestor of 2 nodes in a binary tree.
 * No path to parent 
 * Locate each node path from the root and then look for diversion while traversing
 * the path lists
 */

public class LowestCommonAncestor {
    
    ArrayList<TreeNode> dfsStack = new ArrayList<>();
    boolean found = false;

    public void getLowestCommonAncestor (TreeNode root, int a, int b) {
        
        ArrayList<Integer> pathA = printPath(root, a);
        ArrayList<Integer> pathB = printPath(root, b);

        for (int i = 0; i < pathA.size() - 1 && i < pathB.size() - 1; i++) {
            if (pathA.get(i + 1) != pathB.get(i + 1)) {
                System.out.println("Loest common ancestor=" + pathA.get(i));
                break;
            }
        }
    }


    public boolean findPath(TreeNode root, ArrayList<Integer> path, int x) {

        if (root == null) {
            return false;
        }

        path.add(root.data);

        if (root.data == x) {
            System.out.println("found " + x);
            return true;
        } 
        
        if (findPath(root.left, path, x) || findPath(root.right, path, x)) {
            return true;
        }

        path.remove(path.size() - 1);
        return false;
    }

    public ArrayList<Integer> printPath(TreeNode root, int x)
    {
        // ArrayList to store the path
        ArrayList<Integer> path = new ArrayList<>();
     
        // if required node 'x' is present
        // then print the path
        if (findPath(root, path, x))
        {
            for (int i = 0; i < path.size() - 1; i++)    
                System.out.print(path.get(i) + "->");
            System.out.print(path.get(path.size() - 1));   
        }
        // 'x' is not present in the binary tree 
        else {
            System.out.print("No Path");
        }

        System.out.println("\npath arl = " + path);

        return path;
    }

    public static void main(String [] ar) {

        TreeNode root_2 = new TreeNode(10);
        root_2.left = new TreeNode(8);
        root_2.right = new TreeNode(15);

        root_2.left.left = new TreeNode(4);
        root_2.right.left = new TreeNode(14);
        root_2.right.right = new TreeNode(16);

        root_2.left.left.right = new TreeNode(5);
        root_2.left.left.left = new TreeNode(2);

        root_2.left.left.right.right = new TreeNode(6);

        // just to print path from root to node
        LowestCommonAncestor lca = new LowestCommonAncestor();
        //lca.printPath(root_2, 14);
        
        lca.getLowestCommonAncestor(root_2, 2, 6);
    }
}

class TreeNode {
    TreeNode left, right;
    int data;
    boolean visited = false;

    public TreeNode(int data) {
        this.data = data;
    }
}