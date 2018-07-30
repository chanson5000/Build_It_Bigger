package com.udacity.gradle.builditbigger.backend;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.nverno.jokeprovider.JokeProvider;

/**
 * An endpoint class we are exposing
 */
@Api(
        name = "myApi",
        version = "v1",
        namespace = @ApiNamespace(
                ownerDomain = "backend.builditbigger.gradle.udacity.com",
                ownerName = "backend.builditbigger.gradle.udacity.com",
                packagePath = ""
        )
)
public class Endpoint {

    @ApiMethod(name = "tellJoke")
    public DataBean tellJoke() {
        JokeProvider jokeProvider = new JokeProvider();
        DataBean response = new DataBean();
        response.setData(jokeProvider.getRandomChuckNorrisJoke());
        return response;
    }
}
