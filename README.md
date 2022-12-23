# jees
## Introduction to Jakarta Enterprise Edition - Servlet

### Used technologies
- Apache Tomcat 10.1
- Maven 3
  - See pom.xml for details
- Eclipse 2022-12

### As JDBC resource, access to PostgreSQL is assumed
- _Almost any other RDBMS should do_
- For setup see [hron](https://github.com/egalli64/hron)
- Let Tomcat know how to connect to it
  - The JDBC jar should be placed in Tomcat lib folder
  - Add a resource element in context.xml with name jdbc/hron
    - See META-INF/context.xml for details