package builderDesignPatternToBuildVomplexObjectsInASeriesOfSteps;

public abstract class SandwichBuilder {

    Sandwich sandwich;

    public Sandwich getSandwich() {
        return sandwich;
    }

    public void makeSandwich() {
        sandwich = new Sandwich();
    }

    public abstract void buildBread();

    public abstract void buildVegetables();

    public abstract void buildMeat();

    public abstract void buildCheese();

    public abstract void buildCondiments();
}

class BLTBuilder extends SandwichBuilder {

    @Override
    public void buildBread() {
        sandwich.setBread("White Bread");
    }

    @Override
    public void buildVegetables() {
        sandwich.setVegetables("Lettuce  Tomato");
    }

    @Override
    public void buildMeat() {
        sandwich.setMeat("Bacon");
    }

    @Override
    public void buildCheese() {
        sandwich.setCheese("");
    }

    @Override
    public void buildCondiments() {
        sandwich.setCondiments("Mayonnaise");
    }
}


class SandwitchArtist {

    private SandwichBuilder sandwichBuilder;

    public void setSandwichBuilder(SandwichBuilder sandwichBuilder) {
        this.sandwichBuilder = sandwichBuilder;
    }

    public Sandwich getSandwich() {
        return sandwichBuilder.getSandwich();
    }

    public void takeSandwichOrder() {
        sandwichBuilder.makeSandwich();
        sandwichBuilder.buildBread();
        sandwichBuilder.buildCheese();
        sandwichBuilder.buildCondiments();
        sandwichBuilder.buildMeat();
        sandwichBuilder.buildVegetables();
    }
}

class TestBuilder {
    public static void main(String[] args) {
        SandwitchArtist paul = new SandwitchArtist();
        SandwichBuilder bltBuilder = new BLTBuilder();

        paul.setSandwichBuilder(bltBuilder);

        paul.takeSandwichOrder();

        Sandwich bltSandwich = paul.getSandwich();

        System.out.println(bltSandwich.toString());
    }
}