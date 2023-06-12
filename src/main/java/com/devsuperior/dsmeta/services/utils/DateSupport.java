package com.devsuperior.dsmeta.services.utils;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class DateSupport {

	private LocalDate maxLocalDate;
	private LocalDate minLocalDate;
	
	public DateSupport(String minDate, String maxDate) {
		this.maxLocalDate = (maxDate.equals("")) ? LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault())
				: LocalDate.parse(maxDate, DateTimeFormatter.ISO_LOCAL_DATE);
		this.minLocalDate = (minDate.equals("")) ? this.maxLocalDate.minusYears(1L)
				: LocalDate.parse(minDate, DateTimeFormatter.ISO_LOCAL_DATE);
	}

	public LocalDate getMaxLocalDate() {
		return maxLocalDate;
	}

	public LocalDate getMinLocalDate() {
		return minLocalDate;
	}
	
}
