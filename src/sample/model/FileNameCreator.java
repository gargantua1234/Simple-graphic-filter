package sample.model;

/**
 * Created by Arek on 20.01.2017.
 */

public class FileNameCreator {

    public static String createFileName(String input, String type){
        String result;
        int index = input.lastIndexOf('.');
        result = input.substring(0, index);
        result +=  "-" + type;
        result += input.substring(index);

        return result;
    }
}
