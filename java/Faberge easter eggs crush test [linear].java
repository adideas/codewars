import java.math.BigInteger;

public class Faberge {
    private static BigInteger mod = BigInteger.valueOf(998244353);
    private static int count = 80001;
    private static BigInteger[] haha = new BigInteger[count];
    
    public static BigInteger height(BigInteger eggs, BigInteger floor) {
      floor = floor.mod(mod);
      
      if (BigInteger.ZERO.compareTo(eggs) == 0) {
        return BigInteger.ZERO;
      }
      
      if (BigInteger.ZERO.compareTo(floor) == 0) {
        return BigInteger.ZERO;
      }
      
      BigInteger height = BigInteger.ZERO;
      BigInteger t = BigInteger.ONE;
      
      if (haha[0] == null) {
        haha[0] = BigInteger.ZERO;
        haha[1] = BigInteger.ONE;
        
        for(int i = 2; i < count; i++) {
          BigInteger index = BigInteger.valueOf(i);
          
          BigInteger a = mod.subtract(mod.divide(index));
          BigInteger b = haha[mod.mod(index).intValue()];
          haha[i] = a.multiply(b).mod(mod);
        }
      }
      
      BigInteger index = BigInteger.ONE;
      BigInteger endIndex = eggs.add(BigInteger.ONE);

      for (;index.compareTo(endIndex) != 0; index = index.add(BigInteger.ONE)) {
        // t = t * (floor - index + 1) * ??? % MOD;
        t = t.multiply(
          floor.subtract(index).add(BigInteger.ONE)
        ).multiply(
          haha[index.intValue()]
        ).mod(mod);
        
        height = height.add(t).mod(mod);
      }
      
      return height.mod(mod);
    }
}
