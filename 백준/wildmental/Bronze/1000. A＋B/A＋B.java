import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        // 버퍼 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 입력
        String[] nums = br.readLine().split(" ");
        // 출력
        System.out.println(Integer.parseInt(nums[0]) + Integer.parseInt(nums[1]));
    }
}
