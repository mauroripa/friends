package com.example.friends.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MaxUploadSizeExceededException;

@ControllerAdvice
public class EccezioneController {

    @ExceptionHandler(MaxUploadSizeExceededException.class)
    public String handleMaxUploadSizeExceededException(MaxUploadSizeExceededException ex) {
        // Gestisci l'eccezione qui, ad esempio restituendo un messaggio di errore all'utente
        return "redirect:/areariservata?messaggio=dimensioneSuperata";
    }
}
