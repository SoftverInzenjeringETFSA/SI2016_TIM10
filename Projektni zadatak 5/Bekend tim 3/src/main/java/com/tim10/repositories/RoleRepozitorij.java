package com.tim10.repositories;

import com.tim10.models.Role;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Dragnic on 24.05.2017..
 */
public interface  RoleRepozitorij extends CrudRepository<Role, Long> {
@Query("select r from Role r where id=?")

public Role findById( Long id);
}
