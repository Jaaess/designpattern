package howtoUseAdapterPattern.before;

public class EnemyShip {

    protected String name;
    private int attackPower;
    protected int spacesMovedPerTurn;

    public EnemyShip(int currentLevel) {

        if (currentLevel <= 5) {
            name = "Galax";
            this.attackPower = 5;
            this.spacesMovedPerTurn = 2;
        } else if (currentLevel > 5 || currentLevel < 10) {
            name = "Galaxian";
            this.attackPower = 5;
            this.spacesMovedPerTurn = 2;
        } else if (currentLevel > 10) {
            name = "Galaxian Prime";
            this.attackPower = 15;
            this.spacesMovedPerTurn = 4;
        }
    }

    public void moveShip() {
        System.out.println(name + " moves " + spacesMovedPerTurn + " spaces ");
    }

    public void makeShipAttack() {
        System.out.println(name + " does " + spacesMovedPerTurn + " damage ");
    }


    public static void main(String[] args) {

        EnemyShip level1Ship = new EnemyShip(6);
        level1Ship.moveShip();
        level1Ship.makeShipAttack();

        // the user want to add a completely different type of ship, he decided to add
        // subclass of EnemyShip and change the way the EnemyShip moves,
        // and he planes to add more subclasses as he needed additional ships.
        GalaxianPrime primeTime = new GalaxianPrime(15);
        primeTime.moveShip();
        primeTime.makeShipAttack();
    }
}


class GalaxianPrime extends EnemyShip {

    public GalaxianPrime(int currentLevel) {
        super(currentLevel);
    }

    public void moveShip() {
        System.out.println(name + " turns on forcefield and moves " + spacesMovedPerTurn + " spaces ");
    }
}
