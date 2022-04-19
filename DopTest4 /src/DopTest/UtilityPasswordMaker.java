package DopTest;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UtilityPasswordMaker {
    public static final int MIN_PASSWORD_LENGTH = 8;

    public static boolean isCorrectPassword(final String password) {
        // password validity check: at least 8 chars length, 1 UppercaseLetter, 1 lowerCase letter, 1 digit, 1 non AlphaOrDigit
        boolean hasUppercaseLetter = false;
        boolean hasLowerCaseLetter = false;
        boolean hasDigit = false;
        boolean hasNonAlphaOrDigit = false;
        boolean result = false;

        if (password.length() > MIN_PASSWORD_LENGTH) {
            for (final Character character : password.toCharArray()) {
                if (Character.isUpperCase(character)) {
                    hasUppercaseLetter = true;
                    break;
                }
            }
            for (final Character character : password.toCharArray()) {
                if (Character.isLowerCase(character)) {
                    hasLowerCaseLetter = true;
                    break;
                }
            }
            for (final Character character : password.toCharArray()) {
                if (Character.isDigit(character)) {
                    hasDigit = true;
                    break;
                }
            }
            for (final Character character : password.toCharArray()) {
                if (!Character.isAlphabetic(character) && !Character.isDigit(character)) {
                    hasNonAlphaOrDigit = true;
                    break;
                }
            }

            if (hasUppercaseLetter && hasLowerCaseLetter && hasDigit && hasNonAlphaOrDigit) result = true;
        }

        return result;
    }

    public static String generatePassword() {
        String password = "";

        // password generation
        final String chars = "!@#$%^&*()_+~`|\\?><";
        final String upperCaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        final String lowerCaseLetters = "abcdefghijklmnopqrstuvwxyz";
        final String digits = "0123456789";
        Random random = new Random();


        for (int i = 0; i < 2; i++) {
            password += chars.charAt(random.nextInt(chars.length()));
            password += upperCaseLetters.charAt(random.nextInt(upperCaseLetters.length()));
            password += lowerCaseLetters.charAt(random.nextInt(lowerCaseLetters.length()));
            password += digits.charAt(random.nextInt(digits.length()));
        }
        // todo chars of the password MANY times to prevent analysis
        //перемешиваю все символы для пароля в переменной char;
        for (String w : chars.split("\\s+")) {
            char[] mix = w.toCharArray();                           //массив для перемешивания;
            for (int i = 1; i < mix.length - 1; ++i) {              //прохожусь по всем символам;
                int j = random.nextInt(mix.length - 2) + 1;  //выбираю рандомный символ;
                char t = mix[i];
                mix[i] = mix[j];
                mix[j] = t;
            }
            System.out.println("Перемешаный пароль: " + new String(mix));} //вывожу перемешанный пароль;
        
            return password;
        }
    }
