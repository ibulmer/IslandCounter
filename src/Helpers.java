/**
 * Created by ianbulmer on 12/15/18.
 */
public class Helpers {

    public static int getMaxIndex(double[] arr) {
        double result[] = new double[arr.length];
        double max = 0;
        int maxIndex = 0;
        System.out.println("\n");
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
                maxIndex = i;
            }
        }

        return maxIndex;
    }
}
