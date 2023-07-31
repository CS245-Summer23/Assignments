package trees;

public class Person {
    public Person mother;
    public Person father;
    public String birthCountry;

    public Person(String s, Person mother, Person father){
        this.birthCountry = s;
        this.mother = mother;
        this.father = father;
    }
}
