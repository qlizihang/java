package Assignment;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

/**
 * @author qlizihang
 * @date 2023/5/14 16:44
 * @description:
 */
public class Pet_shop {
    public static Stack<String> his_op = new Stack<String>();      //使用栈来保留操作，如果出现错误输入就可以返回上一次的输入
    public static double re_money;         //通过static关键词实现全局变量的作用
    public static void main(String[] args) {
        boolean  bought = false;   //判断是否进行了领养或者购买的操作


        Scanner in = new Scanner(System.in);
        ArrayList<Pet> pets = new ArrayList<>();
        pets.add(new Pet("猫", "将军", "公", "英短银渐层","银白色", 2, 1300));
        pets.add(new Pet("猫", "荣浩", "公", "布偶猫","灰色", 1, 800));
        pets.add(new Pet("猫", "无常", "公", "短毛猫","黑色", 2, 900));
        pets.add(new Pet("猫", "咪咪", "母", "金吉拉","橘黄色", 4, 1200));
        pets.add(new Pet("猫", "守常", "母", "无毛猫","棕色", 10, 900));
        pets.add(new Pet("狗", "旺财", "公", "哈士奇","黑白", 2, 1500));
        pets.add(new Pet("狗", "晴天", "母", "哈士奇","黑白", 4, 1300));
        pets.add(new Pet("狗", "耀祖", "公", "萨摩耶","白色", 6, 1400));
        pets.add(new Pet("狗", "阿浩", "公", "雪纳瑞","白色", 4, 1300));


        System.out.println("欢迎使用宠物商店系统，请选择您的登录方式：\n" + "---------------------------------");
        System.out.println("1.顾客登录\n2.管理员登录\n0.退出\n");
        int op1 = 100;  //初始化op1
        while (op1!=0){
            System.out.println("请输入您的操作(0)：");
            op1 = in.nextInt();
            switch (op1){
                case 1:
                    his_op.push(String.valueOf(op1));
                    System.out.println("顾客登录(以游客形式登录)：");//不会进行账户的判断
                    Cus_LoginPart Customer = new Cus_LoginPart("0", "0");
                    System.out.println("登录成功");
                    Customer.ability();
                    int op2 = 1000000000;
                    while(op2!=0){
                        System.out.println("请输入您的操作(1-1)：");
                        op2 = in.nextInt();
                        switch (op2){
                            case 1:
                                his_op.push(String.valueOf(op2));
                                System.out.println("查询操作：");
                                Customer.showAllPets(pets);
                                break;
                            case 2:
                                his_op.push(String.valueOf(op2));
                                System.out.println("筛选操作：");
                                Customer.select_operation();
                                break;
                            case 3:
                                his_op.push(String.valueOf(op2));
                                System.out.println("领养操作：");
                                Customer.buy_adopt(pets);
                                bought = true;
                                re_money = Customer.money;
                                break;
                            case 0:
                                break;
                            default:
                                System.out.println("无效操作，请重新输入！");
                        }
                    }

                    break;
                case 2:
                    his_op.push(String.valueOf(op1));
                    String user1 = "root";
                    String password1 = "root1";
                    System.out.println("管理员登录：");
                    System.out.println("请输入用户名：");
                    String user = in.next();
                    System.out.println("请输入密码：");
                    String psw = in.next();
                    if (user.equals(user1)&&psw.equals(password1)){
                        System.out.println("登陆成功！欢迎您的使用！\n");
                        Ad_loginPart ad_loginPart = new Ad_loginPart(user, psw);
                        ad_loginPart.ability();
                        int op3 = 9999;
                        while(op3!=0){
                            System.out.println("请输入您的操作(2-1)：");
                            op3 = in.nextInt();
                            switch (op3){
                                case 1:
                                    his_op.push(String.valueOf(op3));
                                    System.out.println("查询操作：");
                                    ad_loginPart.operation();
                                    break;
                                case 2:
                                    his_op.push(String.valueOf(op3));
                                    System.out.println("更新操作：\n请输入要更改的宠物的名字：");
                                    String name0 = in.next();
                                    System.out.println("要更改的发色:");
                                    String color0 = in.next();
                                    ad_loginPart.updateDye(pets, name0, color0);
                                    break;
                                case 3:
                                    his_op.push(String.valueOf(op3));
                                    System.out.println("添加操作：");
                                    Pet pet = ad_loginPart.inputPetInfo();
                                    System.out.println("添加的宠物信息：");
                                    pet.show();
                                    break;
                                case 4:
                                    his_op.push(String.valueOf(op3));
                                    System.out.print("余额：");
                                    if (bought){
                                        System.out.println(re_money);
                                    }
                                    break;
                                case 0:
                                    break;
                                default:
                                    System.out.println("无效操作，请重新输入！");
                            }
                        }
                        break;
                    }else {
                        System.out.println("登陆失败！");
                    }
                    break;
                case 0:
                    System.out.println("谢谢使用！再见！");
                    break;
                default:
                    System.out.println("无效操作，请重新输入！");
            }
        }

        }
}


