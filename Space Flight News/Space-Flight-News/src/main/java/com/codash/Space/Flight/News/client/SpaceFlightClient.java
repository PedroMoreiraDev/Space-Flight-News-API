package com.codash.Space.Flight.News.client;

import com.codash.Space.Flight.News.response.ArticleResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import static org.springframework.http.MediaType.APPLICATION_JSON;

@Service

public class SpaceFlightClient {

    private final WebClient webClient;

    public SpaceFlightClient(WebClient.Builder builder) {
        webClient = builder.baseUrl("https://api.spaceflightnewsapi.net/v3/articles").build();
    }

    public Mono<ArticleResponse> findAnArticleById(Integer id){

        return webClient
                .get()
                .uri("/"+id)
                .accept(APPLICATION_JSON)
                .retrieve()
                .onStatus(HttpStatus::is4xxClientError,
                        error -> Mono.error(new RuntimeException("verifique os parametros informados")))
                .bodyToMono(ArticleResponse.class);
    }
}
