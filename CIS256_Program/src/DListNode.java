/* DListNode.java */

/**
 *  A DListNode is a node in a doubly-linked list(with sentinels).
 */

public class DListNode {

    /**
     *  item references the item stored in the current node.
     *  prev references the previous node in the DList.
     *  next references the next node in the DList.
     *
     *  DO NOT CHANGE THE FOLLOWING FIELD DECLARATIONS.
     */

    public int item;
    public DListNode prev;
    public DListNode next;

    DListNode() {
        item = 0;
        next = null;
        prev = null;
    }

    DListNode(int i) {
        item = i;
        next = null;
        prev = null;
    }
}