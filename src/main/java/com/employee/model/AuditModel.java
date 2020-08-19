package com.employee.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(
        value = {"createdStamp", "lastUpdatedStamp"},
        allowGetters = true
)
public abstract class AuditModel implements Serializable {
    @Column(name = "CREATED_STAMP", nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createdStamp;
    
    @Column(name = "LAST_UPDATED_STAMP", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date lastUpdatedStamp;
    
    public Date getCreatedStamp() {
      return createdStamp;
    }

    public void setCreatedStamp(Date createdStamp) {
      this.createdStamp = createdStamp;
    }

    public Date getLastUpdatedStamp() {
      return lastUpdatedStamp;
    }

    public void setLastUpdatedStamp(Date lastUpdatedStamp) {
      this.lastUpdatedStamp = lastUpdatedStamp;
    }
}
