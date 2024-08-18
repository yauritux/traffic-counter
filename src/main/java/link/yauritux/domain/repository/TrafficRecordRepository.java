package link.yauritux.domain.repository;

import link.yauritux.domain.model.TrafficRecord;

import java.util.List;

/**
 * @author Yauri Attamimi (yaurigneel@gmail.com)
 * @version 1.0
 *
 */
public interface TrafficRecordRepository {

    List<TrafficRecord> findAll();
}
