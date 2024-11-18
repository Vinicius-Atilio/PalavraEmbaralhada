package org.example.palavraembaralhada;

import org.example.palavraembaralhada.contracts.Engine;
import org.example.palavraembaralhada.enums.Level;
import org.example.palavraembaralhada.usescase.factory.EngineFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import java.io.FileNotFoundException;
import java.util.Scanner;

@SpringBootApplication
public class PalavraEmbaralhadaApplication {

    public static void main(String[] args) throws FileNotFoundException {
        EngineFactory engineFactory = new EngineFactory();
        Engine engine = engineFactory.createEngine(Level.VERY_HARD);

        engine.welcome();
        while (!engine.isGameOver()) {
            engine.nextRound();
            Scanner scanner = new Scanner(System.in);
            String userInput = scanner.nextLine();
            engine.play(userInput);
            engine.playAgain();
            engine.hit();
            engine.timeToHunt();
            engine.timeToKill();
        }

        engine.winner();
        engine.loser();


    }
}
