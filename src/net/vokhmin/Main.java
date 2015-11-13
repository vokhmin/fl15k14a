package net.vokhmin;

public class Main {

    public static void main(String[] args) {

        Circuit r12 = new Resistore(12.0);
        Circuit r4 = new Resistore(4.0);
        Circuit r2 = new Resistore(2.0);
        double expected;

        Circuit[] resistorsA = { r4, r4, r2 };

        Parallel parallelA = new Parallel(resistorsA);
        expected = 1 / ( 2 / 4.0 + 1 / 2.0 );
        if (parallelA.getResistance() != expected)
            System.out.printf("ERROR:1: expected - %f, but actual - %f", expected, parallelA.getResistance());

        Serial serialA = new Serial(resistorsA);
        expected = 2 * 4.0 + 2.0;
        if (serialA.getResistance() != expected)
            System.out.printf("ERROR:2: expected - %f, but actual - %f", expected, serialA.getResistance());

        Circuit circuit;

        circuit = new Serial( new Circuit[] {parallelA, serialA} );
        expected = 1.0 + 10.0;
        if (circuit.getResistance() != expected)
            System.out.printf("ERROR:3: expected - %f, but actual - %f", expected, circuit.getResistance());

        circuit = new Parallel( new Circuit[] {parallelA, serialA} );
        expected = 1 / ( 1 / 1.0 + 1 / 10.0);
        if (circuit.getResistance() != expected)
            System.out.printf("ERROR:4: expected - %f, but actual - %f", expected, circuit.getResistance());

    }
}
