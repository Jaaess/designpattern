package eliminateDuplicateCodeWithTheTemplateMethodPattern;

public class VeggieSub extends Sandwitch {

    boolean customerWantsMeat() {
        return false;
    }

    @Override
    void addMeat() {

    }

    @Override
    void addCondiments() {
        System.out.println("Vinger and Oil Added");
    }
}
