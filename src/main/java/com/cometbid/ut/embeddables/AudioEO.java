/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cometbid.ut.embeddables;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.StringJoiner;
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
public class AudioEO implements Serializable {

    @Column(name = "AUDIO_ID", nullable = false)
    private String audioId;

    @Lob
    @Column(name = "AUDIO_FILE")
    private byte[] audio;

    // @Basic(optional = false)
    @Column(name = "AUDIO_LENGTH", nullable = true)
    private long audioLength;

    // @Basic(optional = false)
    @Column(name = "AUDIO_CONTENT_TYPE", nullable = false, length = 128)
    private String audioContentType;

    /*
    @Column(name = "AUDIO_MIME_TYPE", length = 128)
    private String audioMimeType;
     */
    @Basic(optional = false)
    @Column(name = "AUDIO_SIZE", nullable = false)
    private double audioSize;

    @Column(name = "AUDIO_LAST_UPDATE")
    // @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime lastUpdate;

    @Column(name = "AUDIO_UPLOAD_DATE", nullable = true)
    // @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime uploadDate;

    @Basic(optional = true)
    @Field(index = Index.YES, analyze = Analyze.NO, store = Store.NO)
    @Column(name = "AUDIO_DESC", nullable = true, length = 200)
    private String audioDesc;

    public AudioEO() {
    }

    public AudioEO(String audioId) {
        this.audioId = audioId;
    }

    public String getAudioId() {
        return audioId;
    }

    public void setAudioId(String audioId) {
        this.audioId = audioId;
    }

    public byte[] getAudio() {
        return audio;
    }

    public void setAudio(byte[] audio) {
        this.audio = audio;
    }

    public long getAudioLength() {
        return audioLength;
    }

    public void setAudioLength(long audioLength) {
        this.audioLength = audioLength;
    }

    public String getAudioContentType() {
        return audioContentType;
    }

    public void setAudioContentType(String audioContentType) {
        this.audioContentType = audioContentType;
    }

    /*public String getAudioMimeType() {
    return audioMimeType;
    }
    
    public void setAudioMimeType(String audioMimeType) {
    this.audioMimeType = audioMimeType;
    }*/
    public double getAudioSize() {
        return audioSize;
    }

    public void setAudioSize(double audioSize) {
        this.audioSize = audioSize;
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

    public String getAudioDesc() {
        return audioDesc;
    }

    public void setAudioDesc(String audioDesc) {
        this.audioDesc = audioDesc;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.getAudioId());
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
        final AudioEO other = (AudioEO) obj;
        if (!Objects.equals(this.getAudioId(), other.getAudioId())) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(",");
        joiner.add("AudioEO{");
        joiner.add("audioId=").add(this.getAudioId());
        joiner.add("audioLength=").add(String.valueOf(this.getAudioLength()));
        joiner.add("audioContentType=").add(this.getAudioContentType());
        // joiner.add("audioMimeType=").add(this.getAudioMimeType());
        joiner.add("audioSize=").add(String.valueOf(this.getAudioSize()));
        joiner.add("lastUpdate=").add(this.getLastUpdate().toString());
        joiner.add("uploadDate=").add(this.getUploadDate().toString());
        joiner.add("audioDesc=").add(this.getAudioDesc());
        joiner.add("}");
        return joiner.toString();
    }

}
