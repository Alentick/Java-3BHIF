/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linq;

import entity.Pupil;
import java.time.Instant;
import java.time.temporal.ChronoField;
import java.util.Date;

/**
 *
 * @author alen
 */
public class AggregateWeeks implements AggregateFunction<Integer,Pupil>{
    
    @Override
    public Integer aggregateSingleElement(Integer aggregation, Pupil element) {
        
        Date date = element.getBirthDate();
        Instant instant = date.toInstant();
        int nano = (int) instant.getEpochSecond();
        int second = nano;
        int minute = second / 60;
        int hour = minute / 60;
        int day = hour / 24;
        int week = day / 7;
        return aggregation + week;
    }
}
