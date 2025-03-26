package it.epicode;

import it.epicode.dao.EventoDAO;
import it.epicode.dao.LocationDAO;
import it.epicode.dao.PartecipazioneDAO;
import it.epicode.dao.PersonaDAO;
import it.epicode.models.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Persona persona = new Persona();
        persona.setId(1);
        persona.setNome("Luca");
        persona.setCognome("Pisani");
        persona.setEmail("iBb2y@example.com");
        persona.setDataDiNascita(LocalDate.of(2000, 1, 1));
        persona.setSesso(Sesso.M);

        Location location = new Location();
        location.setId(1);
        location.setName("Via Roma 1");
        location.setCitta("Roma");

        Evento evento = new Evento();
        evento.setId(1);
        evento.setTitolo("Evento di prova");
        evento.setDataEvento(LocalDate.now());
        evento.setDescrizione("Descrizione di prova");
        evento.setTipoEvento(TipoEvento.PUBLICO);
        evento.setNumeroMassimoPartecipanti(50);
        evento.setLocation(location);

        Partecipazione partecipazione = new Partecipazione();
        partecipazione.setId(1);
        partecipazione.setEvento(evento);
        partecipazione.setPersona(persona);
        partecipazione.setStatoPartecipazione(StatoPartecipazione.CONFERMATO);

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestioneeventi");
        EntityManager em = emf.createEntityManager();
        LocationDAO locationDAO = new LocationDAO(em);
        locationDAO.save(location);
        EventoDAO eventoDAO = new EventoDAO(em);
        eventoDAO.save(evento);
        PersonaDAO personaDAO = new PersonaDAO(em);
        personaDAO.save(persona);
        PartecipazioneDAO partecipazioneDAO = new PartecipazioneDAO(em);
        partecipazioneDAO.save(partecipazione);
    }
}