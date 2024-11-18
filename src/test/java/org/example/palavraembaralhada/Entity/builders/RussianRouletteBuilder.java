package org.example.palavraembaralhada.Entity.builders;

import org.example.palavraembaralhada.Entity.RussianRoulette;

public class RussianRouletteBuilder {
    private int scoreOfDeath;
    private boolean hunt;

    public static RussianRouletteBuilder builder() {
        return new RussianRouletteBuilder();
    }

    public RussianRouletteBuilder withScoreOfDeath(int scoreOfDeath) {
        this.scoreOfDeath = scoreOfDeath;
        return this;
    }

    public RussianRouletteBuilder withHunt(boolean hunt) {
        this.hunt = hunt;
        return this;
    }

    public RussianRoulette build() {
        return new RussianRoulette(scoreOfDeath, hunt);
    }
}
