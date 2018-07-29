package com.nverno.jokeprovider;

import com.google.gson.stream.JsonReader;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class JokeProvider {

    public String getRandomChuckNorrisJoke() {

        try {
            List<String> jokesList = new ArrayList<>();
            Random random = new Random();

            URL url = getClass().getClassLoader().getResource("jokes.json");

            if (url != null) {
                String path = url.getPath();

                JsonReader jsonReader = new JsonReader(new FileReader(path));

                jsonReader.beginArray();

                while (jsonReader.hasNext()) {
                    jokesList.add(jsonReader.nextString());
                }

                jsonReader.endArray();
                jsonReader.close();

                return jokesList.get(random.nextInt(jokesList.size()));
            } else {
                return null;
            }

        } catch (IOException ex) {
            System.out.println("Error: " + ex.getMessage());
            ex.printStackTrace();
            return null;
        }
    }
}
