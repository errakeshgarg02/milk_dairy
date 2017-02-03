package com.rakesh.milk.dairy.prop;

import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix="milk_dairy.datasource")
public class MyDataSourceProperties extends DataSourceProperties {	

}
