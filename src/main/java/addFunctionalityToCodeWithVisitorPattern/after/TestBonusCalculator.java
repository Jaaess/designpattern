package addFunctionalityToCodeWithVisitorPattern.after;

public class TestBonusCalculator {
    public static void main(String[] args) {

        YearlyBonusVisitor yearlyBonusCalculator = new YearlyBonusVisitor();

        SalesTrainee bradTrainee = new SalesTrainee(5, 1, 20000);
        Salesman tomSalesman = new Salesman(150000, 62);
        SalesTrainee rosBoss = new SalesTrainee(1000000, 1200, 40000);

        System.out.println("YEARLY BONUS");

        System.out.println(bradTrainee.accept(yearlyBonusCalculator));
        System.out.println(tomSalesman.accept(yearlyBonusCalculator));
        System.out.println(rosBoss.accept(yearlyBonusCalculator));

        System.out.println("\nQUARTERLY BONUS");

    }
}
