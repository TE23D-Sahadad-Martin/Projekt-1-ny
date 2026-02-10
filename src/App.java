import java.util.ArrayList;
import java.util.Scanner;


public class App {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        ArrayList<Beställning> beställningar = new ArrayList<>();

        boolean kör = true;

        while (kör) {
            System.out.println("\n==== BYGGFÖRETAGET ====");
            System.out.println("1. Lägg till beställning");
            System.out.println("2. Lista beställningar");
            System.out.println("3. Ta bort en beställning");
            System.out.println("4. Visa total vinst");
            System.out.println("5. Avsluta");
            System.out.print("Välj: ");

            int val = input.nextInt();

            switch (val) {
                case 1 -> {
                    System.out.println("Välj typ:");
                    System.out.println("1. Villa");
                    System.out.println("2. Radhus");
                    System.out.println("3. Garage");

                    int typVal = input.nextInt();

                    Beställning ny = null;

                    if (typVal == 1) {
                        ny = new Villa();
                    } else if (typVal == 2) {
                        ny = new Radhus();
                    } else if (typVal == 3) {
                        ny = new Garage();
                    }

                    if (ny != null) {
                        beställningar.add(ny);
                        System.out.println("Beställningen lades till!");
                    }
                }

                case 2 -> {
                    System.out.println("\n--- Alla beställningar ---");

                    if (beställningar.isEmpty()) {
                        System.out.println("Inga beställningar finns ännu.");
                    } else {
                        for (Beställning b : beställningar) {
                            System.out.println(b);
                        }
                    }
                }

                case 3 -> {
                    System.out.println("Vilken beställning vill du ta bort? (Index börjar vid 0)");

                    int index = input.nextInt();

                    if (index >= 0 && index < beställningar.size()) {
                        beställningar.remove(index);
                        System.out.println("Beställning borttagen!");
                    } else {
                        System.out.println("Ogiltigt index.");
                    }
                }

                case 4 -> {
                    int total = 0;
                    for (Beställning b : beställningar) {
                        total += b.getPris();
                    }
                    System.out.println("Total vinst: " + total + " kr");
                }

                case 5 -> {
                    kör = false;
                    System.out.println("Programmet avslutas...");
                }

                default -> System.out.println("Fel val.");
            }
        }
    }
}


abstract class Beställning {
    protected int pris;

    public int getPris() {
        return pris;
    }

    @Override
    public String toString() {
        return "Typ: " + this.getClass().getSimpleName() + " | Pris: " + pris + " kr";
    }
}


class Villa extends Beställning {

    public Villa() {
    
        this.pris = 3500000 + (int)(Math.random() * 1500000);
    }
}


class Radhus extends Beställning {

    public Radhus() {
     
        this.pris = 2500000 + (int)(Math.random() * 1500000);
    }
}


class Garage extends Beställning {

    public Garage() {
     
        this.pris = 500000 + (int)(Math.random() * 500000);
    }
}
