/* DList.java */


/* findFront, findLast, removeFront, removeLast, insertFront, insertLast*/


/**
 *  A doubly-linked list's implementations are
 *  circularly-linked and employs a sentinel (dummy)
 *  node at the head of the list.
 *
 *	head references the sentinel node.
 */

/** Program 1 Expectations:
 *  Implement a Doubly Linked List with a sentinel node.
 *  The class should support find, insertion() and remove()
 *  operations from head and tail of the list.
 */

public class DList {
    protected DListNode head;
    protected long size;

    // constructor for an empty DList
    // head points to itself when list is empty
    public DList() {
        head = new DListNode();
        head.item = Integer.MIN_VALUE;
        head.next = head;
        head.prev = head;
        size = 0;
    }

    // constructor for a one-node DList
    public DList(int inte) {
        head = new DListNode();
        head.item = Integer.MIN_VALUE;
        head.next = new DListNode();
        head.next.item = inte;
        head.prev = head.next;
        head.next.prev = head;
        head.prev.next = head;
        size = 1;
    }

    // constructor for a two-node DList
    public DList(int int1, int int2) {
        head = new DListNode();
        head.item = Integer.MIN_VALUE;
        head.next = new DListNode();
        head.next.item = int1;
        head.prev = new DListNode();
        head.prev.item = int2;
        head.next.prev = head;
        head.prev.next = head;
        head.next.next = head.prev;
        head.prev.prev = head.next;
        size = 2;
    }

    public Object findFront() {
        if (size == 0) {
            return null;
        } else {
            return head.next.item;
        }
    }

    public Object findLast() {
        if (size == 0) {
            return null;
        } else {
            return head.prev.item;
        }
    }

    public void insertFront(int i) {
        DListNode newNode = new DListNode(i);
        newNode.next = head.next;
        newNode.prev = head;
        head.next.prev = newNode;
        head.next = newNode;
        size++;
    }

    public void removeFront() {
        if (size == 0) {
        } else {
            head.next.prev = null;
            head.next = head.next.next;
            head.next.prev = head;
            size--;
        }
    }

    public void insertLast(int a) {
        DListNode newNode2 = new DListNode(a);
        newNode2.next = head;
        newNode2.prev = head.prev;
        head.prev.next = newNode2;
        head.prev = newNode2;
        size++;
    }

    public void removeLast() {
        if (size == 0) {
        } else {
            head.prev.next = null;
            head.prev = head.prev.prev;
            head.prev.next = head;
            size--;
        }
    }

    public String toString() {
        String result = "[  ";
        DListNode current = head.next;
        while (current != head) {
            result = result + current.item + "  ";
            current = current.next;
        }
        return result + "]";
    }

