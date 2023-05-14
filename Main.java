public class Main {
    public static void main(String[] args) {
        System.out.println("<-------第一题------->");
        //TODO:在此编写第一题测试代码
        Compute compute;
        compute = new add();
        UseCompute.useCom(compute, 28,7);
        compute = new sub();
        UseCompute.useCom(compute, 28, 7);
        compute = new mul();
        UseCompute.useCom(compute, 28, 7);
        compute = new div();
        UseCompute.useCom(compute, 28, 7);


        System.out.println("<-------第二题------->");
        //TODO:在此编写第二题测试代码
        int[] score = new int[3];
        score[0] = 90;
        score[1] = -10;
        score[2] = 141;
        for (int i=0;i<3;i++){
            try{
                System.out.println("第" + (i+1) + "个数字：");
                if (score[i]>=0 && score[i]<=100){
                    System.out.println(score[i]);
                }else {
                    throw new ScoreException("输入异常");
                }
            }catch (ScoreException e){
                System.out.println(e.getMessage());
                //e.printStackTrace();
            }
        }
        System.out.println("<-------第三题------->");
        //TODO:在此编写第三题测试代码
        System.out.println("第三题需要输入来进行测试，所以见单独的Java文件。");
        System.out.println("<-------第四题------->");
        //TODO:在此编写第四题测试代码
        MyDate mydate = new MyDate("2002","3","11");
        System.out.println("MyDate类测试：" + mydate);
        Employee em = new employ("lisi", 23, mydate);
        System.out.println(em);

        System.out.println("<-------第五题------->");

        //TODO:在此编写第五题测试代码
        String s = "abcde";
        String[] words = new String[]{"a", "bb","acd", "ace"};
        int count = CountWords(s, words);
        System.out.println(count);
    }

    private static int CountWords(String S, String[] words) {
        int count = 0;
        for (String word : words)
            if (panduan(S, word)) {
                count++;
            }
        return count;
    }

    private static  boolean panduan(String S, String word) {
        int i = 0, j = 0;
        while (i < S.length() && j < word.length()) {
            if (S.charAt(i) == word.charAt(j)) {
                j++;
            }
            i++;
        }
        return j == word.length();
    }
}
//第一题相关代码：
interface  Compute{
    int computer(int n, int m);
}
class add implements Compute {
    @Override
    public int computer(int n, int m) {
        return n+m;
    }
}
class sub implements Compute {
    @Override
    public int computer(int n, int m) {
        return n-m;
    }
}
class mul implements Compute {
    @Override
    public int computer(int n, int m){
        return m*n;
    }
}

class div implements Compute {
    @Override
    public int computer(int n, int m){
        return n/m;
    }
}

class UseCompute {
    public static void useCom(Compute com, int one, int two) {
        System.out.println("结果: " + com.computer(one, two));
    }
}
//第二题相关代码：
class ScoreException extends Exception{
    public ScoreException(String s){
        super(s);
    }
}
//第四题相关代码：
abstract class Employee{
    private String name;
    private int number;
    private MyDate birthday;
    public Employee(String s, int num , MyDate bir){
        this.name = s;
        this.number = num;
        this.birthday  = bir;
    }
    public abstract  String earnings();
    @Override
    public String toString() {
        return "name:" + name  + "number:" + number + "birthday:" + birthday.toString();
    }
}
class MyDate {
    private int year;
    private int month;
    private int day;

    public MyDate(String year, String month, String day) {
        this.year = Integer.parseInt(year);
        this.month = Integer.parseInt(month);
        this.day = Integer.parseInt(day);
    }

    @Override
    public String toString() {
        return year + "-" + month + "-" + day;
    }
}
class employ extends Employee {
    private String name;
    private int number;
    private MyDate birthday;
    employ(String s, int num, MyDate bir){
        super(s, num, bir);
        this.name = s;
        this.number = num;
        this.birthday = bir;
    }

    @Override
    public String earnings() {
        return null;
    }
    public String toString() {
        return "name:" + name + '\n' + "number:" + number +'\n' + "birthday:" + birthday.toString();
    }
}

