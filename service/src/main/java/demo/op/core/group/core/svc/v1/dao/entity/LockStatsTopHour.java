package demo.op.core.group.core.svc.v1.dao.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import org.springframework.cloud.gcp.data.spanner.core.mapping.Column;
import org.springframework.cloud.gcp.data.spanner.core.mapping.PrimaryKey;
import org.springframework.cloud.gcp.data.spanner.core.mapping.Table;

// Generated 13 Feb, 2021 5:53:45 PM by Hibernate Tools 5.4.21.Final
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
