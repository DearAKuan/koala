package com.yzbubble.koala.infrastructure;

import com.yzbubble.koala.domain.FieldMetadata;

import java.util.List;

public interface PlatformFieldMetadataDao {
    List<FieldMetadata> select(String tableName);
}
