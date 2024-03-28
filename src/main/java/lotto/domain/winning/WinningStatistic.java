package lotto.domain.winning;

import java.text.DecimalFormat;
import java.util.EnumMap;
import java.util.Map;
import lotto.domain.grade.Grade;
import lotto.domain.lotto.PurchaseInfomation;

public class WinningStatistic {

    private final Map<Grade, Integer> gradeCounts = new EnumMap<>(Grade.class);

    private final PurchaseInfomation purchaseInfomation;

    public WinningStatistic(PurchaseInfomation purchaseInfomation) {
        this.purchaseInfomation = purchaseInfomation;
        initializeGradeCounts();
    }

    private void initializeGradeCounts() {
        for (Grade grade : Grade.values()) {
            gradeCounts.put(grade, 0);
        }
    }

    public int getGradeCount(final Grade grade) {
        return gradeCounts.getOrDefault(grade, 0);
    }

    public void calculateWinningStatistic(final Grade grade) {
        gradeCounts.put(grade, gradeCounts.getOrDefault(grade, 0) + 1);
    }

    public double calculateProfitRate() {
        double profitRate =
            (double) calculateTotalWinningAmount() / purchaseInfomation.getPurchaseAmount();
        return Double.parseDouble(formattedProfitRate(Math.floor(profitRate * 100) / 100));
    }

    private int calculateTotalWinningAmount() {
        return gradeCounts.entrySet()
            .stream()
            .mapToInt(grade -> grade.getKey().getPrizeMoney() * grade.getValue())
            .sum();
    }

    private String formattedProfitRate(double profitRate) {
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        return decimalFormat.format(profitRate);
    }
}
