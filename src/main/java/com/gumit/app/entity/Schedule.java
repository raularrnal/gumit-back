package com.gumit.app.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "schedule")
@NoArgsConstructor
public class Schedule {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	
	@Column(name = "open_hour")
	private Integer openHour;
	@Column(name = "open_minutes")
	private Integer openMinutes;

	@Column(name = "close_hour")
	private Integer closeHour;
	@Column(name = "close_minutes")
	private Integer closeMinutes;

	
	
	
}
