package org.example;

import org.example.Attributes.Point;
import org.example.Chesspieces.Chesspiece;
import org.example.Logic.ChessBoard;
import org.example.Logic.LogicInterpreter;
import org.example.Visualizers.ChessVisualizer;

import java.util.Optional;

public class ChessGame {

    private final ChessBoard currentBoard;
    private final ChessVisualizer visualizer;
    private final LogicInterpreter logicInterpreter = new LogicInterpreter();

    public ChessGame(ChessBoard board, ChessVisualizer visualizer) {
        this.currentBoard = board;
        this.visualizer = visualizer;
    }

    public void movePiece(Point from, Point to) {
        // 1. Figur vom Brett holen
        Optional<Chesspiece> pieceToMoveOpt = currentBoard.getPieceAt(from);

        if (pieceToMoveOpt.isEmpty()) {
            System.out.println("Fehler: Auf dem Startfeld " + from + " steht keine Figur.");
            return;
        }

        Chesspiece piece = pieceToMoveOpt.get();

        // 2. Regelprüfung
        boolean isValidMove = logicInterpreter.isMoveValid(currentBoard.getPiecesOnBoard(), piece, from, to);

        if (isValidMove) {
            // 3. Wenn der Zug gültig ist, führe ihn auf dem Brett aus
            System.out.println("Bewege " + piece.getClass().getSimpleName() + " von " + from + " nach " + to);
            Optional<Chesspiece> capturedPiece = currentBoard.movePiece(from, to);

            capturedPiece.ifPresent(captured ->
                    System.out.println("Figur " + captured.getClass().getSimpleName() + " wurde geschlagen!")
            );

            // 4. Update den Visualizer
            // visualizer.drawBoard(currentBoard); // Du übergibst das Board zum Zeichnen

            // 5. Wechsle den Spieler, prüfe auf Schach etc.
            // ...
        } else {
            System.out.println("Ungültiger Zug für " + piece.getClass().getSimpleName() + " von " + from + " nach " + to);
        }
    }
}