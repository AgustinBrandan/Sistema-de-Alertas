## Sistema de Alertas
###### IDE utilizado intellij
El codigo se encuentra en src/main
Las pruebas estan realizadas en src/test

### Clases utilizadas 

##### Usuario
Que tiene como atributos nombre,apellido, una lista de alertas y una lista de temas que puede suscribirse para recibir alertas de este tema especifico. Nos permite crear a un usuario
##### Alerta
Clase que tiene como atributo mensaje,expiracion,leido y un tema.
##### Informativa
Clase que extiende de Alerta y nos permite crear alertas informativa que solo la reciben los usuarios que estan subscriptos a esos temas.
##### Urgente
Clase que extiende de Alerta y nos permite crear alertas urgentes que la reciben todo los usuarios sin importar que esten o no subscriptos al tema.
##### Tema
Clase que tiene como atributo tema y nos permite crear un tema.
##### Systemalert
Clase que tiene como atributos una lista de usuarios y una lista de temas.
Nos permite registrar usuarios al sistema, registrar temas al sistemas y una funcion que envia alerta dependiendo si es Informativa o Urgente.

#### Test
Se testearon las principales funcionalidades del programa.

##### UsuarioTest
Se testeo la funcion addalert para verificar que la alerta se agrega la alerta al usuario.

##### SystemalertTest
Se testeo registrar usuario y registrar topico.
Tambien se probo la funcion sendAlertas ya sea enviando una alerta informativa que solo se le envia a los subscripto a ese topico y tambien se probo enviando una alerta urgente que la reciben los dos usuarios.