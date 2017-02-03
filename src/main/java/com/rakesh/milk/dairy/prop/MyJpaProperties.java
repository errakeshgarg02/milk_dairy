package com.rakesh.milk.dairy.prop;

import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 
 * @author rakesh.kumar
 *
 */
@ConfigurationProperties(prefix="milk_dairy.jpa")
public class MyJpaProperties extends JpaProperties{
	
	private String packageToScan;
	private String hbm2ddlAuto;
	
	public String getPackageToScan() {
		return packageToScan;
	}

	public void setPackageToScan(String packageToScan) {
		this.packageToScan = packageToScan;
	}

	public String getHbm2ddlAuto() {
		return hbm2ddlAuto;
	}

	public void setHbm2ddlAuto(String hbm2ddlAuto) {
		this.hbm2ddlAuto = hbm2ddlAuto;
	}
	

}
