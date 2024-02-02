package com.pyro.diony.domain.advertisement.mapper;

import com.pyro.diony.domain.advertisement.dto.AdvertiseRequest;
import com.pyro.diony.domain.advertisement.dto.response.AdDetailResponse;
import com.pyro.diony.domain.advertisement.dto.response.AdvertiseResponse;
import com.pyro.diony.domain.advertisement.dto.response.AudioDetailResponse;
import com.pyro.diony.domain.advertisement.entity.Advertisement;
import com.pyro.diony.domain.advertisement.entity.Audio;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AdvertisementMapper {
    Advertisement toEntity(AdvertiseRequest advertiseRequest);

    AdDetailResponse toResponse(Advertisement advertisement);



}
