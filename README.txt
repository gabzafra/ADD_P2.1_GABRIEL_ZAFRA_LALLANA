repo https://github.com/gabzafra/ADD_P2.1_GABRIEL_ZAFRA_LALLANA

Usuarios precargados

Administrador:
"admin@mail.com","admin"

Usuarios normales:
"adam@mail.com", "aaaa",
"betty@mail.com","bbbb",
"charlie@mail.com","cccc"
"cecil@mail.com","cece"
"diane@mail.com","dddd"
"eric@mail.com", "eeee"

Como ampliación he añadido a la zona de administración un formulario con radiobtns para cambiar el
idioma por defecto y la forma de persistencia de la aplicación. Estos cambios necesitan de un reinicio del
servidor para tener efecto.

Dado que dado el enunciado hay que manejar un buen número de archivos .properties y además he querido
mantener el caché de propiedades he creado una clase PropBundle que permite relacionar cada bundle
con su archivo en el despliegue del servidor para así poder realizar actualizaciones.

Cuando se inicia el servidor un listener ConfigServletContextListener inicializa el servicio de
Configuración ConfigService. Este se encarga de proveer al resto de la aplicación de los valores
de las propiedades almacenadas y de inicializar el Logger, ya sea con un archivo de log4j.properties
o si no con el configurador por defecto.

El listener utiliza el Logger para mostrar por consola la ubicación del despliegue donde se creará
el archivo de logs en \logs\actions.log

En el lado de la persistencia he añadido al modelo User un campo para mantener su preferencia de idioma.
Y he creado una implementación de UserDAO que utiliza el ConectorJDBC para almacenar los datos de
los usuarios en una bd MySQL.

En tanto a los servicios, he actualizado UserService para que guarde logs de las acciones de los usuarios,
y para que use jasypt para encriptar las contraseñas

He añadido un LangService que se encarga de proporcionar localización a los mensajes de error.

PersistenceService solo tiene un método encargado de decidir qué tipo de persistencia se usa dado el
valor de app.persistence
