class TreeNode{

    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class LCABinaryTree {

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q)  return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(left != null && right != null)   return root;
        return left != null ? left : right;
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(3);
        TreeNode p = new TreeNode(5);
        root.left = p;
        root.right = new TreeNode(1);
        p.left = new TreeNode(6);
        p.right = new TreeNode(2);
        TreeNode q = new TreeNode(4);
        TreeNode node = p.right; node.left = new TreeNode(7); node.right = q;
        node = root.right;
        node.left = new TreeNode(0);
        node.right = new TreeNode(8);

        TreeNode resultNode = lowestCommonAncestor(root, p, q);
        System.out.println(resultNode.val);

    }

}
