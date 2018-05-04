package com.yzbubble.koala.infrastructure.mssql;

import com.yzbubble.koala.domain.FieldMetadata;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MssqlFieldMetadataMapper {
    List<FieldMetadata> select(@Param("tableName") String tableName);
}
