package com.pyro.diony.domain.advertisement.repository;

import com.pyro.diony.domain.advertisement.entity.Advertisement;
import com.pyro.diony.domain.advertisement.entity.Audio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AudioRepository extends JpaRepository<Audio, Long> {
    List<Audio> findAllByAdvertisement(Advertisement advertisement);
}
