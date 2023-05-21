import java.util.Scanner;
/**
 * @author qlizihang
 * @date 2023/5/11 19:54
 * @description:  编写一个计算 N 个整数平均值的程序。程序提示用户输入，必须输入所有 N 个数。如果用户输入的值是一个负数，则应该抛出一个异常并捕获，
 * 提示“必须是正数或者0”。并提示用户再次输入该数。
 */

public class third_que {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("请输入总数N：");
        int flag =  0;
        while (flag==0){
            try {
                int n = in.nextInt();
                if (n <= 0) {
                    throw new IllegalArgumentException();
                }
                System.out.println("你需要输入" + n + "个数");


                int a;
                double sum = 0;
                for (int i = 0; i < n; i++) {
                    System.out.println("请输入第" + (i + 1) + "个数");
                    try {
                        a = in.nextInt();
                        if (a < 0) {
                            throw new IllegalArgumentException();
                        }
                        sum += a;
                    } catch (IllegalArgumentException e) {
                        System.out.println("输入的数必须是正整数或0，请重新输入该数");
                        i -= 1;
                    }
                }
                System.out.println("平均数是：" + sum / n);
            } catch (IllegalArgumentException e) {
                System.out.println("输入的数没有意义,请重新输入：");
            }
        }

    }
}

