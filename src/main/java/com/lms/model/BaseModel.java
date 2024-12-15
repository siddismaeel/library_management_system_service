package com.lms.model;

import java.util.Date;
import java.util.Objects;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;



import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;


@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseModel {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="BASE_MODEL_SEQ")
    @SequenceGenerator(name="BASE_MODEL_SEQ", sequenceName="BASE_MODEL_SEQ", allocationSize=1)
    protected Long id;
    
    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    protected Date created_at;

    @LastModifiedDate
    @Temporal(TemporalType.TIMESTAMP)
    protected Date updated_at;

	@Override
	public int hashCode() {
		return Objects.hash(created_at, id, updated_at);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}

	public Date getUpdated_at() {
		return updated_at;
	}

	public void setUpdated_at(Date updated_at) {
		this.updated_at = updated_at;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BaseModel other = (BaseModel) obj;
		return Objects.equals(created_at, other.created_at) && Objects.equals(id, other.id)
				&& Objects.equals(updated_at, other.updated_at);
	}

    
    
}

