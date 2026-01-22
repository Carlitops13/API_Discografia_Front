# Taylor Frontend - The Eras Collection

Frontend de la discografía de Taylor Swift construido con Spring Boot, Thymeleaf y Tailwind CSS.

## 🚀 Despliegue en Render con Docker

### Requisitos:
- Cuenta en [Render.com](https://render.com)
- Repositorio en GitHub (público)

### Pasos para desplegar:

1. **Push a GitHub**
```bash
git add .
git commit -m "Frontend con Docker para Render"
git push origin main
```

2. **En Render.com:**
   - Click en **"New +"** → **"Web Service"**
   - Selecciona tu repositorio `taylor-frontend`
   - Configura con estos valores:
     - **Name:** `taylor-frontend`
     - **Environment:** `Docker`
     - **Region:** Elige la más cercana
     - **Branch:** `main`
     - **Dockerfile Path:** `./Dockerfile` (automático)

3. **Variables de entorno (opcional):**
   - Ve a **"Environment"** y agrega:
     - `BACKEND_URL` = `https://api-discografia.onrender.com/api/albums`

4. **Deploy:**
   - Click en **"Create Web Service"**
   - Render construirá y desplegará automáticamente

### URL de tu aplicación:
Una vez desplegada, será algo como:
```
https://taylor-frontend-xxx.onrender.com
```

---

## 🏃 Ejecutar localmente

### Con Maven:
```bash
./mvnw spring-boot:run
```

### Con Docker:
```bash
# Construir imagen
docker build -t taylor-frontend .

# Ejecutar contenedor
docker run -p 8080:8080 taylor-frontend
```

Accede a: `http://localhost:8080`

---

## 📋 Características

- ✨ Búsqueda en tiempo real de álbumes
- 🎵 Filtrado por género
- 💜 Sistema de favoritos
- 📱 Diseño responsive con Tailwind CSS
- 🎨 Estilo elegante inspirado en Taylor Swift
- 🔗 Conectado con backend en Render

---

## 📁 Estructura del proyecto

```
src/
├── main/
│   ├── java/
│   │   └── com/swiftie/taylor_frontend/
│   │       ├── controller/
│   │       ├── service/
│   │       ├── model/
│   │       └── config/
│   └── resources/
│       ├── application.properties
│       └── templates/
│           └── albums.html
└── test/
```

---

## 🔧 Configuración

### application.properties
```properties
spring.application.name=swiftie-web
server.port=8080
spring.security.user.name=admin
spring.security.user.password=admin123
```

### Backend URL
La aplicación obtiene los álbumes de:
```
https://api-discografia.onrender.com/api/albums
```

---

## 🛠️ Tecnologías

- **Spring Boot 4.0.0**
- **Thymeleaf** (Motor de plantillas)
- **Tailwind CSS** (Estilos)
- **Java 17**
- **Maven**
- **Docker**

---

## 📝 Licencia

Made with 💜 for Taylor Swift fans
