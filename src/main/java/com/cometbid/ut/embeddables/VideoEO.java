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
public class VideoEO implements Serializable {

   // private static final long serialVersionUID = 83580295L;

    @Column(name = "VIDEO_ID", nullable = false)
    private String videoId;

    @Lob
    @Column(name = "VIDEO_FILE")
    private byte[] video;

    // @Basic(optional = false)
    @Column(name = "VIDEO_LENGTH", nullable = true)
    private long videoLength;

    @Basic(optional = false)
    @Column(name = "VIDEO_CONTENT_TYPE", nullable = false, length = 128)
    private String videoContentType;

    @Column(name = "VIDEO_MIME_TYPE", length = 128)
    private String videoMimeType;

    @Basic(optional = false)
    @Column(name = "VIDEO_SIZE", nullable = false)
    private double videoSize;

    @Column(name = "VIDEO_LAST_UPDATE", nullable = true)
   // @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime lastUpdate;

    @Column(name = "VIDEO_UPLOAD_DATE")
   // @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime uploadDate;

    @Basic(optional = true)
    @Field(index = Index.YES, analyze = Analyze.NO, store = Store.NO)
    @Column(name = "VIDEO_DESC", nullable = true, length = 100)
    private String videoDesc;

    public VideoEO() {
    }

    public VideoEO(String videoId) {
        this.videoId = videoId;
    }

    public String getVideoId() {
        return videoId;
    }

    public void setVideoId(String videoId) {
        this.videoId = videoId;
    }

    public byte[] getVideo() {
        return video;
    }

    public void setVideo(byte[] video) {
        this.video = video;
    }

    public long getVideoLength() {
        return videoLength;
    }

    public void setVideoLength(long videoLength) {
        this.videoLength = videoLength;
    }

    public String getVideoContentType() {
        return videoContentType;
    }

    public void setVideoContentType(String videoContentType) {
        this.videoContentType = videoContentType;
    }

    public String getVideoMimeType() {
        return videoMimeType;
    }

    public void setVideoMimeType(String videoMimeType) {
        this.videoMimeType = videoMimeType;
    }

    public double getVideoSize() {
        return videoSize;
    }

    public void setVideoSize(double videoSize) {
        this.videoSize = videoSize;
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

    public String getVideoDesc() {
        return videoDesc;
    }

    public void setVideoDesc(String videoDesc) {
        this.videoDesc = videoDesc;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.getVideoId());
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
        final VideoEO other = (VideoEO) obj;
        if (!Objects.equals(this.getVideoId(), other.getVideoId())) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "VideoEO{"
                + "videoId=" + this.getVideoId()
                + ", videoLength=" + this.getVideoLength()
                + ", videoContentType=" + this.getVideoContentType()
                + ", videoMimeType=" + this.getVideoMimeType()
                + ", videoSize=" + this.getVideoSize()
                + ", lastUpdate=" + this.getLastUpdate()
                + ", uploadDate=" + this.getUploadDate()
                + ", videoDesc=" + this.getVideoDesc()
                + '}';
    }

}