    public static void main(String[] args) {

        /*----------------------insertFront-----------------------*/

        DList l = new DList();
        System.out.println("### TESTING insertFront ###\nEmpty list is " + l);

        l.insertFront(9);
        System.out.println("\nInserting 9 at front.\nList with 9 is " + l);
        if (l.head.next.item != 9) {
            System.out.println("head.next.item is wrong.");
        }
        if (l.head.next.prev != l.head) {
            System.out.println("head.next.prev is wrong.");
        }
        if (l.head.prev.item != 9) {
            System.out.println("head.prev.item is wrong.");
        }
        if (l.head.prev.next != l.head) {
            System.out.println("head.prev.next is wrong.");
        }
        if (l.size != 1) {
            System.out.println("size is wrong.");
        }

        l.insertFront(8);
        System.out.println("\nInserting 8 at front.\nList with 8 and 9 is " + l);
        if (l.head.next.item != 8) {
            System.out.println("head.next.item is wrong.");
        }
        if (l.head.next.prev != l.head) {
            System.out.println("head.next.prev is wrong.");
        }
        if (l.head.prev.item != 9) {
            System.out.println("head.prev.item is wrong.");
        }
        if (l.head.prev.next != l.head) {
            System.out.println("head.prev.next is wrong.");
        }
        if (l.head.next.next != l.head.prev) {
            System.out.println("l.head.next.next != l.head.prev.");
        }
        if (l.head.prev.prev != l.head.next) {
            System.out.println("l.head.prev.prev != l.head.next.");
        }
        if (l.size != 2) {
            System.out.println("size is wrong.");
        }

        /*----------------------removeFront-----------------------*/

        l = new DList(1, 2);
        System.out.println("\n\n### TESTING removeFront ###\nList with 1 and 2 is "
                + l);

        l.removeFront();
        System.out.println("\nRemoving 1 at front.");
        System.out.println("\nList with 2 is " + l);
        if (l.head.next.item != 2) {
            System.out.println("head.next.item is wrong.");
        }
        if (l.head.next.prev != l.head) {
            System.out.println("head.next.prev is wrong.");
        }
        if (l.head.prev.item != 2) {
            System.out.println("head.prev.item is wrong.");
        }
        if (l.head.prev.next != l.head) {
            System.out.println("head.prev.next is wrong.");
        }
        if (l.size != 1) {
            System.out.println("size is wrong.");
        }

        l.removeFront();
        System.out.println("\nRemoving 2 at front.");
        System.out.println("\nEmpty list is " + l);
        if (l.head.next != l.head) {
            System.out.println("head.next is wrong.");
        }
        if (l.head.prev != l.head) {
            System.out.println("head.prev is wrong.");
        }
        if (l.size != 0) {
            System.out.println("size is wrong.");
        }

        l.removeFront();
        System.out.println("\nRemoving a node at front.");
        System.out.println("\nEmpty list is " + l);
        if (l.head.next != l.head) {
            System.out.println("head.next is wrong.");
        }
        if (l.head.prev != l.head) {
            System.out.println("head.prev is wrong.");
        }
        if (l.size != 0) {
            System.out.println("size is wrong.");
        }


        /*----------------------insertLast-----------------------*/

        l = new DList();
        System.out.println("\n\n### TESTING insertLast ###\nEmpty list is " + l);

        l.insertLast(8);
        System.out.println("\nInserting 8 at Last.\nList with 8 is " + l);
        if (l.head.prev.item != 8) {
            System.out.println("head.prev.item is wrong.");
        }
        if (l.head.prev.next != l.head) {
            System.out.println("head.prev.next is wrong.");
        }
        if (l.head.next.item != 8) {
            System.out.println("head.next.item is wrong.");
        }
        if (l.head.next.prev != l.head) {
            System.out.println("head.next.prev is wrong.");
        }
        if (l.size != 1) {
            System.out.println("size is wrong.");
        }

        l.insertLast(9);
        System.out.println("\nInserting 8 at front.\nList with 8 and 9 is " + l);
        if (l.head.prev.item != 9) {
            System.out.println("head.prev.item is wrong.");
        }
        if (l.head.prev.next != l.head) {
            System.out.println("head.prev.prev is wrong.");
        }
        if (l.head.next.item != 8) {
            System.out.println("head.next.item is wrong.");
        }
        if (l.head.next.prev != l.head) {
            System.out.println("head.next.prev is wrong.");
        }
        if (l.head.next.next != l.head.prev) {
            System.out.println("l.head.next.next != l.head.prev.");
        }
        if (l.head.prev.prev != l.head.next) {
            System.out.println("l.head.prev.prev != l.head.next.");
        }
        if (l.size != 2) {
            System.out.println("size is wrong.");
        }

        /*----------------------removeLast-----------------------*/
        l = new DList(1, 2);
        System.out.println("\n\n### TESTING removeLast ###\nList with 1 and 2 is "
                + l);

        l.removeLast();
        System.out.println("\nRemoving 2 at last.");
        System.out.println("\nList with 1 is " + l);
        if (l.head.prev.item != 1) {
            System.out.println("head.prev.item is wrong.");
        }
        if (l.head.prev.next != l.head) {
            System.out.println("head.prev.next is wrong.");
        }
        if (l.head.next.item != 1) {
            System.out.println("head.next.item is wrong.");
        }
        if (l.head.next.prev != l.head) {
            System.out.println("head.next.prev is wrong.");
        }
        if (l.size != 1) {
            System.out.println("size is wrong.");
        }

        l.removeLast();
        System.out.println("\nRemoving 1 at last.");
        System.out.println("\nEmpty list is " + l);
        if (l.head.prev != l.head) {
            System.out.println("head.prev is wrong.");
        }
        if (l.head.next != l.head) {
            System.out.println("head.next is wrong.");
        }
        if (l.size != 0) {
            System.out.println("size is wrong.");
        }

        l.removeFront();
        System.out.println("\nRemoving a node at last.");
        System.out.println("\nEmpty list is " + l);
        if (l.head.next != l.head) {
            System.out.println("head.next is wrong.");
        }
        if (l.head.prev != l.head) {
            System.out.println("head.prev is wrong.");
        }
        if (l.size != 0) {
            System.out.println("size is wrong.");
        }
    }
}