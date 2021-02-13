package demo.op.core.airport.core.svc.v1.dao.mapper;

import org.mapstruct.Mapper;
import com.macys.mst.order.foundation.core.utils.mapper.AbstractMapper;

@Mapper(componentModel = "spring")
public interface AirportToAirportMapper
    extends AbstractMapper<
        demo.cosmos.core.airport.model.Airport,
        demo.op.core.airport.core.svc.v1.dao.entity.OrderMaster> {}
