# hibernate-example
Quite simple Hibernate ORM usage example.

Project have only two entites - Customer and Order.

### Credits

In this project I use [PostgreSQL](https://www.postgresql.org/) 9.5 database, [Google Guava](https://github.com/google/guava) and [Lombok](https://github.com/rzwitserloot/lombok) libraries.

### Errors

When using ```hbm2ddl.auto = create-drop``` strategy, there will be an error in log. [Here](https://forum.hibernate.org/viewtopic.php?f=1&t=1043688) is an explanation of this error.
