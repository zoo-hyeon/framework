package framework.core.security.program.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import framework.core.dto.PagedResponse;
import framework.core.security.program.dto.ProgramRequest;
import framework.core.security.program.entity.Program;
import framework.core.security.program.repository.ProgramRepository;
import framework.core.security.program.service.ProgramService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ProgramServiceImpl implements ProgramService {

    private final RequestMappingHandlerMapping handlerMapping;

    private final ProgramRepository programRepository;

    public ProgramServiceImpl(RequestMappingHandlerMapping handlerMapping, ProgramRepository programRepository) {
        super();
        this.handlerMapping = handlerMapping;
        this.programRepository = programRepository;
    }

    @Override
    public PagedResponse<Program> findNotRegisteredProgram(ProgramRequest reqDTO) {
        Map<RequestMappingInfo, HandlerMethod> mappings = handlerMapping.getHandlerMethods();
        Set<RequestMappingInfo> keys = mappings.keySet();

        List<Program> list = programRepository
                .findByIdLikeAndNameLikeAndUrlLikeOrderByIdAsc(reqDTO.getId(), reqDTO.getName(), reqDTO.getUrl())
                .orElseGet(() -> new ArrayList<Program>());


        List<Program> notRegistered = null;

        if (reqDTO.isMatcherUrlVisible()) {
            notRegistered = list
                    .stream().filter(item -> {
                        return keys.stream().anyMatch(key -> {
                            return item.getUrl().equals(key.getPatternsCondition().toString());
                        });
                    }).collect(Collectors.toList());
        } else {
            notRegistered = list
                    .stream().filter(item -> {
                        return keys.stream().anyMatch(key -> {
                            return new AntPathMatcher()
                                    .match(item.getUrl(), key.getPatternsCondition().toString());
                        });
                    }).collect(Collectors.toList());
        }

        PagedResponse<Program> resDTO = new PagedResponse<Program>();
        resDTO.setPagedContent(notRegistered, null, null);
        return resDTO;
    }

}
