package sample;

import java.util.ArrayList;

public class NotDumb {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();

        int num_of_tiers = 14;
        num_of_tiers++;
        ArrayList<Double>[] tier = new ArrayList[num_of_tiers];

        tier[1] = binomialINSANE(tier, 1);
        System.out.println("Tier: 1");
        for (int i = 0; i <= 4; i++) {
            System.out.println(tier[1].get(i) + " | " + i);
        }
        System.out.println("Cumulative time: " + (System.currentTimeMillis() - startTime));
        
        for (int i = 2; i < num_of_tiers; i++) {
            System.out.println("Tier: " + i);
            tier[i] = binomialINSANE(tier, i);
            for (int j = 0; j < 6; j++) {
                System.out.println(tier[i].get(j) + " | " + j);
            }
            double temp = 0.0;
            for (int j = 6; j < tier[i].size(); j++) {
                temp += tier[i].get(j);
            }
            System.out.println(temp);
            System.out.println("Cumulative time: " + (System.currentTimeMillis() - startTime));
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
        ArrayList<Double> randomTemp = new ArrayList<Double>();

        for (int i = 0; i <= 4 * (nested.size() - 1); i++) {
            randomPLEASEWORK.add(0.0);
            randomTemp.add(0.0);
        }

        for (int i = 0; i < nested.size(); i++) {
            ArrayList<Double> binomialInt_NUTS = binomialInt(4 * i);
            for (int j = 0; j <= 4 * i; j++) {
                randomTemp.set(j, nested.get(i) * binomialInt_NUTS.get(j));
                randomPLEASEWORK.set(j, randomPLEASEWORK.get(j) + randomTemp.get(j));
            }
//            System.out.println("Random Temp: " + randomTemp + " | " + i);
        }

        return randomPLEASEWORK;
    }

    public static ArrayList<Double> binomialINSANE(ArrayList[] tier, int n) {
        if (n == 1)
            return binomialInt(4);
        else
            return binomialWow(tier[n-1]);
    }
}