public class DepthAnalysis {

    private static class TreeNode {
        double item;
        TreeNode left;
        TreeNode right;
        TreeNode(double item) {
            this.item = item;
        }
    }

    private static TreeNode root;

    public static void main(String[] args) {

        for(int i = 0; i < 1023; i++) {
            treeInsert(Math.random());
        }

        System.out.println("Number of leaves: " + countLeaves(root));
        System.out.println("Average depth:    " + (double)(depthSum(root,0)/countLeaves(root)));
        System.out.println("Maximum depth:    " + maximumDepth(root,0));

    }
    static int countLeaves(TreeNode node) {    //this routine only counts the leaves, returns 1, else recall the subroutine.
        if(node == null)
            return 0;
        else if(node.left == null && node.right == null)   //then it's a leaf node
            return 1;
        else
            return countLeaves(node.left) + countLeaves(node.right);
    }

    //Check this:
    static int depthSum(TreeNode node, int depth) {
        if(node == null) {
            return 0;    //the tree is empty and there are no leaves.
        }
        else if(node.left == null && node.right == null) {
            //the node is a leaf, and there are no subtrees of the node, so the sum of the leaf depths is just the depth of this node.
            return depth;
        }
        else {
            return depthSum(node.left, depth + 1) + depthSum(node.right, depth + 1);
        }
    }

    static int maximumDepth(TreeNode node, int depth) {
        if(node == null) {
            return 0;
        }
        else if(node.right == null && node.left == null) {
            return depth;
        }
        else {
            int leftMax = maximumDepth(node.left,depth+1);
            int rightMax = maximumDepth(node.right,depth+1);
            if(leftMax > rightMax)
                return leftMax;
            else
                return rightMax;
        }
    }
    private static void treeInsert(double newItem) {
        if(root == null) {
            //The tree is empty. Set root to point to a new node containing the new item. This becomes the only node in the tree.
            root = new TreeNode(newItem);
            return;
        }
        TreeNode runner;
        runner = root;
        while(true) {
            if(newItem < runner.item) {
                if(runner.left == null) {
                    runner.left = new TreeNode(newItem);
                    return;
                }
                else
                    runner = runner.left;
            }
            else {
                if(runner.right == null) {
                    runner.right = new TreeNode(newItem);
                    return;
                }
                else
                    runner = runner.right;
            }
        }
    }

}
