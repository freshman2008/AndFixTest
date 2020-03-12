1.手动生成patch
apkpatch.bat -f new.apk -t old.apk -o output -k mytest.jks -p test123456 -a key0 -e test123456

2.AndFix组件化，patch文件是应用启动时通过向后台服务器请求获得