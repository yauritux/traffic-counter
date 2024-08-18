package link.yauritux.domain.model;

import java.time.LocalDateTime;

/**
 * @author Yauri Attamimi (yaurigneel@gmail.com)
 * @version 1.0
 *
 * @param timestamp
 * @param carCount
 */
public record TrafficRecord(LocalDateTime timestamp, int carCount) {
}
