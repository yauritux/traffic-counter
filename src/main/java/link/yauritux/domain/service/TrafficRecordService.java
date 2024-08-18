package link.yauritux.domain.service;

import link.yauritux.domain.model.TrafficRecord;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

/**
 * @author Yauri Attamimi (yaurigneel@gmail.com)
 * @version 1.0
 *
 */
public interface TrafficRecordService {

    int totalCarsSeen();
    Map<LocalDate, Integer> carsPerDay();
    List<TrafficRecord> top3HalfHours();
    List<TrafficRecord> leastCarsIn1_5Hours();
}
