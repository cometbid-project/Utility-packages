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
import org.hibernate.search.annotations.Analyze;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Index;
import org.hibernate.search.annotations.Store;

/**
 *
 * @author Gbenga
 */
@Embeddable
// @Table(name = "ITEM_IMAGES_V", catalog = "", schema = "PM")
// @XmlRootElement
/*
@NamedQueries({
    @NamedQuery(name = "ItemImagesEO.findAll", query = "SELECT i FROM ItemImagesEO i")
    , @NamedQuery(name = "ItemImagesEO.findByMediaId",
            query = "SELECT i FROM ItemImagesEO i WHERE i.mediaId = :mediaId")
    , @NamedQuery(name = "ItemImagesEO.findByItemDesc",
            query = "SELECT i FROM ItemImagesEO i WHERE i.photoDesc = :photoDesc")}
)
 */
public class ImageEO implements Serializable {

    // private static final long serialVersionUID = 83580295L;
    @Column(name = "IMAGE_ID", nullable = false)
    private String imageId;

    @Lob
    @Column(name = "ACTUAL_IMAGE", nullable = true)
    private byte[] itemImage;

    @Lob
    @Column(name = "THUMBNAIL_IMG", nullable = true)
    private byte[] itemThumbnail;

    // @Basic(optional = false)
    @Column(name = "FILE_NAME", nullable = false, length = 256)
    private String fileName;

    // @Basic(optional = false)
    @Column(name = "PHOTO_HEIGHT")
    private long photoHeight;

    // @Basic(optional = false)
    @Column(name = "PHOTO_WIDTH")
    private long photoWidth;

    //  @Basic(optional = false)
    @Column(name = "THUMB_HEIGHT")
    private long thumbNailHeight;

    // @Basic(optional = false)
    @Column(name = "THUMB_WIDTH")
    private long thumbNailWidth;

    @Column(name = "IMG_UPLOAD_DATE")
    //  @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime uploadDate;

    @Column(name = "IMG_LAST_UPDATE")
    //  @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime lastUpdate;

    @Basic(optional = false)
    @Column(name = "CONTENT_TYPE", nullable = false, length = 128)
    private String contentType;

    /*@Column(name = "MIME_TYPE", length = 128)
    private String mimeType;*/
    
    // @Basic(optional = false)
    @Column(name = "IMG_SIZE")
    private double docSize;

    @Column(name = "Photo_DESC", length = 200)
    @Field(index = Index.YES, analyze = Analyze.NO, store = Store.NO)
    private String photoDesc;

    public ImageEO() {
    }

    public ImageEO(String imageId) {
        this.imageId = imageId;
    }

    public String getImageId() {
        return imageId;
    }

    public void setImageId(String imageId) {
        this.imageId = imageId;
    }

    public byte[] getItemImage() {
        return itemImage;
    }

    public void setItemImage(byte[] itemImage) {
        this.itemImage = itemImage;
    }

    public byte[] getItemThumbnail() {
        return itemThumbnail;
    }

    public void setItemThumbnail(byte[] itemThumbnail) {
        this.itemThumbnail = itemThumbnail;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public long getPhotoHeight() {
        return photoHeight;
    }

    public void setPhotoHeight(long photoHeight) {
        this.photoHeight = photoHeight;
    }

    public long getPhotoWidth() {
        return photoWidth;
    }

    public void setPhotoWidth(long photoWidth) {
        this.photoWidth = photoWidth;
    }

    public long getThumbNailHeight() {
        return thumbNailHeight;
    }

    public void setThumbNailHeight(long thumbNailHeight) {
        this.thumbNailHeight = thumbNailHeight;
    }

    public long getThumbNailWidth() {
        return thumbNailWidth;
    }

    public void setThumbNailWidth(long thumbNailWidth) {
        this.thumbNailWidth = thumbNailWidth;
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

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    /*public String getMimeType() {
    return mimeType;
    }
    
    public void setMimeType(String mimeType) {
    this.mimeType = mimeType;
    }*/
    public double getDocSize() {
        return docSize;
    }

    public void setDocSize(double docSize) {
        this.docSize = docSize;
    }

    public String getPhotoDesc() {
        return photoDesc;
    }

    public void setPhotoDesc(String photoDesc) {
        this.photoDesc = photoDesc;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + Objects.hashCode(this.getImageId());
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
        final ImageEO other = (ImageEO) obj;
        if (!Objects.equals(this.getImageId(), other.getImageId())) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ImageEO{"
                + "imageId=" + this.getImageId()
                //   + ", itemImage=" + this.getItemImage()
                //  + ", itemThumbnail=" + itemThumbnail
                + ", fileName=" + this.getFileName()
                + ", photoHeight=" + this.getPhotoHeight()
                + ", photoWidth=" + this.getPhotoWidth()
                + ", thumbNailHeight=" + this.getThumbNailHeight()
                + ", thumbNailWidth=" + this.getThumbNailWidth()
                + ", uploadDate=" + this.getUploadDate()
                + ", lastUpdate=" + this.getLastUpdate()
                + ", contentType=" + this.getContentType()
              //  + ", mimeType=" + this.getMimeType()
                + ", docSize=" + this.getDocSize()
                + ", photoDesc=" + this.getPhotoDesc()
                + '}';
    }

}
