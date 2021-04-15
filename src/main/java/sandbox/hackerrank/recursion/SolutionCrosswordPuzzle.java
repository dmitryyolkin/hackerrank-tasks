package sandbox.hackerrank.recursion;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SolutionCrosswordPuzzle {
    private static final char EMPTY_PLACE = '-';

    // https://www.hackerrank.com/challenges/crossword-puzzle/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=recursion-backtracking
    public String[] calculate(String[] crossword, String words) {

        Map<Integer, List<Slot>> lines = new HashMap<>();
        Map<Integer, List<Slot>> columns = new HashMap<>();

        // Fill Slots
        Map<Integer, List<List<Integer>>> columnsIndexes = new HashMap<>();
        for (int i = 0; i < crossword.length; i++) {
            String line = crossword[i];
            int start = 0;
            int end = -1;
            while (start != -1) {
                start = line.indexOf(EMPTY_PLACE, end + 1);
                int lastEnd = start;
                while (lastEnd > -1) {
                    end = lastEnd;
                    if (lastEnd >= line.length() - 1 || line.charAt(++lastEnd) != EMPTY_PLACE) {
                        break;
                    }
                }

                if (start >= 0) {
                    // collect column info
                    for (int j = start; j <= end; j++) {
                        List<List<Integer>> allPrevIndexes = columnsIndexes.computeIfAbsent(j, v -> new ArrayList<>());
                        List<Integer> prevIndex = null;
                        for (List<Integer> prevIndexCandidate : allPrevIndexes) {
                            if (prevIndexCandidate.contains(i - 1)) {
                                prevIndex = prevIndexCandidate;
                                break;
                            }
                        }

                        if (prevIndex == null) {
                            prevIndex = new ArrayList<>();
                            allPrevIndexes.add(prevIndex);
                        }
                        prevIndex.add(i);
                    }

                    if (end > start) {
                        lines.computeIfAbsent(i, v -> new ArrayList<>()).add(new Slot(
                                true,
                                i, start, end,
                                new HashMap<>()
                        ));
                    }
                }
            }
        }

        // fill columns
        Map<Integer, List<List<Integer>>> filteredColumnsIndexes = new HashMap<>();
        for (Map.Entry<Integer, List<List<Integer>>> entry : columnsIndexes.entrySet()) {
            List<List<Integer>> allPrevIndexes = entry.getValue();
            List<List<Integer>> newAllPrevIndexes = new ArrayList<>();
            for (List<Integer> prevIndex : allPrevIndexes) {
                if (prevIndex.size() > 1) {
                    newAllPrevIndexes.add(prevIndex);
                }
            }

            if (!newAllPrevIndexes.isEmpty()) {
                filteredColumnsIndexes.put(entry.getKey(), newAllPrevIndexes);
            }
        }

        for (Map.Entry<Integer, List<List<Integer>>> columnEntry : filteredColumnsIndexes.entrySet()) {
            Integer columnIndex = columnEntry.getKey();
            for (List<Integer> columnSlot : columnEntry.getValue()) {
                // valid column
                Slot verticalSlot = new Slot(
                        false,
                        columnIndex,
                        columnSlot.get(0), columnSlot.get(columnSlot.size() - 1),
                        collectIntersectedSlots(
                                lines, columnIndex,
                                columnSlot.get(0), columnSlot.get(columnSlot.size() - 1)
                        )
                );
                columns
                        .computeIfAbsent(columnIndex, v -> new ArrayList<>())
                        .add(verticalSlot);
            }
        }

        // file intersected with lines
        for (List<Slot> slots : lines.values()) {
            for (Slot slot : slots) {
                slot.intersectedSlots.putAll(collectIntersectedSlots(
                        columns,
                        slot.slotIndex,
                        slot.startIndex, slot.endIndex
                ));
            }
        }

        // Allocate words
        List<Slot> allSlots = new ArrayList<>();
        allSlots.addAll(lines.values().stream().flatMap(Collection::stream).collect(Collectors.toList()));
        allSlots.addAll(columns.values().stream().flatMap(Collection::stream).collect(Collectors.toList()));
        Map<Slot, Allocation> allocatedSlots = allocateWords(
                Stream.of(words.split(";")).collect(Collectors.toList()),
                allSlots,
                new LinkedHashMap<>(), new HashSet<>()
        );

        // fill result
        String[] result = new String[crossword.length];
        for (int i = 0; i < crossword.length; i++) {
            String initialColumn = crossword[i];
            StringBuilder allocatedColumn = new StringBuilder();
            for (int j = 0; j < initialColumn.length(); j++) {
                char symbol = initialColumn.charAt(j);
                if (symbol == EMPTY_PLACE) {
                    for (Map.Entry<Slot, Allocation> allocationEntry : allocatedSlots.entrySet()) {
                        String word = allocationEntry.getValue().word;
                        Slot allocatedSlot = allocationEntry.getKey();
                        if (allocatedSlot.horizontal) {
                            if (allocatedSlot.slotIndex == i &&
                                    allocatedSlot.startIndex <= j && j <= allocatedSlot.endIndex) {
                                symbol = word.charAt(j - allocatedSlot.startIndex);
                                break;
                            }
                        } else if (allocatedSlot.slotIndex == j &&
                                allocatedSlot.startIndex <= i && i <= allocatedSlot.endIndex) {
                            symbol = word.charAt(i - allocatedSlot.startIndex);
                            break;
                        }
                    }

                }
                allocatedColumn.append(symbol);
            }
            result[i] = allocatedColumn.toString();
        }
        return result;
    }

    private Map<Slot, Allocation> allocateWords(List<String> words,
                                                List<Slot> allSlots,
                                                Map<Slot, Allocation> allocatedSlots,
                                                Set<Allocation> forbiddenAllocations) {

        for (int i = 0; i < words.size(); i++) {
            String candidateWord = words.get(i);
            if (allocatedSlots.values().stream().anyMatch(a -> a.word.equals(candidateWord))) {
                // candidate is already allocated
                continue;
            }

            boolean wordIsAllocated = false;
            for (Slot candidateSlot : allSlots) {
                if (candidateWord.length() == candidateSlot.getSize() &&
                        !allocatedSlots.containsKey(candidateSlot) &&
                        isNotForbidden(candidateWord, candidateSlot, allocatedSlots, forbiddenAllocations)) {
                    // check letters match
                    boolean conflict = false;
                    for (Map.Entry<Slot, Map<Integer, Integer>> intersectedEntry : candidateSlot.intersectedSlots.entrySet()) {
                        Slot intersectedSlot = intersectedEntry.getKey();
                        String allocatedWord = Optional.ofNullable(allocatedSlots.get(intersectedSlot)).map(a -> a.word).orElse(null);
                        if (allocatedWord != null) {
                            Map.Entry<Integer, Integer> intersectedIndexes = intersectedEntry.getValue().entrySet().iterator().next();
                            int candidateLetterIndex = (candidateSlot.horizontal ? intersectedIndexes.getValue() : intersectedIndexes.getKey()) - candidateSlot.startIndex;
                            int allocatedLetterIndex = (intersectedSlot.horizontal ? intersectedIndexes.getValue() : intersectedIndexes.getKey()) - intersectedSlot.startIndex;
                            if (candidateWord.charAt(candidateLetterIndex) != allocatedWord.charAt(allocatedLetterIndex)) {
                                conflict = true;
                                break;
                            }
                        }
                    }

                    if (!conflict) {
                        // save and go to next candidate word
                        int prevIndex = i - 1;
                        allocatedSlots.put(candidateSlot, new Allocation(
                                candidateWord, candidateSlot,
                                i == 0 ? null : allocatedSlots.values().stream().filter(a -> a.word.equals(words.get(prevIndex))).findFirst().orElseThrow(IllegalArgumentException::new)
                        ));
                        wordIsAllocated = true;
                        break;
                    }
                }
            }

            if (!wordIsAllocated) {
                // try another allocation
                Allocation lastAddedAllocation = null;
                for (Map.Entry<Slot, Allocation> entry : allocatedSlots.entrySet()) {
                    lastAddedAllocation = entry.getValue();
                }

                if (lastAddedAllocation == null) {
                    throw new IllegalStateException("There is no option to allocate a word: " + candidateWord);
                }

                LinkedHashMap<Slot, Allocation> newAllocatedSlots = new LinkedHashMap<>(allocatedSlots);
                newAllocatedSlots.remove(lastAddedAllocation.slot);

                Set<Allocation> newForbiddenAllocations = new HashSet<>(forbiddenAllocations);
                newForbiddenAllocations.add(lastAddedAllocation);
                return allocateWords(
                        words,
                        allSlots,
                        newAllocatedSlots,
                        newForbiddenAllocations
                );
            }
        }

        return allocatedSlots;
    }

    private boolean isNotForbidden(String candidate,
                                   Slot candidateSlot,
                                   Map<Slot, Allocation> allocatedSlots,
                                   Set<Allocation> forbiddenAllocations) {
        // all parents are in allocated and candidate not in forbidden -> ok
        Allocation previousCandidateAllocation = forbiddenAllocations.stream()
                .filter(a -> a.word.equals(candidate) && a.slot.equals(candidateSlot))
                .findFirst()
                .orElse(null);
        if (previousCandidateAllocation == null) {
            // no such allocations in the past
            return true;
        }

        Allocation parent = previousCandidateAllocation.parent;
        while (parent != null) {
            Allocation p = parent;
            if (allocatedSlots
                    .values()
                    .stream()
                    .noneMatch(a -> a.word.equals(p.word) && a.slot.equals(p.slot))) {
                // no such allocation in the past
                return true;
            }
            parent = parent.parent;
        }

        return false;
    }

    private Map<Slot, Map<Integer, Integer>> collectIntersectedSlots(Map<Integer, List<Slot>> candidates,
                                                                     Integer originalIndex,
                                                                     int originalStartIndex, int originalEndIndex) {
        return candidates
                .values()
                .stream()
                .flatMap(Collection::stream)
                .filter(slot -> {
                    if (originalStartIndex <= slot.slotIndex && slot.slotIndex >= originalEndIndex) {
                        return false;
                    }

                    return (slot.startIndex <= originalIndex && originalIndex <= slot.endIndex);
                })
                .collect(Collectors.toMap(
                        s -> s,
                        s -> {
                            Map<Integer, Integer> map = new HashMap<>();
                            map.put(
                                    s.horizontal ? s.slotIndex : originalIndex,
                                    s.horizontal ? originalIndex : s.slotIndex
                            );
                            return map;
                        }
                ));
    }

    // Tree structure
    private static class Allocation {
        private final String word;
        private final Slot slot;
        private final Allocation parent;

        private Allocation(String word, Slot slot, Allocation parent) {
            this.word = word;
            this.slot = slot;
            this.parent = parent;
        }

    }

    private static class Slot {
        private final boolean horizontal;
        private final int slotIndex;
        private final int startIndex;
        private final int endIndex;
        private final Map<Slot, Map<Integer, Integer>> intersectedSlots;

        private Slot(boolean horizontal,
                     int slotIndex,
                     int startIndex,
                     int endIndex,
                     Map<Slot, Map<Integer, Integer>> intersectedSlots) {
            this.horizontal = horizontal;
            this.slotIndex = slotIndex;
            this.startIndex = startIndex;
            this.endIndex = endIndex;
            this.intersectedSlots = intersectedSlots;
        }

        public int getSize() {
            return endIndex - startIndex + 1;
        }

        public Map<Slot, Map<Integer, Integer>> getIntersectedSlots() {
            return intersectedSlots;
        }
    }

}
