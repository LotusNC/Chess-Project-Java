package org.example.Visualizers;

import org.example.Attributes.Color;
import org.example.Attributes.Point;
import org.example.Chesspieces.Chesspiece;
import org.example.Logic.ChessBoard;

import java.util.Optional;

public class ConsoleVisualizer implements ChessVisualizer {

    @Override
    public void visualize(ChessBoard board) {
        // Wir gehen davon aus, dass das Brett eine feste Größe hat, z.B. 8x8.
        // Die Schleife iteriert von der höchsten Reihe (7) zur niedrigsten (0),
        // damit das Brett korrekt in der Konsole ausgerichtet ist (A8 oben links).
        for (int y = 7; y >= 0; y--) {
            // Zeilennummer am Rand anzeigen für bessere Orientierung
            System.out.print((y + 1) + " ");
            for (int x = 0; x < 8; x++) {
                Point currentPoint = new Point(x, y);
                Optional<Chesspiece> pieceOpt = board.getPieceAt(currentPoint);

                if (pieceOpt.isPresent()) {
                    // Wenn eine Figur da ist, hol sie dir
                    Chesspiece piece = pieceOpt.get();
                    // Hol dir das Symbol für die Figur
                    char pieceSymbol = getPieceSymbol(piece);
                    System.out.print(pieceSymbol + " ");
                } else {
                    // Wenn keine Figur da ist, zeige ein leeres Feld
                    System.out.print(". ");
                }
            }
            // Nach jeder Zeile einen Zeilenumbruch machen
            System.out.println();
        }
        // Spaltenbuchstaben am unteren Rand hinzufügen
        System.out.println("  a b c d e f g h");
        System.out.println(); // Leerzeile für besseres Aussehen
    }

    /**
     * Hilfsmethode, um das Zeichen für eine bestimmte Schachfigur zu bekommen.
     * @param piece Die Schachfigur.
     * @return Ein char-Symbol für die Figur.
     */
    private char getPieceSymbol(Chesspiece piece) {
        char symbol;
        String pieceType = piece.getClass().getSimpleName();

        switch (pieceType) {
            case "Pawn":
                symbol = 'P';
                break;
            case "Rook":
                symbol = 'R';
                break;
            case "Knight":
                symbol = 'N'; // 'N' weil 'K' für den König ist
                break;
            case "Bishop":
                symbol = 'B';
                break;
            case "Queen":
                symbol = 'Q';
                break;
            case "King":
                symbol = 'K';
                break;
            default:
                symbol = '?'; // Falls eine unbekannte Figur auftaucht
                break;
        }

        // Wenn die Figur schwarz ist, mache den Buchstaben klein
        if (piece.getColor().equals(Color.BLACK)) {
            return Character.toLowerCase(symbol);
        }

        return symbol;
    }
}