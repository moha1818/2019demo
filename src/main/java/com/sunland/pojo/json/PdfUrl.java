package com.sunland.pojo.json;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

public class PdfUrl implements Serializable {
    private static final long serialVersionUID = -1123309325111873772L;
    @ApiModelProperty(value="PDF下载地址")
    private String pdfUrl;
    @ApiModelProperty(value="快照URL")
    private String snapshotUrl;

    public String getPdfUrl() {
        return pdfUrl;
    }

    public void setPdfUrl(String pdfUrl) {
        this.pdfUrl = pdfUrl;
    }

    public String getSnapshotUrl() {
        return snapshotUrl;
    }

    public void setSnapshotUrl(String snapshotUrl) {
        this.snapshotUrl = snapshotUrl;
    }
}
