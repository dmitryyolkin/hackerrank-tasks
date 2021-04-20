package sandbox.hackerrank.stacks;

import java.util.*;

public class SolutionCastleOnTheGrid {

    private static final char EMPTY_PLACE = '.';
    private static final char BUSY_PLACE = 'X';

    // https://www.hackerrank.com/challenges/castle-on-the-grid/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=stacks-queues
    public int calculate(String[] grid, int startX, int startY, int goalX, int goalY) {

        Map<Node, List<Node>> node2NodeDirectConnections = convertGrid2Map(grid);
        Node startNode = new Node(startX, startY);
        Node endNode = new Node(goalX, goalY);

        int path = 0;
        Set<Node> processedNeighbours = new HashSet<>();
        processedNeighbours.add(startNode);

        List<Node> neighbours = node2NodeDirectConnections.get(startNode);
        while (neighbours != null && !neighbours.isEmpty()) {
            path++;
            if (neighbours.contains(endNode)) {
                // path is found
                break;
            }

            List<Node> candidates = new ArrayList<>();
            for (Node neighbour : neighbours) {
                if (!processedNeighbours.contains(neighbour)) {
                    List<Node> secondNeighbours = node2NodeDirectConnections.get(neighbour);
                    if (secondNeighbours != null) {
                        for (Node secondNeighbour : secondNeighbours) {
                            if (!processedNeighbours.contains(secondNeighbour)) {
                                candidates.add(secondNeighbour);
                            }
                        }
                    }
                }

                processedNeighbours.add(neighbour);
            }

            neighbours = candidates;
        }

        return path;
    }

    private Map<Node, List<Node>> convertGrid2Map(String[] grid) {
        Map<Node, List<Node>> result = new HashMap<>();
        for (int i = 0; i < grid.length; i++) {
            String row = grid[i];
            for (int j = 0; j < row.length(); j++) {
                char element = row.charAt(j);
                if (element == EMPTY_PLACE) {
                    Node node = new Node(i, j);
                    // check directions
                    // left
                    for (int k = j - 1; k >= 0; k--) {
                        char prevElement = row.charAt(k);
                        if (prevElement == BUSY_PLACE) {
                            break;
                        } else {
                            result
                                    .computeIfAbsent(node, v -> new ArrayList<>())
                                    .add(new Node(i, k));
                        }
                    }
                    // right
                    for (int k = j + 1; k < row.length(); k++) {
                        char newxtElement = row.charAt(k);
                        if (newxtElement == BUSY_PLACE) {
                            break;
                        } else {
                            result
                                    .computeIfAbsent(node, v -> new ArrayList<>())
                                    .add(new Node(i, k));
                        }
                    }
                    // up
                    for (int k = i - 1; k >= 0; k--) {
                        String prevRow = grid[k];
                        char prevElement = prevRow.charAt(j);
                        if (prevElement == BUSY_PLACE) {
                            break;
                        } else {
                            result
                                    .computeIfAbsent(node, v -> new ArrayList<>())
                                    .add(new Node(k, j));
                        }
                    }
                    // down
                    for (int k = i + 1; k < grid.length; k++) {
                        String nextRow = grid[k];
                        char prevElement = nextRow.charAt(j);
                        if (prevElement == BUSY_PLACE) {
                            break;
                        } else {
                            result
                                    .computeIfAbsent(node, v -> new ArrayList<>())
                                    .add(new Node(k, j));

                        }
                    }
                }
            }
        }
        return result;
    }

    private static class Node{
        private final int x;
        private final int y;

        private Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return x == node.x &&
                    y == node.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

}
