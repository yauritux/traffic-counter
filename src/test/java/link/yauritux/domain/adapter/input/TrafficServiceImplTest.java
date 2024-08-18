package link.yauritux.domain.adapter.input;

import link.yauritux.adapter.input.TrafficRecordServiceImpl;
import link.yauritux.domain.model.TrafficRecord;
import link.yauritux.domain.repository.TrafficRecordRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

/**
 * @author Yauri Attamimi (yaurigneel@gmail.com)
 * @version 1.0
 */
@ExtendWith(MockitoExtension.class)
public class TrafficServiceImplTest {

    @InjectMocks
    private TrafficRecordServiceImpl trafficRecordService;
    @Mock
    private TrafficRecordRepository trafficRecordRepository;

    @Test
    void testTotalCarsSeen() {
        when(trafficRecordRepository.findAll()).thenReturn(mockTrafficRecords());
        assertEquals(175, trafficRecordService.totalCarsSeen());
    }

    @Test
    void testCarsPerDay() {
        when(trafficRecordRepository.findAll()).thenReturn(mockTrafficRecords());

        Map<LocalDate, Integer> carsPerDay = trafficRecordService.carsPerDay();
        assertEquals(120, carsPerDay.get(LocalDate.of(2024, 8, 17)));
        assertEquals(55, carsPerDay.get(LocalDate.of(2024, 8, 18)));
    }

    @Test
    void testTop3HalfHours() {
        when(trafficRecordRepository.findAll()).thenReturn(mockTrafficRecords());

        List<TrafficRecord> top3 = trafficRecordService.top3HalfHours();
        assertEquals(40, top3.get(0).carCount());
        assertEquals(35, top3.get(1).carCount());
        assertEquals(30, top3.get(2).carCount());
    }

    private List<TrafficRecord> mockTrafficRecords() {
        return Arrays.asList(
                new TrafficRecord(LocalDateTime.parse("2024-08-17T00:00:00"), 20),
                new TrafficRecord(LocalDateTime.parse("2024-08-17T00:30:00"), 35),
                new TrafficRecord(LocalDateTime.parse("2024-08-17T01:00:00"), 15),
                new TrafficRecord(LocalDateTime.parse("2024-08-17T01:30:00"), 40),
                new TrafficRecord(LocalDateTime.parse("2024-08-17T02:00:00"), 10),
                new TrafficRecord(LocalDateTime.parse("2024-08-18T00:00:00"), 25),
                new TrafficRecord(LocalDateTime.parse("2024-08-18T00:30:00"), 30)
        );
    }
}
