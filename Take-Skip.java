public class Main {
    public static int[] takeSkip(int[] nums, int take, int skip) {
        //Extra credit part - predetermine array size
        //The first element accounts for how many full cycle of take + skip we can fit
        //The second element accounts for that small leftover section, which will either be a full take amount or the remainder of cycle, whichever is less
        int length = (take * (nums.length / (take + skip))) + Math.min(nums.length % (take + skip), take);
        
        int[] result = new int[length];
        int takeCount = 0;                          //keep track of how many have been taken at a time
        int resItr = 0;                             //iterator for the result array
        for (int i = 0; i < nums.length; i++) {
            if (takeCount == take) {                //if the full amount has been taken, start skipping, skip - 1 because i will increase again at the end of the loop
                i += (skip - 1);
                takeCount = 0;                      //reset the amount taken this cycle
            } else {
                result[resItr] = nums[i];           //else, take the number and put it in the result array
                resItr++;
                takeCount++;                        //increment the amount taken
            }
        }
        
        return result;
    }
    
    public static void main(String args[]) {
        int[] test = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        
        int[] result1 = takeSkip(test, 1, 2);
        for (int i = 0; i < result1.length; i++) {
            System.out.print(result1[i] + ", ");
        }
        System.out.println("");
        int[] result2 = takeSkip(test, 1, 5);
        for (int i = 0; i < result2.length; i++) {
            System.out.print(result2[i] + ", ");
        }
        System.out.println("");
        int[] result3 = takeSkip(test, 3, 2);
        for (int i = 0; i < result3.length; i++) {
            System.out.print(result3[i] + ", ");
        }
        System.out.println("");
        int[] result4 = takeSkip(test, 2, 2);
        for (int i = 0; i < result4.length; i++) {
            System.out.print(result4[i] + ", ");
        }
    }
}
