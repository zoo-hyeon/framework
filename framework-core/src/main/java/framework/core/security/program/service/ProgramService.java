package framework.core.security.program.service;

import framework.core.dto.PagedResponse;
import framework.core.security.program.dto.ProgramRequest;
import framework.core.security.program.entity.Program;

public interface ProgramService {

    public PagedResponse<Program> findNotRegisteredProgram(ProgramRequest reqDTO);

}
