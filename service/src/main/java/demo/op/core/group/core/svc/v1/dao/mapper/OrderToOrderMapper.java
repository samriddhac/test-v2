package demo.op.core.group.core.svc.v1.dao.mapper;

import org.mapstruct.Mapper;
import com.macys.mst.order.foundation.core.utils.mapper.AbstractMapper;

@Mapper(componentModel = "spring")
public interface OrderToOrderMapper
    extends AbstractMapper<
        com.abcd.uop.model.Order, demo.op.core.group.core.svc.v1.dao.entity.OrderMaster> {}
