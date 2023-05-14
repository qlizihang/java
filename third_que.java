package third_work;
import java.util.Scanner;
/**
 * @author qlizihang
 * @date 2023/5/11 19:54
 * @description:  编写一个计算 N 个整数平均值的程序。程序提示用户输入，必须输入所有 N 个数。如果用户输入的值是一个负数，则应该抛出一个异常并捕获，
 * 提示“必须是正数或者0”。并提示用户再次输入该数。
 */
public class third_que {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        System.out.println("请输入总数：");
        int n = reader.nextInt();
        int input;
        double sum=0.0f;
        for (int i=0;i<n;i++){
            System.out.println("请输入第" + (i+1) + "个数");
            try{
                input = reader.nextInt();
                if (input<0) throw new inputException("输入的数必须大于0,请重新输入第"+ (i+1) +"个数");
                sum += input;
            }catch (inputException e){
                System.out.println(e.getMessage());
                //e.printStackTrace();
                i-=1;
            }
        }
        System.out.println("平均值为:" + sum/n);
    }
}
class inputException extends Exception{
    public inputException(String s){
        super(s);
    }
}
