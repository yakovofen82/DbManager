package com.yakov.db.manager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yakov.db.manager.model.DBConnection;

@Repository
public interface DBConnectionRepository extends JpaRepository<DBConnection, Long> {


}
