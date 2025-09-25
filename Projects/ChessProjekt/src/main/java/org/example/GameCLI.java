package org.example;

import org.example.Attributes.Point;
import org.example.Logic.ChessBoard;
import org.example.Visualizers.ConsoleVisualizer;

import java.util.Scanner;

/**
 * Die Command-Line Interface (CLI) für das Schachspiel.
 * Diese Klasse ist verantwortlich für die Interaktion mit dem Benutzer,
 * das Einlesen von Befehlen und die Darstellung des Spielzustands in der Konsole.
 */
public class GameCLI {

    private final ChessGame game;
    private final ChessBoard board;
    private final ConsoleVisualizer visualizer;
    private final Scanner scanner;

    public GameCLI(ChessGame game, ChessBoard board, ConsoleVisualizer visualizer) {
        this.game = game;
        this.board = board;
        this.visualizer = visualizer;
        this.scanner = new Scanner(System.in);
    }

    /**
     * Startet die Hauptschleife des Spiels, die auf Benutzereingaben wartet.
     */
    public void start() {
        System.out.println("Willkommen beim Chess Projekt!");
        visualizer.visualize(board);
        System.out.println("Gib 'help' ein, um eine Liste der Befehle zu sehen.");

        while (true) {
            System.out.print("> ");
            String input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("exit") || input.equalsIgnoreCase("quit")) {
                System.out.println("Das Spiel wird beendet. Auf Wiedersehen!");
                break;
            }

            processCommand(input);
        }

        scanner.close();
    }

    /**
     * Verarbeitet einen einzelnen Befehl vom Benutzer.
     * @param input Die vollständige Eingabezeile des Benutzers.
     */
    private void processCommand(String input) {
        String[] parts = input.split(" ");
        String command = parts[0].toLowerCase();

        switch (command) {
            case "help":
                printHelp();
                break;
            case "show":
                visualizer.visualize(board);
                break;
            case "move":
                handleMoveCommand(parts);
                break;
            default:
                System.out.println("Unbekannter Befehl. Gib 'help' ein für eine Liste der Befehle.");
                break;
        }
    }

    private void handleMoveCommand(String[] parts) {
        if (parts.length == 3) {
            try {
                Point from = parsePoint(parts[1]);
                Point to = parsePoint(parts[2]);
                game.movePiece(from, to);
                visualizer.visualize(board); // Brett nach dem Zug anzeigen
            } catch (IllegalArgumentException e) {
                System.out.println("Fehler: " + e.getMessage() + " Bitte benutze die Standard-Schachnotation (z.B. 'e2').");
            }
        } else {
            System.out.println("Ungültiges Format. Benutze: move <von> <nach> (z.B. 'move e2 e4')");
        }
    }

    private void printHelp() {
        System.out.println("Verfügbare Befehle:");
        System.out.println("  show              - Zeigt das aktuelle Schachbrett an.");
        System.out.println("  move e2 e4        - Bewegt eine Figur von der Start- zur Zielposition.");
        System.out.println("  exit / quit       - Beendet das Spiel.");
    }

    private Point parsePoint(String algebraicNotation) {
        if (algebraicNotation == null || algebraicNotation.length() != 2) {
            throw new IllegalArgumentException("Ungültige Eingabe '" + algebraicNotation + "'.");
        }

        char fileChar = algebraicNotation.charAt(0);
        char rankChar = algebraicNotation.charAt(1);

        if (fileChar < 'a' || fileChar > 'h' || rankChar < '1' || rankChar > '8') {
            throw new IllegalArgumentException("Koordinate '" + algebraicNotation + "' außerhalb des Bretts.");
        }

        int x = fileChar - 'a';
        int y = rankChar - '1';

        return new Point(x, y);
    }
}