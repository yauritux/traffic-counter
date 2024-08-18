package link.yauritux;

import link.yauritux.adapter.input.TrafficRecordServiceImpl;
import link.yauritux.adapter.output.FileTrafficRecordRepository;
import link.yauritux.application.TrafficCounterApplication;
import link.yauritux.domain.repository.TrafficRecordRepository;
import link.yauritux.domain.service.TrafficRecordService;

import java.nio.file.Paths;

/**
 * @author Yauri Attamimi (yaurigneel@gmail.com)
 * @version 1.0
 *
 */
public class TrafficCounterMainStarter {

    public static void main( String[] args ) {
        TrafficRecordRepository repository = new FileTrafficRecordRepository("traffic_data.txt");
        TrafficRecordService service = new TrafficRecordServiceImpl(repository);
        TrafficCounterApplication application = new TrafficCounterApplication(service);

        application.run();
    }
}
