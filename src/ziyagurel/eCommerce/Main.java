package ziyagurel.eCommerce;

import ziyagurel.eCommerce.business.concretes.UserService;
import ziyagurel.eCommerce.core.GoogleAdapter;
import ziyagurel.eCommerce.core.GoogleService;
import ziyagurel.eCommerce.dataAccess.abstracts.IUserDao;
import ziyagurel.eCommerce.dataAccess.concretes.UserHibernateDao;
import ziyagurel.eCommerce.entities.concretes.User;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        User user = new User("Merve","Emir", "merveemirbuyuran@gmail.com","1234");
        User user2 = new User("Ziya","Gürel", "ziyagurel55@hotmail.com","1234");
        User user3 = new User("Ziya","Gürel", "ziyagure.44@hotmail.xyz","1234");
        users.add(user);
        users.add(user2);
        users.add(user3);
        IUserDao dao = new UserHibernateDao();
        for (User item : users){
            UserService service = new UserService(item, dao);
            System.out.println("lütfen kayıt işlemi devamı için " + item.getEmail() + " adresinizden onay işlemini yapınız.");
            service.sendToConfirmMail();
            service.completedRegister();
        }
        User user4 = new User("Cris","Nolan", "crisnolan@windowslive.com","1234");
        GoogleService gservice = new GoogleAdapter();
        gservice.googleWithRegister();
    }
}
