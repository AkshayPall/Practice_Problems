public class Solution {
    public int divide(int dividend, int divisor) {
        if(divisor == 1){
            return dividend;
        } else if (divisor == -1){
            if(dividend == Integer.MIN_VALUE){
                return Integer.MAX_VALUE;
            }
            return (0-dividend);
        }
        //check if one is neg
        int sign = (dividend < 0 ^ divisor < 0) ? -1 : 1;
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);

        if(dividend < divisor || divisor == 0){
            return 0;
        }
        if (dividend == divisor){
            return sign;
        }

        //at this point, we know dividend > divisor,
        int backupDiv = divisor;
        int toReturn = 0;
        int tempResult = 0;
        while(dividend >= divisor){ //same as dividend-divisor >= 0
            if(tempResult == 0){
                tempResult++;
            } else {
                tempResult = tempResult << 1;
            }
            divisor = divisor << 1;

            //check here to reset
            if(dividend < divisor){
              divisor = divisor >> 1;
              dividend -= divisor;
              divisor = backupDiv;
              toReturn += tempResult;
              tempResult = 0;
            }
        }
        if(sign < 0){
            toReturn = -toReturn;
        }
        return toReturn;
    }
}
