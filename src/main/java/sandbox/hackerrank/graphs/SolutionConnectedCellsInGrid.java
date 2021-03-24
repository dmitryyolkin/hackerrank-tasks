package sandbox.hackerrank.graphs;

import java.util.*;

public class SolutionConnectedCellsInGrid {

    // https://www.hackerrank.com/challenges/ctci-connected-cell-in-a-grid/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=graphs
    public int calculate(int[][] grid) {
        List<Set<Cell>> regions = new ArrayList<>();
        for (int i = 0; i < grid.length; i++) {
            int[] columns = grid[i];
            for (int j = 0; j < columns.length; j++) {
                int value = columns[j];
                if (value == 1) {
                    // candidate to region
                    List<Integer> borderRegions = new ArrayList<>();
                    for (int regionIndex = 0; regionIndex < regions.size(); regionIndex++) {
                        Set<Cell> region = regions.get(regionIndex);
                        boolean go2NextRegion = false;
                        for (int regionRowIndex = Math.max(0, i - 1); regionRowIndex <= Math.min(grid.length - 1, i + 1); regionRowIndex++) {
                            for (int regionColumnIndex = Math.max(0, j - 1); regionColumnIndex <= Math.min(columns.length - 1, j + 1); regionColumnIndex++) {
                                if (regionRowIndex != i || regionColumnIndex != j) {
                                    // candidate
                                    Cell cellCandidate = new Cell(regionRowIndex, regionColumnIndex);
                                    if (region.contains(cellCandidate)) {
                                        borderRegions.add(regionIndex);
                                        go2NextRegion = true;
                                        break;
                                    }
                                }
                            }

                            if (go2NextRegion) {
                                // go to next region
                                break;
                            }
                        }

                    }

                    updateRegions(regions, borderRegions, new Cell(i, j));
                }
            }
        }
        return regions
                .stream()
                .max(Comparator.comparingInt(Set::size))
                .map(Set::size)
                .orElse(0);
    }

    private void updateRegions(List<Set<Cell>> regions,
                               List<Integer> borderRegions,
                               Cell cell) {
        Set<Cell> expectedRegion;
        if (borderRegions.isEmpty()) {
            //create new region
            expectedRegion = new HashSet<>();
            regions.add(expectedRegion);
        } else if (borderRegions.size() == 1) {
            // add to current region
            expectedRegion = regions.get(borderRegions.get(0));
        } else {
            // merge regions
            expectedRegion = new HashSet<>();
            List<Set<Cell>> candidates4Removing = new ArrayList<>();
            for (Integer regionCandidateIndex : borderRegions) {
                // add old to new region
                // and remove old region
                Set<Cell> regionCandidate = regions.get(regionCandidateIndex);
                expectedRegion.addAll(regionCandidate);
                candidates4Removing.add(regionCandidate);
            }
            regions.removeAll(candidates4Removing);
            regions.add(expectedRegion);
        }

        expectedRegion.add(cell);
    }

    private static class Cell{
        private final int row;
        private final int column;

        private Cell(int row, int column) {
            this.row = row;
            this.column = column;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Cell cell = (Cell) o;
            return row == cell.row &&
                    column == cell.column;
        }

        @Override
        public int hashCode() {
            return Objects.hash(row, column);
        }

        @Override
        public String toString() {
            return "Cell{" +
                    "row=" + row +
                    ", column=" + column +
                    '}';
        }
    }

}
