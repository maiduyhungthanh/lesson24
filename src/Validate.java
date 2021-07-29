import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validate {
    public static final Pattern EmailRegex = Pattern.compile(
            "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$",
            Pattern.CASE_INSENSITIVE);

    public static final Pattern PasswordRegex = Pattern.compile(
            "(?=.*[a-z])(?=.*[A-Z])(?=.*[.,-_;]).{3,15}",
            Pattern.CASE_INSENSITIVE);

    public static String validateEmail(String email) {
        Matcher matcher = EmailRegex.matcher(email);
        if (matcher.find()) {
            return email;
        } else {
            throw new RuntimeException("Email không hợp lệ");
        }
    }

    public static String validatePassword(String password) {
        //Check password, password cần chứa 3 ký tự đến 15 ký tự
        //password chứa ít nhất 1 ký tự in hoa, 1 ký tự đặc biệt (. , - _ ;)
        Matcher matcher = PasswordRegex.matcher(password);
        if (matcher.find()) {
            return password;
        } else {
            throw new RuntimeException("Password cần chứa 3 ký tự đến 15 ký tự, ít nhất 1 chữ hoa, 1 chữ đặc biệt");
        }
    }
    
    public static String validatePassA(String passA) {
        
        Matcher matcher = PasswordRegex.matcher(passA);
        if (matcher.find()) {
            return passA;
        } else {
             throw new RuntimeException("Password cần chứa 3 ký tự đến 15 ký tự, ít nhất 1 chữ hoa, 1 chữ đặc biệt");
           
             
        }
    }
 public static String validateEmailA(String emailA) {
        Matcher matcher = EmailRegex.matcher(emailA);
        if (matcher.find()) {
            return emailA;
        } else {
            throw new RuntimeException("Email không hợp lệ");
        }
    }
}
