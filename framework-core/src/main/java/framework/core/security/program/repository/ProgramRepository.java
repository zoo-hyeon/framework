package framework.core.security.program.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;

import framework.core.security.program.entity.Program;

@Repository
public interface ProgramRepository extends JpaRepository<Program, Long> {
    Optional<List<Program>> findByNameLike(String name);

    Optional<List<Program>> findByIdLikeAndNameLikeAndUrlLikeOrderByIdAsc(@Nullable Long id, @Nullable String name, @Nullable String url);
}
