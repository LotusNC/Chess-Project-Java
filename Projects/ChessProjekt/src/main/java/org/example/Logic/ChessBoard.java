package org.example.Logic;

import org.example.Attributes.Point;
import org.example.Chesspieces.Chesspiece;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class ChessBoard {
    private final int height;
    private final int width;

    public Map<Point, Chesspiece> piecesOnBoard = new HashMap<>();

    public ChessBoard(int height, int width) {
        this.height = height;
        this.width = width;
    }

    public Optional<Chesspiece> getPieceAt(Point position) {
        return Optional.ofNullable(piecesOnBoard.get(position));
    }

    public Optional<Chesspiece> movePiece(Point from, Point to) {
        Chesspiece pieceToMove = piecesOnBoard.remove(from);
        if (pieceToMove != null) {
            // Die alte Figur an der Zielposition wird "geschlagen" und zurückgegeben.
            Chesspiece capturedPiece = piecesOnBoard.put(to, pieceToMove);
            return Optional.ofNullable(capturedPiece);
        }
        return Optional.empty();
    }

    public void placePiece(Chesspiece piece, Point position) {
        piecesOnBoard.put(position, piece);
    }

    public String getBoardInfo() {
        return "Height: " + this.height + ", Width: " + this.width;
    }

    public Map<Point, Chesspiece> getPiecesOnBoard() {
        return new HashMap<>(piecesOnBoard);
    }

}
