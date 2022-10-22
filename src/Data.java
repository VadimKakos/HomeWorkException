public class Data {

    public static final String ALPHABET = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789_";

    public static boolean validate(String login, String password, String confirmPassword) {
        try {
            check(login, password, confirmPassword);
        } catch (WrongPasswordException | WrongLoginException e) {
            return false;
        }
        return true;
    }

    private static void check(String login, String password, String confirmPassword) throws WrongLoginException, WrongPasswordException {
        if (!validate(login)) {
            throw new WrongLoginException("Неверный пароль");
        }
        if (!validate(password)) {
            throw new WrongPasswordException("Некорректный пароль");
        }
        if (!validate(confirmPassword)) {
            throw new WrongPasswordException("Некорректный пароль");
        }
        if (!password.equals(confirmPassword)) {
            throw new WrongPasswordException("неверное подтверждение пароля");

        }

    }

    private static boolean validate(String l) {

        if (l.length() > 20) {
            return false;
        }
        for (int i = 0; i < ALPHABET.length(); i++) {
            if (!ALPHABET.contains(String.valueOf(l.charAt(i)))) {
                return false;
            }
        }
        return true;
    }
}

