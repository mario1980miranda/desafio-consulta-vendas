package com.devsuperior.dsmeta.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.devsuperior.dsmeta.dto.SaleMinDTO;
import com.devsuperior.dsmeta.dto.SaleReportDTO;
import com.devsuperior.dsmeta.dto.SaleSummaryDTO;
import com.devsuperior.dsmeta.entities.Sale;
import com.devsuperior.dsmeta.repositories.SaleRepository;
import com.devsuperior.dsmeta.services.utils.DateSupport;

@Service
public class SaleService {

	@Autowired
	private SaleRepository repository;

	public SaleMinDTO findById(Long id) {
		Optional<Sale> result = repository.findById(id);
		Sale entity = result.get();
		return new SaleMinDTO(entity);
	}

	public Page<SaleReportDTO> getReport(String minDate, String maxDate, String name, Pageable pageable) {
		final DateSupport dateSupport = new DateSupport(minDate, maxDate);
		return this.repository.getReport(dateSupport.getMinLocalDate(), dateSupport.getMaxLocalDate(), name, pageable);
	}

	public Page<SaleSummaryDTO> getSummary(String minDate, String maxDate, Pageable pageable) {
		final DateSupport dateSupport = new DateSupport(minDate, maxDate);
		return this.repository.getSummary(dateSupport.getMinLocalDate(), dateSupport.getMaxLocalDate(), pageable);
	}
}
