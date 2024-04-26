package com.example.friends.service;

import jakarta.servlet.http.HttpSession;

public interface ServizioTentativiAccesso {

    void accessoRiuscito(HttpSession session);

    void accessoFallito(HttpSession session);

    boolean isBloccato(HttpSession session);

}
