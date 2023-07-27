package org.java.travel.agency;

import java.time.LocalDate;
import java.util.Scanner;

public class Agency {
    public static void main(String[] args) {
           /*Nel progetto java-travel-agency, creare la classe Vacanza caratterizzata da:
- destinazione
- data inizio
- data fine
Quando viene creata una nuova Vacanza vanno effettuati dei controlli:
- destinazione, data inizio e data fine non possono essere null
- la data inizio non può essere già passata
- la data fine non può essere prima della data inizio
Se fallisce la validazione vanno sollevate opportune eccezioni
La classe Vacanza espone un metodo per calcolare la durata in giorni della vacanza.


Aggiungere una classe Agenzia con metodo main, dove chiediamo all’operatore se vuole inserire una nuova vacanza o uscire.
Se vuole proseguire con l’inserimento va chiesta la destinazione, il giorno, mese e anno di partenza e il giorno, mese anno di ritorno.
Con questi dati va generata una nuova vacanza e in console verrà stampato un messaggio del tipo: “Hai prenotato una vacanza di [numero di giorni] giorni
a [destinazione] dal [data inizio formattata] al [data fine formattata]“.
Se la creazione della vacanza genera un errore, il programma non deve interrompersi ma va gestito con dei messaggi di errore
che permettono all’utente di capire cosa è andato storto e di ripetere l’inserimento.
     */
        Scanner scan = new Scanner(System.in);
        String makeVacation;
        boolean repeat = true;
        while (repeat) {
            System.out.println("do you want to make a travel ?  Y/N");
            makeVacation = scan.nextLine();
            if (makeVacation.equalsIgnoreCase("Y")) {
                System.out.println("where do you want to travel?");
                String getDestination = scan.nextLine();
                System.out.println("when you want to travel? (YYY-MM-DD)");
                String travelBeginning = scan.nextLine();
                System.out.println("when you want to return? (YYY-MM-DD)");
                String travelEnding = scan.nextLine();
                //converto le date in localDate
                LocalDate getTravelBeginning = LocalDate.parse(travelBeginning);
                LocalDate getTravelEnding = LocalDate.parse(travelEnding);
                //collego la classe vacation per creare l'oggetto
                try {
                    Vacation vacation = new Vacation(getDestination, getTravelBeginning, getTravelEnding);
                    int daysOfStay = vacation.getDaysOfStay();
                    System.out.println("you have booked a " + daysOfStay + " days travel in " + getDestination + " from " + getTravelBeginning + " to " + getTravelEnding + ". have a nice trip");
                    repeat = false;
                } catch (RuntimeException e) {
                    System.out.println(e.getMessage());
                }

            } else if (makeVacation.equalsIgnoreCase("N")) {
                System.out.println("ok, goodbye");
                repeat = false;
            } else {
                System.out.println("you entered an invalid choice");
            }
        }
 /*
            String dateString = "2023-01-06";
            LocalDate date = LocalDate.parse(dateString);
             */




    }
}
