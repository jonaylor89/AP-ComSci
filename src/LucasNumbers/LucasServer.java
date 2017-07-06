package LucasNumbers;

import java.util.ArrayList;

 class LucasServer {

     private static ArrayList<LNumber> luci = new ArrayList<>();

    static void lucasNumbers(int count) {

        luci.clear();

        int x = 2, y = 1;
        luci.add(new LNumber(x));
        luci.add(new LNumber(y));

        for(int i = 2; i < count; i++){
            int z = x + y;
            luci.add(new LNumber(z));

            x = y;
            y = z;
        }
    }

    static void checkDivisibility(){

        for(LNumber j : luci) {
            if (j.getValue() % 5 == 0) {
                j.setDivisible();
            }
        }
    }

    static void dump(){

        System.out.println("Value : Divisible by 5");

        for(LNumber l : luci) {
            System.out.println(l.toString());
        }
    }

}
