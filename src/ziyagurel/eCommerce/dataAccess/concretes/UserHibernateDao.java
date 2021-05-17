package ziyagurel.eCommerce.dataAccess.concretes;

import ziyagurel.eCommerce.dataAccess.abstracts.IUserDao;
import ziyagurel.eCommerce.entities.concretes.User;

import java.util.ArrayList;
import java.util.List;

public class UserHibernateDao implements IUserDao {
    @Override
    public void register(User user) {
        System.out.println("Kullanıcı başarı şekilde kayıt edildi.");
    }

    @Override
    public List<User> getAll() {
        List<User> users = new ArrayList<>();
        User user = new User("Ziya", "Gurel", "ziyagurel55@hotmail.com","1234");
        User user2 = new User("ab", "ab", "ziyagurel55@hotmail.com","1234");
        users.add(user);
        users.add(user2);
        return users;
    }

}
