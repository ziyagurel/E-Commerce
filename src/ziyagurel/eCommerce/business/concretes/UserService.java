package ziyagurel.eCommerce.business.concretes;

import ziyagurel.eCommerce.business.abstracts.IUserService;
import ziyagurel.eCommerce.dataAccess.abstracts.IUserDao;
import ziyagurel.eCommerce.entities.concretes.User;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserService implements IUserService {
    private User user;
    private IUserDao userDao;
    private boolean isComplete;

    public UserService(User user, IUserDao userDao) {
        this.user = user;
        this.userDao = userDao;
    }

    @Override
    public boolean validatePassword(String password) {
        return password.length() >= 6;
    }

    @Override
    public boolean validateEmailFormat(String email) {
        String regex = "\\\\b[A-Z0-9._%-]+@[A-Z0-9.-]+\\\\.[A-Z]{2,4}\\\\b";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        if (!matcher.matches()) {
            System.out.println("Eksik Format içermektedir. Tekrar kontrol ediniz.");
            return false;
        } else
            return true;
    }

    @Override
    public boolean validateNameAndLastName(String name, String lastName) {
        String errMessage = "Lutfen ";
        if(name.length() < 2){
            errMessage += "isim";
            if(lastName.length() < 2)
                errMessage += "soyisim";
            errMessage += "alan/alanlarini 2 karakterden uzun giriniz.";
            System.out.println(errMessage);
            return false;
        } else
            return true;
    }

    @Override
    public boolean isThereEmail(String email) {
        for(User user : userDao.getAll()){
            if(user.getEmail().contains(email)){
                System.out.println("Lutfen kullanilmayan e posta yaziniz...");
                return false;
            }
        }
        return true;
    }

    @Override
    public void sendToConfirmMail() {
        if(validatePassword(user.getEmail()) && validateEmailFormat(user.getEmail()) && validateNameAndLastName(user.getName(),user.getLastName())
                && isThereEmail(user.getEmail())){
            System.out.println("Mail adresiniz onaylandı...");
            isComplete = true;
        } else {
            System.out.println("Bilgilerinizi kontrol ediniz...");
        }
    }

    @Override
    public void completedRegister() {
        if (confirmRegisterPage()){
            userDao.register(user);
        } else
            System.out.println("Mail adresiniz doğrulanmadı");
    }

    @Override
    public boolean confirmRegisterPage() {
        return isComplete;
    }
}
