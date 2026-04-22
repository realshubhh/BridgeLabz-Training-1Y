// LeetCode #1342 - Number of Steps to Reduce a Number to Zero
// If even divide by 2, if odd subtract 1. Count total steps.
// Time: O(log n), Space: O(1)

public class NumberOfStepsToZero {

    public int numberOfSteps(int num) {
        int steps = 0;
        while (num > 0) {
            if (num % 2 == 0) num /= 2;
            else              num -= 1;
            steps++;
        }
        return steps;
    }

    // Bit manipulation approach
    public int numberOfStepsBit(int num) {
        if (num == 0) return 0;
        int steps = 0;
        while (num > 1) {
            steps += (num & 1) == 1 ? 2 : 1; // odd needs subtract+divide, even needs only divide
            num >>= 1;
        }
        return steps + 1; // final step: 1 -> 0
    }

    public static void main(String[] args) {
        NumberOfStepsToZero sol = new NumberOfStepsToZero();
        System.out.println(sol.numberOfSteps(14));    // 6
        System.out.println(sol.numberOfSteps(8));     // 4
        System.out.println(sol.numberOfSteps(123));   // 12

        System.out.println(sol.numberOfStepsBit(14)); // 6
        System.out.println(sol.numberOfStepsBit(8));  // 4
    }
}
