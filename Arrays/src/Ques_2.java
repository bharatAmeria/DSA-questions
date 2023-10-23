import java.util.HashSet;
import java.util.Set;

// Check if a sub array with 0 sum exists or not
public class Ques_2 {

    public static Boolean findSub_array (int[] arr){
        Set<Integer> set = new HashSet<>();

        set.add(0);
        int sum = 0;

        for (int value: arr) {
            sum+= value;
            if (set.contains(sum)) {
                return true;
            }
            set.add(sum);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {4,-6,3,-1,4,2,7};
        if(findSub_array(arr)) {
            System.out.println("Sub array exist");
        }else {
            System.out.println("Sub array DNE");
        }
    }
}
