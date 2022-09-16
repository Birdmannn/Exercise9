import textio.TextIO;

public class ReadWord2 {

    private static class TreeNode {
        String item;
        TreeNode left;
        TreeNode right;
        TreeNode(String str) {
            item = str;
        }
    }

    private static TreeNode root;

    public static void main(String[] args) {
        boolean check, proceed;
        String str;

        System.out.println("This program will let you select a file to read, and will compute a sorted list of words in it.");
        System.out.print("Do you wish to proceed? ");
        proceed = TextIO.getlnBoolean();

        if(!proceed) {
            System.out.println("Goodbye.");
        }
        else {
            check = TextIO.readUserSelectedFile();
            if(!check) {
                System.out.println("No file was selected.");
            }
            else {
                while(true) {
                    str = readNextWord();
                    if(str == null)
                        break;
                    str = str.toLowerCase();
                    if(!treeContains(root, str))
                        treeInsert(str);
                }
                TextIO.writeUserSelectedFile();
                TextIO.putln("words in file: \n");
                treeList(root);
                TextIO.putln("\nThere are " + countNodes(root) + " words in the file.");
                TextIO.writeStandardOutput();
                System.out.println("End of Program...");
            }
        }
    }

    private static void treeInsert(String newItem) {
        if(root == null) {
            //The tree is empty. Set root to point to a new node containing the new item. This becomes the only node in the tree.
            root = new TreeNode(newItem);
            return;
        }
        TreeNode runner;
        runner = root;
        while(true) {
            if(newItem.compareTo(runner.item) < 0) {
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


    private static String readNextWord() {
        char ch = TextIO.peek();
        while (ch != TextIO.EOF && !Character.isLetter(ch)) {
            //Skip past non-letters.
            TextIO.getAnyChar();
            ch = TextIO.peek();
        }
        if(ch == TextIO.EOF)
            return null;

        String word = "";
        while (true) {
            word += TextIO.getAnyChar();
            ch = TextIO.peek();
            if(ch == '\'') {
                TextIO.getAnyChar();
                ch = TextIO.peek();

                if(Character.isLetter(ch)) {
                    word += "\'" + TextIO.getAnyChar();
                    ch = TextIO.peek();
                }
                else
                    break;
            }
            if(!Character.isLetter(ch)) {
                //If the next character is not a letter, the word is finished, so break out of the loop.
                break;
            }
            // If we haven't broken out of the loop, next char is a letter.
        }
        return word;    // Return word that has been read.
    }

    private static void treeList(TreeNode node) {
        if(node != null) {
            treeList(node.left);
            TextIO.putln(" " + node.item);
            treeList(node.right);
        }
    }
    private static int countNodes(TreeNode node) {
        if(node == null) {
            return 0;
        }
        else {
            //Add up the root node and the nodes in its two subtrees
            int leftCount = countNodes(node.left);
            int rightCount = countNodes(node.right);
            return 1+leftCount+rightCount;
        }
    }
    static boolean treeContains(TreeNode root, String item) {
        if(root == null) {
            return false;
        }
        else if(item.equals(root.item)) {
            return true;
        }
        else if(item.compareTo(root.item) < 0) {
            return treeContains(root.left, item);
        }
        else {
            return treeContains(root.right, item);
        }
    }
}
