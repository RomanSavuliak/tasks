
public class Test {
    public static void main(String[] args) {
        int[] nums = new int[]{3, -1, 12, 4, 5};
        int[] nums2 = new int[]{-3, -1, 12, -4, 5};
        int[] nums3 = new int[]{3, -1, 12, 4, -5};
        String sNums;
        sNums = "[";
        for (int i = 0; i < nums.length; i++) {
            sNums += nums[i];
            if (i + 1 < nums.length)
                sNums += " ";
        }
        sNums += "]";
        System.out.println(sNums);

        printArray(subArrayOfPositiveItems(nums2));
        printArray(subArrayOfEvenIndexItems(nums3));

    }

    public static int[] subArrayOfPositiveItems(int[] nums) {
        int n = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) n++;}
        int[] subArrayOfPositiveItems = new int[n];
        n = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) subArrayOfPositiveItems[n++] = nums[i];}
        return subArrayOfPositiveItems;
    }

    public static int[] subArrayOfEvenIndexItems(int[] nums){
        int n;
        if (nums.length % 2 == 0) n = nums.length/2;
        else n = nums.length / 2 + 1;
        int[] subArrayOfEvenIndexItems = new int[n];
        for (int i = 0; i < nums.length; i+= 2) {
            subArrayOfEvenIndexItems[i/2] = nums[i];
        }
        return subArrayOfEvenIndexItems;
    }

    public static void printArray(int []nums){
        System.out.print('[');
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]);
            if (i + 1 < nums.length)
                System.out.print(" ");
        }
        System.out.println(']');
    }
}