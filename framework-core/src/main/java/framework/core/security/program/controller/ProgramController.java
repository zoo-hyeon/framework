package framework.core.security.program.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import framework.core.dto.PagedResponse;
import framework.core.security.program.dto.ProgramRequest;
import framework.core.security.program.entity.Program;
import framework.core.security.program.service.ProgramService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/admin/program")
public class ProgramController {

    private final ProgramService programService;

    @GetMapping("/findNotRegisteredProgram")
    public PagedResponse<Program> findNotRegisteredProgram(HttpServletRequest request, ProgramRequest reqDTO) {
        return programService.findNotRegisteredProgram(reqDTO);
    }

}
