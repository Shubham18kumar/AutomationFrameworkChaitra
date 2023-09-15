package vtiger.GenericUtilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * This class consist of Generic/reusable Methods related to property file
 * 
 * @author ShubhamKashyap
 */
public class PropertyFileUtility {
    /**
     * This method will read data from PropertyFile and return the value to the caller
     *
     * @param propertyFileKey
     * @return
     * @throws IOException
     */
    public String readDataFromPropertyFile(String propertyFileKey) throws IOException {
        FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\CommonData.Properties");
        Properties p = new Properties();
        p.load(fis);
        String value = p.getProperty(propertyFileKey);
        fis.close();    // Close the FileInputStream when done
        return value;
    }
}
