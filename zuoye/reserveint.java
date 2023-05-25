package zuoye;

/**
 * @author qlizihang
 * @date 2023/5/23 16:18
 * @description: 给你一个 32 位的有符号整数 x ，返回 x 中每位上的数字反转后的结果。
 * 如果反转后整数超过 32 位的有符号整数的范围 [−231,  231 − 1] ，就返回 0。
 */
public class reserveint {
    public static void main(String[] args) {
        int num = -264128499;
        int re;
        if (num>0) {
            re = reInt(num);
            if (re<-Math.pow(2,31)&&re>Math.pow(2,31)-1){
                re = 0;
            }
            System.out.println(re);
        }
        else if (num<0){
            re = -reInt(num);
            if (re<-Math.pow(2,31)&&re>Math.pow(2,31)-1){
                re = 0;
            }
            System.out.println(re);
        }

    }

    public static int reInt(int num){

        num = Math.abs(num);
        int length = String.valueOf(Math.abs(num)).length();
        int consult;
        int j=0;
        int mul;
        int remainder = Math.abs(num);
        int result = 0;
        for (int i=length-1;i>=0;i--) {
            consult = (int) (remainder / Math.pow(10,i));
            remainder = (int) (num % Math.pow(10,i));
            mul = (int) Math.pow(10,j);
            result += consult*mul;
            j++;
        }

        return result;
    }
}
