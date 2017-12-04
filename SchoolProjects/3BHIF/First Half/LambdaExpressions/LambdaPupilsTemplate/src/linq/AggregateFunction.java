package linq;

/**
 * Generische Aggregationsmethode wird über ein Interface
 * definiert. Die konkrete Aggregation kann dann eine
 * Summe, Mittelwert, Erster Wert, letzter Wert, ... sein
 *
 * @param <R> Ergebnistyp
 * @param <T> Typ in der Collection
 * @author java@htl-leonding
 */
@FunctionalInterface
public interface AggregateFunction<R, T> {
    public R aggregateSingleElement(R aggregation, T element);
}
