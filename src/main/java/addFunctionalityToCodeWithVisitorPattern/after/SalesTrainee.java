package addFunctionalityToCodeWithVisitorPattern.after;

/**
 * to allow the bonus-Calculator-Guy (Visitor), that will calculate the bonus
 * Every Employee: SalesTrainee, Salesman and Boss should implement Visitable interface.
 */
public class SalesTrainee implements Visitable {

    private int sickDays;
    private int failedTests;
    private double salary;

    public SalesTrainee(int sickDays, int failedTests, double salary) {
        this.sickDays = sickDays;
        this.failedTests = failedTests;
        this.salary = salary;
    }

    public int getSickDays() {
        return sickDays;
    }

    public void setSickDays(int sickDays) {
        this.sickDays = sickDays;
    }

    public int getFailedTests() {
        return failedTests;
    }

    public void setFailedTests(int failedTests) {
        this.failedTests = failedTests;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public double accept(Visitor visitor) {
        // ALLOW the class, that will do the calculation, to visit
        return visitor.visit(this); //know what type of object, it's gonna to perform the calculation on.
    }
}
