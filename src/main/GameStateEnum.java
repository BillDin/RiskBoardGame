package main;

public enum GameStateEnum {

    CLAIM,
    SETUP,
    PLAYING,
    FINISHED;

    @Override
    public String toString() {
        return this.name();
    }
}
