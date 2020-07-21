package chapter14;

class NumberOf1Bits {
    public int hammingWeight(int n) {
        int sum = 0;
        while (n != 0) {
            sum++;
            n &= (n - 1); //清零最底位的1
        }
        return sum;
    }
}