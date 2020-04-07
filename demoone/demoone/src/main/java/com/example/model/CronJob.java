package com.example.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class CronJob {
@Id
int id;
@Column
String cronexpn;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getCronexpn() {
	return cronexpn;
}
public void setCronexpn(String cronexpn) {
	this.cronexpn = cronexpn;
}
}
