public class total_possible_sol_to_a_linear_Eq_of_k_variable {
    public static int count(int[] coeff, int k, int rhs) {
        if (rhs == 0) {
            return 1;
        }
        if (rhs < 0 || k < 0) {
            return 0;
        }
        int include = count(coeff, k, rhs - coeff[k]);
        int exclude = count(coeff, k-1, rhs);
        return include + exclude;
    }

    public static void main(String[] args) {
        int[] coeff = {1,2,3};
        int k = coeff.length;

        int rhs = 4;
        System.out.println(count(coeff, k-1, rhs));

    }


}
