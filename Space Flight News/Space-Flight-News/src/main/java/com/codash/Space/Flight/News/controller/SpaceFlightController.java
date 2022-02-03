package com.codash.Space.Flight.News.controller;

import com.codash.Space.Flight.News.client.SpaceFlightClient;
import com.codash.Space.Flight.News.response.ArticleResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@AllArgsConstructor
@RequestMapping("/articles")
public class SpaceFlightController {
    SpaceFlightClient spaceFlightClient;

    @GetMapping("/{id}")
    public Mono<ArticleResponse> getArtcleById(@PathVariable Integer id){
    return spaceFlightClient.findAnArticleById(id);
    }

}
