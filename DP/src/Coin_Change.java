public class Coin_Change {
    public static int count(int[] s, int target) {
        if (target == 0) {
            return 1;
        }
        if (target < 0) {
            return 0;
        }
        int result = 0;

        for (int c: s) {
            result += count(s, target - c);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] s = {1,2,3};
        int target = 4;

        System.out.println(count(s,target));
    }
}
