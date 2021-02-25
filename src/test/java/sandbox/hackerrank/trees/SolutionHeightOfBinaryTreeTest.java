package sandbox.hackerrank.trees;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionHeightOfBinaryTreeTest {
    @Test
    public void testSolution() {
        SolutionHeightOfBinaryTree solution = new SolutionHeightOfBinaryTree();

        Node root = insert(null, 3);
        // 2nd level
        insert(root, 2);
        insert(root, 5);

        // 3rd level
        insert(root, 1);
        insert(root, 4);
        insert(root, 6);

        // 4th level
        insert(root, 7);

        assertEquals(
                3,
                solution.calculate(root)
        );
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
