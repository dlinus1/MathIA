package sample;

public class ArraysOnly {
    double[][] tiers;
    int tiers_num = 2;

    public static void main(String[] args) {
        // Dont change stuff from HERE
        long startTime = System.currentTimeMillis();
        // to HERE        
        ArraysOnly nuts = new ArraysOnly();
        nuts.doThings();
        nuts.printTiers();
        // or HERE 
        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
        System.out.println("\n" + (nuts.tiers_num - 1) + " tiers took " + duration + " milliseconds");
        // to HERE
    }

    public ArraysOnly() {         // set length of tiers correctly
        tiers_num++;
        tiers = new double[tiers_num][];
        for (int i = 1; i < tiers_num; i++) {
            tiers[i] = new double[(int) (Math.pow(4, i) + 1)];
        }
    }

    private void doThings() {
        tiers[1] = binomialInt(4);
        for (int i = 2; i < tiers.length; i++) {
             binomialWow(i);
        }
        
    }
    private void printTiers() {
        for (int i = 1; i < tiers.length; i++) {
            System.out.println("Tier " + i);
            long startTime = System.currentTimeMillis();
            for (int j = 0; j < Math.min(tiers[i].length, 6); j++) {
                System.out.println(tiers[i][j]);
            }
            long endTime = System.currentTimeMillis();
            long duration = endTime - startTime;
            System.out.println("Tier " + i + " took " + duration + " millis\n");
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

    public static double[] binomialInt(int n) {
        double[] binomialDistribution = new double[n + 1];
        for (int i = 0; i <= n; i++) {
            binomialDistribution[i] = (choose(n, i) / (Math.pow(2, n)));
        }
        return binomialDistribution;
    }

    public void binomialWow(int tier) {
        double[] randomTemp = new double[(int) (Math.pow(4, tier)) + 1];
        for (int i = 0; i < tiers[tier - 1].length; i++) {
            double[] nuts = binomialInt(4 * i);
            for (int j = 0; j < 4 * i; j++) {
                if(tier == 2) {
                    System.out.println(tiers[tier][j]);
                }
                randomTemp[j] = tiers[tier - 1][i] * nuts[j];
                tiers[tier][j] += tiers[tier][j];
            }
        }
    }
}