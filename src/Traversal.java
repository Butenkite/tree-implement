import java.util.*;
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

    TreeNode<Integer> megaRoot = new TreeNode<>(1);
    TreeNode<Integer> current = megaRoot;
    for(int i = 2; i < 30001; i++){
      TreeNode<Integer> node = new TreeNode<>(i);
      current.right = node;
      current = current.right;
    }

    Set<Integer> set = convertToSet(root);
    System.out.println(set);

  }

  public static void preOrderIter(TreeNode<?> current){
    Stack<TreeNode<?>> stack = new Stack<>();
    stack.push(current);

    while(!stack.isEmpty()){
      TreeNode<?> node = stack.pop();
      if(node == null) continue;
      System.out.println(node.value);
      stack.push(node.right);
      stack.push(node.left);
    }
  }

  public static <T> Set<T> convertToSet(TreeNode<T> root){
    Set<T> set = new HashSet<>();

    convertToSetHelper(root, set);

    return set;
  }

  public static int countDistinctValues(TreeNode<?> root){
    Set<?> values = convertToSet(root);
    return values.size();
  }

  public static <T> void convertToSetHelper(TreeNode<T> current, Set<T> set){
    if(current == null) return;
    set.add(current.value);
    convertToSetHelper(current.left, set);
    convertToSetHelper(current.right, set);
  }

  public static void levelOrderIter(TreeNode<?> current){
    Queue<TreeNode<?>> queue = new LinkedList<>();
    queue.add(current);

    while(!queue.isEmpty()){
      TreeNode<?> node = queue.poll();
      if(node == null) continue;
      System.out.println(node.value);
      queue.add(node.left);
      queue.add(node.right);
    }
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
