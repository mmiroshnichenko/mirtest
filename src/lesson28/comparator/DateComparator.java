package lesson28.comparator;

import java.util.Comparator;

public class DateComparator extends BaseComparator implements Comparator<Capability> {
    @Override
    public int compare(Capability o1, Capability o2) {
        Integer res = compareObjectsWithNull(o1.getDateCreated(), o2.getDateCreated());
        if (res == null) {
            res = 0;
            if (o2.getDateCreated().getTime() > o1.getDateCreated().getTime()) {
                res = 1;
            } else if (o2.getDateCreated().getTime() > o1.getDateCreated().getTime()) {
                res = -1;
            }
        }
        return res;
    }
}
