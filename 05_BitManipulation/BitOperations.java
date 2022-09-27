public class BitOperations {
    //Get ith Bit
    public static int getIthBit(int n, int i) {
        int bitMask = 1<<i;
        return (n & bitMask) == 0 ? 0 : 1;
    }

    //Set ith Bit
    public static int setIthBit(int n, int i) {
        int bitMask = 1<<i;
        return n | bitMask;
    }

    //Clear ith Bit
    public static int clearIthBit(int n, int i) {
        int bitMask = ~(1<<i);
        return n & bitMask;
    }

    //Update ith Bit
    public static int updateIthBit(int n, int i, int val) {
        //Method1
        // if(val == 0) {
        //     return n & (~(1<<i));
        // } else {
        //     return n | (1<<i);
        // }

        //Method2
        n = clearIthBit(n, i);
        int bitMask = val<<i;
        return n | bitMask;
    }

    //Clear Last i Bits
    public static int clearLastIbits(int n, int i) {
        int bitMask = (~0)<<i; // or (-1)<<i
        return n | bitMask;
    }

    //Clear Bits in Range (i,j)
    public static int clearBitsinRange(int n, int i, int j) {
        int a = ~0<<i;
        int b = (1<<i)-1;
        int bitMask = a | b;
        return n & bitMask;
    }

    //Check if number is power of 2 or not
    public static boolean isPowerof2(int n) {
        return (n & (n-1)) == 0;
    }

    //Count number of set bits
    public static int countSetBits(int n) {
        int setBits = 0;
        int bitMask = 1;
        while(n != 0) {
            if((n & bitMask) != 0) { //last bit is 1
                setBits++;
            }
            n = n>>1;
        }
        return setBits;
    }

    //a faster method to count set bits
    public static int countSetBits2(int n) {
        int setBits = 0;
        while(n>0) {
            // removes the last set bit from curr number
            n = n & (n-1); 
            setBits++;
        }
        return setBits;
    }
    public static void main(String args[]) {
       System.out.println(countSetBits(9));  
    }
}
