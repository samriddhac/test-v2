package demo.op.core.order.collector.core.v2.dao.mapper;

import org.mapstruct.Mapper;
import com.macys.mst.order.foundation.core.utils.mapper.AbstractMapper;

@Mapper(componentModel = "spring")
public interface OrderTwoToOrderTwoMapper
    extends AbstractMapper<
        com.abcd.oop.model.Order, demo.op.core.order.collector.core.v2.dao.entity.OrderMaster> {}
