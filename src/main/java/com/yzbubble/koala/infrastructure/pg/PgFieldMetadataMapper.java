package com.yzbubble.koala.infrastructure.pg;

import com.yzbubble.koala.domain.FieldMetadata;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PgFieldMetadataMapper {
    List<FieldMetadata> select(@Param("tableName") String tableName);
}
