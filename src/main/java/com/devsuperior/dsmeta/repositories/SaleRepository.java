package com.devsuperior.dsmeta.repositories;

import java.time.LocalDate;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.devsuperior.dsmeta.dto.SaleReportDTO;
import com.devsuperior.dsmeta.dto.SaleSummaryDTO;
import com.devsuperior.dsmeta.entities.Sale;

public interface SaleRepository extends JpaRepository<Sale, Long> {

	@Query("SELECT "
			+ "new com.devsuperior.dsmeta.dto.SaleReportDTO(obj.id, obj.date, obj.amount, obj.seller.name) "
			+ "FROM Sale obj "
			+ "WHERE "
			+ "obj.date BETWEEN :minLocalDate AND :maxLocalDate "
			+ "AND (:name = '' OR LOWER(obj.seller.name) LIKE LOWER(CONCAT('%',:name,'%')))")
	Page<SaleReportDTO> getReport(LocalDate minLocalDate, LocalDate maxLocalDate, String name, Pageable pageable);

	@Query("SELECT new com.devsuperior.dsmeta.dto.SaleSummaryDTO(obj.seller.name, SUM(obj.amount)) FROM Sale obj WHERE obj.date BETWEEN :minLocalDate AND :maxLocalDate GROUP BY obj.seller.name")
	Page<SaleSummaryDTO> getSummary(LocalDate minLocalDate, LocalDate maxLocalDate, Pageable pageable);
}
