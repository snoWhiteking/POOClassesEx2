import java.util.Random;

public class Character {

    private String name;
    private int energy;
    private int hunger;
    private int sleep;

    private Random randomizer = new Random();
    private double playChoice, huntChance, eatChance;

    public Character(String name, int energy, int hunger, int sleep, String kind) {
        this.name = name;

        if (energy >= 0 && energy <= 10)
            this.energy = energy;
        if (hunger >= 0 && hunger <= 10)
            this.hunger = hunger;
        if (sleep >= 0 && sleep <= 10)
            this.sleep = sleep;
        
        switch (kind) {
            case "sleepy":
                huntChance = 0.15;
                eatChance = 0.15;
                break;
            case "hungry":
                huntChance = 0.2;
                eatChance = 0.7;
                break;
            default:
                huntChance = 0.4;
                eatChance = 0.3;
                break;
        }
    }

    public String getName() {
        return this.name;
    }
    public int getEnergy() {
        return this.energy;
    }
    public int getHunger() {
        return this.hunger;
    }
    public int getSleep() {
        return this.sleep;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }
    public void setHunger(int hunger) {
        this.hunger = hunger;
    }
    public void setSleep(int sleep) {
        this.sleep = sleep;
    }

    public void hunt() {
        if (this.energy >= 2) {
            System.out.println(this.name + " is hunting!");
            this.energy -= 2;
        }
        else 
            System.out.println(this.name + " is too tired to hunt.");
        
        this.hunger += this.hunger < 10 ? 1 : 0;
        this.sleep += this.sleep < 10 ? 1 : 0;
        
        showInfo();
    }

    public void eat() {
        if (this.hunger >= 1) {
            System.out.println(this.name + " is eating.");
            this.hunger -= 1;
            this.energy += this.energy < 10 ? 1 : 0;
        }
        else
            System.out.println(this.name + " is not hungry to eat.");
        
        showInfo();
    }

    public void sleep() {
        if (this.sleep >= 1) {
            System.out.println(this.name + " is sleeping.");
            this.sleep -= 1;
            this.energy += this.energy < 10 ? 1 : 0;
        }
        else
            System.out.println(this.name + " is not tired to sleep.");
        
        showInfo();
    }

    public void play() {
        playChoice = randomizer.nextDouble();

        if (playChoice <= huntChance)
            hunt();
        else if (playChoice <= (eatChance + huntChance))
            eat();
        else
            sleep();

    }

    public void showInfo() {
        System.out.printf("%s's Energy: %s\n", this.name, this.energy);
        System.out.printf("%s's Hunger: %s\n", this.name, this.hunger);
        System.out.printf("%s's Sleep: %s\n", this.name, this.sleep);
    }
}
