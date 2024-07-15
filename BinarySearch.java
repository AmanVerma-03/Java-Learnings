import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // Test the search function
        String name = "AmanVerma";
        char a = 'a';
        System.out.println(search(name, a)); // Output: true

        // Print the char array of the name
        System.out.println(Arrays.toString(name.toCharArray()));

        // Test the binarySearch function
        int[] arr = {10, 34, 56, 89, 98};
        int target = 89;
        int index = binarySearch(arr, target);
        System.out.println("Target found at index: " + index); // Output: Target found at index: 3

        // Test the orderAgnosticBinary function
        int[] arrAsc = {10, 34, 56, 89, 98};
        int[] arrDesc = {98, 89, 56, 34, 10};
        int targetAsc = 89;
        int targetDesc = 10;
        int indexAsc = orderAgnosticBinary(arrAsc, targetAsc);
        int indexDesc = orderAgnosticBinary(arrDesc, targetDesc);
        System.out.println("Target found at index in ascending array: " + indexAsc); // Output: Target found at index: 3
        System.out.println("Target found at index in descending array: " + indexDesc); // Output: Target found at index: 3
    }

    static boolean search(String str, char target) {
        if (str.length() == 0)
            return false;

        for (int i = 0; i < str.length(); i++) {
            if (target == str.charAt(i))
                return true;
        }
        return false;
    }

    // This is binary search
    static int binarySearch(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            // int mid = (start + end)/2;
            // integer have a fix size , there might be possible that (start + end) thing we are doing exceeds the range of integers in java
            int mid = start + (end - start) / 2;
            if (target < arr[mid])
                end = mid - 1;
            else if (target > arr[mid])
                start = mid + 1;
            else
                return mid;
        }
        return -1; // Target not found
    }

    // This is orderAgnostic binary search
    static int orderAgnosticBinary(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        // find whether the array is sorted in ascending or descending order
        boolean isAsc = arr[start] < arr[end];
        while (start <= end) {
            // int mid = (start + end)/2;
            // integer have a fix size , there might be possible that (start + end) thing we are doing exceeds the range of integers in java
            int mid = start + (end - start) / 2;
            if (arr[mid] == target) {
                return mid;
            }
            if (isAsc) {
                if (target < arr[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if (target < arr[mid]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }
}
