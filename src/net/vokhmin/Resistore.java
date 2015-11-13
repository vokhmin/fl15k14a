package net.vokhmin;

public class Resistore extends Circuit {

    final double resistance;

    public Resistore(double resistance) {
        this.resistance = resistance;
    }

    @Override
    public double getResistance() {
        return resistance;
    }

}
