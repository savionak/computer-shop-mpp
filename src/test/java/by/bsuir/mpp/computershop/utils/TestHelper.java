package by.bsuir.mpp.computershop.utils;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.Random;

public class TestHelper {

    public static final Random RANDOM = new Random();
    public static final String NON_RANDOM_STRING = "some_nonrandom_value";

    private static final int BITS_COUNT = 130;
    private static final int RADIX = 32;

    public static Long nextLongId() {
        return RANDOM.nextLong() + 1;
    }

    public static Long nextLong() {
        return RANDOM.nextLong();
    }

    public static int nextInt(int max) {
        return RANDOM.nextInt(max) + 1;
    }

    public static Timestamp getCurrentTimestamp(){
        return new Timestamp(System.currentTimeMillis()) ;
    }

    public static String nextString() {
        return nextString(BITS_COUNT);
    }

    public static String nextString(int bitsCount) {
        return new BigInteger(bitsCount, RANDOM).toString(RADIX);
    }
}
