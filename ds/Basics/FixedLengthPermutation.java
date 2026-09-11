public class FixedLengthPermutation {

    static int count = 0;

    public static void permute(int n) {
        int[] arr = new int[n];
        backtrack(arr, 0, n);
    }

    private static void backtrack(int[] arr, int index, int n) {

        if (index == n) {
            count++;
            printer(arr);
            return;
        }

        for (int i = 0; i <= n; i++) {

            arr[index] = i;

            backtrack(arr, index + 1, n);

            arr[index] = 0;
        }
    }

    private static void printer(int[] arr) {
        System.out.println("Permutation " + count + ":");

        for (int x : arr) {
            System.out.print(x + " ");
        }

        System.out.println();
    }

    public static void main(String[] args) {
        permute(2);
    }
}