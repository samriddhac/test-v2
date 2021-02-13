package demo.op.core.order.core.v1.dao.mapper;

import org.mapstruct.Mapper;
import com.macys.mst.order.foundation.core.utils.mapper.AbstractMapper;

@Mapper(componentModel = "spring")
public interface OrderToOrderMapper
    extends AbstractMapper<
        com.macys.uop.model.Order, demo.op.core.order.core.v1.dao.entity.OrderMaster> {}
