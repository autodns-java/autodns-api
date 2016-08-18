package net.h0lg.autodns;

import net.h0lg.autodns.xml.request.model.Auth;

import java.io.IOException;
import java.util.Properties;

public class AutoDnsClient {

	private static final String PROPERTY_USERNAME = "autodns.username";
	private static final String PROPERTY_PASSWORD = "autodns.password";
	private static final String PROPERTY_CONTEXT = "autodns.context";

	private static final String DEFAULT_PROPERTIES_FILE = "autodns.properties";

	private final Auth credentials;
	private final Properties properties;
	private static AutoDnsClient instance;

	private AutoDnsClient(final Properties properties) {
		this.properties = properties;
		this.credentials = collectCredentialsFromProperties();
	}

	private Auth collectCredentialsFromProperties() {
		Auth credentials = new Auth(
				this.properties.getProperty(PROPERTY_USERNAME),
				this.properties.getProperty(PROPERTY_PASSWORD),
				this.properties.getProperty(PROPERTY_CONTEXT)
		);

		return credentials;
	}

	public static AutoDnsClient instance(Properties properties) {
		if (instance == null) {
			instance = new AutoDnsClient(properties);
		}

		return instance;
	}

	public static AutoDnsClient instance() {
		Properties properties = defaultProperties();

		return instance(properties);
	}

	private static Properties defaultProperties() {
		Properties properties = new Properties();

		try {
			properties.load(Thread.currentThread().getContextClassLoader().getResourceAsStream(DEFAULT_PROPERTIES_FILE));
		} catch (IOException ioe) {
			return genericProperties();
		}

		return properties;
	}

	private static Properties genericProperties() {
		Properties properties = new Properties();

		properties.put(PROPERTY_USERNAME, "unknwon");
		properties.put(PROPERTY_PASSWORD, "unknown");
		properties.put(PROPERTY_CONTEXT, "unknown");

		return properties;
	}

	public Auth getCredentials() {
		return credentials;
	}

	public Properties getProperties() {
		return properties;
	}
}
