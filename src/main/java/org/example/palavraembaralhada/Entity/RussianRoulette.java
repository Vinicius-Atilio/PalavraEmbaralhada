package org.example.palavraembaralhada.Entity;

public class RussianRoulette {
    private int scoreOfDeath;
    private boolean hunt;

    public RussianRoulette(int scoreOfDeath, boolean hunt) {
        this.scoreOfDeath = scoreOfDeath;
        this.hunt = hunt;
    }

    public int getScoreOfDeath() {
        return scoreOfDeath;
    }

    public void setScoreOfDeath(int scoreOfDeath) {
        this.scoreOfDeath += scoreOfDeath;
    }

    public boolean isHunt() {
        return hunt;
    }

    public void setHunt(boolean hunt) {
        this.hunt = hunt;
    }
}
