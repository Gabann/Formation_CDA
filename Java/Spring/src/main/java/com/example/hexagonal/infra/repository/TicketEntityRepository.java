package com.example.hexagonal.infra.repository;

import com.example.hexagonal.infra.entity.TicketEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketEntityRepository extends CrudRepository<TicketEntity, Long>
{

}
