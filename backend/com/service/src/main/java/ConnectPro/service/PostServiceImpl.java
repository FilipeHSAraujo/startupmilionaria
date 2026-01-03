package ConnectPro.service;

import ConnectPro.model.Post;
import ConnectPro.repository.PostRepository;
import ConnectPro.repository.UserRepository;

import java.util.List;
import java.util.Optional;

public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;
    private final UserRepository userRepository;

    public PostServiceImpl(PostRepository postRepository, UserRepository userRepository) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Post createPost(Post post, Long userId) {
        return null;
    }

    @Override
    public Optional<Post> findPostById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<Post> findAllPosts() {
        return List.of();
    }

    @Override
    public List<Post> findPostByUser(Long userId) {
        return List.of();
    }

    @Override
    public void deletePost(Long id) {

    }
}
