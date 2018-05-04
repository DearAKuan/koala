package com.yzbubble.koala;

import com.yzbubble.koala.domain.FieldMetadata;
import com.yzbubble.koala.infrastructure.pg.PgFieldMetadataMapper;
import com.yzbubble.koala.infrastructure.SqlSessionFactoryHolder;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

class PgFieldMetadataMapperTest {
    @org.junit.jupiter.api.Test
    void select() {
        SqlSession session = SqlSessionFactoryHolder.getSqlSessionFactory().openSession();
        try {
            PgFieldMetadataMapper pgFieldMetadataMapper = session.getMapper(PgFieldMetadataMapper.class);
            List<FieldMetadata> list = pgFieldMetadataMapper.select("disaster_sea_condition");
            System.out.println(list);
        } finally {
            session.close();
        }
    }

}