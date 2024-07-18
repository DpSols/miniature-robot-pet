package org.sample.samplegateway.comparator;

import org.sample.samplegateway.model.SortingParam;
import org.sample.samplegateway.model.User;

import java.util.Comparator;

public class ByAgeComparator implements Comparator<User> {
    private SortingParam sortingParam;

    public ByAgeComparator(SortingParam sortingParam) {
        this.sortingParam = sortingParam;
    }

    @Override
    public int compare(User o1, User o2) {
        if (sortingParam == SortingParam.DESCENDING) {
            return o2.getAge() - o1.getAge();
        }
        return o1.getAge() - o2.getAge();
    }
}
