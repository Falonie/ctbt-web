package com.ctbt.ctbtweb.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "ALARM_TYPE")
@Data
@NoArgsConstructor
public class AlarmType {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "TYPE_ID")
	private String typeId;

	@Column(name = "TYPE_NAME")
	private String typeName;

	@Column(name = "TYPE_DESC")
	private String typeDesc;

	@Column(name = "LIST_NO")
	private Integer listNo;

	@Column(name = "VALIDITY")
	private String validity;
}
