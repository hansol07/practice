package kh.promising.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.querydsl.core.types.Predicate;

import kh.promising.dto.BoardDTO;
import kh.promising.repository.BoardRepository;

@Service
public class BoardService {

	@Autowired
	private BoardRepository repo;
	
	public void save(BoardDTO dto) {
		repo.save(dto);
	}
	public List<BoardDTO> findAll() {
		return repo.findAll();
	}
	public void deleteById(Long bno) {
		repo.deleteById(bno);
	}
	public Optional<BoardDTO> findById(Long bno) {
		return repo.findById(bno);
	}
	public Predicate makePredicate(String type, String keyword) {
		return repo.makePredicate(null, null);
	}
}
