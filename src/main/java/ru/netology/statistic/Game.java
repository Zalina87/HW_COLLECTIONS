package ru.netology.statistic;

import java.util.HashMap;
import java.util.Map;

public class Game {
    private Map<String, Player> playerMap = new HashMap<>();

    public Map<String, Player> getPlayerMap() {
        return playerMap;
    }

    public void register(Player player) {
        playerMap.put(player.getName(), player);
    }

    private Player findByName(String name) {
        return playerMap.get(name);
    }

    public int round(String playerName1, String playerName2) {
        Player player1 = findByName(playerName1);
        Player player2 = findByName(playerName2);
        if (player1 == null) {
            throw new NotRegisteredException("Player with name " + playerName1 + " is not registered");
        }
        if (player2 == null) {
            throw new NotRegisteredException("Player with name " + playerName2 + " is not registered");
        }
        if (player1.getStrength() > player2.getStrength()) {
            return 1;
        } else if (player1.getStrength() < player2.getStrength()) {
            return 2;
        } else {
            return 0;
        }
    }
}


