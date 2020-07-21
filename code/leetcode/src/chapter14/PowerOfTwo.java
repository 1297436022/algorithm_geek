package chapter14;

class PowerOfTwo {

    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0; //清除最低位的1
    }
    
}