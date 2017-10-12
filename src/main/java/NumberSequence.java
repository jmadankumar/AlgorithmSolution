import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by madan$tcs on 12-Oct-17.
 */
public class NumberSequence {
    public static void main(String[] args) {
        List<Integer> numberList = Arrays.asList(new Integer[]{1, 2, 4, 5, 6, 8, 10});
        if (null != numberList && !numberList.isEmpty()) {
            System.out.println(getNumberRange(numberList));
        }
    }

    private static List<NumberRange> getNumberRange(List<Integer> numberList) {
        List<NumberRange> numberRangeList = new ArrayList<NumberRange>();
        int currentNumberRangeIndex = 0;
        numberRangeList.add(convertToNumberRange(numberList.get(0), numberList.get(0)));
        for (int index = 1; index < numberList.size(); index++) {
            if (numberRangeList.get(currentNumberRangeIndex).getEndNumber() + 1 == numberList.get(index)) {
                numberRangeList.get(currentNumberRangeIndex).setEndNumber(numberList.get(index));
            } else {
                numberRangeList.add(convertToNumberRange(numberList.get(index), numberList.get(index)));
                currentNumberRangeIndex++;
            }
        }
        return numberRangeList;
    }

    private static NumberRange convertToNumberRange(Integer startNumber, Integer endNumber) {
        NumberRange numberRange = new NumberRange();
        numberRange.setStartNumber(startNumber);
        numberRange.setEndNumber(endNumber);
        return numberRange;
    }
}

class NumberRange {
    private Integer startNumber;
    private Integer endNumber;

    public Integer getStartNumber() {
        return startNumber;
    }

    public void setStartNumber(Integer startNumber) {
        this.startNumber = startNumber;
    }

    public Integer getEndNumber() {
        return endNumber;
    }

    public void setEndNumber(Integer endNumber) {
        this.endNumber = endNumber;
    }

    @Override
    public String toString() {
        return "NumberRange{" +
                "startNumber=" + startNumber +
                ", endNumber=" + endNumber +
                '}';
    }
}