package javahibernateii.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Cupom.class)
public abstract class Cupom_ {

	public static volatile SingularAttribute<Cupom, Boolean> aprovado;
	public static volatile SingularAttribute<Cupom, String> nome;
	public static volatile SingularAttribute<Cupom, Supermercado> ptoVenda;
	public static volatile SingularAttribute<Cupom, Long> id;

}

