/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cometbid.ut.embeddables;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Lob;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Gbenga
 */
@Embeddable
public class DocumentEO implements Serializable {

    // private static final long serialVersionUID = 83580295L;
    @Column(name = "DOC_ID", nullable = false)
    private String docId;

    @Lob
    @Column(name = "DOC_FILE")
    private byte[] itemDocument;

    @Column(name = "DOCUMENT_NAME", length = 255)
    private String documentName;

    @Column(name = "CONTENT_TYPE", length = 128)
    private String docContentType;

    @Basic(optional = false)
    @Column(name = "DOCUMENT_SIZE", nullable = false)
    private double docSize;

    @Column(name = "DOC_LAST_UPDATE")
    //  @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime lastUpdate;

    @Column(name = "DOC_UPLOAD_DATE", nullable = true)
    //   @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime uploadDate;

    @Basic(optional = true)
    @Column(name = "DOC_DESC", nullable = true, length = 100)
    private String documentDesc;

    public DocumentEO() {
    }

    public DocumentEO(String docId) {
        this.docId = docId;
    }

    public String getDocId() {
        return docId;
    }

    public void setDocId(String docId) {
        this.docId = docId;
    }

    public byte[] getItemDocument() {
        return itemDocument;
    }

    public void setItemDocument(byte[] itemDocument) {
        this.itemDocument = itemDocument;
    }

    public String getDocContentType() {
        return docContentType;
    }

    public void setDocContentType(String docContentType) {
        this.docContentType = docContentType;
    }

    public double getDocSize() {
        return docSize;
    }

    public void setDocSize(double docSize) {
        this.docSize = docSize;
    }

    public LocalDateTime getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(LocalDateTime lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public LocalDateTime getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(LocalDateTime uploadDate) {
        this.uploadDate = uploadDate;
    }

    public String getDocumentDesc() {
        return documentDesc;
    }

    public void setDocumentDesc(String documentDesc) {
        this.documentDesc = documentDesc;
    }

    public String getDocumentName() {
        return documentName;
    }

    public void setDocumentName(String documentName) {
        this.documentName = documentName;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.getDocId());
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final DocumentEO other = (DocumentEO) obj;
        if (!Objects.equals(this.getDocId(), other.getDocId())) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DocumentEO{"
                + "docId=" + this.getDocId()
                // + ", itemDocument=" + itemDocument
                + ", docMimeType=" + this.getDocContentType()
                + ", docSize=" + this.getDocSize()
                + ", lastUpdate=" + this.getLastUpdate()
                + ", uploadDate=" + this.getUploadDate()
                + ", documentDesc=" + this.getDocumentDesc()
                + '}';
    }

}
