package ar.com.donpepe.awardmanagement.daos;

import ar.com.donpepe.awardmanagement.domain.EntityWithId;

public interface EntityWithIdDao<T extends EntityWithId> extends GenericDao<T, Integer> {

}
