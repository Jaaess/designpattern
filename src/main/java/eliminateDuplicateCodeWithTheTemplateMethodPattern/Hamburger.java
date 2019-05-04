package eliminateDuplicateCodeWithTheTemplateMethodPattern;

public class Hamburger extends Sandwitch{


    @Override
    void addMeat() {
        System.out.println("Hamburger Added");
    }

    @Override
    void addCondiments() {
        System.out.println("Special Sauce Added");
    }
}