# Gestor Credenciales De Eventos 

Estudiantes: Vidente Bravo, Antonio Verdugo

## Problematica

Se nos solicito que realizaramos una pequeña aplicacion en la cual esta aplicacion pudiera clonar credenciales que ingresemos, 
se nos solicito que usaramos el patron singleton en conjunto el patron de diseño prototype, ya que prototype puede clonar datos ingresados
y se nos pidio un diagrama UML, para ser Exactos el diagrama de Clase

## Clonar el Repositorio

Sigue estos pasos para clonar y ejecutar el proyecto en tu equipo local:

1. Abre tu terminal (Git Bash, CMD o PowerShell).
2. Ejecuta el siguiente comando para clonar el repositorio:

   ```bash
   https://github.com/Anthonyo3477/GestorCredencial.git

## Patron Prototype - Aplicado

    public Credencial clone() {
            try {
                return (Credencial) super.clone(); //ACA SE INSTANCIA DE FORMA MAS CLARA
            } catch (CloneNotSupportedException e) {
                return null;
            }
        }
- Prototype: El método clone() crea una copia exacta del objeto actual usando super.clone().

## Patron Singleton - Aplicado

    public static GestorCredenciales getInstancia() {
          if (instancia == null) {
              instancia = new GestorCredenciales();
          }
          return instancia;
      }
- Singleton: El método getInstancia() asegura que solo se cree una única instancia de GestorCredenciales.


## Menu De Consola

    public static void mostrarMenu() {
            int opcion;
            do {
                System.out.println("\n--- Generador de Credenciales ---");
                System.out.println("1. Ver plantilla base");
                System.out.println("2. Crear nueva credencial (desde plantilla)");
                System.out.println("3. Ver todas las credenciales");
                System.out.println("4. Eliminar credencial");
                System.out.println("5. Salir");
                System.out.print("Seleccione una opcion: ");
                opcion = scanner.nextInt();
                scanner.nextLine();
    
                switch (opcion) {
                    case 1:
                        verPlantilla();
                    case 2:
                        crearDesdePlantilla();
                    case 3:
                        GestorCredenciales.getInstancia().listarCredenciales();
                    case 4:
                        eliminarCredencial();
                    case 5:
                        System.out.println("Saliendo...");
                    default:
                        System.out.println("Opción inválida.");
                }
            } while (opcion != 5);
        }



## Diagrama UML 

![diagrama_clases](https://github.com/user-attachments/assets/ad65e445-08bb-46a1-82f5-1a67e7fee934)

Este diagrama representa un sistema generador de credenciales usando dos patrones de diseño:

- Singleton: La clase CredencialGenerator asegura que solo exista una única instancia global para generar credenciales.
 Esto se logra mediante el método getInstance().

- Prototype: La clase abstracta Credencial define el método clonar(),
 que es implementado por sus subclases (CredencialVIP, CredencialStaff, CredencialAsistente) para permitir la clonación de objetos.
 Así, se pueden crear copias personalizadas de una credencial base.

## Captura Del Sistema Funcionand

![image2](https://github.com/user-attachments/assets/3fed0676-7752-4e8a-8992-1aa9c96724f8)
