package ru.tulupov.alex.medalmanah.Model.api;

import java.util.List;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Path;
import ru.tulupov.alex.medalmanah.News;

public interface ApiNews {

    @GET("/api/publications/{page}")
    void getPublicationsByPage(@Path("type") int page, Callback<List<News>> news);

}