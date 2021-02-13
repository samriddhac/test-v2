package demo.op.core.order.core.v1.dao.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import org.springframework.cloud.gcp.data.spanner.core.mapping.Column;
import org.springframework.cloud.gcp.data.spanner.core.mapping.PrimaryKey;
import org.springframework.cloud.gcp.data.spanner.core.mapping.Table;

// Generated 13 Feb, 2021 6:15:22 PM by Hibernate Tools 5.4.21.Final
/**
 * OrderLine generated by hbm2java
 */
@Getter
@Setter
@NoArgsConstructor
@Table(name = "OrderLine")
public class OrderLine implements java.io.Serializable {

    @PrimaryKey
    @Column(name = "id", nullable = false)
    private long id;

    @Column(name = "Order_Pk")
    private String orderPk;

    @Column(name = "Order_Id")
    private String orderId;

    @Column(name = "Line_Id")
    private Long lineId;

    @Column(name = "Upc_Number")
    private Long upcNumber;

    @Column(name = "Ordered_Qty")
    private Long orderedQty;

    @Column(name = "Delivery_Type")
    private String deliveryType;

    @Column(name = "Line_Total")
    private Long lineTotal;

    @Column(name = "Fulfillment_Type")
    private String fulfillmentType;

    @Column(name = "Product_Type")
    private String productType;
}
