package com.codash.Space.Flight.News.response;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class ArticleResponse {
    private Integer id;
    private boolean featured;
    private String url;
}
