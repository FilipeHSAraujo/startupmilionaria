package ConnectPro.com.service.impl;

import ConnectPro.com.model.Post;
import ConnectPro.com.repository.PostRepository;
import ConnectPro.com.repository.UserRepository;
import ConnectPro.com.service.PostService;

public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;
    private final UserRepository userRepository;

    public PostServiceImpl(PostRepository postRepository, UserRepository userRepository) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
    }
}
