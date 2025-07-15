// public class bitmanipulation {


//     public static void main(String[] args) {
//         int n = 308;
//         int i=3;
//         int mask = 1<<i;
//         if((n&mask)!=0){
//             System.out.println("bit are set");
//         }else{
//             System.out.println("bit are not set");
//         }

//         if((n&mask)==n){
//             System.out.println("bit");
//         }else{
//             System.out.println("not bit");
//         }

//         //problem 3: clear ith bit;
//         int mask = ~(1<<i);
//         if((n&mask)==0){
//             System.out.println(i+"th bit is cleared");
//         }

//         //count bits which changes while converting n to 0 if n=13
//         result = n&(n-1);

//         {
//             int n = 13;
//             int count =0;
//             while(n!=0){
//                 count++;
//                 n = n&(n-1);

//             }
//             System.out.println(count);
//         }


//         //write the function that takes an integer as input and return the count of set bits it has
//         n=11;
//         binary = 1011;
//         output = 3;
//         countbits(int n){
//             int count =0;
//             while(n>0){
//                 count+=n&1;
//                 n>>=1;
//             }
//             return count;
//         }


//     }
// }







public class bitmanipulation {

    // Q1: Check if the ith bit is set
    public static void checkIfBitIsSet(int n, int i) {
        int mask = 1 << i;
        if ((n & mask) != 0) {
            System.out.println("Q1: The " + i + "th bit is set.");
        } else {
            System.out.println("Q1: The " + i + "th bit is not set.");
        }
    }

    // Q2: Check if (n & mask) == n
    public static void compareWithMask(int n, int i) {
        int mask = 1 << i;
        if ((n & mask) == n) {
            System.out.println("Q2: (n & mask) is equal to n.");
        } else {
            System.out.println("Q2: (n & mask) is NOT equal to n.");
        }
    }

    // Q3: Clear the ith bit
    public static void clearIthBit(int n, int i) {
        int clearMask = ~(1 << i);
        int result = n & clearMask;
        System.out.println("Q3: After clearing " + i + "th bit: " + result);
    }

    // Q4: Count number of bits changed using n = n & (n-1)
    public static void countSetBitsByClearing(int n) {
        int count = 0;
        int temp = n;
        while (temp != 0) {
            count++;
            temp = temp & (temp - 1);
        }
        System.out.println("Q4: Number of set bits in " + n + " is " + count);
    }

    // Q5: Count number of set bits using right shift
    public static int countBits(int n) {
        int count = 0;
        while (n > 0) {
            count += n & 1;
            n >>= 1;
        }
        return count;
    }

    public static void main(String[] args) {

        int n1 = 308;
        int bitIndex = 3;

        // Q1
        checkIfBitIsSet(n1, bitIndex);

        // Q2
        compareWithMask(n1, bitIndex);

        // Q3
        clearIthBit(n1, bitIndex);

        // Q4
        int numberToCount = 13;
        countSetBitsByClearing(numberToCount);

        // Q5
        int input = 11;
        int output = countBits(input);
        System.out.println("Q5: Number of set bits in " + input + " is " + output);
    }
}
