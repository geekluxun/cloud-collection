package com.geekluxun.entity;

import java.util.Date;

public class TPage {
    private Long id;

    private Long pageId;

    private String title;

    private String url;

    private String iconUri;

    private Integer level;

    private Integer browseTotalCount;

    private Date lastBrowseTime;

    private Byte readed;

    private Integer concurrencyVersion;

    private Date createTime;

    private Date modifyTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPageId() {
        return pageId;
    }

    public void setPageId(Long pageId) {
        this.pageId = pageId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public String getIconUri() {
        return iconUri;
    }

    public void setIconUri(String iconUri) {
        this.iconUri = iconUri == null ? null : iconUri.trim();
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getBrowseTotalCount() {
        return browseTotalCount;
    }

    public void setBrowseTotalCount(Integer browseTotalCount) {
        this.browseTotalCount = browseTotalCount;
    }

    public Date getLastBrowseTime() {
        return lastBrowseTime;
    }

    public void setLastBrowseTime(Date lastBrowseTime) {
        this.lastBrowseTime = lastBrowseTime;
    }

    public Byte getReaded() {
        return readed;
    }

    public void setReaded(Byte readed) {
        this.readed = readed;
    }

    public Integer getConcurrencyVersion() {
        return concurrencyVersion;
    }

    public void setConcurrencyVersion(Integer concurrencyVersion) {
        this.concurrencyVersion = concurrencyVersion;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }
}