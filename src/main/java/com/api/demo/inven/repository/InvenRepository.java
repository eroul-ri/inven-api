package com.api.demo.inven.repository;

import com.api.demo.inven.domain.Inven;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface InvenRepository extends JpaRepository<Inven, Long> {
    List<Inven> findByPrdNm(String prdNm);
    Optional<Inven> findByPrdNmAndOptnNm(String prdNm, String optnNm);
}
