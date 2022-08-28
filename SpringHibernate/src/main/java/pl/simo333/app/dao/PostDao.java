package pl.simo333.app.dao;

import org.springframework.stereotype.Repository;
import pl.simo333.app.domain.Post;
import pl.simo333.app.domain.PostComment;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class PostDao {

    @PersistenceContext
    private EntityManager entityManager;

    public Post testSave() {
        Post post = new Post("First post");
        post.addComment(new PostComment("My first review"));
        post.addComment(new PostComment("My second review"));
        post.addComment(new PostComment("My third review"));

        entityManager.persist(post);
        return post;
    }
}
