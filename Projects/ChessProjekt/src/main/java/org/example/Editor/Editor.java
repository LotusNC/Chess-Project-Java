package org.example.Editor;

import org.example.Attributes.Color;
import org.example.Attributes.Direction;
import org.example.Attributes.Point;
import org.example.Chesspieces.*;
import org.example.Logic.ChessBoard;

/**
 * Eine Klasse nach dem Builder-Pattern, um ChessBoard-Objekte
 * schrittweise zu erstellen und zu konfigurieren.
 */
public class Editor {

    private final ChessBoard board;

    public Editor() {
        this.board = new ChessBoard(8, 8);
    }

    public Editor addWhite(PieceType type, int x, int y) {
        addPiece(type, Color.WHITE, x, y);
        return this;
    }

    public Editor addBlack(PieceType type, int x, int y) {
        addPiece(type, Color.BLACK, x, y);
        return this;
    }

    public ChessBoard build() {
        return this.board;
    }

    private void addPiece(PieceType type, Color color, int x, int y) {
        Point position = new Point(x, y);
        Chesspiece piece = createPiece(type, color, position);
        this.board.placePiece(piece, position);
    }

    private Chesspiece createPiece(PieceType type, Color color, Point position) {
        switch (type) {
            case PAWN:
                Direction direction = color.equals(Color.WHITE) ? Direction.UP : Direction.DOWN;
                return new Pawn(position, color, direction);
            case ROOK:    return new Rook(position, color);
            case KNIGHT:  return new Knight(position, color);
            case BISHOP:  return new Bishop(position, color);
            case QUEEN:   return new Queen(position, color);
            case KING:    return new King(position, color);
            default:
                throw new IllegalArgumentException("Unbekannter Figurentyp: " + type);
        }
    }
}