package ar.com.donpepe.awardmanagement.utils;

import java.lang.reflect.ParameterizedType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BaseLogger<T> {
	@SuppressWarnings("unchecked")
	public BaseLogger() {
		Class<T> thisClass = (Class<T>) ((ParameterizedType) getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
		this.logger = LoggerFactory.getLogger(thisClass);
	}

	protected Logger logger;
}
