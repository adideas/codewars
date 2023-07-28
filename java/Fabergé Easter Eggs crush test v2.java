import java.math.BigInteger;

public class Faberge {
    public static BigInteger height(BigInteger eggs, BigInteger tries) {
        BigInteger result = BigInteger.ZERO;
        BigInteger tempResult = BigInteger.ONE;
        for (int i=1; i<=eggs.intValue(); result = result.add(tempResult), i++) {
            tempResult = tempResult.multiply(tries.add(BigInteger.valueOf(1-i))).divide(BigInteger.valueOf(i));
        }
        return result;
    }
}
