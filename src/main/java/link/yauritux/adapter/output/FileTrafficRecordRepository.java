package link.yauritux.adapter.output;

import link.yauritux.domain.model.TrafficRecord;
import link.yauritux.domain.repository.TrafficRecordRepository;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author Yauri Attamimi (yaurigneel@gmail.com)
 * @version 1.0
 */
@RequiredArgsConstructor
public class FileTrafficRecordRepository implements TrafficRecordRepository {

    private static final Logger logger = LogManager.getLogger(FileTrafficRecordRepository.class);

    private final String filePath;

    @Override
    public List<TrafficRecord> findAll() {
        List<TrafficRecord> records = new ArrayList<>();
        try {
            var br = new BufferedReader(new InputStreamReader(Objects.requireNonNull(getClass().getResourceAsStream("/" + filePath))));
            String line = br.readLine();
            while (line != null) {
                String[] parts = line.split(" ");
                LocalDateTime timestamp = LocalDateTime.parse(parts[0], DateTimeFormatter.ISO_DATE_TIME);
                int carCount = Integer.parseInt(parts[1]);
                records.add(new TrafficRecord(timestamp, carCount));
                line = br.readLine();
            }
        } catch (IOException e) {
            logger.error("Failed to read traffic records from file {}", filePath);
        } catch (Exception e) {
            logger.error("Failed to read traffic records from file {}. Reason: {}", filePath, e.getMessage());
        }

        return records;
    }
}
