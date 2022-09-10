package pl.simo333.domain;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "articles")
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Size(min = 2, max = 200)
    private String title;
    @NotNull
    @ManyToOne
    @JoinColumn(name = "author")
    private Author author;
    @NotNull
    @Min(1)
    @ManyToMany
    @JoinTable(name = "article_categories")
    private Set<Category> categories = new HashSet<>();
    @NotNull
    @Size(min = 2, max = 500)
    private String content;
    private LocalDateTime created;
    private LocalDateTime updated;

    public Article() {
    }

    public Article(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public void addCategory(Category category) {
        categories.add(category);
        category.getArticles().add(this);
    }

    public void removeCategory(Category category) {
        categories.remove(category);
        category.getArticles().remove(this);
    }

    @PrePersist
    public void prePersist() {
        created = LocalDateTime.now(ZoneId.systemDefault());
    }

    @PreUpdate
    public void preUpdate() {
        updated = LocalDateTime.now(ZoneId.systemDefault());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public LocalDateTime getUpdated() {
        return updated;
    }

    public void setUpdated(LocalDateTime updated) {
        this.updated = updated;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", created=" + created +
                ", updated=" + updated +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Article article = (Article) o;
        return id.equals(article.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
