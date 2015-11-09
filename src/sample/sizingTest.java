package sample;

import java.util.ArrayList;

public class sizingTest {
    public static void main(String[] args) {
        ArrayList<Double>[] tiers = new ArrayList[14];
        tiers[0] = new ArrayList<Double>(5);
        for (int i = 1; i < 14; i++) {
            tiers[i] = binomialINSANE(i, tiers);
            System.out.println("tier " + i + " size: " + tiers[i].size());
        }
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

    public static ArrayList<Double> binomialInt(int n) {
        ArrayList<Double> randomVar = new ArrayList<Double>(n);
        for (int i = 0; i <= n; i++) {
            randomVar.add(choose(n, i) / (Math.pow(2, n)));
        }
        return randomVar;
    }


    public static ArrayList<Double> binomialWow(ArrayList<Double> nested) {
        ArrayList<Double> randomPLEASEWORK = new ArrayList<Double>();
        ArrayList<Double> randomTemp = new ArrayList<Double>(randomPLEASEWORK.size());

        for (int i = 0; i <= 4 * (nested.size() - 1); i++) {
            randomPLEASEWORK.add(0.0);
            randomTemp.add(0.0);
        }
        return randomPLEASEWORK;
    }


    public static ArrayList<Double> binomialINSANE(int n, ArrayList<Double>[] tiers) {
        if (n == 1)
            return binomialInt(4);
        else
            return binomialWow(tiers[n-1]);
    }
}