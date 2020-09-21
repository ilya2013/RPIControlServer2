package com.ibesh.rpi.repository;

import com.ibesh.rpi.model.DhtModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface DhtRepository extends CrudRepository<DhtModel, Long> {
}
