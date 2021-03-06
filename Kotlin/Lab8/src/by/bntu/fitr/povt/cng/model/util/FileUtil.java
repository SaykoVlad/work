package by.bntu.fitr.povt.cng.model.util;

import by.bntu.fitr.povt.cng.model.util.logging.ConsoleLogger;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;

import java.io.*;
import java.util.List;

public class FileUtil {

    private static Logger LOGGER = Logger.getLogger(FileUtil.class);

    public static boolean compareFiles(String firstFileName, String secondFileName) {
        File firstFile = new File(firstFileName);
        File secondFile = new File(secondFileName);
        List first = null;
        List second = null;
        try {
            first = FileUtils.readLines(firstFile, "UTF-8");
            second = FileUtils.readLines(secondFile, "UTF-8");
        } catch (IOException e) {
            LOGGER.warn(e.toString());
        }
        assert first != null;
        return first.equals(second);
    }

    public static boolean compareFiles(File firstFile, File secondFile){
        String first = getStringFromFile(firstFile);
        String second = getStringFromFile(secondFile);
        return first.equals(second);
    }

    public static void serialize(Object object, String fileName){
        try(var oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(object);
        } catch (IOException e) {
            LOGGER.warn(e.toString());
//            new ConsoleLogger().logEvent(e.toString());
        }
        LOGGER.debug("object was serialized");
    }

    public static Object deSerialize(String fileName){
        Object obj = null;
        try(var oos = new ObjectInputStream(new FileInputStream(fileName))) {
            obj = oos.readObject();
            LOGGER.debug("object was deSerialized");
        } catch (IOException | ClassNotFoundException e) {
            LOGGER.warn(e.toString());
//            e.printStackTrace();
        }
        return obj;
    }

    private static String getStringFromFile(File file){
        StringBuilder sb = new StringBuilder();
        try (BufferedReader bfr = new BufferedReader(new InputStreamReader(new FileInputStream(file)))){
            String temp;
            while((temp = bfr.readLine())!=null){
                sb.append(temp);
            }
        } catch (IOException e) {
            LOGGER.warn("File " + file.getPath() + " not found");
            //e.printStackTrace();
        }
        return sb.toString();
    }




}
