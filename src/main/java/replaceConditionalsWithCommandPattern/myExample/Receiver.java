package replaceConditionalsWithCommandPattern.myExample;

import java.util.ArrayList;
import java.util.List;

public interface Receiver {
    // represent how all these Receivees will be different from each other.
    public void createEmail(String emailStatistics);
}

/**
 * inside the command interface we wanna represent
 * the method that will change based on the different Receivers.
 */
interface Command {
    public void executeEmailSending(String emailStatistics);
}

/**
 * define my different Receivers
 */
class Manager implements Receiver {

    @Override
    public void createEmail(String emailStatistics) {
        System.out.println("Email for the Manger is sent: " + emailStatistics);
    }
}

/**
 * define my different Receivers
 */
class Secretary implements Receiver {

    @Override
    public void createEmail(String emailStatistics) {
        System.out.println("Email for the Secretary is sent: " + emailStatistics);
    }
}

/**
 * define my different Receivers
 */
class HRManager implements Receiver {

    @Override
    public void createEmail(String emailStatistics) {
        System.out.println("Email for the HR Manager is sent: " + emailStatistics);
    }
}


class Waiter implements Command {

    Receiver theReceiver;

    Waiter(Receiver theReceiver) {
        this.theReceiver = theReceiver;
    }

    @Override
    public void executeEmailSending(String emailStatistics) {
        theReceiver.createEmail(emailStatistics);
    }
}


/**
 * invoker add more flexibility, same amount of flexibility like for Receivers but for Waiters
 * let say we want to have multiple different types of waiter
 * may be there is a special Waiter that everybody wants, he gets additional tips than a normal waiter
 */
class CashRegister {

    Command theCommand;

    public CashRegister(Command theCommand) {
        this.theCommand = theCommand;
    }

    public void returnFinalBill(String emailStatistics) {
        theCommand.executeEmailSending(emailStatistics);
    }
}

/**
 * I need A WAY to return the right Receiver object based on the method that gonna be called.
 * return the right type of object based on this class: ReceiverTypePicker
 */
class ReceiverTypePicker {

    public static Receiver getManager() {
        return new Manager();
    }

    public static Receiver getSecretary() {
        return new Secretary();
    }

    public static Receiver getHRManager() {
        return new HRManager();
    }
}


/**
 * group Receivers in ArrayList, so we gonna be able to use these Receivers as a simple command
 * <p>
 * this is in reference to the refactoring refactoring pattern BOOK.
 */
class ReceiverGroup {
    List<Receiver> receivers;

    public ReceiverGroup() {
        receivers = new ArrayList<>();
    }

    public void add(Receiver newReceiver) {
        receivers.add(newReceiver);
    }

    public Receiver get(int receiverIndex) {
        return receivers.get(receiverIndex);
    }
}

class UseCashRegister {
    public static void main(String[] args) {

        Receiver sallyMay = ReceiverTypePicker.getManager();
        Waiter theWaiter = new Waiter(sallyMay);

        //  we gonna need an invoker,
        // that makes sure that the method is called and stores the waiter
        // so Receiver assigned to Waiter will gonna be available.
        CashRegister createEmail = new CashRegister(theWaiter);
        createEmail.returnFinalBill("Sehr geehrter Herr Manager ...");

        // work also for other types: HR Manager
        Receiver joeHamb = ReceiverTypePicker.getHRManager();
        theWaiter = new Waiter(joeHamb);
        createEmail = new CashRegister(theWaiter);
        createEmail.returnFinalBill("Sehr geehrter Herr HR Manager ...");

        //
        //use these Receivers as a simple command
        //
        ReceiverGroup receiverGroup = new ReceiverGroup();
        receiverGroup.add(ReceiverTypePicker.getSecretary());
        receiverGroup.get(0);
        receiverGroup.get(0).createEmail("Sehr geehrter Frau Secretary ...");

    }
}