package org.example.Editor;

import org.example.Logic.ChessBoard;

/**
 * Eine Sammlung von Voreinstellungen (Presets) für Schachbrett-Aufstellungen.
 * Diese Klasse definiert konkrete Brett-Layouts und verwendet den Editor,
 * um diese zu erstellen.
 */
public final class StandardPresets {

    private StandardPresets() {}

    /**
     * Erstellt das Preset für die Standard-Anfangsaufstellung eines Schachspiels.
     *
     * @return Ein ChessBoard, das für den Start einer neuen Partie konfiguriert ist.
     */
    public static ChessBoard standardGame() {
        return new Editor()
                // Weiße Figuren
                .addWhite(PieceType.ROOK, 0, 0)
                .addWhite(PieceType.KNIGHT, 1, 0)
                .addWhite(PieceType.BISHOP, 2, 0)
                .addWhite(PieceType.QUEEN, 3, 0)
                .addWhite(PieceType.KING, 4, 0)
                .addWhite(PieceType.BISHOP, 5, 0)
                .addWhite(PieceType.KNIGHT, 6, 0)
                .addWhite(PieceType.ROOK, 7, 0)
                .addWhite(PieceType.PAWN, 0, 1)
                .addWhite(PieceType.PAWN, 1, 1)
                .addWhite(PieceType.PAWN, 2, 1)
                .addWhite(PieceType.PAWN, 3, 1)
                .addWhite(PieceType.PAWN, 4, 1)
                .addWhite(PieceType.PAWN, 5, 1)
                .addWhite(PieceType.PAWN, 6, 1)
                .addWhite(PieceType.PAWN, 7, 1)

                // Schwarze Figuren
                .addBlack(PieceType.ROOK, 0, 7)
                .addBlack(PieceType.KNIGHT, 1, 7)
                .addBlack(PieceType.BISHOP, 2, 7)
                .addBlack(PieceType.QUEEN, 3, 7)
                .addBlack(PieceType.KING, 4, 7)
                .addBlack(PieceType.BISHOP, 5, 7)
                .addBlack(PieceType.KNIGHT, 6, 7)
                .addBlack(PieceType.ROOK, 7, 7)
                .addBlack(PieceType.PAWN, 0, 6)
                .addBlack(PieceType.PAWN, 1, 6)
                .addBlack(PieceType.PAWN, 2, 6)
                .addBlack(PieceType.PAWN, 3, 6)
                .addBlack(PieceType.PAWN, 4, 6)
                .addBlack(PieceType.PAWN, 5, 6)
                .addBlack(PieceType.PAWN, 6, 6)
                .addBlack(PieceType.PAWN, 7, 6)

                // Den Bauprozess abschließen und das Brett zurückgeben
                .build();
    }
}