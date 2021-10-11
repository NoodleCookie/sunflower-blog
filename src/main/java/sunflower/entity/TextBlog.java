package sunflower.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@Builder
@Entity
@Table(name = "sunflower_blog")
public class TextBlog implements Blog {
    @Id
    @Column(name = "bid")
    @JsonIgnore
    private String id;

    @Column(name = "b_title")
    private String title;

    @Column(name = "b_content_url")
    private String content;

    @Column(name = "b_create_time")
    @CreatedDate
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date createdTime;

    @Column(name = "b_author")
    private String author;

    @JsonIgnore
    @Column(name = "b_delete")
    private boolean deleted;
}
