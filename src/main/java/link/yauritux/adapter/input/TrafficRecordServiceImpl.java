package link.yauritux.adapter.input;

import link.yauritux.domain.model.TrafficRecord;
import link.yauritux.domain.repository.TrafficRecordRepository;
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
public class TrafficRecordServiceImpl implements TrafficRecordService {

    private final TrafficRecordRepository trafficRecordRepository;

    @Override
    public int totalCarsSeen() {
        return 0;
    }

    @Override
    public Map<LocalDate, Integer> carsPerDay() {
        return Map.of();
    }

    @Override
    public List<TrafficRecord> top3HalfHours() {
        return List.of();
    }

    @Override
    public List<TrafficRecord> leastCarsIn1_5Hours() {
        return List.of();
    }
}
