package framework.core.security.program.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import framework.core.entity.CommonAudit;
import framework.core.security.menu.entity.Menu;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "TB_PROGRAM")
@SequenceGenerator(name = "TB_PROGRAM_SQ_GEN", sequenceName = "SQ_TB_PROGRAM")
public class Program extends CommonAudit {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TB_PROGRAM_SQ_GEN")
    @Column(name = "SEQ")
    private Long id;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "program")
    private Menu menu;

    @Column(name = "PRGM_NM", length = 30)
    private String name;

    @Column(name = "URL", length = 200)
    private String url;

    @Column(name = "PRGM_TYPE", length = 6)
    private String type;

    @Column(name = "RMK", length = 300)
    private String remark;
}
