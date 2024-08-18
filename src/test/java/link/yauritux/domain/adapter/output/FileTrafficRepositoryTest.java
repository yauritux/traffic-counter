package link.yauritux.domain.adapter.output;

import link.yauritux.adapter.output.FileTrafficRecordRepository;
import link.yauritux.domain.model.TrafficRecord;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Yauri Attamimi (yaurigneel@gmail.com)
 * @version 1.0
 */
public class FileTrafficRepositoryTest {

    @Test
    void testFindAll() {
        FileTrafficRecordRepository repository = new FileTrafficRecordRepository("traffic_data.txt");
        List<TrafficRecord> records = repository.findAll();

        assertEquals(24, records.size());
        assertEquals(LocalDateTime.parse("2021-12-01T05:00:00"), records.get(0).timestamp());
        assertEquals(5, records.get(0).carCount());

        assertEquals(LocalDateTime.parse("2021-12-01T08:00:00"), records.get(6).timestamp());
        assertEquals(42, records.get(6).carCount());
    }
}
