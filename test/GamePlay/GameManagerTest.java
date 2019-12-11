package GamePlay;

import GameGadgets.Board;
import MVC.TextFieldPrintStream;
import javafx.scene.control.TextArea;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameManagerTest {

    private GameManager gameManager;

    @BeforeEach
    void setUp() {
        gameManager = new GameManager(new Board(), new TextFieldPrintStream(System.out ,new TextArea()));
    }

    @Test
    void playerClaim() {
    }

    @Test
    void playerPlaceTroop() {
    }

    @Test
    void playerMoveArmies() {
    }

    @Test
    void playerAttack() {
    }
}