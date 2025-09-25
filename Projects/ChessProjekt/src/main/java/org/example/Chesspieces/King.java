package org.example.Chesspieces;

import org.example.Attributes.Color;
import org.example.Attributes.Point;

public class King extends Chesspiece {
    public King(Point position, Color color) {
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

        // Der König kann sich in jede Richtung bewegen, aber nur um maximal ein Feld.
        // Das bedeutet, der Abstand auf der x-Achse und auf der y-Achse darf
        // jeweils nicht größer als 1 sein.
        return dx <= 1 && dy <= 1;
    }
}
