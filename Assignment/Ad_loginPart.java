package Assignment;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

/**
 * @author qlizihang
 * @date 2023/5/14 20:06
 * @description:
 */
public class Ad_loginPart extends LoginPart implements function {
    double money = 123453.3;

    public Ad_loginPart(String user, String psw) {
        super(user, psw);
    }

    @Override
    public void ability() {
        System.out.println("您的权限有：------");
        System.out.println("1.查询所有宠物信息");
        System.out.println("2.更改宠物信息");
        System.out.println("3.添加宠物信息");
        System.out.println("4.查询余额");
        System.out.println("0.退出");
    }

    @Override
    public void showAllPets(ArrayList<Pet> pets) {
        for (Pet pet : pets) {
            pet.show();
        }
    }

    @Override
    public void selectByGender(ArrayList<Pet> pets, String gender) {
        for (Pet pet : pets) {
            if (pet.getGender().equals(gender)) {
                pet.show();
            }
        }
    }

    @Override
    public void selectByType(ArrayList<Pet> pets, String type) {
        for (Pet pet : pets) {
            if (pet.getType().equals(type)) {
                pet.show();
            }
        }
    }

    @Override
    public void selectByColor(ArrayList<Pet> pets, String color) {
        for (Pet pet : pets) {
            if (pet.getColor().equals(color)) {
                pet.show();
            }
        }
    }

    @Override
    public void selectByAge(ArrayList<Pet> pets, float age1, float age2) {
        for (Pet pet : pets) {
            if (pet.getAge() >= age1 && pet.getAge() <= age2) {
                pet.show();
            }
        }
    }

    @Override
    public void selectByPrice(ArrayList<Pet> pets, float price1, float price2) {
        for (Pet pet : pets) {
            if (pet.getPrice() >= price1 && pet.getPrice() <= price2) {
                pet.show();
            }
        }
    }

    @Override
    public void selectBySpecie(ArrayList<Pet> pets, String specie) {

    }


    @Override
    public void updateDye(ArrayList<Pet> pets, String name, String color) {
        for (Pet pet : pets) {
            if (pet.getName().equals(name)) {
                pet.setColor(color);
                System.out.println("更改后的宠物信息：");
                pet.show();
            }
        }
    }

    @Override
    public void selectBySpecie(ArrayList<Pet> pets, String name, String color) {

    }


    @Override
    public void updateDelete(String name, ArrayList<Pet> pets) {
        boolean exit = false;
        for (Pet pet : pets) {
            if (pet.getName().equals(name)) {
                pets.remove(pet);
                exit = true;
                break;
            }
        }
        if (!exit) {
            System.out.println("Ta已经不在了!");
        }
    }

    public Pet inputPetInfo() {
        Scanner reader = new Scanner(System.in);
        System.out.println("请输入宠物的品种：");
        String specie = reader.next();
        System.out.println("请输入宠物的名字：");
        String name = reader.next();
        System.out.println("请输入宠物的性别：");
        String gender = reader.next();
        System.out.println("请输入宠物的类型：");
        String type = reader.next();
        System.out.println("请输入宠物的颜色：");
        String color = reader.next();
        System.out.println("请输入宠物的年龄（月）：");
        float age = reader.nextFloat();
        System.out.println("请输入宠物的价格（元）：");
        float price = reader.nextFloat();
        return new Pet(specie, name, gender, type, color, age, price);
    }

    public void updateAdd(Pet pet, ArrayList<Pet> pets) {
        pets.add(pet);
    }

    public void operation() {
        ArrayList<Pet> pets = new ArrayList<>();
        pets.add(new Pet("猫", "将军", "公", "英短银渐层", "银白色", 2, 1300));
        pets.add(new Pet("猫", "荣浩", "公", "布偶猫", "灰色", 1, 800));
        pets.add(new Pet("猫", "无常", "公", "短毛猫", "黑色", 2, 900));
        pets.add(new Pet("猫", "咪咪", "母", "金吉拉", "橘黄色", 4, 1200));
        pets.add(new Pet("猫", "守常", "母", "无毛猫", "棕色", 10, 900));
        pets.add(new Pet("狗", "旺财", "公", "哈士奇", "黑白", 2, 1500));
        pets.add(new Pet("狗", "晴天", "母", "哈士奇", "黑白", 4, 1300));
        pets.add(new Pet("狗", "耀祖", "公", "萨摩耶", "白色", 6, 1400));
        pets.add(new Pet("狗", "阿浩", "公", "雪纳瑞", "白色", 4, 1300));
        System.out.println("请输入查找类型：\n21.按照性别筛选\n22.按照品种筛选\n23.按照颜色筛选\n24.按照年龄（月）筛选\n25.按照价格筛选\n26.按照物种筛选\n27.查询全部\n20.退出\n");
        Ad_loginPart ad = new Ad_loginPart("root", "root1");
        Stack<String> select_op = new Stack<String>();
        Scanner reader = new Scanner(System.in);
        int op = 999;
        while (op != 20) {
            System.out.println("请输入您的操作(2-2)：");
            op = reader.nextInt();
            switch (op) {
                case 21:
                    System.out.print("请输入性别：");
                    String gender0 = reader.next();
                    ad.selectByGender(pets, gender0);
                    select_op.push(String.valueOf(op));
                    break;
                case 22:
                    select_op.push(String.valueOf(op));
                    System.out.print("请输入品种：");
                    String type0 = reader.next();
                    ad.selectByType(pets, type0);
                    break;
                case 23:
                    select_op.push(String.valueOf(op));
                    System.out.print("请输入颜色：");
                    String color0 = reader.next();
                    ad.selectByColor(pets, color0);
                    break;
                case 24:
                    select_op.push(String.valueOf(op));
                    System.out.print("请输入年龄段:");
                    float age1 = reader.nextFloat();
                    float age2 = reader.nextFloat();
                    float temp1;
                    if (age2 < age1) {
                        temp1 = age1;
                        age1 = age2;
                        age2 = temp1;
                    }
                    ad.selectByAge(pets, age1, age2);
                    break;
                case 25:
                    select_op.push(String.valueOf(op));
                    System.out.print("请输入价格区间：");
                    float price1 = reader.nextFloat();
                    float price2 = reader.nextFloat();
                    float temp2;
                    if (price2 < price1) {
                        temp2 = price1;
                        price1 = price2;
                        price2 = temp2;
                    }
                    ad.selectByPrice(pets, price1, price2);
                    break;
                case 26:
                    System.out.println("请输入您想查询的物种");
                    String specie = reader.next();
                    ad.selectBySpecie(pets, specie);
                    break;
                case 27:
                    System.out.print("查询全部的宠物信息");
                    ad.showAllPets(pets);
                case 20:
                    System.out.println("退出查询");
                    break;
                default:
                    System.out.println("无效操作，请重新输入！");
            }
        }
    }

    public double showyue(double price){
        return money+price;
    }
}