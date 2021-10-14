package sandbox.hackerrank.linkedlist;

import org.junit.Test;
import sandbox.SolutionTemplate;

import static org.junit.Assert.assertEquals;

public class SolutionReverseLinkedListTest {
    @Test
    public void testSolution() {
        SolutionReverseLinkedList solution = new SolutionReverseLinkedList();
        SolutionReverseLinkedList.DoublyLinkedList linkedList = new SolutionReverseLinkedList.DoublyLinkedList();
        linkedList.insertNode(1);
        linkedList.insertNode(2);
        linkedList.insertNode(3);
        linkedList.insertNode(4);

        SolutionReverseLinkedList.DoublyLinkedListNode head = linkedList.head;
        SolutionReverseLinkedList.DoublyLinkedListNode tail = linkedList.tail;

        SolutionReverseLinkedList.DoublyLinkedListNode reversedHead = solution.reverse(head);
        int[] reversedData = new int[]{4, 3, 2, 1};
        int i = 0;
        while (reversedHead.next != null) {
            assertEquals(reversedData[i++], reversedHead.data);
            reversedHead = reversedHead.next;
        }
    }

}
