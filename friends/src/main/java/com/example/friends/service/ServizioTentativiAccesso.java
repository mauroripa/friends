package com.example.friends.service;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class ServizioTentativiAccesso {


    private  final int MAX_TENTATIVI = 5;
    private Map<String, Integer> tentativi = new ConcurrentHashMap<>();

    public void accessoRiuscito(String username) {
        tentativi.remove(username);
    }

    public void accessoFallito(String username) {
        int conteggioTentativi = tentativi.getOrDefault(username, 0);
        tentativi.put(username, conteggioTentativi + 1);
        if (conteggioTentativi + 1 > MAX_TENTATIVI) {
            bloccaUtente(username);
        }
    }

    public boolean isBloccato(String username) {
        return tentativi.containsKey(username);
    }

    private void bloccaUtente(String username) {

    }
}
