import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Graph plt = new Graph();
        int[] values = new Random().ints(10, 0, 101).toArray();

        System.out.println(Arrays.toString(values));
        plt.plot(values);
        plt.show();
    }
}
