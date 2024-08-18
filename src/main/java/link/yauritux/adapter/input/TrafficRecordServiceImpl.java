package link.yauritux.adapter.input;

import link.yauritux.domain.model.TrafficRecord;
import link.yauritux.domain.repository.TrafficRecordRepository;
import link.yauritux.domain.service.TrafficRecordService;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Yauri Attamimi (yaurigneel@gmail.com)
 * @version 1.0
 */
@RequiredArgsConstructor
public class TrafficRecordServiceImpl implements TrafficRecordService {

    private final TrafficRecordRepository trafficRecordRepository;

    @Override
    public int totalCarsSeen() {
        return trafficRecordRepository.findAll().stream().mapToInt(TrafficRecord::carCount).sum();
    }

    @Override
    public Map<LocalDate, Integer> carsPerDay() {
        return trafficRecordRepository.findAll().stream()
                .collect(Collectors.groupingBy(
                        record -> record.timestamp().toLocalDate(),
                        Collectors.summingInt(TrafficRecord::carCount)
                ));
    }

    @Override
    public List<TrafficRecord> top3HalfHours() {
        return trafficRecordRepository.findAll().stream()
                .sorted(Comparator.comparingInt(TrafficRecord::carCount).reversed())
                .limit(3)
                .collect(Collectors.toList());
    }

    @Override
    public List<TrafficRecord> leastCarsIn1_5Hours() {
        List<TrafficRecord> records = trafficRecordRepository.findAll();
        int minCars = Integer.MAX_VALUE;
        List<TrafficRecord> minPeriod = new ArrayList<>();

        for (int i = 0; i <= records.size() - 3; i++) {
            int carsInPeriod = records.get(i).carCount() +
                    records.get(i + 1).carCount() +
                    records.get(i + 2).carCount();
            if (carsInPeriod < minCars) {
                minCars = carsInPeriod;
                minPeriod = records.subList(i, i + 3);
            }
        }

        return minPeriod;
    }
}
