package Assignment;

import java.util.ArrayList;
/*TODO:
    这部分其实可以用class来写各种方法，然后直接继承，比较简单
 */
public interface function {
    //通用功能：
    //显示全部的宠物信息
    void showAllPets(ArrayList<Pet> pets);
    //1.按照性别筛选
    void selectByGender(ArrayList<Pet> pets, String gender);
    //2.按照品种筛选
    void selectByType(ArrayList<Pet> pets, String type);
    //3.按照颜色筛选
    void selectByColor(ArrayList<Pet> pets, String color);
    //4.按照年龄（月）筛选
    void selectByAge(ArrayList<Pet> pets, float age1, float age2);
    //5.价格筛选
    void selectByPrice(ArrayList<Pet> pets, float price1, float price2);
    //6.物种筛选
    void selectBySpecie(ArrayList<Pet> pets, String specie);


    //管理员功能
    //1.更新--染色
    void updateDye(ArrayList<Pet> pets,String name, String color);

    void selectBySpecie(ArrayList<Pet> pets, String name, String color);

    //2.更新--添加
    Pet inputPetInfo();
    //3.更新--删除
    void updateDelete(String name , ArrayList<Pet> pets);
}
