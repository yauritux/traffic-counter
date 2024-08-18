package link.yauritux.application;

import link.yauritux.domain.model.TrafficRecord;
import link.yauritux.domain.service.TrafficRecordService;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

/**
 * @author Yauri Attamimi (yaurigneel@gmail.com)
 * @version 1.0
 */
@RequiredArgsConstructor
public class TrafficCounterApplication {

    private final TrafficRecordService trafficRecordService;

    public void run() {
        System.out.println("Total cars seen: " + trafficRecordService.totalCarsSeen());

        System.out.println("Cars seen per day:");
        Map<LocalDate, Integer> carsPerDay = trafficRecordService.carsPerDay();
        carsPerDay.forEach((date, count) -> System.out.println(date + " " + count));

        System.out.println("Top 3 half hours with most cars:");
        List<TrafficRecord> top3 = trafficRecordService.top3HalfHours();
        top3.forEach(record -> System.out.println(record.timestamp() + " " + record.carCount()));

        System.out.println("1.5 hour period with least cars:");
        List<TrafficRecord> leastCars = trafficRecordService.leastCarsIn1_5Hours();
        leastCars.forEach(record -> System.out.println(record.timestamp() + " " + record.carCount()));
    }
}
