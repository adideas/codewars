import java.math.BigInteger;
import java.util.stream.LongStream;
import java.util.HashMap;

public class Faberge {
  public static HashMap<Long, BigInteger> save = new HashMap<Long, BigInteger>();
  
  public static BigInteger height(BigInteger eggs, BigInteger floor) {
    System.out.println(eggs + " => " + floor);
    
    
    return BigInteger.TWO.pow(floor.intValue())
      .subtract(BigInteger.ONE)
      .subtract(
        calculateSmartSumOfDeltas(eggs, floor)
      );
  }

  private static BigInteger calculateSmartSumOfDeltas(BigInteger eggs, BigInteger floor) {
    
    long diff = floor.subtract(eggs).longValue();
    
    BigInteger sum = BigInteger.ZERO;
    
    Factorial left = null;
    Factorial right = null;
    
    for (long i = 0; i < diff; i++) {
      
      if (left == null || right == null) {
        left = new Factorial(floor.longValue() - i + 1L, floor.longValue());
        right = new Factorial(1L, i);
        
      } else { 
        left.toLeft();
        right.toRight();
      }
      
      sum = sum.add(left.value.divide(right.value));
    }
    return sum;
  }
  
  public static class Factorial {
    public BigInteger value = BigInteger.ONE;
    public Long from;
    public Long to;
    
    public Factorial(Long from, Long to)
    {
      this.from = from;
      this.to = to;
      for(;from <= to; from++) {
        value = value.multiply(BigInteger.valueOf(from));
      }
    }
    
    public void toLeft() {
      from--;
      value = value.multiply(BigInteger.valueOf(from));
    }
    
    public void toRight() {
      to++;
      value = value.multiply(BigInteger.valueOf(to));
    }
  }
}
