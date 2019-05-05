package replaceConditionalsWithCommandPattern;

public class Customer {

    private int age;
    private boolean man;
    private double bill;

    public Customer(int age, boolean man, double bill) {
        this.age = age;
        this.man = man;
        this.bill = bill;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isMan() {
        return man;
    }

    public void setMan(boolean man) {
        this.man = man;
    }

    public double getBill() {
        return bill;
    }

    public void setBill(double bill) {
        this.bill = bill;
    }

    public void returnFinalBill() {

        // Problem : to add a new customer type we nedd to change the customer logic to return Bill,
        // even if we create subclasses we have to create new subclasses  and so on
        // ,adding new discounts is gonna require changes in all subclasses,
        // adding a new calculation device also need to deal with all these Subclasess
        // Command Pattern in this Case will help a lot.
        double percentageOff = 0.0;

        if (age > 60) {
            percentageOff += .05;
        }
        if (!man) {
            percentageOff += .05;
        }

        System.out.println("Bill Amout: $" + (bill - (bill * percentageOff)));
    }

    public static void main(String[] args) {
        Customer billSmith = new Customer(62,true, 12);
        // calculate customer's bill utilising discounts that are based on sex and age.
        billSmith.returnFinalBill();
    }
}
