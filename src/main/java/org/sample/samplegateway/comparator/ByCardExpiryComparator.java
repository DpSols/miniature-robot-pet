package org.sample.samplegateway.comparator;

import org.sample.samplegateway.model.Card;
import org.sample.samplegateway.model.SortingParam;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;

public class ByCardExpiryComparator implements Comparator<Card> {
    private final SortingParam sortingParam;

    public ByCardExpiryComparator(SortingParam sortingParam) {
        this.sortingParam = sortingParam;
    }

    @Override
    public int compare(Card o1, Card o2) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/yy");

        LocalDate expiry1 = LocalDate.parse(o1.getExpiry(), formatter);
        LocalDate expiry2 = LocalDate.parse(o2.getExpiry(), formatter);

        if (sortingParam == SortingParam.DESCENDING) {
            return expiry2.compareTo(expiry1);
        }
        return expiry1.compareTo(expiry2);
    }
}
