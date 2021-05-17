package ziyagurel.eCommerce.business.abstracts;

public interface IUserService {
    boolean validatePassword(String password);
    boolean validateEmailFormat(String email);
    boolean validateNameAndLastName(String name, String lastName);
    boolean isThereEmail(String email);
    boolean confirmRegisterPage();
    void sendToConfirmMail();
    void completedRegister();


}
