# HIBERUS BANK
Te han involucrado en el nuevo proyecto de Hiberus, llamado "Hiberus Bank". El objetivo de este proyecto es permitir pagar nóminas y que los/as trabajadores/as puedan realizar transferencias inmediatas entre ellos/as.

# Qué se pide
1. Permitir dar de alta a trabajadores/as. Éstos/as tendrán: nombre, apellidos, un salario bruto y un saldo inicial de 0€. No hay control de autorización.
2. Permitir dar de baja a trabajadores/as. No hay control de autorización.
3. Permitir subir (sí, solo subir) el salario a los/as trabajadores/as. No hay control de autorización.
4. Permitir pagar las nóminas a los/as trabajadores/as. Estos pagos deben dejar registro de la fecha de pago (aaaammddThh:mm:ssZ) de la nómina y del importe neto (hay que descontarle un 5,25% de IRPF al salario bruto). Este importe neto, evidentemente, ha de verse reflejado en el saldo del trabajador/a. Las nóminas se pagarán a través de un endpoint parcialmente securizado: es decir, que solo se aceptarán las nóminas que tengan una header {"Authorization": "Gandalf"}.
5. Permitir realizar transferencias inmediatas entre los/as trabajadores/as. No hay control de autorización.
6. Permitir obtener la información de un/a trabajador/a específico/a (nombre, apellidos, salario, saldo, cobros de nómina, transferencias emitidas exitosamente, transferencias recibidas exitosamente). No hay control de autorización.
7. Permitir obtener el listado de pagos de nóminas y de transferencias de todos/as los/as trabajadores/as. No hay control de autorización.
8. Permitir obtener el listado de transferencias que no se han podido realizar (ver Easter Eggs). No hay control de autorización.

# Easter eggs
1. De momento esta aplicación está totalmente abierta a todo el mundo excepto a los "Antonios", que solo podrán cobrar las nóminas. Cualquier transferencia de/para un "Antonio", deberá fallar.
2. Cualquier transferencia de una cifra no-múltiplo de 10€, deberá fallar.
3. Cualquier transferencia cuyo emisor no pueda realizar (por falta de saldo), deberá fallar.

# Aspectos técnicos obligatorios
1. Separar el backend en 2 microservicios como mínimo.
2. Cada microservicio debe tener al menos un 80% de cobertura de instrucciones con los test automáticos.
3. Utilizar los verbos POST, PUT, GET, DELETE correctamente.
4. En los test, las bases de datos tienen que ser H2 y DEBEN "limpiarse" antes de ejecutar cada test.
5. Documentar los endpoints usando Swagger (u Open API 3).
6. Utilizar el patrón Repository (nada de consultas hardcodeadas).
7. Acompañar la solución de una descripción en un SOLUCION.md, incluyendo un diagrama de despliegue en el que se vean los microservicios, los puertos y servicios expuestos por cada uno y las BBDD.

# Aspectos técnicos optativos
1. Desarrollar cada microservicio siguiendo una arquitectura hexagonal.
2. Persistir el contenido de las BBDD en disco entre ejecución y ejecución usando volúmenes de Docker.
3. Implementar clases de no más de 40 líneas (excepto las de test).
4. Implementar métodos de no más de 12 líneas.
5. Utilizar dos SGBD diferentes (si tienes dos microservicios, uno puede guardar la información en un MySQL y otro en un MongoDB, por ejemplo).