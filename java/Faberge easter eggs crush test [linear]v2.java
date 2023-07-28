import java.math.BigInteger;

public class Faberge {
  private static BigInteger mo = BigInteger.valueOf(998244353);
  
  public static BigInteger height(BigInteger n, BigInteger m) {
    BigInteger ret = BigInteger.ZERO;
    BigInteger binom = BigInteger.ONE;
    for (BigInteger i = BigInteger.ONE; i.compareTo(n) <= 0; i = i.add(BigInteger.ONE)) {
      binom = binom.multiply(m.subtract(i).add(BigInteger.ONE)).multiply(i.modInverse(mo)).mod(mo);
      ret = ret.add(binom).mod(mo);
    }
    return ret;
  }
}
