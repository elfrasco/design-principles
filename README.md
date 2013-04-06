design-principles
=================

Ejemplos para la charla de Principios de Diseño, que incluye SOLID, GRASP, Inmutabilidad y Closures.

Todos los ejemplos están incluidos en un solo proyecto Maven.

A continuación se especifica, para cada ejemplo:

    * Paquetes: Paquetes involucrados en el ejemplo (en general los paquetes del tipo "before" muestran el código antes de aplicar el principio y los paquetes "after" muestran lo mismo después de haber aplicado el principio)
    * Clase Principal: La clase por la que conviene comenzar a leer el ejemplo
    * Modo de Ejecución: Desde dónde se puede ejecutar (si el ejemplo fue pensado para ejecutarse)
    * Comentarios: Algún comentario adicional que pueda facilitar la comprensión del ejemplo

Ejemplo DRY:
============

    * Paquetes:
        * ar.com.epidataconsulting.principles.dry.before
        * ar.com.epidataconsulting.principles.dry.after
        * ar.com.epidataconsulting.principles.database
        * ar.com.epidataconsulting.principles.model
    * Clase Principal:
        * EmployeeDAO (before & after)
    * Modo de Ejecución:
        * No hace falta ejecutarlo
    * Comentarios:
        * El paquete "database" no es relevante para el ejemplo. Simplemente simula una API Java excesivamente verbosa a una base de datos donde los objetos se guardan como HashMaps. Esta capa de infraestructura fue pensada para usar por los ejemplos y es sólo para fines didácticos.

Ejemplo SRP:
============

    * Paquetes:
        * ar.com.epidataconsulting.principles.srp.before
        * ar.com.epidataconsulting.principles.srp.after
        * ar.com.epidataconsulting.principles.database
        * ar.com.epidataconsulting.principles.model
    * Clase Principal:
        * DAOUtil (before)
        * EmployeeDAO (after)
    * Modo de Ejecución:
        * No hace falta ejecutarlo
    * Comentarios:
        * El paquete "database" no es relevante para el ejemplo. Simplemente simula una API Java excesivamente verbosa a una base de datos donde los objetos se guardan como HashMaps. Esta capa de infraestructura fue pensada para usar por los ejemplos y es sólo para fines didácticos.

Ejemplo OCP:
============

    * Paquetes:
        * ar.com.epidataconsulting.principles.ocp.before
        * ar.com.epidataconsulting.principles.ocp.after
    * Clase Principal:
        * ProjectTest (before & after) - En src/test/java
    * Modo de Ejecución:
        * Se ejecuta desde el JUnit Test ProjectTest.work (before & after) - En src/test/java
    * Comentarios:
        * En este ejemplo lo que se modifica es el modelo, mostrando cómo pasar de un gran switch/case a un modelo polimórfico.

Ejemplo LSP:
============

    * Paquetes:
        * ar.com.epidataconsulting.principles.lsp.before
        * ar.com.epidataconsulting.principles.lsp.after
        * ar.com.epidataconsulting.principles.model2
    * Clase Principal:
        * TheBoss (before & after)
    * Modo de Ejecución:
        * Se ejecuta como Java App desde el mismo main() de las clases TheBoss (before & after)
    * Comentarios:
        * Todo el ejemplo está autocontenido en las clases TheBoss, utilizando el nuevo modelo (model2) mejorado con el principio OCP.

Ejemplo ISP:
============

    * Paquetes:
        * ar.com.epidataconsulting.principles.isp.before
        * ar.com.epidataconsulting.principles.isp.after
        * ar.com.epidataconsulting.principles.model2
    * Clase Principal:
        * Ninguna -> Es un ejemplo de modelo (sin ejecución)
    * Modo de Ejecución:
        * No hace falta ejecutarlo
    * Comentarios:
        * -

Ejemplo IOC:
============

    * Paquetes:
        * ar.com.epidataconsulting.principles.ioc.before
        * ar.com.epidataconsulting.principles.ioc.after
        * ar.com.epidataconsulting.principles.model2
    * Clase Principal:
        * SavePredictiveEngineProjectService (before & after)
    * Modo de Ejecución:
        * Se ejecuta como Java App desde el mismo main() de las clases SavePredictiveEngineProjectService (before & after)
    * Comentarios:
        * Lo más importante que muestra el ejemplo es cómo se invierte el control (en este caso con el uso del contenedor de inyección de dependencia de Spring) a nivel DAO (capa de persistencia). El método save() muestra dos tipos de inversión de control, en el que se trabaja contra interfaces y no contra implementaciones:
            * En el before (antes de aplicar el principio) tenemos que el método save() tiene la responsabilidad de crear el objeto de dominio Project. En el ejemplo after esto evoluciona ya que la clase ahora ya no es responsable de la construcción del objeto, sino una clase Factory (ProjectMockBuilder)
            * En el after (antes de aplicar el principio) tenemos que el método save() tiene la responsabilidad de instanciar explícitamente el objeto DAO que se comunicará con la base de datos. En el ejemplo after esta responsabilidad se delega en Spring, al cual se le solicita el bean llamado "projectDAO". Para hacer más interesante el ejemplo, ProjectDAO se convierte en una interfaz y se proveen dos implementaciones: ProjectHashMapDAO y ProjectHibernateDAO. Tocando el applicationContext.xml podemos variar la implementación de forma declarativa.

Ejemplo DIP:
============

    * Paquetes:
        * ar.com.epidataconsulting.principles.dip.after
        * ar.com.epidataconsulting.principles.model2
    * Clase Principal:
        * SavePredictiveEngineProjectService
    * Modo de Ejecución:
        * Se ejecuta como Java App desde el mismo main() de las clases SavePredictiveEngineProjectService (before & after)
    * Comentarios:
        * Este ejemplo no tiene "before" porque es continuación del anterior de IOC. Podría considerarse como "before" al "after" de IOC.
        * Este ejemplo lleva aún más lejos el uso de Spring mostrando la Inyección de Dependencia con varios ejemplos, inyectando el connectionManager y el projectMapper en el projectDAO, o inyectando el projectDAO en el saveProjectService.
        * Incluso se reemplaza el Factory programático (ProjectMockBuilder) por la Inyección de Dependencia de Spring, construyendo el Project Mock de forma declarativa en el applicationContext.xml e inyectándolo en el saveProjectService.

Ejemplo Inmutability
====================

    * Paquetes:
        * ar.com.epidataconsulting.principles.inmutability
    * Clase Principal:
        * MoneyService
    * Modo de Ejecución:
        * Se ejecuta desde el JUnit MoneyServiceTest (se proveen tres test: sum(), substraction(), differentCurrency()) - En src/test/java
    * Comentarios:
        * En este ejemplo hay dos clases inmutables Money y Currency.

Ejemplo Free-Side Effect Function:
==================================

    * Paquetes:
        * ar.com.epidataconsulting.principles.freesudeeffect.before
        * ar.com.epidataconsulting.principles.freesudeeffect.after
    * Clase Principal:
        * UserValidator
    * Modo de Ejecución:
        * No hace falta ejecutarlo
    * Comentarios:
        * Este ejemplo fue extraído del libro "Clean Code" de Robert C. Martin (Uncle Bob)

Ejemplo Closures:
=================

    * Directorio:
        * src/main/javascript
    * Página Principal:
        * closures.html
    * Modo de Ejecución:
        * Visualizar closures.html en un navegador y seguir los ejemplos.
    * Comentarios:
        * Este html fue extraído de la página: http://web.archive.org/web/20080303020002/http://blog.morrisjohns.com/javascript_closures_for_dummies (Javascript Closures For Dummies)

