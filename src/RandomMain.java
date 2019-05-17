import java.security.SecureRandom;

import java.util.HashMap;
import java.util.Random;

public class RandomMain {
    public static void main(String[] args) {
        int parameter = 3;
        SecureRandom srandom = new SecureRandom();
        HashMap<Integer, Integer> counter = new HashMap<>();
        Random random = new Random();
        XorGenerator xor = new XorGenerator();
        generate10000(counter, srandom, parameter);
        print(counter, srandom);
        generate10000(counter, random, parameter);
        print(counter, random);
        generate10000(counter, xor, parameter);
        print(counter, xor);
    }

    public static void generate10000(HashMap<Integer, Integer> counter, Random rand, int parameter) {
        for (int i = 0; i < 100000; ++i) {
            int c = rand.nextInt(parameter) + 1;
            Integer a = counter.get(c);
            if (a == null) {
                counter.put(c, 1);
            } else {
                counter.put(c, a + 1);
            }
        }
    }

    public static void print(HashMap<Integer, Integer> counter, Random rand) {
        System.out.println("Generator " + rand.getClass().getName() + " has made:");
        counter.forEach((key, value) -> {
            System.out.print(key + " amount: " + value + "; ");
            counter.put(key, 0);
        });
        System.out.println("");
    }

}
