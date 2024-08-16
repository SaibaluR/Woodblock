package utils;

import java.util.Properties;

public class ConfigLoader {
	public static Properties createAccountProperties;
	public static Properties mailproperties;
	public static Properties configProperties;

	/**
	 * To fetch data from Create Account Property file
	 * 
	 * @param key of the property file
	 * @return value of corresponding will be returned
	 */
	public static String getCreateAccountProperty(String key) {
		if (createAccountProperties == null) {
			createAccountProperties = PropertyUtils.propertyLoader("//resources//createAccountConfig.properties");
		}
		return createAccountProperties.getProperty(key);
	}

	/**
	 * To fetch data from Mail Property file
	 * 
	 * @param key of the property file
	 * @return value of corresponding will be returned
	 */
	public static String getMailProperty(String key) {
		if (mailproperties == null) {
			mailproperties = PropertyUtils.propertyLoader("//resources//mailConfig.properties");
		}
		return mailproperties.getProperty(key);
	}

	/**
	 * To fetch data from Configuration Property file
	 * 
	 * @param key of the property file
	 * @return value of corresponding will be returned
	 */
	public static String getConfigProperty(String key) {
		if (configProperties == null) {
			configProperties = PropertyUtils.propertyLoader("//resources//config.properties");
		}
		return configProperties.getProperty(key);
	}

}
