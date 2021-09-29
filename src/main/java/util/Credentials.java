package util;

import java.util.Properties;

/*
Create a class that extends this abstract class and name it Secret
 */
public abstract class Credentials {
    static public void setPass(Properties dbProperties) {
        dbProperties.setProperty("user", "local_r123456");
        dbProperties.setProperty("password", "dagadegijniebepalen!");
    }
}
