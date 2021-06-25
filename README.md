# “看病不难”互联网医疗平台

## 启动后端
cd litemall
mvn install
mvn clean package
java -Dfile.encoding=UTF-8 -jar litemall-all/target/litemall-all-0.1.0-exec.jar

## 启动管理员前端
npm install -g cnpm --registry=https://registry.npm.taobao.org
cd litemall/litemall-admin
cnpm install
cnpm run dev

## 启动用户前端
npm install -g cnpm --registry=https://registry.npm.taobao.org
cd litemall/litemall-vue
cnpm install
cnpm run dev
