import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Hus> beställningar = new ArrayList<>();

        while (true) {
            System.out.println("\n--- BYGGFÖRETAGET ---");
            System.out.println("1. Lägg till beställning"); //lägger till beställning 
            System.out.println("2. Lista alla beställningar"); //visar alla beställningar du har gjort
            System.out.println("3. Visa total vinst");
            System.out.println("4. Avsluta");
            System.out.print("Välj: ");

            int val = sc.nextInt();
            sc.nextLine(); 

            if (val == 1) {
                System.out.println("\nVilken typ av byggnad?");
                System.out.println("1. Villa");
                System.out.println("2. Radhus");
                System.out.println("3. Parhus");
                System.out.print("Välj: ");
                int typ = sc.nextInt();
                sc.nextLine();

                // Frågar efter information av huset
                System.out.print("Antal rum: ");
                int rum = sc.nextInt();
                System.out.print("Yta (kvm): ");
                int yta = sc.nextInt();
                System.out.print("Antal badrum: ");
                int badrum = sc.nextInt();
                System.out.print("Kök (1 = ja, 0 = nej): ");
                int kök = sc.nextInt();

                int tomt = 0; 

                if (typ == 1 || typ == 2) {
                    System.out.print("Tomtstorlek (kvm): ");
                    tomt = sc.nextInt();
                }

                System.out.print("Pris (kr): ");
                int pris = sc.nextInt();

                
                Hus h = new Hus(rum, yta, badrum, kök, tomt, pris);
                beställningar.add(h);

                System.out.println("Beställning tillagd!");

            } else if (val == 2) {
                System.out.println("\n--- ALLA BESTÄLLNINGAR ---");
                for (Hus h : beställningar) {
                    System.out.println(h);
                }

            } else if (val == 3) {
                int total = 0;
                for (Hus h : beställningar) {
                    total += h.pris;
                }
                System.out.println("Total vinst: " + total + " kr");

            } else if (val == 4) {
                System.out.println("Program avslutas.");
                break;
            }
        }
    }
}

class Hus {
    int rum;
    int yta;
    int badrum;
    int kök;
    int tomtstorlek;
    int pris;

    Hus(int rum, int yta, int badrum, int kök, int tomtstorlek, int pris) {
        this.rum = rum;
        this.yta = yta;
        this.badrum = badrum;
        this.kök = kök;
        this.tomtstorlek = tomtstorlek;
        this.pris = pris;
    }

    public String toString() {
        return "Rum: " + rum +
                ", Yta: " + yta + " kvm" +
                ", Badrum: " + badrum +
                ", Kök: " + (kök == 1 ? "Ja" : "Nej") +
                ", Tomt: " + tomtstorlek + " kvm" +
                ", Pris: " + pris + " kr";
    }
}
