package sample;

import java.util.ArrayList;

/**
 * Created by 40095 on 11/4/15.
 */
public class timingTest {
    public static void main(String[] args) {
        long badStart = System.currentTimeMillis();
        bad();
        long badEnd = System.currentTimeMillis();
        System.out.println("bad took " + (badEnd - badStart) + " millis");
        long goodStart = System.currentTimeMillis();
        good();
        long goodEnd = System.currentTimeMillis();
        System.out.println("good took " + (goodEnd - goodStart) + " millis");
    }
    public static void bad() {
        for (int i = 0; i <= 4; i++) {
            System.out.println(binomialInt(4).get(i) + " | " + i);
        }
    }
    public static void good() {
        ArrayList<Double> binomialInt_4 = binomialInt(4);
        for (int i = 0; i <= 4; i++) {
            System.out.println(binomialInt_4.get(i) + " | " + i);
        }

    }
    public static ArrayList<Double> binomialInt(int n) {
        ArrayList<Double> binomialArr = new ArrayList<Double>(n);
        for (int i = 0; i <= n; i++) {
            binomialArr.add(choose(n, i) / (Math.pow(2, n)));
        }
        return binomialArr;
    }
    public static int choose(int n, int k) {
        if (k > n)
            return 0;
        if (k == n)
            return 1;
        if (k == 0)
            return 1;
        return choose(n - 1, k - 1) * n / k;
    }
}
