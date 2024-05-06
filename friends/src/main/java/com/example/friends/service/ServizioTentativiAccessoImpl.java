package com.example.friends.service;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Service;


@Service
public class ServizioTentativiAccessoImpl {

   public final int MAX_TENTATIVI = 3; // numero massimo di tentativi di accesso
    public final int TEMPO_SBLOCCO_SECONDI = 60; // tempo per lo sblocco 60 secondi

    public synchronized void accessoRiuscito(HttpSession session) {
        session.removeAttribute("tentativiAccesso");
        session.removeAttribute("utenteBloccatoFino");
    }

    public synchronized void accessoFallito(HttpSession session) {
        Integer tentativi = (Integer) session.getAttribute("tentativiAccesso");
        if (tentativi == null) {
            tentativi = 0;
        }
        tentativi++;
        session.setAttribute("tentativiAccesso", tentativi);
        if (tentativi >= MAX_TENTATIVI) {
            bloccaUtente(session);
        }
    }

    public synchronized boolean isBloccato(HttpSession session) {
        Integer utenteBloccatoFino = (Integer) session.getAttribute("utenteBloccatoFino");
        if (utenteBloccatoFino != null) {
            int tempoAttuale = (int) (System.currentTimeMillis() / 1000);
            return tempoAttuale < utenteBloccatoFino;
        }
        return false;
    }

    private void bloccaUtente(HttpSession session) {
        int tempoSblocco = (int) (System.currentTimeMillis() / 1000) + TEMPO_SBLOCCO_SECONDI;
        session.setAttribute("utenteBloccato", true);
        session.setAttribute("utenteBloccatoFino", tempoSblocco);
    }
    public synchronized int tempoRimanenteSblocco(HttpSession session) {
        Integer utenteBloccatoFino = (Integer) session.getAttribute("utenteBloccatoFino");
        if (utenteBloccatoFino != null) {
            int tempoAttuale = (int) (System.currentTimeMillis() / 1000);
            return Math.max(0, utenteBloccatoFino - tempoAttuale);
        }
        return 0;
    }

}
