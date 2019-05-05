package replaceConditionalsWithCommandPattern;


import java.util.ArrayList;
import java.util.List;

/**
 * represent all possible Bill payers
 */
public interface BillPayer {
    // represent how all these Bill Payers will be different from each other.
    public void calculateBill(double amountDue);
}

/**
 * inside the command interface we wanna represent
 * the method that will change based on the different Bill Payers.
 */
interface Command {

    public void executeCalculationBill(double amountDue);
}

/**
 * define my different Bill Payers
 */
class WomanOver60 implements BillPayer {

    @Override
    public void calculateBill(double amountDue) {
        System.out.println("Bill Amout for Woman Over 60: $" + (amountDue - (amountDue * .10)));
    }
}

/**
 * define my different Bill Payers
 */
class ManOver60 implements BillPayer {

    @Override
    public void calculateBill(double amountDue) {
        System.out.println("Bill Amout for Man Over 60: $" + (amountDue - (amountDue * .05)));
    }
}

/**
 * define my different Bill Payers
 */
class ManUnder60 implements BillPayer {

    @Override
    public void calculateBill(double amountDue) {
        System.out.println("Bill Amout for Man Under 60: $" + (amountDue - (amountDue * .0)));
    }
}


class Waiter implements Command {

    BillPayer thePayer;

    Waiter(BillPayer thePayer) {
        this.thePayer = thePayer;
    }

    @Override
    public void executeCalculationBill(double amountDue) {
        thePayer.calculateBill(amountDue);
    }
}


/**
 * invoker add more flexibility, same amount of flexibility like for BillPayers but for Waiters
 * let say we want to have multiple different types of waiter
 * may be there is a special Waiter that everybody wants, he gets additional tips than a normal waiter
 */
class CashRegister {

    Command theCommand;

    public CashRegister(Command theCommand) {
        this.theCommand = theCommand;
    }

    public void returnFinalBill(double amountDue) {
        theCommand.executeCalculationBill(amountDue);
    }
}

/**
 * I need A WAY to return the right BillPayer object based on the method that gonna be called.
 * return the right type of object based on this class: CustomerTypePicker
 */
class CustomerTypePicker {

    public static BillPayer getWomanOver60() {
        return new WomanOver60();
    }

    public static BillPayer getManOver60() {
        return new ManOver60();
    }

    public static BillPayer getManUnder60() {
        return new ManUnder60();
    }
}


/**
 * group BillPayers in ArrayList, so we gonna be able to use these BillPayers as a simple command
 * <p>
 * this is in reference to the refactoring refactoring pattern BOOK.
 */
class CustomerGroup {
    List<BillPayer> customers;

    public CustomerGroup() {

        customers = new ArrayList<>();
    }

    public void add(BillPayer newPayer) {
        customers.add(newPayer);
    }

    public BillPayer get(int customerIndex) {
        return customers.get(customerIndex);
    }
}

class UseCashRegister {
    public static void main(String[] args) {

        BillPayer sallyMay = CustomerTypePicker.getWomanOver60();
        Waiter theWaiter = new Waiter(sallyMay);

        //  we gonna need an invoker,
        // that makes sure that the method is called and stores the waiter
        // so BillPayer assigned to Waiter will gonna be available.
        CashRegister calculateBill = new CashRegister(theWaiter);
        calculateBill.returnFinalBill(12.00);

        // work also for other types: man over 60
        BillPayer joeHamb = CustomerTypePicker.getManOver60();
        theWaiter = new Waiter(joeHamb);
        calculateBill = new CashRegister(theWaiter);
        calculateBill.returnFinalBill(12.00);

        //
        //use these BillPayers as a simple command
        //
        CustomerGroup custGroup = new CustomerGroup();
        custGroup.add(CustomerTypePicker.getManUnder60());
        custGroup.get(0);
        custGroup.get(0).calculateBill(12.00);

    }
}