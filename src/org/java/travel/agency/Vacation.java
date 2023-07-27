package org.java.travel.agency;

import java.time.LocalDate;
import java.time.Period;

public class Vacation {
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


    //attributi
    private String destination;
    private LocalDate travelBeginning;
    private LocalDate travelEnding;

    //costruttore


    public Vacation(String destination, LocalDate travelBeginning, LocalDate travelEnding) {
        //controlli
        //se destination è null o stringa vuota
        if (destination == null || destination.isEmpty()){
            //sollevo un eccezione
            throw new RuntimeException("please, choose a valid destination");
        }
        //se travelBeginning è null o già passata
        if (travelBeginning == null || travelBeginning.isBefore(LocalDate.now())) {
            //sollevo un eccezione
            throw new RuntimeException("the travel start date cannot already be in the past or null. please choose a valid date");
        }
        //se travelEnding è null o prima della data di inizio
        if (travelEnding == null || travelEnding.isBefore(travelBeginning)) {
            //sollevo un eccezione
            throw new RuntimeException("the travel end date cannot be before the travel start date or null. please choose a valid date");
        }
        this.destination = destination;
        this.travelBeginning = travelBeginning;
        this.travelEnding = travelEnding;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) throws RuntimeException {
        if (destination == null || destination.isEmpty()){
            //sollevo un eccezione
            throw new RuntimeException("please, choose a valid destination");
        }
        //se passa allora modifica il valore
        this.destination = destination;
    }

    public LocalDate getTravelBeginning() {
        return travelBeginning;
    }

    public void setTravelBeginning(LocalDate travelBeginning) throws RuntimeException {
        if (travelBeginning == null || travelBeginning.isBefore(LocalDate.now())) {
            //sollevo un eccezione
            throw new RuntimeException("the travel start date cannot already be in the past or null. please choose a valid date");
        }
        this.travelBeginning = travelBeginning;
    }

    public LocalDate getTravelEnding() {
        return travelEnding;
    }

    public void setTravelEnding(LocalDate travelEnding) {
        if (travelEnding == null || travelEnding.isBefore(travelBeginning)) {
            //sollevo un eccezione
            throw new RuntimeException("the travel end date cannot be before the travel start date or null. please choose a valid date");
        }
        this.travelEnding = travelEnding;
    }
    //metodo per ottenere i giorni di vacanza
    public int getDaysOfStay() {
        Period daysPeriod = Period.between(travelBeginning, travelEnding);
        return daysPeriod.getDays();
    }

}
