package sandbox.hackerrank.trees;

import org.junit.Test;
import sandbox.SolutionTemplate;

import static org.junit.Assert.assertEquals;

public class SolutionSearchCommonParentTest {
    @Test
    public void testSolution() {
        SolutionSearchCommonParent solution = new SolutionSearchCommonParent();

        Node root = insert(null, 4);

        insert(root, 2);
        insert(root, 3);
        insert(root, 1);
        insert(root, 7);
        insert(root, 6);

        assertEquals(
                findNode(root, 2),
                solution.calculate(root, 1, 2)
        );

        assertEquals(
                root,
                solution.calculate(root, 1, 7)
        );

        assertEquals(
                findNode(root, 2),
                solution.calculate(root, 1, 3)
        );

    }

    private Node findNode(Node node, int data){
        if (node.data == data) {
            return node;
        }

        Node result;
        if (node.left != null) {
            result = findNode(node.left, data);
            if (result != null) {
                return result;
            }
        }

        if (node.right != null) {
            result = findNode(node.right, data);
            if (result != null) {
                return result;
            }
        }

        return null;

    }

    private Node insert(Node root, int data) {
        if(root == null) {
            return new Node(data);
        } else {
            Node cur;
            if(data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

}
