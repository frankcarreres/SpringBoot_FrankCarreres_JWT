package com.ieseljust.ad.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ieseljust.ad.model.Singer;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public interface SingerRepository extends JpaRepository<Singer, Integer>{

}
