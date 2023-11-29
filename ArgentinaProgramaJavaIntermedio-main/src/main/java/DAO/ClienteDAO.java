package DAO;

import modelo.Cliente;

public class ClienteDAO extends AbstractJpaDAO< Cliente > {

	public ClienteDAO(){
	      setClazz(Cliente.class );
}
}