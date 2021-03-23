package sandbox.hackerrank.graphs;

import java.util.*;

public class SolutionFindNearestClone {

    // https://www.hackerrank.com/challenges/find-the-nearest-clone/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=graphs
    public int findShortest(int graphNodes, int[] graphFrom, int[] graphTo, long[] ids, int val) {
        Map<Long, List<Integer>> id2Node = new HashMap<>();
        // group by ids
        for (int i = 0; i < graphNodes; i++) {
            id2Node
                    .computeIfAbsent(ids[i], v -> new ArrayList<>())
                    .add(i + 1);
        }

        List<Integer> sameIdNodes = id2Node.get((long) val);
        if (sameIdNodes == null || sameIdNodes.size() < 2) {
            // less than 2 same color nodes
            return -1;
        }

        // create map with links
        Map<Integer, List<Integer>> node2NodeConnection = new HashMap<>();
        for (int i = 0; i < graphFrom.length; i++) {
            // put connections for both nodes
            int from = graphFrom[i];
            int to = graphTo[i];
            node2NodeConnection
                    .computeIfAbsent(from, v -> new ArrayList<>())
                    .add(to);

            node2NodeConnection
                    .computeIfAbsent(to, v -> new ArrayList<>())
                    .add(from);
        }

        int min = -1;
        for (int i = 0; i < sameIdNodes.size() - 1; i++) {
            Integer currNode = sameIdNodes.get(i);
            Set<Integer> expectedSameIdNodes = new HashSet<>(sameIdNodes.subList(i + 1, sameIdNodes.size()));

            int length = 1;
            List<Integer> connectedNodes = Optional
                    .ofNullable(node2NodeConnection.get(currNode))
                    .orElse(Collections.emptyList());
            Set<Integer> processedNodes = new HashSet<>();
            processedNodes.add(currNode);
            while (!connectedNodes.isEmpty()) {
                List<Integer> newConnectedNodes = new ArrayList<>();
                for (Integer connectedNode : connectedNodes) {
                    if (expectedSameIdNodes.contains(connectedNode) &&
                            (min == -1  || length < min)){
                        min = length;
                    }

                    processedNodes.add(connectedNode);
                    newConnectedNodes.addAll(Optional
                                    .ofNullable(node2NodeConnection.get(connectedNode))
                                    .orElse(Collections.emptyList())
                    );
                    newConnectedNodes.removeAll(processedNodes);
                }

                connectedNodes = newConnectedNodes;
                length++;

            }

        }
        return min;
    }

}
