package Assignment;

/**
 * @author qlizihang
 * @date 2023/5/14 19:24
 * @description:  宠物类
 */
public class Pet {
    private String species;
    private String name;
    private String gender;
    private String type;
    private String color;
    private float age;
    private float price;
    public Pet(String specie, String name,String gender,String type, String color, float age ,float price){
        this.species = specie;
        this.name = name;
        this.gender = gender;
        this.type = type;
        this.color = color;
        this.age = age;
        this.price = price;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setAge(float age) {
        this.age = age;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getSpecies() {
        return species;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public String getType() {
        return type;
    }

    public String getColor() {
        return color;
    }

    public float getAge() {
        return age;
    }

    public float getPrice() {
        return price;
    }

    public void show(){
        System.out.println("Specie:" + this.species + "     Name:" + this.name + "     Gender:" + this.gender + "     Type:" + this.type + "     Color:" + this.color
        + "     Age(月):" + this.age + "     Price(元):" + this.price);
    }
}
