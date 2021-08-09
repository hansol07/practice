package kh.promising.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import kh.promising.dto.MemberDTO;

public interface MemberRepository extends JpaRepository<MemberDTO, String> {
	
}
