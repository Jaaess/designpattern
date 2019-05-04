package eliminateDuplicateCodeWithTheTemplateMethodPattern;

public class Cook {

    public static void main(String[] args) {

        Sandwitch customer1 = new Hamburger();
        customer1.makeSandwitch();

        Sandwitch customer2 = new VeggieSub();
        customer2.makeSandwitch();
    }
}
