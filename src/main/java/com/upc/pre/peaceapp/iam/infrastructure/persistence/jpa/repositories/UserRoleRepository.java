package com.upc.pre.peaceapp.iam.infrastructure.persistence.jpa.repositories;

import com.upc.pre.peaceapp.iam.domain.model.aggregates.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

public interface UserRoleRepository extends CrudRepository<User, Long> {
    @Modifying
    @Transactional
    @Query(value = "delete from user_roles where user_id = ?1", nativeQuery = true)
    void deleteRolesByUserId(Long userId);
}
