package framework.core.security.program.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProgramRequest {
    private Long id;
    private String name;
    private String url;
    private boolean matcherUrlVisible;
}
