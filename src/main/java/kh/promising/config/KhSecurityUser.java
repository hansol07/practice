package kh.promising.config;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import kh.promising.dto.MemberDTO;
import kh.promising.dto.MemberRole;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class KhSecurityUser extends User{
	private static final String ROLE_PREFIX = "ROLE_";
	
	private MemberDTO dto;
	public KhSecurityUser (String username,String password, Collection<? extends GrantedAuthority> authorities) {
		super(username,password,authorities);
	}
	public KhSecurityUser(MemberDTO member) {
		super(member.getUsername(), member.getPassword(), makeGrantedAuthority(member.getRoles()));
	}
	private static List<GrantedAuthority> makeGrantedAuthority(List<MemberRole> roles) {
		
		List<GrantedAuthority> list = new ArrayList<>();
		roles.forEach(
				role -> list.add(new SimpleGrantedAuthority(ROLE_PREFIX+role.getRoleName()))
				);
		return list;
	}
	
}
