package demo.op.core.order.collector.core.v1.dao.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import org.springframework.cloud.gcp.data.spanner.core.mapping.Column;
import org.springframework.cloud.gcp.data.spanner.core.mapping.PrimaryKey;
import org.springframework.cloud.gcp.data.spanner.core.mapping.Table;

// Generated 13 Feb, 2021 6:24:44 PM by Hibernate Tools 5.4.21.Final
/**
 * LockStatsTotal10minute generated by hbm2java
 */
@Getter
@Setter
@NoArgsConstructor
@Table(name = "LOCK_STATS_TOTAL_10MINUTE")
public class LockStatsTotal10minute implements java.io.Serializable {

    private LockStatsTotal10minuteId id;
}
