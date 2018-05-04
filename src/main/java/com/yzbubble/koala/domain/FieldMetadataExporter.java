package com.yzbubble.koala.domain;

import com.yzbubble.bee.excel.SimpleExcelWriter;
import com.yzbubble.bee.excel.core.ExcelVersionEnum;
import com.yzbubble.koala.infrastructure.PlatformFieldMetadataDao;
import com.yzbubble.koala.infrastructure.PlatformFieldMetadataDaoFactory;

import java.util.*;

public class FieldMetadataExporter {
    private final PlatformFieldMetadataDao platformFieldMetadataDao;

    public FieldMetadataExporter() {
        platformFieldMetadataDao = PlatformFieldMetadataDaoFactory.get();
    }

    public void export(String fullPath, String ... tableNames) {
        ExcelVersionEnum excelVersionEnum = ExcelVersionEnum.parse(fullPath);
        SimpleExcelWriter writer = new SimpleExcelWriter(excelVersionEnum);
        Arrays.stream(tableNames).forEach(item -> {
            List<FieldMetadata> fieldMetadatas = platformFieldMetadataDao.select(item);
            writer.write(item, fieldMetadatas, FieldMetadata.class, new LinkedHashMap<String, String>() {{
                put("name", "名称");
                put("type", "类型");
                put("description", "描述");
                put("notNull", "非空");
            }});
        });
        writer.exportFile(fullPath);
    }
}
