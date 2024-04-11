import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//Дано предложение. Необходимо проверить его на наличие
    //    ошибок в буквосочетании « жи » и «ши» и исправить их.
public class MistakeSentence {
    public static void main(String[] args) throws IOException {
        System.out.println("Напиши предложение с жи-ши предлогами, а я проверю ошибки в этом правиле");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        char[] sentence = reader.readLine().toCharArray();
        for (int i=0; i<sentence.length; i++ ) {
            if (sentence[i] == 'ж' || sentence[i] == 'Ж' || sentence[i] == 'ш' || sentence[i] == 'Ш'){
                if (sentence[i+1]=='ы'){
                    System.out.printf("Допущена ошибка - жи и ши пиши с буквой И. %d символ заменен",i+1);
                    System.out.println();
                    sentence[i+1] = 'и';
                }
            }
        }
        String str = String.valueOf(sentence);
        System.out.println(str);

    }
}
