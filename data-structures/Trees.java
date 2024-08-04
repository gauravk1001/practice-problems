import java.util.ArrayList;

public class Trees {

    TreeNode root;

    public TreeNode createTree(int[] arr) {

        // for (int i = 0; i < arr.length; i++) {
        TreeNode root = build(0, arr);
        // }

        return root;
    }

    public TreeNode build(int i, int[] arr) {

        TreeNode t = new TreeNode(arr[i]);
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < arr.length) {
            t.left = build(left, arr);
        }
        if (right < arr.length) {
            t.right = build(right, arr);
        }

        return t;
    }

    void inOrderTraversal(TreeNode node) {
        if (node != null) {
            inOrderTraversal(node.left);
            System.out.print(node.data + ", ");
            inOrderTraversal(node.right);
        }
    }

    void preOrderTraversal(TreeNode node) {
        if (node != null) {
            System.out.print(node.data + ", ");
            preOrderTraversal(node.left);
            preOrderTraversal(node.right);
        }
    }

    void postOrderTraversal(TreeNode node) {
        if (node != null) {
            postOrderTraversal(node.left);
            postOrderTraversal(node.right);
            System.out.print(node.data + ", ");
        }
    }

    ArrayList<TreeNode> q = new ArrayList<>();

    void bfs(TreeNode root, int find) {
        if (root == null) {
            return;
        }

        for (TreeNode a : q) {
            System.out.println("traversing=" + a);
            if (find == a.data) {
                System.out.println("found=" + a);
                break;
            }
            q.add(a.left);
            q.add(a.right);
        }
    }

    void dfs(TreeNode root, int find) {
        if (root == null) {
            return;
        }

        // visit(root);
        // not finished; pseudo code
        root.visited = true;
        q = new ArrayList<>();
        for (TreeNode a : q) {
            if (!a.visited) {
                dfs(a, find);
            }
        }
    }

    public static void main(String args[]) {
        Trees t = new Trees();

        TreeNode tn = t.createTree(new int[] { 10, 5, 20, 3, 7, 30 });
        t.inOrderTraversal(tn);
        System.out.println();
        t.preOrderTraversal(tn);
        System.out.println();
        t.postOrderTraversal(tn);
    }

}

class TreeNode {
    TreeNode left, right;
    int data;
    boolean visited;

    public TreeNode(int data) {
        this.data = data;
        this.visited = false;
    }

}
