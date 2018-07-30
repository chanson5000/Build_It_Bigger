package com.nverno.jokeprovider;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class JokeProvider {

    private static List<String> jokesArray = Arrays.asList(
            "When Chuck Norris claps his hands, the sun turns off.",
            "Chuck Norris got a standing ovation by simply walking into a paraplegic convention.",
            "Chuck Norris understands the lyrics to \"Louie Louie.\"",
            "The following is the complete list of things Chuck Norris cannot do:",
            "Chuck Norris once Round-House kicked a man so fast, his foot went at the speed of light, traveled back in time and killed the dinosaurs. Meteor? No, Chuck Norris.",
            "Chuck Norris won the $142,000,000 Texas state PowerBall Lottery with a ticket stub from a Texas Rangers baseball game.",
            "Chuck Norris once fell into a pit full of rattle snakes. He emerged 10 minutes later while smartly clad in his new vest, belt and boots.",
            "Chuck Norris can save 15% or more on car insurance WITHOUT switching to Geico... or even buying car insurance."
    );

    public String getRandomChuckNorrisJoke() {
        Random random = new Random();

        return jokesArray.get(random.nextInt(jokesArray.size()));
    }
}
