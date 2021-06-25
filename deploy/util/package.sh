#!/bin/bash

# 请注意
# 本脚本的作用是把本项目编译的结果保存到deploy文件夹中
# 1. 把项目数据库文件拷贝到deploy/db
# 2. 编译internetmedical-admin
# 3. 编译internetmedical-all模块，然后拷贝到deploy/internetmedical

DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" >/dev/null && pwd )"
cd $DIR/../..
internetmedical_HOME=$PWD
echo "internetmedical_HOME $internetmedical_HOME"

# 复制数据库
cat $internetmedical_HOME/internetmedical-db/sql/internetmedical_schema.sql > $internetmedical_HOME/deploy/db/internetmedical.sql
cat $internetmedical_HOME/internetmedical-db/sql/internetmedical_table.sql >> $internetmedical_HOME/deploy/db/internetmedical.sql
cat $internetmedical_HOME/internetmedical-db/sql/internetmedical_data.sql >> $internetmedical_HOME/deploy/db/internetmedical.sql

# 安装阿里node镜像工具
npm install -g cnpm --registry=https://registry.npm.taobao.org

# 打包internetmedical-admin
cd $internetmedical_HOME/internetmedical-admin
cnpm install
cnpm run build:dep

# 打包internetmedical-vue
cd $internetmedical_HOME/internetmedical-vue
cnpm install
cnpm run build:dep

cd $internetmedical_HOME
mvn clean package
cp -f $internetmedical_HOME/internetmedical-all/target/internetmedical-all-*-exec.jar $internetmedical_HOME/deploy/internetmedical/internetmedical.jar