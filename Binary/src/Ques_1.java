// Bit Hacks – Part 1 (Basic)
// Problem 1. Check if an integer is even or odd
// Problem 2. Detect if two integers have opposite signs or not
// Problem 3. Add 1 to an integer
// Problem 4. Swap two numbers without using any third variable
public class Ques_1 {
    public static void main(String[] args) {
        int n = 10;
//        System.out.println(OppSigns(x));

        int x = 4;
        int y = -8;

        x = 4;
        System.out.println(x + " + " + 1 + " is " + -~x);
        x = -4;
        System.out.println(x + " + " + 1 + " is " + -~x);
        x = 0;
        System.out.println(x + " + " + 1 + " is " + -~x);


        if ((n & 1)!= 0) {
            System.out.println(n + " is odd");
        }else {
            System.out.println(n + " is even");
        }

    }
    public static String toBinaryString(int n) {
        return String.format("%32s", Integer.toBinaryString(n).replace(" ","0"));
    }
    public static void OppSigns(int x, int y) {


        System.out.println(x + " in binary is " + toBinaryString(x));
        System.out.println(y + " in binary is " + toBinaryString(y));

        boolean isOpposite = ((x ^ y) < 0);
        if (isOpposite) {
            System.out.println(x + " and " + y + " have opposite signs");
        }
        else {
            System.out.println(x + " and " + y + " don't have opposite signs");
        }
    }
}
