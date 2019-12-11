package GameGadgets;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    private Player player;

    @BeforeEach
    void setUp() {
        player = new Player(0, "name");
    }

    @Test
    void owns() {
        player.claim("a");
        assertTrue(player.owns("a"));
        assertFalse(player.owns("b"));
    }
}