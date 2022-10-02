import textio.TextIO;


public class PrintReversedNode {

    private static class ListNode {
        int item;
        ListNode next;

        ListNode(int N) {
            item = N;
        }
    }

    private static ListNode root, reversed;


    public static void main(String[] args) {

        System.out.println("This program prints out the items in a ListNode in reversed order.");


        for(int i = 0; i < 6; i++) {
            int rand = (int)(6*Math.random())+1;
            insertItem(rand);
        }


        System.out.println();
        System.out.println("Original values:");
        printList(root);
        System.out.println("\nReversed Values:");
        printList(doReversed(root));

    }

    static void printList(ListNode node) {
        ListNode runner;
        runner = node;
        while(runner != null) {
            System.out.println(runner.item);
            runner = runner.next;
        }
    }


    static void insertItem(int N) {
        if(root == null) {
            root = new ListNode(N);
        }
        else {
            ListNode runner;
            runner = root;
            while(true) {
                if(runner.next == null) {
                    runner.next = new ListNode(N);
                    break;
                }
                else {
                    runner = runner.next;
                }
            }
        }

    }

    static ListNode doReversed(ListNode head) {
      ListNode runner;
      runner = head;
      while(runner != null) {     //implements a stack
          ListNode newNode = new ListNode(runner.item);
          newNode.next = reversed;
          reversed = newNode;
          runner = runner.next;
      }
      return reversed;

    }


}
