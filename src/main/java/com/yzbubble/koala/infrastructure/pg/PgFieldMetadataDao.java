package com.yzbubble.koala.infrastructure.pg;

import com.yzbubble.koala.domain.FieldMetadata;
import com.yzbubble.koala.infrastructure.PlatformFieldMetadataDao;
import com.yzbubble.koala.infrastructure.SqlSessionFactoryHolder;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class PgFieldMetadataDao implements PlatformFieldMetadataDao {
    private SqlSessionFactory sqlSessionFactory = SqlSessionFactoryHolder.getSqlSessionFactory();

    @Override
    public List<FieldMetadata> select(String tableName) {
        SqlSession session = SqlSessionFactoryHolder.getSqlSessionFactory().openSession();
        try {
            PgFieldMetadataMapper pgFieldMetadataMapper = session.getMapper(PgFieldMetadataMapper.class);
            List<FieldMetadata> list = pgFieldMetadataMapper.select(tableName);
            return list;
        } finally {
            session.close();
        }
    }
}
