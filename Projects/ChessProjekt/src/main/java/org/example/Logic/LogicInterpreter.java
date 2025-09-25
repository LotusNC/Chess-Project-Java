package org.example.Logic;

import org.example.Attributes.Color;
import org.example.Attributes.Point;
import org.example.Chesspieces.Chesspiece;
import org.example.Chesspieces.King;
import org.example.Chesspieces.Queen;

import java.util.Map;
import java.util.Optional;

public class LogicInterpreter {

    public boolean isColorInCheck(Map<Point, Chesspiece> piecesInPlay, Color kingColor) {
        Optional<Point> kingPositionOpt = findKingPosition(piecesInPlay, kingColor);

        if (kingPositionOpt.isEmpty()) {
            System.out.println("Fehler: König der Farbe " + kingColor.getColorName() + " nicht auf dem Brett gefunden!");
            return false;
        }
        Point kingPosition = kingPositionOpt.get();

        // Gehe jede Figur auf dem Brett durch.
        for (Map.Entry<Point, Chesspiece> entry : piecesInPlay.entrySet()) {
            Chesspiece piece = entry.getValue();
            Point piecePosition = entry.getKey();

            if (!piece.getColor().equals(kingColor)) {
                if (isMoveValid(piecesInPlay, piece, piecePosition, kingPosition)) {
                    System.out.println("SCHACH! König (" + kingColor.getColorName() + ") auf " + kingPosition +
                            " wird von " + piece.getClass().getSimpleName() +
                            " (" + piece.getColor().getColorName() + ") auf " + piecePosition + " bedroht.");
                    return true;
                }
            }
        }

        return false;
    }

    private Optional<Point> findKingPosition(Map<Point, Chesspiece> pieces, Color color) {
        return pieces.entrySet().stream()
                .filter(entry -> entry.getValue() instanceof King && entry.getValue().getColor().equals(color))
                .map(Map.Entry::getKey)
                .findFirst();
    }

    public boolean isMoveValid(Map<Point, Chesspiece> piecesInPlay, Chesspiece piece, Point from, Point to) {
        if (!piece.canMoveTo(from, to)) {
            return false;
        }

        Chesspiece destinationPiece = piecesInPlay.get(to);
        if (destinationPiece != null) {
            if (destinationPiece.getColor().equals(piece.getColor())) {
                return false; // Man kann keine eigene Figur schlagen
            }
        }

        return true;
    }

    private boolean isPathClear(Map<Point, Chesspiece> pieces, Point from, Point to) {
        int dx = Integer.compare(to.getX(), from.getX());
        int dy = Integer.compare(to.getY(), from.getY());

        Point current = new Point(from.getX() + dx, from.getY() + dy);

        while (!current.equals(to)) {
            if (pieces.containsKey(current)) {
                return false;
            }
            current = new Point(current.getX() + dx, current.getY() + dy);
        }

        return true;
    }
}