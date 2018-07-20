package com.training.springcore.trash;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class HomeAssistant {

    @Inject
    private MusicFinder deezerFinder;
    @Inject
    private MusicFinder spotifyFinder;

    public HomeAssistant(MusicFinder deezerFinder,
                         MusicFinder spotifyFinder) {
        this.deezerFinder = deezerFinder;
        this.spotifyFinder = spotifyFinder;
    }
}