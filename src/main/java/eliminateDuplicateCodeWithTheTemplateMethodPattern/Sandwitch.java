package eliminateDuplicateCodeWithTheTemplateMethodPattern;

public abstract class Sandwitch {

    final void makeSandwitch() {

        System.out.println("\n---- NEW ORDER ----\n");

        cutBun();

        if (customerWantsMeat()) {
            addMeat();
        }

        addVegetables();

        if (customerWantsCondiments()) {
            addCondiments();
        }

        wrapSandwitch();
    }

    abstract void addMeat();

    abstract void addCondiments();

    public void cutBun() {
        System.out.println("The bun was Cut");
    }

    public void addVegetables() {
        System.out.println("Lettuce, Onions & Tomatoes");
    }

    public void wrapSandwitch() {
        System.out.println("The Sandwitch was Wrapped");
    }

    boolean customerWantsMeat() {
        return true;
    }

    boolean customerWantsCondiments() {
        return true;
    }
}
