package com.ibesh.rpi.mapper;

import com.ibesh.rpi.dto.DhtDto;
import com.ibesh.rpi.model.DhtModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper
public interface DHTSourceDestinationMapper {
    @Mappings({
            @Mapping(target="time", source = "time",
                    dateFormat = "yyyy-MM-dd-HH.mm.ss")})
    DhtModel sourceToDestination(DhtDto source);

    @Mappings({
            @Mapping(target="time", source = "time",
                    dateFormat = "yyyy-MM-dd-HH.mm.ss")})
    DhtDto destinationToSource(DhtModel destination);
}

