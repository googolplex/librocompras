sistema para registrar compras y ventas personales y elaborar 
el libro de compras y ventas, que es necesario para la
presentacion del IVA en la SET
hecho el 01/2017

1. si se puede usar el OJDBC7 y el JDK8 con eclipse neon y openxava 5.6
2. Dar permiso al JAVA8 en el java.policy con la linea

permission javax.management.MBeanTrustPermission "register";
esto evita el warning de la tarea ant para actualizar esquemas

Este sistema esta escrito en OPENXAVA 5.6 con eclipse neon
y el JDK8 

Para que funcione en la intranet de casa debes cambiar el JUNIT2 por el JUNIT
dentro del persistence del openxava. De otro modo no se conecta, data timeout.
Simplemente intercambiar los nombres.

la carpeta openshiftfeliz contiene lo necesario para conectarse
al postgres del openshift 
