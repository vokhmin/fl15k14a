package net.vokhmin;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class Parallel extends Circuit {

    private final ArrayList<Circuit> resistances = new ArrayList<Circuit>();

    public Parallel(Circuit circuit) {
        resistances.add(circuit);
    }

    public Parallel(Collection<Circuit> circuits) {
        this.resistances.addAll(circuits);
    }

    public Parallel(Circuit[] circuits) {
        this.resistances.addAll(Arrays.asList(circuits));
    }

    @Override
    public double getResistance() {
        double res = 0.0;
        for (Circuit r : resistances) {
            res += 1 / r.getResistance();
        }
        return 1 / res;
    }
}
