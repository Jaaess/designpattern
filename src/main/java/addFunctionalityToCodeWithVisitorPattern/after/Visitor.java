package addFunctionalityToCodeWithVisitorPattern.after;

public interface Visitor {

    // all the different type of employees need to handle it.
    public double visit(SalesTrainee trainee);

    public double visit(Salesman salesman);

    public double visit(Boss boss);
}
