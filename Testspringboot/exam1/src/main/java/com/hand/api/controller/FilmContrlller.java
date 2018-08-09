package com.hand.api.controller;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.hand.api.service.FilmService;
import com.hand.domain.entity.Film;
import com.hand.domain.entity.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class FilmContrlller {

    @Autowired
    private FilmService filmService;

    @RequestMapping(value = "/test")
    public List<Film> getFilmByLanguageId(@RequestBody Language language, @RequestHeader(value="User-Agent") String userAgent ){
        System.out.println(userAgent+"@@@@@");
        Byte languageId = language.getLanguageId();
        System.out.println(languageId+"!!!!!!");

        Film film = new Film();
        film.setLanguageId(Byte.valueOf(languageId));
        film.setDescription("testData");
        film.setTitle("test");
        film.setRentalDuration((byte) 1);
        film.setRentalRate(BigDecimal.valueOf(0.99));
        film.setRentalDuration((byte) 1);
        film.setReplacementCost(BigDecimal.valueOf(1));
        film.setLastUpdate(new Date());

        Film film1 = new Film();
        film1.setLanguageId(languageId);
        film1.setFilmId((short) 5);

        return filmService.getFilmById(film1);
    }
}
