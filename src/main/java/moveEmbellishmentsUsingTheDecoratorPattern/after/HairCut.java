package moveEmbellishmentsUsingTheDecoratorPattern.after;

public interface HairCut {

    public String getDescription();

    public double getCost();
}

/**
 * add feature and keep them completely separated in their own class.
 */
abstract class HairCutDecorator implements HairCut {

    protected HairCut hairCut;

    //the Decorator will be able to customise all the haircuts
    public HairCutDecorator(HairCut hairCut) {
        this.hairCut = hairCut;
    }

    public String getDescription() {
        return hairCut.getDescription();
    }

    public double getCost() {
        return hairCut.getCost();
    }
}

/**
 * I wanna represent the most basic type of haircut: the Core Program
 */
class RegularHairCut implements HairCut {

    @Override
    public String getDescription() {
        return "Trim the hair";
    }

    @Override
    public double getCost() {
        return 10.00;
    }
}

/**
 * With the DECORATOR pattern gonna be able to easily add features as well calculation without changing the code that are already exist.
 * every time we need to add an embellishment we do a new class.
 */
class Perm extends HairCutDecorator {

    public Perm(HairCut hairCut) {
        super(hairCut);
    }

    public String getDescription() {
        return hairCut.getDescription() + "\nAdd Chemicals and put hair in Rollers";
    }

    public double getCost() {
        return hairCut.getCost() + 75.00;
    }
}

class TestHairCut {

    public static void main(String[] args) {

        // Perm is the extra add (added embellishment, added Feature that gonna be in the out most part)
        // in the core program: RegularHairCut will be always be done.
        HairCut permAndCut = new Perm(new RegularHairCut());
        System.out.println("SERVICES");
        System.out.println(permAndCut.getDescription());
        System.out.println("Price $: " + permAndCut.getCost());
    }
}


