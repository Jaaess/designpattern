package moveEmbellishmentsUsingTheDecoratorPattern.before;

/**
 * PROBLEM:
 * every time we add a new HairCut option or we change the price, we have to go into this gigantic methods,
 * and change every thing, that's bad
 * Whenever we add a new feature it's bad to add new code to older classes, and every time we will do so,
 * we will make compact easy to understand classes complicated, because we are breaking the SINGLE RESPONSIBILITY PRINCIPE
 * Which is every class should have a single responsibility.
 *
 * SOLUTION:
 *
 * use DECORATOR pattern instead to replace all these special case behaviors or embellishments
 * and put these behaviors in their own class
 * also by using the DECORATOR pattern we gonna satisfy other SOLID principal: the interface segregation principal
 * by using many specific interfaces using the DECORATOR pattern rather than one general purpose interface
 */
public class CalculateHairCut {

    enum HairCutOptions {BASIC_CUT, PERM, HAIR_FROSTING}

    HairCutOptions optionPicked;

    public CalculateHairCut(HairCutOptions optionPicked) {
        this.optionPicked = optionPicked;
    }

    public String getDescription() {
        if (optionPicked == HairCutOptions.PERM) {
            return "\nAdd chemicals and put hair in rollers";
        } else if (optionPicked == HairCutOptions.HAIR_FROSTING) {
            return "\nAdd chemicals and put hair in Foil";
        } else return "Trim the hair";
    }

    public double getCost() {
        if (optionPicked == HairCutOptions.PERM) {
            return 75.00;
        } else if (optionPicked == HairCutOptions.HAIR_FROSTING) {
            return 100.00;
        } else return 10.00;
    }
}
