package addFunctionalityToCodeWithVisitorPattern.after;

public class YearlyBonusVisitor implements Visitor {
    @Override
    public double visit(SalesTrainee trainee) {
        System.out.println("Trainees yearly bonus");
        double yearlyBonusPercentage = (trainee.getSickDays() < 10 && trainee.getFailedTests() < 2) ? .10 : .02;
        double yearlyBonusAmount = trainee.getSalary() * yearlyBonusPercentage;
        return yearlyBonusAmount;
    }

    @Override
    public double visit(Salesman salesman) {
        System.out.println("Salemans yearly bonus");
        double yearlyBonusPercentage = (salesman.getTotalSalesAmount() > 10000 && salesman.getNewCustomers() < 2) ? .10 : .02;
        double yearlyBonusAmount = salesman.getTotalSalesAmount() * yearlyBonusPercentage;
        return yearlyBonusAmount;
    }

    @Override
    public double visit(Boss boss) {
        System.out.println("Trainees yearly bonus");
        double yearlyBonusPercentage = (boss.getOfficeExpenses() < 50000 && boss.getNewCustomers() < 1000) ? .15 : .04;
        double yearlyBonusAmount = boss.getTotalSalesAmount() * yearlyBonusPercentage;
        return yearlyBonusAmount;
    }
}
