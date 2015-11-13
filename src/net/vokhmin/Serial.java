package net.vokhmin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class Serial extends Circuit {

    private final ArrayList<Circuit> resistances = new ArrayList<Circuit>();

    public Serial(Circuit resistance) {
        resistances.add(resistance);
    }

    public Serial(Collection<Circuit> resistors) {
        this.resistances.addAll(resistors);
    }

    public Serial(Circuit[] circuits) {
        this.resistances.addAll(Arrays.asList(circuits));
    }

    @Override
    public double getResistance() {
        double res = 0.0;
        for (Circuit r : resistances) {
            res += r.getResistance();
        }
        return res;
    }
}
