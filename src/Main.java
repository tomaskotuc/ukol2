import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        String soubor = "resources/vstup.txt"; // Název souboru

        try (BufferedReader br = new BufferedReader(new FileReader(soubor))) {
            String radek;   // Čtení souboru řádek po řádku
            while ((radek = br.readLine()) != null) {// Rozdělení  zákazníků podle ;
                String[] zakaznici = radek.split(";");
                for (String zaznam : zakaznici) {
                    if (!zaznam.trim().isEmpty()) {
                        // Rozdělení jednotlivého záznamu na ID a jméno
                        String[] casti = zaznam.split("\\s+");
                        if (casti.length >= 3) {
                            int idZakaznika = Integer.parseInt(casti[0]); // ID zákazníka
                            String krestniJmeno = casti[1]; // Křestní jméno

                            // Kontrola podmínek
                            if ("Ivana".equals(krestniJmeno) && idZakaznika < 500) {
                                System.out.println("ID: " + idZakaznika +" ; "+ "Křestní jméno: " +krestniJmeno);
                            }
                        }
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Došlo k chybě při čtení souboru: " + e.getMessage());
        }
    }
}