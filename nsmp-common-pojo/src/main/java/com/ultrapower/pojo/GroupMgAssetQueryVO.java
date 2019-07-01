package com.ultrapower.pojo;

import java.io.Serializable;

public class GroupMgAssetQueryVO implements Serializable {
    private String groupId;

    private String prov;
    private String assetType;
    private String assetKeyWords;

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getProv() {
        return prov;
    }

    public void setProv(String prov) {
        this.prov = prov;
    }

    public String getAssetType() {
        return assetType;
    }

    public void setAssetType(String assetType) {
        this.assetType = assetType;
    }

    public String getAssetKeyWords() {
        return assetKeyWords;
    }

    public void setAssetKeyWords(String assetKeyWords) {
        this.assetKeyWords = assetKeyWords;
    }
}
