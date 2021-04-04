# JavaPaint
______________
Добавлена возможность добавления плагина фигуры.
Для этого в pom.xml нужно добавить зависимость

        <dependency>
            <groupId>org.example2</groupId>
            <artifactId>Trapezoid</artifactId>
            <version>1.0-SNAPSHOT</version>
            <scope>system</scope>
            <systemPath>${basedir}/src/main/resources/lib/Trapezoid-1.0-SNAPSHOT.jar</systemPath>
        </dependency>

Больше ничего делать не нужно. 

На панели инструментов теперь есть новая кнопка (N в кружочке).
Если дополнительных плагинов нет, она неактивна, если есть - активна.