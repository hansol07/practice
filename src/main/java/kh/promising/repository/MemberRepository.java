package kh.promising.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kh.promising.dto.MemberDTO;
@Repository
public interface MemberRepository extends JpaRepository<MemberDTO, String> {


		Optional<MemberDTO> findByUsername(String username);
}
