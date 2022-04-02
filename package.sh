./mvnw versions:set -DnewVersion=4.0.10
echo '修改版本号'
./mvnw versions:commit
echo '提交修改'
./mvnw clean install -pl emily-spring-boot-starter -am
echo '#########emily-spring-boot-starter打包完成...'
./mvnw clean install -pl emily-spring-cloud-starter -am
echo '#########emily-spring-cloud-starter打包完成...'
./mvnw clean install -pl emily-spring-boot-datasource -am
echo '#########emily-spring-boot-datasource打包完成...'
./mvnw clean install -pl emily-spring-boot-redis -am
echo '#########emily-spring-boot-redis打包完成...'
./mvnw clean install -pl rpc-spring-boot-server -am
echo '#########rpc-spring-boot-server打包完成...'
./mvnw clean install -pl rpc-spring-boot-client -am
echo '#########rpc-spring-boot-client打包完成...'