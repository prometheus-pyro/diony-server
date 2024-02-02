package com.pyro.diony.domain.advertisement.mapper;

import com.pyro.diony.domain.advertisement.dto.AudioRequest;
import com.pyro.diony.domain.advertisement.dto.response.AudioDetailResponse;
import com.pyro.diony.domain.advertisement.entity.Audio;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AudioMapper {

    AudioDetailResponse toResponse(Audio audio);

    Audio toEntity(AudioRequest audioRequest);

}
