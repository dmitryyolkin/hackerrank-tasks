package sandbox.hackerrank.trees;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class SolutionSearchCommonParent {

    // https://www.hackerrank.com/challenges/binary-search-tree-lowest-common-ancestor/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=trees
    public Node calculate(Node root, int v1, int v2) {
        // search parent
        Map<Integer, Node> data2Parent = new HashMap<>();
        Map<Integer, Node> data2Node = new HashMap<>();
        deepDive(root, data2Parent, data2Node);

        Integer currV1 = v1;
        while(currV1 != null) {
            Integer currV2 = v2;
            while(currV2 != null) {
                if (currV1.equals(currV2)) {
                    return data2Node.get(currV2);
                }
                currV2 = Optional.ofNullable(data2Parent.get(currV2)).map(n -> n.data).orElse(null);
            }
            currV1 = Optional.ofNullable(data2Parent.get(currV1)).map(n -> n.data).orElse(null);
        }

        return null;
    }

    private void deepDive(Node node,
                          Map<Integer, Node> data2Parent,
                          Map<Integer, Node> data2Node) {
        data2Node.put(node.data, node);
        if (node.left != null) {
            data2Parent.put(node.left.data, node);
            deepDive(node.left, data2Parent, data2Node);
        }

        if (node.right != null) {
            data2Parent.put(node.right.data, node);
            deepDive(node.right, data2Parent, data2Node);
        }

    }

}
