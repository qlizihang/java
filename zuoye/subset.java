package zuoye;
import java.util.Scanner;

public class subset {
    public static Scanner sc = new Scanner(System.in);
    public static boolean[] dp = new boolean[4096];
    public static int[] nums;
    public static int n;
    public static void main(String[] args) {
        System.out.print("输入总数N:");
        n = sc.nextInt();
        nums = new int[n];
        int state = 0;
        for(int i = 0; i < n; ++i){
            System.out.print("输入第" + (i+1)+ "个数：");
            nums[i] = sc.nextInt();
            state += 1 << i;
        }
        System.out.print('[');
        sc.close();
        dfs(state);
        System.out.print("[]]");
    }

    private static void dfs(int state) {
        if(dp[state]){
            return;
        }
        if (lower_bit(state) == state) {
            System.out.printf("[%d],", nums[decode(state)]);
            dp[state] = true;
            return;
        }
        int lower = 0, tem;
        while(state != 0) {
            tem = lower_bit(state);
            dfs((state ^ tem) | lower);
            state ^= tem;
            lower |= tem;
        }
        System.out.print('[');
        state = lower;
        dp[state] = true;
        while(state != 0){
            tem = lower_bit(state);
            state ^= tem;
            System.out.print(nums[decode(tem)]);
            if(state != 0){
                System.out.print(',');
            }

        }
        System.out.print("],");
    }

    private static int decode(int num) {
        int res = 0;
        while(num != 0){
            num >>= 1;
            ++res;
        }
        return res - 1;
    }

    private static int lower_bit(int x){
        return x & (-x);
    }
}