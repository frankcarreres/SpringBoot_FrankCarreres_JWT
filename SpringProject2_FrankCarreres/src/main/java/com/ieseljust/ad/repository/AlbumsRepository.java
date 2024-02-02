package com.ieseljust.ad.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ieseljust.ad.model.Albums;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public interface AlbumsRepository extends JpaRepository<Albums, Integer> {

}
