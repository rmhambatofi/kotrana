package fr.manitra.kotrana;

/**
 * Created by manitra on 06/11/2016.
 */
public class BitManipulation {

    public static void main(String[] args) {
        int i = 32;
        while(i-- > 0) {
            System.out.print(getBit(5, i) ? '1' : '0');
        }
        System.out.println();
        // 5 = 101, let set bit at position 1 (which is 0) to 1
        System.out.println(setBit(5, 1));
        // 5 = 101, let clear bit at position 2 (it should return 1)
        System.out.println(clearBit(5, 2));
    }

    public static boolean getBit(int num, int pos) {
        return ((num & (1 << pos)) != 0);
    }

    public static int setBit(int num, int pos) {
        return num | (1 << pos);
    }

    public static int clearBit(int num, int pos) {
        int mask = ~(1 << pos); // something like 11110111
        return num & mask;
    }
}
