package de.mmazo.learn.backend.api.image;

import javax.persistence.*;

/**
 * Created by mmazo on 14.05.17.
 */
@Entity
public class Image {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

    @Lob
    @Column(name="image", length=100000)
    private byte[] image;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Image{" +
                "id=" + id +
                '}';
    }
}
