package com.yzbubble.koala.infrastructure.mssql;

import com.yzbubble.koala.domain.FieldMetadata;
import com.yzbubble.koala.infrastructure.PlatformFieldMetadataDao;
import com.yzbubble.koala.infrastructure.SqlSessionFactoryHolder;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class MssqlFieldMetadataDao implements PlatformFieldMetadataDao {
    private SqlSessionFactory sqlSessionFactory = SqlSessionFactoryHolder.getSqlSessionFactory();

    @Override
    public List<FieldMetadata> select(String tableName) {
        SqlSession session = SqlSessionFactoryHolder.getSqlSessionFactory().openSession();
        try {
            MssqlFieldMetadataMapper mssqlFieldMetadataMapper = session.getMapper(MssqlFieldMetadataMapper.class);
            List<FieldMetadata> list = mssqlFieldMetadataMapper.select(tableName);
            return list;
        } finally {
            session.close();
        }
    }
}
