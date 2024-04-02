public class Main {
    public static void main(String[] args) {
        java.util.Scanner sc = new java.util.Scanner(System.in);
        int n = sc.nextInt();
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = sc.nextInt();
        }
        int[] triangleNumbers = new int[45];
        for (int i = 1; i <= 45; i++) {
            triangleNumbers[i-1] = i * (i + 1) / 2;
        }
        for (int number: numbers) {
            boolean isPossible = false;
            for (int i = 0; i < 45; i++) {
                for (int j = 0; j < 45; j++) {
                    for (int k = 0; k < 45; k++) {
                        if (triangleNumbers[i] + triangleNumbers[j] + triangleNumbers[k] == number) {
                            isPossible = true;
                            break;
                        }
                    }
                    if (isPossible) {
                        break;
                    }
                }
                if (isPossible) {
                    break;
                }
            }
            if (isPossible) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }
    }
}
