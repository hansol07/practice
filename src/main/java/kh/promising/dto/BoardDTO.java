package kh.promising.dto;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(of="bno")
@SequenceGenerator(name="MYBOARD_SEQ_GENERATOR",sequenceName = "MYBOARD_SEQ" ,initialValue = 1,allocationSize = 1)
@Entity
@Table(name="myboard")
public class BoardDTO {

	@Id
	@GeneratedValue(strategy = GenerationType. SEQUENCE, generator = "MYBOARD_SEQ_GENERATOR")
	private Long bno;
	private String title;
	@Lob
	private String contents;
	private String writer;
	@CreationTimestamp
	private Timestamp regdate;
	
	
	public BoardDTO(Long bno, String title, String contents, String writer, Timestamp regdate) {
		super();
		this.bno = bno;
		this.title = title;
		this.contents = contents;
		this.writer = writer;
		this.regdate = regdate;
	}


	public BoardDTO() {
		super();
	}

}
