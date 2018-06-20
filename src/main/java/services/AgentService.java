package services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import model.Agent;
import repositories.AgentRepository;

@Service
public class AgentService implements GetAgent {//, UserDetailsService {

	@Autowired
	private AgentRepository agentRepository;

	@Override
	public Agent findByIdentificador(String identifier) {
		return agentRepository.findByIdentificador(identifier);
	}

	@Override
	public Agent find(String identificador, String password, String tipo) {
		return agentRepository.find(identificador, password, tipo);
	}

//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		Agent agent = findByIdentificador(username);
//		
//		//https://docs.spring.io/spring-security/site/docs/4.2.6.RELEASE/apidocs/org/springframework/security/core/userdetails/User.html
//		//https://docs.spring.io/spring-security/site/docs/4.2.6.RELEASE/apidocs/org/springframework/security/core/authority/SimpleGrantedAuthority.html
//
//		 return new User(username, agent.getPassword(), new SimpleGrantedAuthority("ROLE_AGENT"));
//	}

}
