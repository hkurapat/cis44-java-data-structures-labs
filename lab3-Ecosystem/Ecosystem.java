import java.util.Random;

abstract class Animal {
    public abstract String toString();
}

class Bear extends Animal {
    @Override
    public String toString() {
        return "B";
    }
}

class Fish extends Animal {
    @Override
    public String toString() {
        return "F";
    }
}

public class Ecosystem {
    private Animal[] river;
    private Random random;

    public Ecosystem(int riverSize) {
        this.river = new Animal[riverSize];
        this.random = new Random();
        
        for (int i = 0; i < riverSize; i++) {
            int rand = random.nextInt(3);
            if (rand == 0) {
                river[i] = new Bear();
            } else if (rand == 1) {
                river[i] = new Fish();
            }
        }
    }

    public void runStep() {
        Animal[] newRiver = new Animal[river.length];
        
        for (int i = 0; i < river.length; i++) {
            if (river[i] == null) {
                continue;
            }
            
            int move = random.nextInt(3) - 1;
            int newPos = i + move;
            
            if (newPos < 0 || newPos >= river.length) {
                newPos = i;
            }
            
            if (newRiver[newPos] == null) {
                newRiver[newPos] = river[i];
            } else {
                Animal current = river[i];
                Animal other = newRiver[newPos];
                
                if (current instanceof Bear && other instanceof Bear) {
                    for (int j = 0; j < newRiver.length; j++) {
                        if (newRiver[j] == null) {
                            newRiver[j] = new Bear();
                            break;
                        }
                    }
                } else if (current instanceof Fish && other instanceof Fish) {
                    for (int j = 0; j < newRiver.length; j++) {
                        if (newRiver[j] == null) {
                            newRiver[j] = new Fish();
                            break;
                        }
                    }
                } else if ((current instanceof Bear && other instanceof Fish) || 
                           (current instanceof Fish && other instanceof Bear)) {
                    if (current instanceof Bear) {
                        newRiver[newPos] = current;
                    } else {
                        newRiver[newPos] = other;
                    }
                }
                
                if (newRiver[i] == null) {
                    newRiver[i] = river[i];
                }
            }
        }
        
        river = newRiver;
    }

    public void visualize() {
        for (Animal animal : river) {
            System.out.print(animal == null ? "-" : animal.toString());
            System.out.print(" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Ecosystem eco = new Ecosystem(20);
        
        System.out.println("Initial River:");
        eco.visualize();
        System.out.println();
        
        for (int step = 1; step <= 10; step++) {
            System.out.println("Step " + step + ":");
            eco.runStep();
            eco.visualize();
            System.out.println();
        }
    }
}
