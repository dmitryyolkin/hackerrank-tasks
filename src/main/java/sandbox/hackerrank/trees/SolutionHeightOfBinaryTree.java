package sandbox.hackerrank.trees;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SolutionHeightOfBinaryTree {

    // https://www.hackerrank.com/challenges/tree-height-of-a-binary-tree/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=trees
    public int calculate(Node root) {
        int height = -1;
        List<Node> children = Collections.singletonList(root);
        while(!children.isEmpty()) {
            List<Node> temp = new ArrayList<>();
            for (Node child : children) {
                if (child.left != null) {
                    temp.add(child.left);
                }

                if (child.right != null) {
                    temp.add(child.right);
                }
            }
            children = temp;
            height++;
        }
        return height;
    }

}
