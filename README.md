# “看病不难”互联网医疗平台

## 启动后端
cd internetmedical
mvn install
mvn clean package
java -Dfile.encoding=UTF-8 -jar internetmedical-all/target/internetmedical-all-0.1.0-exec.jar

## 启动管理员前端
npm install -g cnpm --registry=https://registry.npm.taobao.org
cd internetmedical/internetmedical-admin
cnpm install
cnpm run dev

## 启动用户前端
npm install -g cnpm --registry=https://registry.npm.taobao.org
cd internetmedical/internetmedical-vue
cnpm install
cnpm run dev
