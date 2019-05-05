package howtoUseAdapterPattern.after;

/**
 * in this code will show how with the ADAPTER we will be able to create a new class without disturbing any of the code,
 * which already here and on top of that ADAPTER will make it easy for us to swap in code RunTime and allows us
 * to communicate with code using methods names, what will make sense for us.
 */
public interface Enemy {

    public void moveShip();

    public void makeShipAttack();
}

class Galax implements Enemy {

    private int attackPower = 5;
    private int spacesMovedPerTurn = 2;

    @Override
    public void moveShip() {
        System.out.println("Galax moves " + spacesMovedPerTurn + " spaces");
    }

    @Override
    public void makeShipAttack() {
        System.out.println("Galax does " + attackPower + " damage");
    }
}

/**
 * this is the ADAPTEE Class
 * it doesn't follow any of the rules of the Enemy interface it doesn't even gonna implement the interface.
 */
class Galaxprime {

    protected String name = "Galaxian Prime";

    private int attackPower = 15;

    protected int spacesMovedPerTurn = 4;

    public void turnOnforceField() {
        System.out.println(name + " turns on force field");
    }

    public void wrapToSpace() {
        System.out.println(name + " warps " + spacesMovedPerTurn + " spaces");
    }

    public void chargePhasers() {
        System.out.println(name + " charges phasers");
    }

    public void firePhasers() {
        System.out.println(name + " fires phasers for " + attackPower);
    }
}


/**
 * hier is an ADAPTER class, it will call the right method (from Galaxprime) when they are called in Enemy interface.
 * the ADAPTER gonna contain an Object of type ADAPTEE (Galaxprime).
 */
class EnemyAdapter implements Enemy {

    //what's gonna the ADPATEE hier do:
    // all the calls that are going to be sent to the Enemy methods for moveShip() and makeShipAttack()
    // it's gonna be sent instead to the propre methods in the GalaxPrime ADAPTEE Class.
    Galaxprime galaxprime;

    public EnemyAdapter(Galaxprime galaxprime) {
        this.galaxprime = galaxprime;
    }

    @Override
    public void moveShip() {
        // that's how to create an adapter
        galaxprime.turnOnforceField();
        galaxprime.wrapToSpace();
    }

    @Override
    public void makeShipAttack() {
        galaxprime.chargePhasers();
        galaxprime.firePhasers();
    }
}


class TestEnemyAdapter {

    public static void main(String[] args) {

        Enemy galax = new Galax();

        Galaxprime galaxPrimeAdaptee = new Galaxprime();
        Enemy galaxPrime = new EnemyAdapter(galaxPrimeAdaptee);

        galax.moveShip();
        galax.makeShipAttack();

        System.out.println();

        galaxPrime.moveShip();
        galaxPrime.makeShipAttack();
    }
}