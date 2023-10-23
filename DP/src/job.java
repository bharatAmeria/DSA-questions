import java.util.*;

public class job {
    int start, finish, profit;

    job(int start, int finish, int profit) {
        this.start =start;
        this.finish = finish;
        this.profit = profit;

    }

    @Override
    public String toString() {
        return "(" + this.start + "," + this.finish + "," + this.finish + ")";
    }
}
class Main {
    public static int MaxProfit (List<job> jobs) {
        Collections.sort(jobs, Comparator.comparing( x -> x.start));

        int n = jobs.size();

        if (n == 0) {
            return 0;
        }
        int[] maxProfit = new int[n];

        for (int i = 0; i < n; i++) {
            maxProfit[i] = 0;
            for (int j = 0; j < i; j++) {
                if (jobs.get(j).finish <= jobs.get(i).start &&
                maxProfit[i] < maxProfit[j]) {
                    maxProfit[i] = maxProfit[j];
                }
            }
            maxProfit[i] += jobs.get(i).profit;
        }
        return Arrays.stream(maxProfit).max().getAsInt();
    }

    public static void main(String[] args) {
        List<job> jobs = Arrays.asList(
                new job( 0, 6, 60 ),
                new job( 5, 9, 50 ),
                new job( 1, 4, 30 ),
                new job( 5, 7, 30 ),
                new job( 3, 5, 10 ),
                new job( 7, 8, 10 )
        );
        System.out.println(MaxProfit(jobs));
    }
}

class Main2 {
    public static void MaxProfit(List<job> jobs) {
        Collections.sort(jobs, Comparator.comparing(x -> x.start));

        int n = jobs.size();
        if (n == 0) {
            return;
        }

        List<List<Integer>> tasks = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            tasks.add(new ArrayList<>());
        }
        int[] maxProfit = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (jobs.get(j).finish <= jobs.get(i).start &&
                maxProfit[i] < maxProfit[j]) {
                    tasks.set(i, new ArrayList<>(tasks.get(j)));
                    maxProfit[i] = maxProfit[j];
                }
                tasks.get(i).add(i);
                maxProfit[i] += jobs.get(i).profit;
            }
        }
        int index = 0;
        for (int i = 0; i < n; i++) {
            if (maxProfit[i] > maxProfit[index]) {
                index = i;
            }
        }
        for (Integer i : tasks.get(index)) {
            System.out.println(jobs.get(i));
        }
    }
}
