import java.util.HashMap;
import java.util.Map;

public class prob_that_person_is_alive_after_taking_n_steps {

    public static double aliveProb(int N, int x, int y, int n, Map<String, Double> dp) {
        if (n==0) {
            return 1.0;
        }

        String key = x + "|" + y + "|" + n;

        if (!dp.containsKey(key)) {
            double p = 0.0;

            if (x > 0) {
                p += 0.25 * aliveProb(N, x-1,y,n-1, dp);
            }
            if (x < N - 1) {
                p += 0.25 * aliveProb(N,x + 1, y, n-1, dp);
            }
            if (y > 0) {
                p += 0.25 * aliveProb(N,x,y-1,n-1,dp);
            }
            if (y < N - 1) {
                p += 0.25 * aliveProb(N,x,y+1,n-1, dp);
            }
            dp.put(key,p);
        }
        return dp.get(key);
    }

    public static void main(String[] args) {
        int N = 10;
        int n = 3;
        int x = 0, y = 0;

        Map<String,Double> dp = new HashMap<>();

        System.out.println(aliveProb(N,x,y,n,dp));
    }
}
