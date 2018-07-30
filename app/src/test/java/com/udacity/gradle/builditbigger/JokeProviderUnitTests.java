package com.udacity.gradle.builditbigger;

import com.nverno.jokeprovider.JokeProvider;

import org.junit.Assert;
import org.junit.Test;

public class JokeProviderUnitTests {

    @Test
    public void getRandomChuckNorrisJoke_ShouldNotBeNull() {
        JokeProvider jokeProvider = new JokeProvider();

        String result = jokeProvider.getRandomChuckNorrisJoke();
        Assert.assertTrue(result != null);
        Assert.assertTrue(!result.equals(""));
    }
}
