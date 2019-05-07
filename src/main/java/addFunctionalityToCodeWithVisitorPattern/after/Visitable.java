package addFunctionalityToCodeWithVisitorPattern.after;

/**
 * allow the Classes that implement the interface Visitable
 * to pass in an object so that the right calculation can done
 * independent from the object type (SalesTrainees, Bosses,...)
 */
public interface Visitable {

    // accept() method will invite in an object to perform those calculation, accept() will be implemented
    // in each employee object, and those employee-objects then pass an object of there specific type to a concrete visitor
    // concrete Visitor will be a guy like YearlyBonusVisitor and QuarterlyBonusVisitor (2 different classes that
    // calculates bonuses in 2 different ways)
    // the concrete Visitor gonna contain a method that's called visit(), that's overloaded to handle each of these employee types
    // and can then perform different calculation based on which employee-type is passed in.
    public abstract double accept(Visitor visitor);

}
