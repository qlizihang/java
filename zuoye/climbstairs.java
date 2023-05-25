package zuoye;

import java.util.ArrayList;

/**
 * @author qlizihang
 * @date 2023/5/23 17:31
 * @description: 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 */
public class climbstairs {
    public static void main(String[] args) {
        int N = 10;
        int count = getways(N);
        System.out.println("一共有" + count + "种方法！");
    }

    public static int getways(int N){
        int[] list = new int[10086];
        list[1] = 1;
        list[2] = 2;
        for (int i=3;i<=N;i++){
            list[i] = list[i-1] + list[i-2];
        }
        return list[N];
    }
}
