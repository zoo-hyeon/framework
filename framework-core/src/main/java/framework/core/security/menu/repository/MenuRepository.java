package framework.core.security.menu.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import framework.core.security.menu.entity.Menu;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Long> {
	Optional<List<Menu>> findByNameContains(String menuName);
}
