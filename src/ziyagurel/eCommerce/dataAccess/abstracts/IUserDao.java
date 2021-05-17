package ziyagurel.eCommerce.dataAccess.abstracts;

import ziyagurel.eCommerce.entities.concretes.User;

import java.util.List;

public interface IUserDao {

    void register(User user);
    List<User> getAll();
}
