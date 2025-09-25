package org.example.Chesspieces;

import org.example.Attributes.Color;
import org.example.Attributes.Point;

public class Bishop extends Chesspiece {
    public Bishop(Point position, Color color) {
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

        // Ein Läufer kann sich nur bewegen, wenn die Bewegung rein diagonal ist.
        // Das ist der Fall, wenn der Abstand auf der x-Achse dem Abstand
        // auf der y-Achse entspricht.
        return dx == dy;
    }
}
