package demo.op.core.order.collector.core.v2.dao.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import org.springframework.cloud.gcp.data.spanner.core.mapping.Column;
import org.springframework.cloud.gcp.data.spanner.core.mapping.PrimaryKey;
import org.springframework.cloud.gcp.data.spanner.core.mapping.Table;

// Generated 13 Feb, 2021 6:29:28 PM by Hibernate Tools 5.4.21.Final
/**
 * LockStatsTopHour generated by hbm2java
 */
@Getter
@Setter
@NoArgsConstructor
@Table(name = "LOCK_STATS_TOP_HOUR")
public class LockStatsTopHour implements java.io.Serializable {

    private LockStatsTopHourId id;
}
