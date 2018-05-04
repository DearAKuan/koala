# koala
koala 是一个使用Excel格式导出数据库表字段定义的工具。

## 依赖

- [yzbubble/bee](https://github.com/yzbubble/bee) : bee 是一个包括若干工具类的代码库，旨在加速其他项目的开发。

## 命令

### 查看帮助文档

```bash
java -jar koala-1.0.jar -h
```

### 查看版本号

```bash
java -jar koala-1.0.jar -v
```

### 查看配置文档

```bash
java -jar koala-1.0.jar -h config
```

## 配置

### 公共配置

```
tables=TABLENAME1,TABLENAME2
config:./koala.properties
```

### Postgresql数据库配置

```
driver=org.postgresql.Driver
url=jdbc:postgresql://localhost:5432/DBNAME
username=postgres
password=xxx
```
### Mssql数据库配置

```
driver=com.microsoft.sqlserver.jdbc.SQLServerDriver
url=jdbc:sqlserver://localhost:1433;databaseName=DBNAME
username=sa
password=xxx
```

## 运行

1. maven 安装依赖。(包括手动安装[yzbubble/bee](https://github.com/yzbubble/bee) )
2. maven 打包。
3. 编写配置文件。默认约定命名为 `koala.properties`，程序会在同一目录自行查找；或者可以通过命令选项 `-c` 另行指定配置地址。
4. 执行如下命令。

```bash
java -jar koala-1.0.jar
```

