package org.example.Chesspieces;

import org.example.Attributes.Color;
import org.example.Attributes.Point;

public class Rook extends Chesspiece {
    public Rook(Point position, Color color) {
        super(position, color);
    }

    @Override
    public boolean canMoveTo(Point from, Point to) {

        if (from.equals(to)) {
            return false;
        }

        // Berechne die Distanz auf beiden Achsen
        int dx = Math.abs(from.getX() - to.getX());
        int dy = Math.abs(from.getY() - to.getY());

        // Gib true zurück, wenn die Bewegung entweder GERADE (wie ein Turm)
        // ODER DIAGONAL (wie ein Läufer) ist.
        return (dx == 0 || dy == 0) || (dx == dy);
    }
}
