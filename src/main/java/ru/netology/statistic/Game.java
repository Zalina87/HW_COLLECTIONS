package ru.netology.statistic;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private List<Player> playerList = new ArrayList<>();

    public List<Player> getPlayerList() {
        return playerList;
    }

    public void register(Player player) {
        playerList.add(player);
    }

    private Player findByName(String name) {
        for (Player curPlayer : playerList) {
            if (curPlayer.getName().equals(name)) {
                return curPlayer;
            }
        }
        return null;
    }

    public int round (String playerName1, String playerName2) {
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


