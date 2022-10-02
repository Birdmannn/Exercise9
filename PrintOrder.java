import textio.TextIO;
public class PrintOrder {


    private static TreeNode root;
    private static QueueOfTreeNodes nQ;

    public static void main(String[] args) {
        boolean answer;

        nQ = new QueueOfTreeNodes();
        System.out.println("Test run print order.");
        treeInsert(5);
        for(int i = 0; i < 9; i++) {
            int rand = i+1;
            if(rand > 4)
                rand += 1;
            treeInsert(rand);
        }

        System.out.println("Items in original list.");
        treeList(root);

        System.out.print("This program will print an unknown traversal.\nDo you wish to Continue?");
        answer = TextIO.getlnBoolean();
        System.out.println();
        if(answer)
            printOrder();

        System.out.print("\nEnd of program.");
    }

    private static void treeList(TreeNode node) {
        if(node != null) {
            treeList(node.left);
            TextIO.putln(" " + node.item);
            treeList(node.right);
        }
    }

    static void printOrder() {
        nQ.enqueue(root);

        while(!nQ.isEmpty()) {
            TreeNode temp = nQ.dequeue();
            System.out.println(temp.item);
            if(temp.left != null)
                nQ.enqueue(temp.left);
            if(temp.right != null)
                nQ.enqueue(temp.right);
        }
    }

    private static void treeInsert(int newItem) {
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
