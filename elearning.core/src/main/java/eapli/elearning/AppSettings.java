/*
 * Copyright (c) 2013-2021 the original author or authors.
 *
 * MIT License
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and
 * associated documentation files (the "Software"), to deal in the Software without restriction,
 * including without limitation the rights to use, copy, modify, merge, publish, distribute,
 * sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or
 * substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT
 * NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM,
 * DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package eapli.elearning;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * the application settings.
 *
 * @author Paulo Gandra Sousa
 */
public class AppSettings {
    private static final Logger LOGGER = LoggerFactory.getLogger(AppSettings.class);

    private static final String PROPERTIES_RESOURCE = "application.properties";
    private static final String REPOSITORY_FACTORY_KEY = "persistence.repositoryFactory";
    private static final String UI_MENU_LAYOUT_KEY = "ui.menu.layout";
    private static final String PERSISTENCE_UNIT_KEY = "persistence.persistenceUnit";
    private static final String SCHEMA_GENERATION_KEY = "javax.persistence.schema-generation.database.action";
    private static final String HIGH_CALORIES_DISH_LIMIT = "HighCaloriesDishLimit";

    private static final String WEB_DASHBOARD_PORT = "WebDashboardPort";

    private static final String AGV_MANAGER_IP = "AgvManagerIPAddress";
    private static final String AGV_MANAGER_PORT = "AgvManagerPort" ;

    private static final String AGV_DIGITAL_TWIN_IP_1 = "AGVDigitalTwinIPAddress1";
    private static final String AGV_DIGITAL_TWIN_IP_2 = "AGVDigitalTwinIPAddress2";
    private static final String AGV_DIGITAL_TWIN_PORT = "AGVDigitalTwinPort";
    private static final String ORDER_SERVER_IP = "OrderServerIP";

    private final Properties applicationProperties = new Properties();

    public AppSettings() {
        loadProperties();
    }

    private void loadProperties() {
        try (InputStream propertiesStream = this.getClass().getClassLoader()
                .getResourceAsStream(PROPERTIES_RESOURCE)) {
            try {
                System.out.println("a");
                // IOException | ParseException e
            } catch (Exception e) {
                throw new RuntimeException("Import of warehouse failed");
            }
            if (propertiesStream != null) {
                this.applicationProperties.load(propertiesStream);
            } else {
                throw new FileNotFoundException(
                        "property file '" + PROPERTIES_RESOURCE + "' not found in the classpath");
            }
        } catch (final IOException exio) {
            setDefaultProperties();
            LOGGER.warn("Loading default properties", exio);
        }
    }


    // Remover.

    private void setDefaultProperties() {
        this.applicationProperties.setProperty(REPOSITORY_FACTORY_KEY,
                "eapli.base.persistence.jpa.JpaRepositoryFactory");
        this.applicationProperties.setProperty(UI_MENU_LAYOUT_KEY, "horizontal");
        this.applicationProperties.setProperty(PERSISTENCE_UNIT_KEY, "eapli"
                + ".base");
        this.applicationProperties.setProperty(HIGH_CALORIES_DISH_LIMIT, "300");
    }

    public Boolean isMenuLayoutHorizontal() {
        return "horizontal"
                .equalsIgnoreCase(this.applicationProperties.getProperty(UI_MENU_LAYOUT_KEY));
    }

    public String getPersistenceUnitName() {
        return this.applicationProperties.getProperty(PERSISTENCE_UNIT_KEY);
    }

    public String getRepositoryFactory() {
        return this.applicationProperties.getProperty(REPOSITORY_FACTORY_KEY);
    }

    public Integer getHighCaloriesDishLimit() {
        return Integer.valueOf(this.applicationProperties.getProperty(HIGH_CALORIES_DISH_LIMIT));
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    public Map getExtendedPersistenceProperties() {
        final Map ret = new HashMap();
        ret.put(SCHEMA_GENERATION_KEY,
                this.applicationProperties.getProperty(SCHEMA_GENERATION_KEY));
        return ret;
    }

    public String getProperty(final String prop) {
        return this.applicationProperties.getProperty(prop);
    }

    public String getWebDashboardPort(){return this.applicationProperties.getProperty(WEB_DASHBOARD_PORT);}

    public String getAGVManagerIP(){return this.applicationProperties.getProperty(AGV_MANAGER_IP);}

    public int getAgvManagerPort(){return Integer.parseInt(applicationProperties.getProperty(AGV_MANAGER_PORT));}

    public String getFirstAGVDigitalTwinIPAddress() {
        return applicationProperties.getProperty(AGV_DIGITAL_TWIN_IP_1);
    }

    public String getSecondAGVDigitalTwinIPAddress() {
        return applicationProperties.getProperty(AGV_DIGITAL_TWIN_IP_2);
    }

    public String getOrderServerIp(){return applicationProperties.getProperty(ORDER_SERVER_IP);}

    public String getAGVDigitalTwinPort() {
        return applicationProperties.getProperty(AGV_DIGITAL_TWIN_PORT);
    }

}
