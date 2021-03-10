package framework.core.security.menu.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import framework.core.entity.CommonAudit;
import framework.core.security.program.entity.Program;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "TB_MENU")
@SequenceGenerator(name = "TB_MENU_SQ_GEN", sequenceName = "SQ_TB_MENU")
public class Menu extends CommonAudit {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TB_MENU_SQ_GEN")
	@Column(name = "SEQ")
	private Long id;

	@Column(name = "PARENT_SEQ")
	private Long parentId;

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "PRGM_SEQ", referencedColumnName = "SEQ")
	private Program program;

	@Column(name = "MENU_NM")
	private String name;

	@Column(name = "TAG")
	private String tag;

	@Column(name = "ORDER_BY")
	private Long orderBy;

}
