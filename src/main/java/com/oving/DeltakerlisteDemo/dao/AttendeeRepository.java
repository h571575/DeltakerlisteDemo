package com.oving.DeltakerlisteDemo.dao;

import com.oving.DeltakerlisteDemo.model.Attendee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository("postgres")
public interface AttendeeRepository extends CrudRepository<Attendee,Integer> {
}
