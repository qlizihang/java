package first_work;

public class one_work {
    public static void main(String args[]){
        System.out.println("1.B  2.B  3.D 4.B  5.D");
        System.out.println(" ");
        showTriangle(4);
        System.out.println(" ");
        reverseString("abcdefg");
        System.out.println(" ");
        isPalindrome(123321);
        isPalindrome(23564);
        System.out.println(" ");
        shuixianHua();
        System.out.println(" ");
        arrayDemo();
    }


    public static void showTriangle(int n){
        System.out.println("n=" + n);
        for(int i=0;i<n;i++){
            for (int j = 1;j<=n-i;j++){
                System.out.print(" ");
            }
            for (int k=0;k<2*i+1;k++){
                System.out.print("★");
            }
            System.out.println(" ");
        }
    }


    public static void reverseString(String s){
        char[] arr = s.toCharArray();
        String s1 = "";
        for (int i=s.length()-1;i>=0;i--){
            s1 += arr[i];
        }
        String s2 = String.valueOf(s1);
        System.out.println(s2);
    }

    public static void isPalindrome(int num){
        boolean flag = false;
        int i = num;
        int j=0;
        while(num!=0){
            j = j*10 + (num%10);
            num = (int)num/10;
        }
        if (i == j){
            flag = true;
        }else {
            flag = false;
        }


        if(flag){
            System.out.println("是的");
        }else{
            System.out.println("不是");
        }
    }

    public static void shuixianHua(){
        int a,b,c;
        for (int i=100;i<1000;i++){
            a = i%10;
            b = i/10%10;
            c = i/100;
            if (a*a*a+b*b*b+c*c*c == i){
                System.out.print(i+" ");
            }
        }
    }

    public static void arrayDemo(){
        int[] arr = new int[]{5,2,7,89,23,56,13,47,74,51,45};
        int max = arr[0];
        int min = arr[0];
        for (int i=0;i<arr.length;i++){
            if (max<arr[i]) {
                max = arr[i];
            }
        }
        for (int i=0;i<arr.length;i++){
            if (min>arr[i]) {
                min = arr[i];
            }
        }
        System.out.println("最大值：" + max +"最小值：" + min);
        System.out.printf("两个最值之和：%d", max+min);
    }
}
