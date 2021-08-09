package kh.promising.dto;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode(of="rno")
@SequenceGenerator(name="REPLY_SEQ_GENERATOR",sequenceName = "REPLY_SEQ" ,initialValue = 1,allocationSize = 1)
@Entity
@Table(name="myreply")
public class ReplyDTO {

	@Id
	@GeneratedValue(strategy = GenerationType. SEQUENCE, generator = "REPLY_SEQ_GENERATOR")
	private Long rno;
	private String replycontents;
	private String writer;
	
	@CreationTimestamp 
	private Timestamp regdate;
	private Long parent;
}
