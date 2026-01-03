package ConnectPro.dto.response;

import java.time.LocalDateTime;

public record PostResponse(
        Long id,
        String title,
        String content,
        Long userId,
        LocalDateTime createdAt
) {}
