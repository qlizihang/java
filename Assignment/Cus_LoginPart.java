package Assignment;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

/**
 * @author qlizihang
 * @date 2023/5/14 20:11
 * @description:
 */
public class Cus_LoginPart extends LoginPart implements function{
    double money;
    public Cus_LoginPart(String user, String psw) {
        super(user, psw);
    }


    @Override
    public void ability() {
        System.out.println("您的权限有：");
        System.out.println("1.查询所有宠物");
        System.out.println("2.筛选");
        System.out.println("3.购买/领养");
        System.out.println("0.退出");
    }

    @Override
    public  void showAllPets(ArrayList<Pet> pets) {
        for (Pet pet: pets){
            pet.show();
        }
    }

    @Override
    public void selectByGender(ArrayList<Pet> pets,String gender) {
        int count =0;
        for (Pet pet: pets){
            if (!pet.getGender().equals(gender)){
                count++;
            }
            else {
                pet.show();
            }
        }
        if (count!=0){
            System.out.println("未找到更多匹配项！");
        }
    }

    @Override
    public void selectByType(ArrayList<Pet> pets, String type) {
        int count = 0;
        for (Pet pet: pets){
            if (!pet.getType().equals(type)){
                count++;
            }else {
                pet.show();
            }
        }
        if (count!=0){
            System.out.println("未找到更多匹配项！");
        }
    }

    @Override
    public void selectByColor(ArrayList<Pet> pets, String color) {
        int count = 0;
        for (Pet pet: pets){
            if (!pet.getColor().equals(color)){
                count++;
            }else {
                pet.show();
            }
        }
        if (count!=0){
            System.out.println("未找到更多匹配项！");
        }
    }

    @Override
    public void selectByAge(ArrayList<Pet> pets, float age1, float age2) {
        int count =0;
        for (Pet pet: pets){
            if (pet.getAge()>=age1 && pet.getAge()<=age2){
                pet.show();
            }else {
                count++;
            }
        }
        if (count!=0){
            System.out.println("未找到更多匹配项！");
        }
    }

    @Override
    public void selectByPrice(ArrayList<Pet> pets, float price1, float price2) {
        int count = 0;
        for (Pet pet: pets){
            if (pet.getPrice()>=price1 && pet.getPrice()<=price2){
                pet.show();
            }else {
                count++;
            }
        }
        if (count!=0){
            System.out.println("未找到更多匹配项！");
        }
    }

    @Override
    public void selectBySpecie(ArrayList<Pet> pets, String specie) {
        int count =0;
        for (Pet pet:pets) {
            if (pet.getSpecies().equals(specie)) {
                pet.show();
            } else {
                count++;
            }
        }
        if (count!=0){
            System.out.println("未找到更多匹配项！");
        }
    }

    @Override
    public void updateDye(ArrayList<Pet> pets, String name, String color) {

    }

    @Override
    public void selectBySpecie(ArrayList<Pet> pets, String name, String color) {

    }


    @Override
    public Pet inputPetInfo(){
        return null;
    }

    @Override
    public void updateDelete(String name, ArrayList<Pet> pets) {
    }
    public void buy_adopt(ArrayList<Pet> pets){
        Scanner reader = new Scanner(System.in);
        System.out.println("请输入您想购买或领养的宠物的名字：");
        String name = reader.nextLine();
        System.out.println(name + "的相关信息");
        for (Pet pet:pets){
            if (pet.getName().equals(name)){
                pet.show();
            }
        }
        System.out.println("您确定要购买/领养这只宠物吗");
        System.out.println("1.是           2.否");
        int op = reader.nextInt();
        switch (op){
            case 1:
                System.out.println("请善待" + name);
                Ad_loginPart ad_loginPart = new Ad_loginPart("root","root1");
                for (Pet pet: pets){
                    if (pet.getName().equals(name)){
                        money = ad_loginPart.showyue(pet.getPrice());
                        pets.remove(pet);
                        break;
                    }
                }


                break;
            case 2:
                System.out.println("Ta会一直等着你的。");
        }
    }

    public void select_operation() {
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
        System.out.println("请输入查找类型：\n11.按照性别筛选\n12.按照品种筛选\n13.按照颜色筛选\n14.按照年龄（月）筛选\n15.按照价格筛选\n16.按照物种筛选\n10.退出\n");
        Cus_LoginPart cu = new Cus_LoginPart("1","1");
        Stack<String> select_op = new Stack<String>();
        Scanner reader = new Scanner(System.in);
        int op = 1000;
        while (op!=10) {
            System.out.println("请输入您的操作(1-2)：");
            op = reader.nextInt();
            switch (op){
                case 11:
                    System.out.print("请输入性别：");
                    String gender0 = reader.next();
                    cu.selectByGender(pets,gender0);
                    select_op.push(String.valueOf(op));
                    break;
                case 12:
                    select_op.push(String.valueOf(op));
                    System.out.print("请输入品种：");
                    String type0 = reader.next();
                    cu.selectByType(pets, type0);
                    break;
                case 13:
                    select_op.push(String.valueOf(op));
                    System.out.print("请输入颜色：");
                    String color0 = reader.next();
                    cu.selectByColor(pets, color0);
                    break;
                case 14:
                    select_op.push(String.valueOf(op));
                    System.out.print("请输入年龄段:");
                    float age1 = reader.nextFloat();
                    float age2 = reader.nextFloat();
                    float temp1;
                    if (age2<age1){
                        temp1 = age1;
                        age1 = age2;
                        age2 = temp1;
                    }
                    cu.selectByAge(pets,age1,age2);
                    break;
                case 15:
                    select_op.push(String.valueOf(op));
                    System.out.print("请输入价格区间：");
                    float price1 = reader.nextFloat();
                    float price2 = reader.nextFloat();
                    float temp2;
                    if (price2<price1){
                        temp2 = price1;
                        price1 = price2;
                        price2 = temp2;
                    }
                    cu.selectByPrice(pets,price1, price2);
                    break;
                case 16:
                    System.out.println("请输入您想查询的物种");
                    String specie = reader.next();
                    cu.selectBySpecie(pets,specie);
                    break;
                case 10:
                    System.out.println("退出查询");
                    break;
                default:
                    System.out.println("无效操作，请重新输入！");
            }

        }
    }
}


