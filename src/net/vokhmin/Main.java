package net.vokhmin;

public class Main {

    public static void main(String[] args) {

        Circuit r12 = new Resistore(12.0);
        Circuit r7 = new Resistore(7.0);
        Circuit r5 = new Resistore(5.0);

        Circuit[] resistorsA = { r12, r12, r12 };
        Parallel parallelA = new Parallel(resistorsA);
        assert parallelA.getResistance() == 12.0 / 3;

        Serial serialA = new Serial(resistorsA);
        assert serialA.getResistance() == 12.0 * 3;
    }
}
