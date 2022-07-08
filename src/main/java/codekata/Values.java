package codekata;

import lombok.Value;

@Value
public class Values {

    private String label;

    private int min;

    private int max;

    public int getDifference() {
        return Math.abs(min - max);
    }

}
