package project1;

import lombok.Getter;

/**
 * packageName    : project1
 * fileName       : SummaryStatistics
 * author         : AngryPig123
 * date           : 24. 12. 1.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 24. 12. 1.        AngryPig123       최초 생성
 */
@Getter
public class SummaryStatistics {

    private final double sum;
    private final double max;
    private final double min;
    private final double average;

    private SummaryStatistics(double sum, double max, double min, double average) {
        this.sum = sum;
        this.max = max;
        this.min = min;
        this.average = average;
    }

    public static SummaryStatistics from(double sum, double max, double min, double average) {
        return new SummaryStatistics(sum, max, min, average);
    }

}
