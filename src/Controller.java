import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Controller {

    String name;
    String pass;

    Scanner scanner = new Scanner(System.in);
    List<User> users = new ArrayList<>();

    public void show() {
        users.add(new User(1, "a", "a@gmail.com", "aaa"));
        users.add(new User(2, "b", "b@gmail.com", "bbb"));
        users.add(new User(3, "c", "c@gmail.com", "ccc"));

        for (User s : users) {

        }
    }

    public void welcome() {
        Menu.mainMenu();
        int choose = Integer.parseInt(scanner.nextLine());
        switch (choose) {
            case 1:
                login();
                break;
            case 2:
                createAccount();
                break;
            case 3:
                forgot();
                break;
            default:
                break;
        }
    }

    public void createAccount() {
        Validate vali = new Validate();
        System.out.println("Nhập ID cho tài khoản mới");
        long idA = Integer.valueOf(scanner.nextLine());
        for (User s : users) {
            if (s.getId() == idA) {
                System.out.println("ID đã tồn tại,vui lòng chọn ID khác");
                createAccount();
            }
        }
        System.out.println("Nhập tên Tài khoản mới");
        String nameA = scanner.nextLine();
        for (User s : users) {
            if (s.getUsername().equalsIgnoreCase(nameA)) {
                System.out.println("Tên Tài Khoản đã được sử dụng");
                createAccount();
            }

            System.out.println("Tạo mật khẩu cho tài khoản mới ");
            String passA = vali.validatePassA(scanner.nextLine());

            System.out.println("Tạo email cho tài khoản mới: ");
            String emailA = vali.validateEmailA(scanner.nextLine());

            users.add(new User(idA, nameA, emailA, passA));
            System.out.println("Đăng ký tài khoản thành công");

            welcome();
        }
    }

    public void login() {
        for (User s : users) {
            System.out.println("Nhập tên đăng nhập: ");
            name = scanner.nextLine();

            System.out.println("Nhập mật khẩu: ");
            pass = scanner.nextLine();

            if (s.getUsername().equalsIgnoreCase(name) && s.getPassword().equalsIgnoreCase(pass)) {

                run();
                edit();

                break;
            } else {
                System.out.println("Sai tên Tài khoản hoặc Mật khẩu");
                System.out.println("Đăng nhập lại");
                welcome();
                break;
            }
        }
    }

    public void edit() {
        Menu.Sub();
        int i = Integer.valueOf(scanner.nextLine());

        switch (i) {
            case 1:
                System.out.println("Nhập tên Tài khoản mới");
                String nameA = scanner.nextLine();
                for (User s : users) {
                    if (s.getUsername().equalsIgnoreCase(nameA)) {
                        System.out.println("Tên Tài Khoản đã được sử dụng");
                        edit();
                    }
                }
                System.out.println("Đã thay đổi thông tin");
                edit();
                break;
            case 2:
                System.out.println("Tạo email cho tài khoản mới: ");
                String emailA = Validate.validateEmailA(scanner.nextLine());
                System.out.println("Đã thay đổi thông tin");
                edit();
                break;
            case 3:
                System.out.println("Tạo mật khẩu cho tài khoản mới ");
                String passA = Validate.validatePassA(scanner.nextLine());
                System.out.println("Đã thay đổi thông tin");
                edit();
                break;
            case 4:
                welcome();

            case 0:
                System.exit(0);

        }
    }

    public void run() {
        for (int i = 5; i > 0; i--) {
            System.out.println(i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("CHÚC MỪNG BẠN ĐÃ TỐT NGHIỆP");
    }

    public void forgot() {
        System.out.println("Nhập email đã đăng ký");
        String emailB = scanner.nextLine();
        for (User s : users) {
            if (s.getEmail().equalsIgnoreCase(emailB)) {
                System.out.println("Thông tin TK -  Tên TK: " + s.getUsername() + "-- Password : " + s.getPassword());
                break;
            } else {
                System.out.println("email này chưa đăng ký tài khoản");
                break;
            }
        }
        welcome();
    }

}






    

   

 

