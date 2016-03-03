package com.zbt.spark;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.zbt.spark.model.Document;

import java.sql.SQLException;

/**
 * Created by Frank Zhang on 16/3/3.
 */
public class ConnectionManager {

    private static Dao<Document,Integer> documentDao;

    public static Dao getDocumentDao() throws SQLException {
        if (documentDao == null) {
            documentDao = DaoManager.createDao(getConnectionSource(),
                    Document.class);
        }
        return documentDao;
    }

    public static ConnectionSource getConnectionSource() throws SQLException {
        String connectionString = "jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=UTF-8";
        ConnectionSource connectionSource = new JdbcConnectionSource(connectionString);
        ((JdbcConnectionSource)connectionSource).setUsername("root");
        ((JdbcConnectionSource)connectionSource).setPassword("");
        return new JdbcConnectionSource(connectionString);
    }
}
