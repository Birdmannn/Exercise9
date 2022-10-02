public class QueueOfTreeNodes {

    private static class Node {
        TreeNode item;
        Node next;
    }


    private Node head = null;  //Points to fist Node in the queue. The queue is empty when head is null

    private Node tail = null;  //Points to last Node in the queue

    public void enqueue(TreeNode node) {
        Node newTail = new Node();
        newTail.item = node;
        if(head == null) {
            head = newTail;
            tail = newTail;
        }
        else {
            tail.next = newTail;
            tail = newTail;
        }
    }

    public TreeNode dequeue() {
        if(head == null)
            throw new IllegalArgumentException("Can't dequeue from an empty queue.");
        TreeNode firstItem = head.item;
        head = head.next;  //The previous second item is now first. If we have just removed the last item, then head is null.

        if(head == null) {
            tail = null;
        }
        return firstItem;
    }

    boolean isEmpty() {
        return (head == null);
    }
}
