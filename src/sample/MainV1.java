package sample;

import java.util.ArrayList;

public class MainV1 {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        System.out.println("Tier 1");
        for (int i = 0; i <= 4; i++) {
            System.out.println(binomialInt(4).get(i) + " | " + i);
        }
        System.out.println("end tier 1");
        System.out.println("Cumulative time: " + (System.currentTimeMillis() - startTime));
        System.out.println("\n");

//        for (int i = 0; i < 16; i++) {
////            System.out.println(binomialWow(binomialInt(4)).get(i) + " | " + i);
//            System.out.println(binomialINSANE(2).get(i) + " | " + i);
//        }

        System.out.println("Tier 2");
        for (int i = 0; i < 6; i++) {
            System.out.println(binomialINSANE(2).get(i) + " | " + i);
        }
        double temp = 0.0;
        for (int i = 6; i < binomialINSANE(2).size(); i++) {
            temp+=binomialINSANE(2).get(i);
        }
        System.out.println(temp);
        System.out.println("end tier 2");
        System.out.println("Cumulative time: " + (System.currentTimeMillis() - startTime));
        System.out.println("\n");


        System.out.println("Tier 3");
        for (int i = 0; i < 6; i++) {
            System.out.println(binomialINSANE(3).get(i) + " | " + i);
        }
        temp = 0.0;
        for (int i = 6; i < binomialINSANE(3).size(); i++) {
            temp+=binomialINSANE(3).get(i);
        }
        System.out.println(temp);
        System.out.println("End tier 3");
        System.out.println("Cumulative time: " + (System.currentTimeMillis() - startTime));
        System.out.println("\n");


        System.out.println("tier 4");
        for (int i = 0; i < 6; i++) {
            System.out.println(binomialINSANE(4).get(i) + " | " + i);
        }
        temp = 0.0;
        for (int i = 6; i < binomialINSANE(4).size(); i++) {
            temp+=binomialINSANE(4).get(i);
        }
        System.out.println(temp);
        System.out.println("End tier: 4");
        System.out.println("Cumulative time: " + (System.currentTimeMillis() - startTime));
        System.out.println("\n");


        System.out.println("tier 5");
        for (int i = 0; i < 6; i++) {
            System.out.println(binomialINSANE(5).get(i) + " | " + i);
        }
        temp = 0.0;
        for (int i = 6; i < binomialINSANE(5).size(); i++) {
            temp+=binomialINSANE(5).get(i);
        }
        System.out.println(temp);
        System.out.println("End tier: 5");
        System.out.println("Cumulative time: " + (System.currentTimeMillis() - startTime));
        System.out.println("\n");

    }
    public static int choose(int n, int k) {
        if(k>n)
            return 0;
        if(k==n)
            return 1;
        if(k==0)
            return 1;
        return choose(n-1,k-1)*n/k;
    }

    public static ArrayList<Double> binomialInt(int n) {
        ArrayList<Double> randomVar = new ArrayList<Double>(n);
        for (int i = 0; i <= n; i++) {
            randomVar.add(choose(n,i)/(Math.pow(2,n)));
        }
        return randomVar;
    }

    public static ArrayList<Double> binomialWow(ArrayList<Double> nested) {
        ArrayList<Double> randomPLEASEWORK = new ArrayList<Double>();
        ArrayList<Double> randomTemp = new ArrayList<Double>(randomPLEASEWORK.size());

        for (int i = 0; i <= 4*(nested.size() - 1); i++) {
            randomPLEASEWORK.add(0.0);
            randomTemp.add(0.0);
        }
        System.out.println(randomPLEASEWORK.size());

        for (int i = 0; i < nested.size(); i++) {
            for (int j = 0; j <= 4 * i; j++) {
                randomTemp.set(j, nested.get(i)*binomialInt(4*i).get(j));
                randomPLEASEWORK.set(j, randomPLEASEWORK.get(j) + randomTemp.get(j));
            }
//            System.out.println("Random Temp: " + randomTemp + " | " + i);
        }

        return randomPLEASEWORK;
    }

    public static ArrayList<Double> binomialINSANE(int n) {
        if(n==1)
            return binomialInt(4);
        else
            return binomialWow(binomialINSANE(n - 1));
    }
}