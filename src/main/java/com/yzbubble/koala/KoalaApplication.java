package com.yzbubble.koala;

import com.yzbubble.koala.domain.FieldMetadataExporter;
import com.yzbubble.koala.infrastructure.ConstantPool;
import com.yzbubble.koala.infrastructure.PropertiesHolder;

import java.io.File;
import java.util.*;
import java.util.stream.Collectors;

public class KoalaApplication {
    public static void main(String[] args) {
        Map<String, List<String>> parsedArgs = parseArgs(args);

        if (parsedArgs.containsKey("-h") || parsedArgs.containsKey("--help")) {
            if (parsedArgs.containsKey("-h") && parsedArgs.get("-h").size() > 0) {
                printSpecificHelp(parsedArgs.get("-h").get(0));
            } else if (parsedArgs.containsKey("--help") && parsedArgs.get("--help").size() > 0) {
                printSpecificHelp(parsedArgs.get("--help").get(0));
            } else {
                printHelp();
            }
            return;
        }

        if (parsedArgs.containsKey("-v") || parsedArgs.containsKey("--version")) {
            printVersion();
            return;
        }

        if (parsedArgs.containsKey("--config") && parsedArgs.get("--config").size() > 0) {
            PropertiesHolder.overridePropertiesByFilePath(parsedArgs.get("--config").get(0));
        } else if (parsedArgs.containsKey("-c") && parsedArgs.get("-c").size() > 0) {
            PropertiesHolder.overridePropertiesByFilePath(parsedArgs.get("-c").get(0));
        } else if (PropertiesHolder.getProperty("config") != null) {
            String defaultConfigPath = PropertiesHolder.getProperty("config");
            if (new File(defaultConfigPath).exists()) {
                PropertiesHolder.overridePropertiesByFilePath(defaultConfigPath);
            }
        }

        String outputPath = ConstantPool.DEFAULT_EXCEL_OUTPUT_PATH;
        if (parsedArgs.containsKey("--output") && parsedArgs.get("--output").size() > 0) {
            outputPath = parsedArgs.get("--output").get(0);
        } else if (parsedArgs.containsKey("-o") && parsedArgs.get("-o").size() > 0) {
            outputPath = parsedArgs.get("-o").get(0);
        } else if (PropertiesHolder.getProperty("output") != null){
            outputPath = PropertiesHolder.getProperty("output");
        }

        List<String> tables = new ArrayList<>();
        if (parsedArgs.containsKey("--tables") && parsedArgs.get("--tables").size() > 0) {
            tables.addAll(parsedArgs.get("--tables"));
        } else if (parsedArgs.containsKey("-t") && parsedArgs.get("-t").size() > 0) {
            tables.addAll(parsedArgs.get("-t"));
        } else if (PropertiesHolder.getProperty("tables") != null){
            String strTables = PropertiesHolder.getProperty("tables");
            tables.addAll(Arrays.stream(strTables.split("\\s*,\\s*")).map(x -> x.trim()).collect(Collectors.toList()));
        } else {
            System.out.println("没有指定需要导出的数据表!");
            return;
        }

        new FieldMetadataExporter().export(outputPath, tables.toArray(new String[tables.size()]));
        System.out.println("导出成功");
    }

    private static void printHelp() {
        System.out.println("Usage:");
        System.out.println("\t-c : --config : 指定配置文件");
        System.out.println("\t-o : --output : 指定输出路径");
        System.out.println("\t-t : --tables : 指定要导出的数据表");
        System.out.println("\t-h : --help : 打印帮助文档");
        System.out.println("\t-v : --version : 打印版本号");
        System.out.println("\t-h config : --help config : 打印配置帮助文档");
        System.out.println("Notice:");
        System.out.println("\t- 目前支持Postgresql和Mssql数据库");
        System.out.println("\t- 默认配置文件为执行文件同目录下的koala.properties");
    }

    private static void printSpecificHelp(String phrase) {
        switch (phrase) {
            case "config" :
                System.out.println("Config description:");
                System.out.println("\tdriver : 指定要使用的数据驱动，目前支持Postgresql和Mssql两种数据库,默认值为org.postgresql.Driver");
                System.out.println("\turl : 数据源地址");
                System.out.println("\tusername : 数据源用户名");
                System.out.println("\tpassword : 数据源密码");
                System.out.println("\ttables : 指定要导出的表名,多个以半角逗号分隔");
                System.out.println("\toutput : 指定输出路径,默认值为.\\koala-output.xlsx");
                break;
        }
    }

    private static void printVersion() {
        System.out.println("version:1.0");
    }

    private static Map<String, List<String>> parseArgs(String[] args) {
        Map<String, List<String>> argsMap = new LinkedHashMap<>();

        String lastKey = null;
        for (String item : args) {
            if (item.startsWith("-")) {
                argsMap.put(item, new ArrayList<>());
                lastKey = item;
            } else if (lastKey != null) {
                argsMap.get(lastKey).add(item);
            }
        }

        return argsMap;
    }
}
