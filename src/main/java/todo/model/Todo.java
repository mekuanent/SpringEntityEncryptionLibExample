package todo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.mekuanent.encryption.annotation.Encrypted;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import todo.encryption.CustomEncryptionHandler;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;

/**
 * Created by Mekuanent Kassaye on 2019-06-13.
 */

@Entity
@EntityListeners({AuditingEntityListener.class})
@JsonIgnoreProperties(value = {"createdAt"},
        allowGetters = true)
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createdAt;

    @Encrypted
    private String title;

    @Encrypted(handler = CustomEncryptionHandler.class)
    private String description;

    public Todo() {
    }

    public Todo(@NotBlank String title, @NotBlank String description) {
        this.title = title;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}


