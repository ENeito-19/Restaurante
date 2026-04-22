# La Cocina de Hector

Plataforma web para gestión de restaurante con menú, ofertas y bebidas.

## Tecnologías

- Java 17
- Spring Boot 2.7.18
- Spring Security
- Spring Data JPA
- Thymeleaf
- H2 Database
- Bootstrap 5

## Ejecución Local

```bash
cd restaurante
mvn spring-boot:run
```

Accede en: http://localhost:8080

## Funcionalidades

- Login/Registro (responsive para móviles)
- Dashboard personalizado
- Menú con categorías: Desayunos, Almuerzos, Cenas
- Sección de Bebidas: Café, Alcohol, Gaseosas, Jugos, Agua
- Ofertas especiales con descuentos
- Diseño mobile-friendly optimizado para iOS y Android
- Footer con "Creador: Hector Navarro"

## Optimizaciones Móviles

- ✅ Diseño responsive con Bootstrap 5
- ✅ Meta tags Open Graph para WhatsApp/Facebook
- ✅ Twitter Cards para Twitter
- ✅ Viewport optimizado para móviles
- ✅ Botones touch-friendly (mínimo 44px de altura)
- ✅ Navegación móvil optimizada
- ✅ Prevenir scroll horizontal en móviles

## Usuarios de prueba

- Usuario: user@restaurante.com / user123

## Despliegue en la Nube (Railway)

La aplicación está configurada para desplegarse en Railway y ser accesible desde dispositivos móviles.

### Pasos para desplegar en Railway:

1. Subir el código a GitHub
2. Crear cuenta en https://railway.app
3. Conectar Railway con GitHub
4. Seleccionar el repositorio
5. Railway detectará automáticamente que es Java/Maven
6. Esperar el despliegue (2-3 minutos)

### Importante - Meta Tags para Redes Sociales

Para que los enlaces compartidos por WhatsApp, Facebook, Twitter, etc. muestren una vista previa atractiva, debes actualizar los meta tags en `src/main/resources/templates/fragments/layout.html` con la URL real de tu aplicación Railway.
