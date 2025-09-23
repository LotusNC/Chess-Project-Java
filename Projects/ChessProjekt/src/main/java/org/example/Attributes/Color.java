package org.example.Attributes;

public class Color {

    private Hex hex;
    private String colorName;

    public Color(Hex hex, String colorName) {
        this.hex = hex;
        this.colorName = colorName;
    }

    public Color() {
        this.hex = new Hex("ffffff");
        this.colorName = "white";
    }
}
