README
===========

Step0: make module dir
----------------

```bash
$ mkdir modules
```

Step1: build jars
----------------

```bash
$ javac -d commons/classes/ -cp commons/src/main/java $(find commons/src/main/java -name "*.java")
$ jar cvf modules/commons.jar -C commons/classes/ .

$ javac -d libs/classes/ -cp "libs/src/main/java/" -p modules/ $(find libs/src/main/java -name "*.java") 
$ jar cvf modules/libs.jar -C libs/classes/ .

javac -d apps/classes/ -cp apps/src/ -p modules $(find apps/src -name "*.java")
jar cvf modules/app.jar -C apps/classes/ .
```

Step2: link modules
------------

```bash
$ jlink --compress=2 --module-path $JAVA_HOME/jmods:modules --add-modules apps --output dist/my-app --launcher myapp=apps/cn.orz.pascal.app.MyApp 
$ ./dist/my-app/bin/myapp
```