import java.io.Serial;
import java.util.*;
import java.util.stream.Collectors;

// Activity Selection Problem
public class Ques_1 {
    public static List<Pair> selectActivity(List<Pair> activities) {
        int k = 0;
        Set<Integer> result = new HashSet<>();
        if (activities.size() > 0) {
            result.add(0);
        }
        Collections.sort(activities, Comparator.comparing(Pair::getFinish));

        for (int i = 1; i < activities.size(); i++) {
            if (activities.get(i).getStart() >= activities.get(k).getFinish()) {
                result.add(i);
                k = i;
            }
        }
        return result.stream().map(activities::get).collect(Collectors.toList());
    }
    public static void main(String[] args) {
        List<Pair> activities = Arrays.asList(new Pair(1, 4), new Pair(3, 5),
                new Pair(0, 6), new Pair(5, 7), new Pair(3, 8),
                new Pair(5, 9), new Pair(6, 10), new Pair(8, 11),
                new Pair(8, 12), new Pair(2, 13), new Pair(12, 14));

        List<Pair> result = selectActivity(activities);
        System.out.println(result);
    }

}
class Pair{
    private int start, finish;

    public Pair (int start, int finish){
        this.start = start;
        this.finish = finish;
    }
    public int getFinish() {
        return finish;
    }
    public int getStart() {
        return start;
    }

    @Override
    public String toString() {
        return "(" + getStart() + " , " + getFinish() + ")";
    }
}
