package designpattern.factory.simplefactory;

/**
 * @author magic_lz
 * Description TODO
 * @version 1.0
 * @ClassName PersonFactoryEnum
 * @date 2020/1/2 10:24
 */
public enum PersonFactoryEnum {
    MAN(new Man()),WOMAN(new Woman());

    private Person person;
    private PersonFactoryEnum(Person person){
        this.person = person;
    }

    public Person getPerson(){
        return person;
    }

    public static void main(String[] args){
      PersonFactoryEnum.MAN.getPerson().run();
    }
}
