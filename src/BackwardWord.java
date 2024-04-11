import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//Дано слово из четного числа букв. Поменять местами его
//        половины. Вывести полученную строку в верхнем регистре.
public class BackwardWord {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите слово с четным количеством букв");
        String word = reader.readLine();
        int wordLength = word.length();
        if (wordLength % 2 != 0) {
            System.out.printf("В этом слове %d букв. Оно нечетное",wordLength);
        }else {
            System.out.println(word.substring(wordLength/2).toUpperCase()+word.substring(0,wordLength/2).toUpperCase());
        }
    }
}