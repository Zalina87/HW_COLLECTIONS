package ru.netology.statistic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class GameTest {

    @Test
    void getPlayerList() {
        Game game = new Game();
        Player player1 = new Player(1, "Petya", 2);
        Player player2 = new Player(2, "Ivan", 5);

        game.register(player1);
        game.register(player2);

        List<Player> expected = List.of(player1, player2);
        List<Player> actual = game.getPlayerList();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void register() {
        Game game = new Game();
        Assertions.assertTrue(game.getPlayerList().isEmpty());

        Player player1 = new Player(1, "Petya", 2);
        Player player2 = new Player(2, "Ivan", 5);

        game.register(player1);
        game.register(player2);

        List<Player> expected = List.of(player1, player2);
        List<Player> actual = game.getPlayerList();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldThrowNotRegisteredException() {
        Game game = new Game();
        Player player1 = new Player(1, "Petya", 2);
        Player player2 = new Player(2, "Ivan", 5);

        game.register(player1);
        game.register(player2);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Misha", "Petya");
        });
        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Ivan", "Misha");
        });
    }

    @Test
    void shouldReturnZeroWhenSameStrengths() {
        Game game = new Game();
        Player player1 = new Player(1, "Petya", 2);
        Player player2 = new Player(2, "Ivan", 2);

        game.register(player1);
        game.register(player2);

        int expected = 0;
        int actual = game.round("Petya", "Ivan");
        Assertions.assertEquals(expected, actual);
    }
    @Test
    void shouldReturnWinnerThenDifferentStrengths() {
        Game game = new Game();
        Player player1 = new Player(1, "Petya", 1);
        Player player2 = new Player(2, "Ivan", 2);
        Player player3 = new Player(3, "Misha", 3);

        game.register(player1);
        game.register(player2);
        game.register(player3);

        int expected = 1;
        int actual = game.round("Ivan", "Petya");
        Assertions.assertEquals(expected, actual);

        expected = 2;
        actual = game.round("Ivan", "Misha");
        Assertions.assertEquals(expected, actual);
    }
}