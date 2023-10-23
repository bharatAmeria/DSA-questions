// Bit Hacks – Part 2 (Playing with k’th bit)

public class Ques_2 {

    public static void main(String[] args) {
        int n = 20;
        int k = 3;

        System.out.println(n + " in binary is " + Integer.toBinaryString(n));
        System.out.println("Turning k'th bit off…");
        n = turnOffKthBit(n, k);
        System.out.println(n + " in binary is " + Integer.toBinaryString(n));

        System.out.println(n + " in binary is " + Integer.toBinaryString(n));
        System.out.println("Turning k'th bit on…");
        n = turnOnKthOBit(n,k);
        System.out.println(n + " in binary is " + Integer.toBinaryString(n));


        System.out.println(n + " in binary is " + Integer.toBinaryString(n));

        if (isKthbitSet(n,k)) {
            System.out.println("K'th bit is set");
        }else{
            System.out.println("k'th bit is not set");
        }

        System.out.println(n + " in binary is " + Integer.toBinaryString(n));
        System.out.println("Toggling k'th bit of n…");
        n = toggleKthBit(n, k);

        System.out.println(n + " in binary is " + Integer.toBinaryString(n));
    }
    public static int turnOffKthBit(int n, int k) {
        return n & ~(1 << (k-1));
    }

    public static int turnOnKthOBit(int n, int k ) {
        return n | (1 << (k-1));
    }
    public static boolean isKthbitSet(int n, int k ) {
        return (n & (1 << (k-1))) != 0;
    }
    public static int toggleKthBit(int n, int k) {
        return n ^ (1 << (k - 1));
    }


}
