package com.yzbubble.koala.infrastructure;

import com.yzbubble.koala.infrastructure.mssql.MssqlFieldMetadataDao;
import com.yzbubble.koala.infrastructure.pg.PgFieldMetadataDao;

import java.util.Objects;

public class PlatformFieldMetadataDaoFactory {
    public static PlatformFieldMetadataDao get() {
        String driver = PropertiesHolder.getProperty("driver");
        Objects.requireNonNull(driver, "数据库驱动\"Driver\"配置不能为空");
        driver = driver.trim();
        switch (driver) {
            case "com.microsoft.sqlserver.jdbc.SQLServerDriver":
                return new MssqlFieldMetadataDao();
            case "org.postgresql.Driver":
                return new PgFieldMetadataDao();
            default:
                throw new RuntimeException(String.format("暂不支持该数据库驱动%s", driver));
        }
    }
}
