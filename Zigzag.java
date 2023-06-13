/* Given an array nums of integers, a move consists of choosing any element and decreasing it by 1. An array A is a 
zigzag array if either:
1)- Every even-indexed element is greater than adjacent elements, ie. A[0] > A[1] < A[2] > A[3] < A[4] > ...
OR, every odd-indexed element is greater than adjacent elements, ie. A[0] < A[1] > A[2] < A[3] > A[4] < ...
Return the minimum number of moves to transform the given array nums into a zigzag array.
* Eg 1 : nums = [1,2,3]        Output = 2
* Eg 2 : nums = [9,6,1,6,2]    Output = 4
*/
import java.util.*;
public class Zigzag
{
      public int MinimumMoves(int nums[])
      {
            int evenMoves = 0, oddMoves = 0;      //* Variables declared -> O(1)
            for(int i = 1; i < nums.length; i = i + 2)     //! Checking Even Moves Required -> O(N)
            {
                  if(i < nums.length - 1)
                  {     // If number index is not last index...
                        if((nums[i] < nums[i + 1]) && (nums[i] < nums[i - 1]))
                              evenMoves = evenMoves + Math.abs(nums[i] - nums[i + 1]) + Math.abs(nums[i] - 
                              nums[i - 1]);
                        else if(nums[i] < nums[i + 1])
                              evenMoves = evenMoves + Math.abs(nums[i] - nums[i + 1]);
                        else if(nums[i] < nums[i - 1])
                              evenMoves = evenMoves + Math.abs(nums[i] - nums[i - 1]);
                  }
                  else    // If number index is last index...
                  {
                        if(nums[i] < nums[i - 1])
                              evenMoves = evenMoves + Math.abs(nums[i] - nums[i - 1]);
                  }
            }
            for(int i = 0; i < nums.length; i = i + 2)     //! Checking Odd Moves Required -> O(N)
            {
                  if((i < nums.length - 1) && (i > 0))
                  {     // If number index is neither first nor last...
                        if((nums[i] < nums[i + 1]) && (nums[i] < nums[i - 1]))
                              oddMoves = oddMoves + Math.abs(nums[i] - nums[i + 1]) + Math.abs(nums[i] - 
                              nums[i - 1]);
                        else if(nums[i] < nums[i + 1])
                              oddMoves = oddMoves + Math.abs(nums[i] - nums[i + 1]);
                        else if(nums[i] < nums[i - 1])
                              oddMoves = oddMoves + Math.abs(nums[i] - nums[i - 1]);
                  }
                  else if(i == 0)    // If number index is first...
                  {
                        if(nums[i] < nums[i + 1])
                              oddMoves = oddMoves + Math.abs(nums[i] - nums[i + 1]);
                  }
                  else     // if number index is last...
                  {
                        if(nums[i] < nums[i - 1])
                              oddMoves = oddMoves + Math.abs(nums[i] - nums[i - 1]);
                  }
            }
            return Math.min(oddMoves, evenMoves) + 1;   // Taking the Minimum...
      }
      public static void main(String args[])
      {
            Scanner sc = new Scanner(System.in);
            int x;
            System.out.print("Enter the number of Elements : ");
            x = sc.nextInt();
            int array[] = new int[x];
            for(int i = 0; i < array.length; i++)
            {
                  System.out.print("Enter value : ");
                  array[i] = sc.nextInt();
            }
            Zigzag zigzag = new Zigzag();    // Object creation...
            System.out.println("Minimum Moves to make Array Zigzag : "+zigzag.MinimumMoves(array)); // Function calling...
            sc.close();
      }
}



//! Time Complexity -> O(N)
//* Space Complexity -> O(1)

// 1. We check for the odd and even indices seperately...
// 2. Then, in the end we take the minimum of the two scores...