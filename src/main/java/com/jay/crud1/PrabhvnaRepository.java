package com.jay.crud1;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

    //public interface PrabhvnaRepository extends JpaRepository<Prabhvna, Long> {
    public interface PrabhvnaRepository extends JpaRepository<Prabhvna, String> {

    //	@Query("SELECT p FROM prabhvna p WHERE p.name LIKE %?1%"
//			+ " OR p.brand LIKE %?1%"
//			+ " OR p.madein LIKE %?1%"
//			+ " OR CONCAT(p.price, '') LIKE %?1%")
    @Query("SELECT p FROM Prabhvna p WHERE CONCAT(p.ecn, ' ', p.centre, ' ', p.karyakarta) LIKE %?1%")
    public List<Prabhvna> search(String keyword);
}
