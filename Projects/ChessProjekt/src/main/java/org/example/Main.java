package org.example;

import org.example.Editor.StandardPresets;
import org.example.Logic.ChessBoard;
import org.example.Visualizers.ConsoleVisualizer;

public class Main {
    public static void main(String[] args) {
        // 1. Kernkomponenten erstellen (Model und View)
        ChessBoard board = StandardPresets.standardGame();
        ConsoleVisualizer visualizer = new ConsoleVisualizer();
        ChessGame game = new ChessGame(board, visualizer);

        // 2. Die Benutzeroberfläche (Controller) erstellen und starten
        GameCLI cli = new GameCLI(game, board, visualizer);
        cli.start();
    }
}