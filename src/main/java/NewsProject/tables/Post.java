package NewsProject.tables;

import javax.persistence.*;

@Entity
@Table(name = "postdata")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "head")
    private String head;

    @Column(name = "article")
    private String article;

    public Post() {
    }

    public Post(Integer id, String head, String article) {
        this.id=id;
        this.head=head;
        this.article=article;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }



}