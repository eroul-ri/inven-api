package com.api.demo.inven.repository;

import com.api.demo.inven.domain.Inven;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvenRepository extends JpaRepository<Inven, Long> {
}
