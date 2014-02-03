package ar.com.donpepe.awardmanagement.daos;

import java.util.List;

import ar.com.donpepe.awardmanagement.domain.User;

public interface UserDao extends EntityWithIdDao<User> {
	List<User> getByUsername(String username);
	User getByUsernameAndPassword(String username, String password);
	List<User> getUsersSalerMans();
	List<User> getByIds(List<Integer> ids);
}
