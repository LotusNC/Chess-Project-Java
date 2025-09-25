package org.example.Chesspieces;

import org.example.Attributes.Color;
import org.example.Attributes.Point;

public class Knight extends Chesspiece {
    public Knight(Point position, Color color) {
        super(position, color);
    }

    @Override
    public boolean canMoveTo(Point from, Point to) {

        if (from.equals(to)) {
            return false;
        }

        // Berechne die absolute Distanz auf beiden Achsen
        int dx = Math.abs(from.x() - to.x());
        int dy = Math.abs(from.y() - to.y());

        // Die L-förmige Bewegung des Springers:
        // Entweder 2 Felder horizontal und 1 vertikal,
        // ODER 1 Feld horizontal und 2 vertikal.
        return (dx == 2 && dy == 1) || (dx == 1 && dy == 2);
    }
}
