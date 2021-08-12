package kh.promising.dto;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@Entity
@ToString
@Table(name="MYMEMBER")
public class MemberDTO {
	
	@Id
	private String username;
	

	private String password;
	
	
	
	private String uphone;

	private String upostcode;
	
	private String address1;

	private String address2;
	
	
	@CreationTimestamp
	private Timestamp regdate;
	
	@UpdateTimestamp
	private Timestamp updatedate;
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="member")
	private List<MemberRole> roles;
	
}
