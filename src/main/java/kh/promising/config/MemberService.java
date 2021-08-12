package kh.promising.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import kh.promising.repository.MemberRepository;

@Service
public class MemberService implements UserDetailsService {

	@Autowired
	private MemberRepository repo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	return 
			repo.findById(username).filter(m -> m != null).map(m -> new KhSecurityUser(m)).get();
	
	}

}
