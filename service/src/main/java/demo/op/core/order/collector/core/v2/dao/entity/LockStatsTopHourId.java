package demo.op.core.order.collector.core.v2.dao.entity;

// Generated 13 Feb, 2021 6:29:28 PM by Hibernate Tools 5.4.21.Final
import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import org.springframework.cloud.gcp.data.spanner.core.mapping.Column;
import org.springframework.cloud.gcp.data.spanner.core.mapping.PrimaryKey;
import org.springframework.cloud.gcp.data.spanner.core.mapping.Table;

/**
 * LockStatsTopHourId generated by hbm2java
 */
@Getter
@Setter
@NoArgsConstructor
public class LockStatsTopHourId implements java.io.Serializable {

    @Column(name = "INTERVAL_END")
    private Date intervalEnd;

    @Column(name = "ROW_RANGE_START_KEY")
    private byte[] rowRangeStartKey;

    @Column(name = "LOCK_WAIT_SECONDS")
    private Double lockWaitSeconds;

    @Column(name = "SAMPLE_LOCK_REQUESTS")
    private Serializable sampleLockRequests;
}
