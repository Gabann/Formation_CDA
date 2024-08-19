package com.example.hexagonal.infra.repository;

import com.example.hexagonal.infra.entity.EventEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventEntityRepository extends CrudRepository<EventEntity, Long>
{
}
