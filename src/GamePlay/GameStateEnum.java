package GamePlay;

/**
 * states of the game
 * @author Zeming Chen
 */
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
