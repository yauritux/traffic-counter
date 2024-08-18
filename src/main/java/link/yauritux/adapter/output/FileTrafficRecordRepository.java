package link.yauritux.adapter.output;

import link.yauritux.domain.model.TrafficRecord;
import link.yauritux.domain.repository.TrafficRecordRepository;
import lombok.RequiredArgsConstructor;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
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
        List<TrafficRecord> records = new ArrayList<>();
        try {
            List<String> lines = Files.readAllLines(Paths.get(ClassLoader.getSystemResource(filePath).getPath()));
            for (String line : lines) {
                String[] parts = line.split(" ");
                LocalDateTime timestamp = LocalDateTime.parse(parts[0], DateTimeFormatter.ISO_DATE_TIME);
                int carCount = Integer.parseInt(parts[1]);
                records.add(new TrafficRecord(timestamp, carCount));
            }
        } catch (IOException e) {
            System.err.println("File not found: " + e.getMessage());
        }

        return records;
    }
}
