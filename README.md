# koala
Koala 是一个使用Excel格式导出数据库表字段定义的工具

## 命令

### 查看帮助文档

```bash
java -jar koala-1.0.jar -h
```

### 查看版本号

```bash
java -jar koala-1.0.jar -v
```

## 配置

### 查看配置文档

```bash
java -jar koala-1.0.jar -h config
```
### 公共配置

```properties
tables=TABLENAME1,TABLENAME2
config:./koala.properties
```

### Postgresql数据库配置

```properties
driver=org.postgresql.Driver
url=jdbc:postgresql://localhost:5432/DBNAME
username=postgres
password=xxx
```
### Mssql数据库配置

```properties
driver=com.microsoft.sqlserver.jdbc.SQLServerDriver
url=jdbc:sqlserver://localhost:1433;databaseName=DBNAME
username=sa
password=xxx
```

## 运行

1. maven 打包。
2. 编写配置文件。默认约定命名为 `koala.properties`，程序会在同一目录自行查找；或者可以通过命令选项 `-c` 另行指定配置地址。
3. 执行如下命令。
```bash
java -jar koala-1.0.jar
```

