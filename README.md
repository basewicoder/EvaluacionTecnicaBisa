# EvaluacionTecnicaBisa
## Entregable

1. **Repositorio en GitHub**:
   [https://github.com/basewicoder/EvaluacionTecnicaBisa]
3. **Reseña de Implementación**: Java es el lenguaje principal, con tecnologías y frameworks detallados en el archivo README.md.

   El proyecto se basa en Java, utilizando el framework Spring Boot en su versión 2.7.17 como base de desarrollo. La aplicación se centra en una evaluación técnica y utiliza diversas tecnologías y dependencias, incluyendo:

    - **Spring Boot Starter Web**: Para el desarrollo de aplicaciones web.
    - **Project Lombok**: Para simplificar el código fuente y reducir la verbosidad.
    - **H2 Database**: Una base de datos en memoria para desarrollo y pruebas.
    - **Spring Boot Starter Data JPA**: Para el acceso a bases de datos relacionales utilizando JPA.
    - **MapStruct**: Para la generación de mapeos entre objetos Java.
    - **Springdoc OpenAPI UI**: Para generar y visualizar la documentación de la API.
      La configuración del proyecto se gestiona mediante Maven y se especifica que la versión de
      `Java utilizada es la 1.8.` Se proporciona también un archivo Dockerfile para facilitar el despliegue de la aplicación en un contenedor.

4. **Archivo Dockerfile** (opcional): Disponible para desplegar la aplicación en un contenedor.


```Dockerfile
# Establecer la imagen base
# Establecer la imagen base
FROM adoptopenjdk/openjdk8:alpine-slim

# Establecer el directorio de trabajo dentro del contenedor
WORKDIR /app

# Copiar el archivo JAR de la aplicación al contenedor
COPY target/exam-0.0.1-SNAPSHOT.jar app.jar

# Exponer el puerto en el que la aplicación se ejecuta dentro del contenedor
EXPOSE 8443

# Comando para ejecutar la aplicación al iniciar el contenedor
CMD ["java", "-jar", "app.jar"]


```

Comandos:

```
# Construir la imagen Docker
docker build -t app_evaluacion .

# Ejecutar el contenedor
docker run -p 8443:8443 app_evaluacion

# Ejecutar el contenedor en segundo plano y mapear el puerto local al puerto 8443 del contenedor
docker run  -d -p 8443:8443 app_evaluacion


```

5. **Documentación de la API** (opcional): Incluida en el repositorio.

En el Enlace se encuentra   la documentación de los Apis(Swagger UI)

**Enlace : [http://localhost:8443/documentation]**

## Opereraciones

**1  Crear Persona**

Endpoint: **localhost:8443/api/v1/persona**
METODO: **POST**

REQUEST
```json
 {
    "nombre": "Juan",
    "apellido": "Pérez González",
    "fechaNacimiento": "2000-01-01",
    "direccion":"Calle los pinos",
    "carnetIdentidad": "123456789"
  }
```
RESPONSE

```JSON
{
	"msg": "Operacion exitosa",
	"code": "00",
	"data": {
		"id": 2,
		"nombre": "Juan",
		"apellido": "Pérez González",
		"fechaNacimiento": "2000-01-01",
		"direccion": "Calle los pinos",
		"carnetIdentidad": "123456789"
	}
}

```

**2 Crear Cliente**

Endpoint: **localhost:8443/api/v1/clientes**
METODO: **POST**

Nota: el endpoint puede crear cliente y persona

REQUEST
```json
 {
  "email": "ejemplo@correo.com",
  "telefono": "123456789",
  "ocupacion": "Desarrollador",
  "estado": "CREADO",
  "persona": {
    "nombre": "Juan",
    "apellido": "Pérez González",
    "fechaNacimiento": "2000-01-01",
    "direccion":"Calle los pinos",
    "carnetIdentidad": "123456789"
  }
}

```
RESPONSE

```JSON
{
	"msg": "Operacion exitosa",
	"code": "00",
	"data": {
		"id": 2,
		"nombre": "Juan",
		"apellido": "Pérez González",
		"fechaNacimiento": "2000-01-01",
		"direccion": "Calle los pinos",
		"carnetIdentidad": "123456789"
	}
}

```


**3  Añadir referencia personal para un cliente**

Endpoint: **localhost:8443/api/v1/clientes/1/referencias**
METODO: **POST**

Nota: el endpoint puede crear cliente y persona

REQUEST
```json
{
  "motivo": "Amigo de la infancia"
}

```
RESPONSE

```JSON
{
	"msg": "Operacion exitosa",
	"code": "00",
	"data": {
		"id": 1,
		"email": "ejemplo@correo.com",
		"telefono": "123456789",
		"ocupacion": "Desarrollador",
		"estado": "ACTIVO",
		"persona": {
			"id": 1,
			"nombre": "Juan",
			"apellido": "Pérez González",
			"fechaNacimiento": "2000-01-01",
			"direccion": "Calle los pinos",
			"carnetIdentidad": "123456789"
		},
		"referencias": [
			{
				"id": 1,
				"motivo": "Amigo de la infancia",
				"clienteID": 1,
				"estado": "00"
			},
		],
		"accesibilidad": null
	}
}

```


**4  Eliminar referencia personal de un cliente**
Endpoint: **localhost:8443/api/v1/clientes/1/referencias?motivo=Ninguna**
METODO: **POST**
REQUEST: N/A

RESPONSE:
```json
{
	"msg": "Operacion exitosa",
	"code": "00",
	"data": {
		"id": 1,
		"email": "ejemplo@correo.com",
		"telefono": "123456789",
		"ocupacion": "Desarrollador",
		"estado": "BLOQUEADO",
		"persona": {
			"id": 1,
			"nombre": "Juan",
			"apellido": "Pérez González",
			"fechaNacimiento": "2000-01-01",
			"direccion": "Calle los pinos",
			"carnetIdentidad": "123456789"
		},
		"referencias": [],
		"accesibilidad": null
	}
}

```

**5  Lista clientes por accesibilidad**

Como se Elimino datos  ya solo quedaría nula

Endpoint: **localhost:8443/api/v1/clientes/accesibilidad**
METODO: **POST**
REQUEST: N/A

**"accesibilidad": "Nula"**
```json
[
	{
		"id": 1,
		"email": "ejemplo@correo.com",
		"telefono": "123456789",
		"ocupacion": "Desarrollador",
		"estado": "BLOQUEADO",
		"persona": {
			"id": 1,
			"nombre": "Juan",
			"apellido": "Pérez González",
			"fechaNacimiento": "2000-01-01",
			"direccion": "Calle los pinos",
			"carnetIdentidad": "123456789"
		},
		"referencias": [],
		"accesibilidad": "Nula"
	}
]

```

Caso accesible Buena :**accesibilidad**

**"accesibilidad": "Regular"**
```json
[
	{
		"id": 1,
		"email": "ejemplo@correo.com",
		"telefono": "123456789",
		"ocupacion": "Desarrollador",
		"estado": "ACTIVO",
		"persona": {
			"id": 1,
			"nombre": "Juan",
			"apellido": "Pérez González",
			"fechaNacimiento": "2000-01-01",
			"direccion": "Calle los pinos",
			"carnetIdentidad": "123456789"
		},
		"referencias": [
			{
				"id": 2,
				"motivo": "Amigo de la infancia",
				"clienteID": 1,
				"estado": "00"
			}
		],
		"accesibilidad": "Regular"
	}
]

```

**"accesibilidad": "Buena"**
```json
[
	{
		"id": 1,
		"email": "ejemplo@correo.com",
		"telefono": "123456789",
		"ocupacion": "Desarrollador",
		"estado": "ACTIVO",
		"persona": {
			"id": 1,
			"nombre": "Juan",
			"apellido": "Pérez González",
			"fechaNacimiento": "2000-01-01",
			"direccion": "Calle los pinos",
			"carnetIdentidad": "123456789"
		},
		"referencias": [
			{
				"id": 3,
				"motivo": "Amigo de la infancia",
				"clienteID": 1,
				"estado": "00"
			},
			{
				"id": 4,
				"motivo": "Amigo de la infancia",
				"clienteID": 1,
				"estado": "00"
			}
		],
		"accesibilidad": "Buena"
	}
]
```