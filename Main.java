import java.util.*;
public class Main {
    public static void main(String[] args) {
        System.out.println("<-------第一题------->");
        //TODO:在此编写第一题测试代码
        String str = "panda";
        Monkey monkey = new Monkey(str);
        System.out.println(monkey.name);
        monkey.speak();
        People people = new People(str);
        people.speak();
        people.think();


        System.out.println("<-------第二题------->");
        //TODO:在此编写第二题测试代码
        Car car = new Car(4, 1150, 3);
        car.speak();
        car = new Car(4, 1150, 7);
        car.speak();
        System.out.println("----------------------------------------");
        Truck truck = new Truck(6, 15000.0, 1, 3000);
        truck.speak();
        truck = new Truck(6, 15000, 2, 7000);
        truck.speak();


        System.out.println("<-------第三题------->");
        //TODO:在此编写第三题测试代码
        String a = "88888888165487616";
        String b = "4654418746164877854";
        System.out.println(getSum(a, b));
        System.out.println("<-------第四题------->");
        //TODO:在此编写第四题测试代码
        System.out.println(uniquePaths(3,6));
        System.out.println("<-------第五题------->");
        //TODO:在此编写第五题测试代码
        System.out.println("测试一：");
        String[] strs = new String[]{"flower", "flow", "flight"};
        System.out.println(re_ggzfc(strs));
        System.out.println("测试二：");
        String[] strss = new String[]{"dog","rececar","car", " "};
        System.out.println(re_ggzfc(strss));
    }


    public static String getSum(String a, String b) {
        List<Integer> la = new ArrayList<Integer>();
        List<Integer> lb = new ArrayList<Integer>();
        String c = "";
        for (int i = a.length() - 1; i >= 0; i--) {
            la.add(a.charAt(i) - '0');
        }
        for (int i = b.length() - 1; i >= 0; i--) {
            lb.add(b.charAt(i) - '0');
        }
        //TODO:在此处编写符合要求的代码，并在主类中编写测试代码
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        int i = 0, j = 0;
        while (i <= la.size() - 1 || j <= lb.size() - 1 || carry != 0) {
            int x = i <= la.size() - 1 ? la.get(i) : 0;
            int y = j <= lb.size() - 1 ? lb.get(j) : 0;
            int sum = x + y + carry;
            i++;
            j++;
            sb.append(sum % 10);
            carry = sum / 10;
        }
        c = sb.reverse().toString();
        return c;
    }
    public static int uniquePaths(int m, int n) {
        int[][] arr = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0)
                    arr[i][j] = 1;
                else {
                    arr[i][j] = arr[i - 1][j] + arr[i][j - 1];
                }
            }
        }
        return arr[m - 1][n - 1];
    }
    public static String re_ggzfc(String[] strs) {
        // 判断是否有空字符串
        if (strs.length == 0) {
            return "";
        }
        String ans = strs[0];
        for (int i = 1; i < strs.length; i++) {
            int j = 0;
            for (; j < ans.length() && j < strs[i].length(); j++) {
                if (ans.charAt(j) != strs[i].charAt(j)) {
                    break;
                }
            }
            ans = ans.substring(0, j);
            // 判断共同前缀是否为空
            if (ans.equals("")) {
                return ans + "\n" +"解释：输入不存在公共前缀";
            }
        }
        return ans;
    }
}


class Monkey{
    String name;
    Monkey(String s){
        this.name = s;
    }
    public void speak(){
        System.out.println("咿咿呀呀 ......");
    }
}
class People extends Monkey {
    People(String s){
        super(s);
    }
    @Override
    public void speak(){
        System.out.println("小样儿，不错嘛！会说话了！");
    }
    public void think(){
        System.out.println("别说话！认真思考！");
    }
}

class Vehicle{
    public int wheels;
    public double weight;
    public Vehicle(int wheels,double weight){
        this.wheels = wheels;
        this.weight = weight;
    }
    public void speak(){
    }
}
class Car extends Vehicle {
    public int loader;
    public Car(int wheels,double weight , int loader){
        super(wheels, weight);
        this.loader = loader;
    }

    @Override
    public void speak() {
        if (this.loader<6){
            System.out.println("车轮的个数是：" + this.wheels + " " + "车重：" + this.weight + "\n" +
                    "这是一辆小车，能载6人，实载" + this.loader + "人");
        }else {
            System.out.println("车轮的个数是：" + this.wheels + " " + "车重：" + this.weight + "\n" +
                    "这是一辆小车，能载6人，实载" + this.loader + "人,你超员了！！！");
        }
    }
}
class Truck extends Car {
    public double payload;
    public Truck(int wheels, double weight ,int loader, double payloader){
        super(wheels, weight, loader);
        this.payload = payloader;
    }
    @Override
    public void speak() {
        if (this.payload<5000){
            System.out.println("车轮的个数是：" + this.wheels + " " + "车重：" + this.weight + "\n" + "这是一辆卡车，能载3人，实载" + this.loader + "人\n"
                    + "这是一辆卡车，核载5000kg，你已装载" + this.payload + "kg");
        }else {
            System.out.println("车轮的个数是：" + this.wheels + " " + "车重：" + this.weight + "\n" + "这是一辆卡车，能载3人，实载" + this.loader + "人\n"
                    + "这是一辆卡车，核载5000kg，你已装载" + this.payload + "kg,你超载了！！！");
        }

    }
}