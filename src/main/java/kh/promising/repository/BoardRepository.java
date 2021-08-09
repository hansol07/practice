package kh.promising.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;

import kh.promising.dto.BoardDTO;
import kh.promising.dto.QBoardDTO;

public interface BoardRepository extends JpaRepository<BoardDTO, Long>,
												QuerydslPredicateExecutor<BoardDTO> {

	public default Predicate makePredicate(String type, String keyword) {
	BooleanBuilder builder =new BooleanBuilder();
	QBoardDTO board = QBoardDTO.boardDTO;
	builder.and(board.bno.gt(0));
	if(type==null) {
		return builder;
	}
	switch(type) {
	case "t" :
		builder.and(board.title.like("%"+keyword+"%"));
		break;
	case "c":
		builder.and(board.contents.like("%"+keyword+"%"));
		break;
	
	case "w" :
		builder.and(board.writer.like("%"+keyword+"%"));
		break;
	}	
	return builder;
	}
}
