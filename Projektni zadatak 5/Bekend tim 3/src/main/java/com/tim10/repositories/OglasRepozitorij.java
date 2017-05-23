package com.tim10.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.tim10.models.Oglas;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OglasRepozitorij extends CrudRepository<Oglas, Long> {

}