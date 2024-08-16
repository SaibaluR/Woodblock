package utils;

import java.io.IOException;
import java.io.InputStream;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JacksonUtils {

	public static <T> T deserializeJson(String filePath, Class<T> T) throws IOException {

		// String correctPath = (System.getProperty("user") + filePath);
		ObjectMapper objectMapper = new ObjectMapper();
		InputStream is = JacksonUtils.class.getClassLoader().getResourceAsStream(filePath);
		return objectMapper.readValue(is, T);

	}
}
