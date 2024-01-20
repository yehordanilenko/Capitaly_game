package Capitaly;

import Capitaly.fields.Field_lucky;
import Capitaly.fields.Field_property;
import Capitaly.fields.Field_service;
import Capitaly.players.Player;
import Capitaly.players.Player_careful;
import Capitaly.players.Player_greedy;
import Capitaly.players.Player_tactical;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import static Capitaly.Capitaly.gamePromotion;


public class Main {
    public static void main(String[] args) throws IOException {
        String inputFile = "C:\\Users\\selez\\Desktop\\Uni\\Sem_3\\Programming technology\\Assignment_1\\GameCapitaly\\game5.txt";
        GameBoard board = new GameBoard();
        BufferedReader reader = new BufferedReader(new FileReader(inputFile));
        try {
            int numberFields = Integer.parseInt(reader.readLine());

            for (int i = 0; i < numberFields; i++) {
                String line = reader.readLine();

                if (line.equals("service")) {
                    int numb = Integer.parseInt(reader.readLine());
                    board.addField(new Field_service(numb));
                } else {
                    if (line.equals("lucky")) {
                        int numb = Integer.parseInt(reader.readLine());
                        board.addField(new Field_lucky(numb));
                    } else {
                        board.addField(new Field_property());
                    }
                }
                // System.out.println(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        int numP = Integer.parseInt(reader.readLine());
        Player[] players = new Player[numP];
        for (int i = 0; i < numP; i++) {
            String str1 = reader.readLine();
            String str2 = reader.readLine();
            if (str2.equals("greedy")) {
                players[i] = new Player_greedy(str1);
            } else {
                if (str2.equals("careful")) {
                    players[i] = new Player_careful(str1);
                } else {
                    players[i] = new Player_tactical(str1);
                }
            }
        }
        int r = Integer.parseInt(reader.readLine());

        int[] rolls = new int[r * players.length];
        for (int i = 0; i < r * players.length; i++) {
            rolls[i] = Integer.parseInt(reader.readLine());
            // System.out.println(rolls[i]);
        }
        // System.out.println(r);
        board.startGame(players, r, rolls);

        System.out.println(gamePromotion);
        for (int i = 0; i < players.length; i++) {
            System.out.println(players[i] + " " + players[i].getBalance() + " " + players[i].getProp());
        }
    }
}