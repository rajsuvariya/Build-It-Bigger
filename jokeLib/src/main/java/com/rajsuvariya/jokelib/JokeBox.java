package com.rajsuvariya.jokelib;

public class JokeBox {

    String jokes[] = new String[] {
            "Why couldn't the bicycle stand up?"+
                    "Because it was two tired",
            "What do you call a cheese that isn't yours?"+
                    "Nacho Cheese!",
            "Before I criticize a man, I like to walk a mile in his shoes."+
                    "That way, when I do criticize him, I'm a mile away and I have his shoes.",
            "What do you call a fish with no eye?"+
                    "Fssshh",
            "Have you heard the one about the Corduroy pillow?"+
                    "It's making HEADLINES!",
            "What's red and bad for your teeth?"+
                    "A brick.",
            "Why didn't the melons get married?"+
                    "Because they cantaloupe!",
            "What did the cobbler say when a cat wandered into his shop?"+
                    "Shoe!",
            "What did the Buddhist say to the hot dog vendor?"+
                    "Make me one with everything!",
            "The face of a child can say it all"+
                    "especially the mouth part of the face.",
            "Why did the cookie go to the hospital?"+
                    "Because he felt crummy.",
            "I intend to live forever..."+
                    "So far, so good."
    };

    public String tellJoke() {
        int index = (int) (Math.random()*jokes.length);
        return jokes[index];
    }
}
