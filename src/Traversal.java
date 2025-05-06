public class Traversal {
  public static void main(String[] args) {
    TreeNode<Integer> root = new TreeNode<>(10, null, null);
    root.left = new TreeNode<>(15);
    root.left.left = new TreeNode<>(39);
    root.left.right = new TreeNode<>(21);

    root.right = new TreeNode<>(20);
    root.right.left = new TreeNode<>(72);
    root.right.left.right = new TreeNode<>(42);

    TreeNode<String> stringRoot = new TreeNode<>("hello", null, null);
    stringRoot.left = new TreeNode<>("cat");
    stringRoot.left.left = new TreeNode<>("miku");
    stringRoot.left.right = new TreeNode<>("dog");

    stringRoot.right = new TreeNode<>("cyborg");
    stringRoot.right.left = new TreeNode<>("jays");
    stringRoot.right.left.right = new TreeNode<>("robocop");

    System.out.println(countNodes(root));
  }

  public static void preOrder(TreeNode<?> current) {
    if(current == null) return;
    System.out.println(current.value);
    preOrder(current.left);
    preOrder(current.right);
  }

  public static <T> void postOrder(TreeNode<T> current) {
    if(current == null) return;
    TreeNode<T> duplicate = new TreeNode<>(current.value);
    T heldValue = current.value;
    postOrder(current.left);
    postOrder(current.right);
    System.out.println(current.value);
  }

  public static void inOrder(TreeNode<?> current) {
    if(current == null) return;
    inOrder(current.left);
    System.out.println(current.value);
    inOrder(current.right);
  }

  public static void greaterThan(TreeNode<Integer> current, int limit){
    if(current == null) return;
    if(current.value > limit) System.out.println(current.value);
    greaterThan(current.left, limit);
    greaterThan(current.right, limit);
  }

  public static int countNodes(TreeNode<?> current){
    if(current == null) return 0;
    int leftCount = countNodes(current.left);
    int rightCount = countNodes(current.right);
    int totalCount = leftCount + rightCount + 1;
    return totalCount;
  }
}
