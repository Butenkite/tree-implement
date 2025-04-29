

public class Traversal {
  public static void main(String[] args) {

    TreeNode root = new TreeNode(10, null, null);
    root.left = new TreeNode(15);
    root.left.left = new TreeNode(39);
    root.left.right = new TreeNode(21);
    root.right = new TreeNode(20);
    root.right.left = new TreeNode(72);
    root.right.left.right = new TreeNode(42);
    preOrder(root);
    System.out.println("-----");
    postOrder(root);
  }

  public static void preOrder(TreeNode current){
    if (current == null) return;
    System.out.println(current.value);
    preOrder(current.left);
    preOrder(current.right);
  }

  public static void postOrder(TreeNode current){
    if (current == null) return;
    postOrder(current.left);
    postOrder(current.right);
    System.out.println(current.value);
  }
}
