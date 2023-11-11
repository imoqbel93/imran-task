package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class CustomPropertiesFile {

    static String projectPath = System.getProperty("user.dir");
    static Properties prop = new Properties();

    public static String getProperties(String country, String module, String key) {
        String value = null;
        try {
            List<String> paths = getListPropertiesFile(country, module);
            for (String path: paths) {
                InputStream input = new FileInputStream(path);
                prop.load(input);
                value = prop.getProperty(key);
                if (value != null) {
                    break;
                }
            }
        } catch (Exception exp) {
            System.out.println(exp.getMessage());
            System.out.println(exp.getCause());
            exp.printStackTrace();
        }
        return value;
    }

    private static List<String> getListPropertiesFile(String country, String moduleName) {
        List<String> listFiles = new ArrayList<>();
        String fileName = projectPath + File.separator + "src"
                + File.separator + "test" + File.separator + "resources"
                + File.separator ;
        File file = new File(fileName);
        File[] subPropModule = file.listFiles();
        for (File modulePath : subPropModule) {
            for (File path: modulePath.listFiles()) {
                String actualModule = path.toString().replace(fileName, "");
                if(actualModule.startsWith(moduleName) && actualModule.contains(country)) {
                    listFiles.add(path.toString());
                }
            }
        }
        return listFiles;
    }
}
