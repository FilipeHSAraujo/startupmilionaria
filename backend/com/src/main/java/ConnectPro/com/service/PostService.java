package ConnectPro.com.service;

import ConnectPro.com.model.Post;

import java.util.List;
import java.util.Optional;

public interface PostService {

    Post createPost(Post post, Long userId);

    Optional<Post> findPostById(Long id);

    List<Post> findAllPosts();

    List<Post> findPostByUser(Long userId);

    void deletePost(Long id);

}
