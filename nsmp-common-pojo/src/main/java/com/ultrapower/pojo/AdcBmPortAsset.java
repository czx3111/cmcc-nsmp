package com.ultrapower.pojo;

public class AdcBmPortAsset {
    private String pkBmPortAsset;

    private String pkBmPort;

    private String pkAsset;

    private String version;

    private String provCode;

    public String getPkBmPortAsset() {
        return pkBmPortAsset;
    }

    public void setPkBmPortAsset(String pkBmPortAsset) {
        this.pkBmPortAsset = pkBmPortAsset == null ? null : pkBmPortAsset.trim();
    }

    public String getPkBmPort() {
        return pkBmPort;
    }

    public void setPkBmPort(String pkBmPort) {
        this.pkBmPort = pkBmPort == null ? null : pkBmPort.trim();
    }

    public String getPkAsset() {
        return pkAsset;
    }

    public void setPkAsset(String pkAsset) {
        this.pkAsset = pkAsset == null ? null : pkAsset.trim();
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version == null ? null : version.trim();
    }

    public String getProvCode() {
        return provCode;
    }

    public void setProvCode(String provCode) {
        this.provCode = provCode == null ? null : provCode.trim();
    }
}