package tn.esprit.entity;

import org.springframework.security.core.GrantedAuthority;

public enum RoleName implements
GrantedAuthority {
	DIRECTEUR,
	ASSISTANT,
	PROFESSEUR,
	PARENT;

	@Override
	public String getAuthority() {

		return  "ROLE_" + name();
	}
	
	
	}