/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.www.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author LENOVO
 */
@Entity
@Table(name = "logs")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LogsEntity.findAll", query = "SELECT l FROM LogsEntity l")
    , @NamedQuery(name = "LogsEntity.findByIdLog", query = "SELECT l FROM LogsEntity l WHERE l.idLog = :idLog")
    , @NamedQuery(name = "LogsEntity.findByLogDate", query = "SELECT l FROM LogsEntity l WHERE l.logDate = :logDate")
    , @NamedQuery(name = "LogsEntity.findByLogger", query = "SELECT l FROM LogsEntity l WHERE l.logger = :logger")
    , @NamedQuery(name = "LogsEntity.findByLevel", query = "SELECT l FROM LogsEntity l WHERE l.level = :level")
    , @NamedQuery(name = "LogsEntity.findByMessage", query = "SELECT l FROM LogsEntity l WHERE l.message = :message")})
public class LogsEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_LOG")
    private Integer idLog;
    @Basic(optional = false)
    @NotNull
    @Column(name = "LOG_DATE")
    @Temporal(TemporalType.DATE)
    private Date logDate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "LOGGER")
    private String logger;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 12)
    @Column(name = "LEVEL")
    private String level;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1000)
    @Column(name = "MESSAGE")
    private String message;

    public LogsEntity() {
    }

    public LogsEntity(Integer idLog) {
        this.idLog = idLog;
    }

    public LogsEntity(Integer idLog, Date logDate, String logger, String level, String message) {
        this.idLog = idLog;
        this.logDate = logDate;
        this.logger = logger;
        this.level = level;
        this.message = message;
    }

    public Integer getIdLog() {
        return idLog;
    }

    public void setIdLog(Integer idLog) {
        this.idLog = idLog;
    }

    public Date getLogDate() {
        return logDate;
    }

    public void setLogDate(Date logDate) {
        this.logDate = logDate;
    }

    public String getLogger() {
        return logger;
    }

    public void setLogger(String logger) {
        this.logger = logger;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idLog != null ? idLog.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LogsEntity)) {
            return false;
        }
        LogsEntity other = (LogsEntity) object;
        if ((this.idLog == null && other.idLog != null) || (this.idLog != null && !this.idLog.equals(other.idLog))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.edu.udb.www.entities.LogsEntity[ idLog=" + idLog + " ]";
    }
    
}
