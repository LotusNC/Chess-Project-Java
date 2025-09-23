package org.example.Attributes;

public class Hex {

    private String sixDigitHex;

    public Hex(String sixDigitHex) {

        if (sixDigitHex.length() == 6) {
            this.sixDigitHex = sixDigitHex;
        } else  {
            throw new IllegalArgumentException("Hex length should be 6");
        }

    }
}
