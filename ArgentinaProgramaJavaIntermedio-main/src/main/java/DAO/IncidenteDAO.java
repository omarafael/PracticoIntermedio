package DAO;

import modelo.Incidente;

public class IncidenteDAO extends AbstractJpaDAO< Incidente >{

	public IncidenteDAO(){
	      setClazz(Incidente.class );
}
}