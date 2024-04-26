package com.example.friends.service;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Service;


@Service
public class ServizioTentativiAccessoImpl {

    private final int MAX_TENTATIVI = 4;

    public synchronized void accessoRiuscito(HttpSession session) {
        session.removeAttribute("tentativiAccesso");
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
        return session.getAttribute("utenteBloccato") != null;
    }

    private void bloccaUtente(HttpSession session) {
        session.setAttribute("utenteBloccato", true);
    }
}
