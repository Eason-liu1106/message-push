package com.server.model;

import java.util.Date;

public class projectNew {
    private Integer id;

    private Object sysJson;

    private Object tenantJson;

    private Object unitJson;

    private Integer tenantId;

    private Integer unitId;

    private Date createTime;

    private Integer createId;

    private Date lastUpdateTime;

    private Integer lastUpdateId;

    private String remarks;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Object getSysJson() {
        return sysJson;
    }

    public void setSysJson(Object sysJson) {
        this.sysJson = sysJson;
    }

    public Object getTenantJson() {
        return tenantJson;
    }

    public void setTenantJson(Object tenantJson) {
        this.tenantJson = tenantJson;
    }

    public Object getUnitJson() {
        return unitJson;
    }

    public void setUnitJson(Object unitJson) {
        this.unitJson = unitJson;
    }

    public Integer getTenantId() {
        return tenantId;
    }

    public void setTenantId(Integer tenantId) {
        this.tenantId = tenantId;
    }

    public Integer getUnitId() {
        return unitId;
    }

    public void setUnitId(Integer unitId) {
        this.unitId = unitId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getCreateId() {
        return createId;
    }

    public void setCreateId(Integer createId) {
        this.createId = createId;
    }

    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public Integer getLastUpdateId() {
        return lastUpdateId;
    }

    public void setLastUpdateId(Integer lastUpdateId) {
        this.lastUpdateId = lastUpdateId;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}