package sandbox.different;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BuyAndSellSolution {

    // See description at Buyers-Sellers.pdf
    public int[][] calculate(int[] sellQuantities, int[] buyQuantities, int[][] restrictions) {
        int[][] result = new int[buyQuantities.length][sellQuantities.length];

        // our task is to start from buyers and sellers having most restrictions than others
        // find buyers/sellers indexes with most restrictions
        Map<Integer, Integer> buyer2Restrictions = new HashMap<>();
        Map<Integer, Integer> seller2Restrictions = new HashMap<>();
        for (int i = 0; i < restrictions.length; i++) {
            int[] column = restrictions[i];
            for (int j = 0; j < column.length; j++) {
                int restriction = column[j];
                Integer prevBuyerValue = buyer2Restrictions.computeIfAbsent(i, v -> 0);
                Integer prevSellerValue = seller2Restrictions.computeIfAbsent(j, v -> 0);
                if (restriction == 0) {
                    // there is restriction
                    buyer2Restrictions.put(i, ++prevBuyerValue);
                    seller2Restrictions.put(j, ++prevSellerValue);
                }
            }
        }

        List<Integer> buyersIndexes = sortCandidates(buyer2Restrictions);
        List<Integer> sellersIndexes = sortCandidates(seller2Restrictions);

        for (int sellerIndex : sellersIndexes) {
            int sellRest = sellQuantities[sellerIndex];
            for (int buyerIndex : buyersIndexes) {
                int buyLimit = buyQuantities[buyerIndex];
                int alreadyBought = IntStream.of(result[buyerIndex]).sum();
                int buyCapacity = buyLimit - alreadyBought;
                if (restrictions[buyerIndex][sellerIndex] != 0 && buyCapacity > 0) {
                    // no restriction between buyer and seller
                    // there is free capacity
                    int value = Math.min(sellRest, buyCapacity);
                    result[buyerIndex][sellerIndex] = value;
                    sellRest -= value;
                    if (sellRest <= 0) {
                        // go to another seller - current is sold
                        break;
                    }
                }
            }
        }

        return result;
    }

    private List<Integer> sortCandidates(Map<Integer, Integer> buyer2Restrictions) {
        return buyer2Restrictions
                .entrySet()
                .stream()
                .sorted((e1, e2) -> -Integer.compare(e1.getValue(), e2.getValue()))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

}
