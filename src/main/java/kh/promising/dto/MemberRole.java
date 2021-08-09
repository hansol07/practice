package kh.promising.dto;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@SequenceGenerator(name="MYMEMBERROLE_SEQ_GENERATOR",sequenceName = "MYMEMBERROLE_SEQ" ,initialValue = 1,allocationSize = 1)
@EqualsAndHashCode(of = "rno")
@ToString
@Table(name="MYMEMBERROLE")
public class MemberRole {

	@Id
	@GeneratedValue(strategy = GenerationType. SEQUENCE, generator = "MYMEMBERROLE_SEQ_GENERATOR")
	private Long rno;
	private String roleName;
}
