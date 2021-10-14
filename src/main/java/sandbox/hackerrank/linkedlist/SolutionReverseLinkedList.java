package sandbox.hackerrank.linkedlist;

public class SolutionReverseLinkedList {

    // https://www.hackerrank.com/challenges/reverse-a-doubly-linked-list/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=linked-lists
    static class DoublyLinkedListNode {
        public int data;
        public DoublyLinkedListNode next;
        public DoublyLinkedListNode prev;

        public DoublyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
            this.prev = null;
        }

        @Override
        public String toString() {
            return "DoublyLinkedListNode{" +
                    "data=" + data +
                    '}';
        }
    }

    static class DoublyLinkedList {
        public DoublyLinkedListNode head;
        public DoublyLinkedListNode tail;

        public DoublyLinkedList() {
            this.head = null;
            this.tail = null;
        }

        public void insertNode(int nodeData) {
            DoublyLinkedListNode node = new DoublyLinkedListNode(nodeData);

            if (this.head == null) {
                this.head = node;
            } else {
                this.tail.next = node;
                node.prev = this.tail;
            }

            this.tail = node;
        }
    }

    public DoublyLinkedListNode reverse(DoublyLinkedListNode llist) {
        DoublyLinkedListNode curr = llist;
        DoublyLinkedListNode head = llist;
        while (curr != null) {
            DoublyLinkedListNode v = curr.next;
            curr.next = curr.prev;
            curr.prev = v;
            head = curr;
            curr = v;
        }
        return head;
    }
}
