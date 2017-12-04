package linq;

/**
 *
 * @param <T>
 */
@FunctionalInterface
public interface Where<T> {
    /**
     * Es wird geprüft, ob element die geforderte Bedingung erfüllt
     *
     * @param element
     * @return Erfüllt die bedingung?
     */
    public abstract boolean where(T element);
    
}
