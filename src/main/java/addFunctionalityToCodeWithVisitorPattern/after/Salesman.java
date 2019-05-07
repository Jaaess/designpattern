package addFunctionalityToCodeWithVisitorPattern.after;

public class Salesman implements Visitable {

    private double totalSalesAmount;
    private int newCustomers;

    public Salesman(double totalSalesAmount, int newCustomers) {
        this.totalSalesAmount = totalSalesAmount;
        this.newCustomers = newCustomers;
    }

    public double getTotalSalesAmount() {
        return totalSalesAmount;
    }

    public void setTotalSalesAmount(double totalSalesAmount) {
        this.totalSalesAmount = totalSalesAmount;
    }

    public int getNewCustomers() {
        return newCustomers;
    }

    public void setNewCustomers(int newCustomers) {
        this.newCustomers = newCustomers;
    }

    @Override
    public double accept(Visitor visitor) {
        // ALLOW the class, that will do the calculation, to visit
        return visitor.visit(this); //know what type of object, it's gonna to perform the calculation on.
    }

}
