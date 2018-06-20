package services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.configurers.provisioning.UserDetailsManagerConfigurer.UserDetailsBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.*;

import model.Agent;
import repositories.AgentRepository;

@Service
public class AgentService implements GetAgent, UserDetailsService {

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

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Agent agent = findByIdentificador(username);
		
		//https://docs.spring.io/spring-security/site/docs/4.2.6.RELEASE/apidocs/org/springframework/security/core/userdetails/User.html
		
		//https://docs.spring.io/spring-security/site/docs/4.2.6.RELEASE/apidocs/org/springframework/security/core/authority/SimpleGrantedAuthority.html
//		UserDetailsBuilder builder = null;
//	    if (agent != null) {
//	      builder = agent;
//	      builder.password(agent.getPassword());
//	      builder.roles("ROLE_AGENT");
//	    } else {
//	      throw new UsernameNotFoundException("User not found.");
//	    }

	   // return builder.build();
		return null;
			
	}

}
