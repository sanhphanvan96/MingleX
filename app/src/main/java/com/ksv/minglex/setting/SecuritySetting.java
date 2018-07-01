package com.ksv.minglex.setting;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component("KSVSecuritySetting")
@ConfigurationProperties(prefix = "security")
public class SecuritySetting {
    private Boolean sqlInjection;
    private String storePasswordSolution;

    public Boolean getSqlInjection() {
        return sqlInjection;
    }

    public void setSqlInjection(Boolean sqlInjection) {
        this.sqlInjection = sqlInjection;
    }

    public String getStorePasswordSolution() {
        return storePasswordSolution;
    }

    public void setStorePasswordSolution(String storePasswordSolution) {
        this.storePasswordSolution = storePasswordSolution;
    }

}
