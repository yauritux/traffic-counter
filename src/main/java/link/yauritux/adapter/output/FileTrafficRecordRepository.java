package link.yauritux.adapter.output;

import link.yauritux.domain.model.TrafficRecord;
import link.yauritux.domain.repository.TrafficRecordRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

/**
 * @author Yauri Attamimi (yaurigneel@gmail.com)
 * @version 1.0
 */
@RequiredArgsConstructor
public class FileTrafficRecordRepository implements TrafficRecordRepository {

    private final String filePath;

    @Override
    public List<TrafficRecord> findAll() {
        return List.of();
    }
}
