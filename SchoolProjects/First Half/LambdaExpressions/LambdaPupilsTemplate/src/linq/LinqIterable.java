/*
 * LinqIterable<T> erweitert das Interface Iterable<T>
 * um einige Defaultmethoden, die die Arbeit mit Collections
 * deutlich vereinfachen.
 */
package linq;

import java.util.Comparator;

/**
 * @param <T>
 */
public interface LinqIterable<T> extends Iterable<T>{
    
    /**
     * Die Methode select() erweitert das Interface Iterable
     * um die Fähigkeit, alle Elemente für die die Predicate-Methode
     * where() true liefert in eine erstellte Zielcollection zu
     * übernehmen.
     * Als Ergebnistyp implementiert die Zielcollection wieder das 
     * Interface LinqIterable und kann daher per MethodChaining 
     * weiterverwendet werden.
     * @param whereClause eigentlich Methodenzeiger
     * @return Liste der passenden Elemente
     */
    default LinqIterable<T> select(Where<T> whereClause){
        LinqArrayList res = new LinqArrayList();
        for(T curr : this){
            if(whereClause.where(curr)){
                res.add(curr);
            }
        }
        return res;
    }
    
    
    /**
     * Die Methode aggregate() ist eine universell einsetzbare Methode zur 
     * Aggregation einer beliebigen LinqIterable-Collection. Durch die
     * Übergabe der Aggregationsfunktion (z.B. als LambdaExpression) kann mit
     * sehr wenig Aufwand eine beliebige Aggregation erreicht werden (z.B. Summe,
     * Mittelwert, Max, Min, ...)
     * @param <R>   Typ des Aggregates
     * @param seed  Startwert für die Aggregation (0 bei "Summen", 1 bei "Produkten")
     * @param aggregateFunction Funktion, die ein Element zur Aggregation hinzufügt
     * @return 
     */
    default <R> R aggregate(R seed, AggregateFunction<R,T> aggregateFunction ){
       R value = seed;
       for(T element : this){
           value = aggregateFunction.aggregateSingleElement(value, element);
       }
       return value;
    }
    /**
     * Die Methode orderBy() ist eine universell einsetzbare Methode zur 
     * Sotierung einer beliebigen LinqIterable-Collection. Durch die
     * Übergabe der Sortierfunktion (z.B. als LambdaExpression) kann mit
     * sehr wenig Aufwand eine beliebige Sotierung von einer Liste durchführen.
     * @param comparator Sotierbedingung
     * @return 
     */
    default LinqIterable<T> orderBy(Comparator<T> comparator){
        LinqArrayList sortedList = (LinqArrayList) this;
        sortedList.sort(comparator);
        return sortedList;
    }
    /**
     * Die Methode groupBy() ist eine universell einsetzbare Methode zur 
     * Gruppierung einer beliebigen LinqIterable-Collection. Durch die
     * Übergabe der Gruppierungsfunktion (z.B. als LambdaExpression) kann mit
     * sehr wenig Aufwand eine beliebige Gruppierung von einer Liste durchführen.
     * @param comparer Gruppierungsbedingung
     * @return 
     */
    default LinqIterable<LinqIterable<T>> groupBy(Comparator<T> comparer){
        LinqArrayList <LinqIterable<T>> groupedList = new LinqArrayList<>();
        for(T value : this){
            boolean listAdd = false;
            for(LinqIterable<T> listEntry : groupedList){
                if(comparer.compare(value, ((LinqArrayList<T>) listEntry).get(0)) == 0){
                    ((LinqArrayList<T>) listEntry).add(value);
                    listAdd = true;
                }
            }
            if(listAdd == false){
                LinqArrayList newCity = new LinqArrayList();
                newCity.add(value);
                groupedList.add(newCity);
            }
            
        }
        return groupedList;
    }
}
