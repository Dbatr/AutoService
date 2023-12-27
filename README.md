# Приложение AutoService

Это приложение на основе Spring Boot управляет автосервисом, предоставляя функционал для работы с механиками, рабочими местами, заданиями, продуктами и ролями пользователей.

## Содержание
- [Контроллеры](#контроллеры)
    - [AssignmentController](#assignmentcontroller)
    - [MechanicController](#mechaniccontroller)
    - [ProductController](#productcontroller)
    - [UserController](#usercontroller)
    - [WorkspaceController](#workspacecontroller)
- [Модели](#модели)
    - [Assignment](#assignment)
    - [Mechanic](#mechanic)
    - [Product](#product)
    - [User](#user)
    - [Workspace](#workspace)
- [Конфигурация Безопасности](#конфигурация-безопасности)
- [Репозитории](#репозитории)
    - [AssignmentRepository](#assignmentrepository)
    - [MechanicRepository](#mechanicrepository)
    - [ProductRepository](#productrepository)
    - [UserRepository](#userrepository)
    - [WorkspaceRepository](#workspacerepository)
- [Сервисы](#сервисы)
    - [AssignmentService](#assignmentservice)
    - [CustomUserDetailsService](#customuserdetailsservice)
    - [MechanicService](#mechanicservice)
    - [ProductService](#productservice)
- [Запуск приложения](#Запуск приложения)
## Контроллеры

### AssignmentController

- **GET /autoservice/assignments**: Получение всех заданий.
- **GET /autoservice/assignments/{assignmentId}**: Получение задания по ID.
- **POST /autoservice/addAssignment**: Добавление нового задания.

### MechanicController

- **GET /autoservice/mechanics**: Получение всех механиков.
- **GET /autoservice/mechanics/{mechanicId}**: Получение механика по ID.
- **PATCH /autoservice/mechanics/{mechanicId}/onDuty/true**: Установка статуса onDuty механика "Да".
- **PATCH /autoservice/mechanics/{mechanicId}/onDuty/false**: Установка статуса onDuty механика "Нет".
- **POST /autoservice/addMechanic**: Добавление нового механика.

### ProductController

- **GET /autoservice/orders**: Получение всех продуктов/заказов.
- **GET /autoservice/orders/{orderId}**: Получение продукта/заказа по ID.
- **PATCH /autoservice/orders/{orderId}/complete**: Пометка продукта/заказа как завершенного.
- **POST /autoservice/addOrder**: Добавление нового продукта/заказа.

### UserController

- **GET /autoservice/users**: Получение всех пользователей.
- **GET /autoservice/users/{userId}**: Получение пользователя по ID.

### WorkspaceController

- **GET /autoservice/workspaces**: Получение всех рабочих мест.
- **GET /autoservice/workspaces/{workspaceId}**: Получение рабочего места по ID.

## Модели

### Assignment

Сущность для хранения информации о заданиях в автосервисе.

### Mechanic

Сущность, описывающая механика в автосервисе.

### Product

Сущность, представляющая продукт/заказ с различными атрибутами.

### User

Сущность, представляющая пользователя с логином, паролем и ролями.

### Workspace

Сущность, представляющая рабочее место с подробностями, такими как доступность и тип работы.

## Конфигурация Безопасности

Конфигурация безопасности управляется в классе `SecurityConfig`.

- **SecurityFilterChain**: Настроен для разрешения доступа к определенным URL-ам без аутентификации.
- **AuthenticationManager**: Настроен для управления аутентификацией с использованием предоставленной AuthenticationConfiguration.
- **PasswordEncoder**: Настроен для использования BCryptPasswordEncoder с силой шифрования 8.

## Репозитории

### AssignmentRepository

Репозиторий для работы с заданиями (assignments). Позволяет получать список заданий для конкретного механика.

### MechanicRepository

Репозиторий для работы с механиками. Предоставляет базовые операции поиска и сохранения механиков.

### ProductRepository

Репозиторий для работы с продуктами (заявками). Позволяет искать продукты по их названию.

### UserRepository

Репозиторий для работы с пользователями. В данном контексте используется для поиска пользователя по его логину.

### WorkspaceRepository

Репозиторий для работы с рабочими местами. Предоставляет базовые операции поиска и сохранения рабочих мест.

## Сервисы
### AssignmentService

Сервис для работы с заданиями. Включает методы для инициализации данных, получения всех заданий, создания нового задания и получения задания по его уникальному идентификатору.

### CustomUserDetailsService

Сервис для работы с пользователями в контексте Spring Security. Реализует интерфейс `UserDetailsService` для загрузки информации о пользователе.

### MechanicService

Сервис для работы с механиками. Включает методы для инициализации данных, получения всех механиков, создания нового механика и обновления статуса onDuty.

### ProductService

Сервис для работы с продуктами (заявками). Включает методы для инициализации данных, получения всех продуктов, создания нового продукта и обновления статуса выполнения.

### UserService

Сервис для работы с пользователями. Включает методы для инициализации данных, получения всех пользователей и получения пользователя по его уникальному идентификатору. Использует `UserRepository` для взаимодействия с базой данных.

### WorkspaceService

Сервис для работы с рабочими местами (подъемниками). Включает методы для инициализации данных, получения информации о рабочем месте по его уникальному идентификатору и получения списка всех рабочих мест. Использует `WorkspaceRepository` для взаимодействия с базой данных.

## AutoServiceApplication

Главный класс Spring Boot приложения. Включает метод `initializeData`, который используется для инициализации тестовых данных при запуске приложения. Зависит от всех вышеперечисленных сервисов.

## Запуск приложения

Для запуска приложения убедитесь, что все зависимости удовлетворены, и выполните метод `main` в классе `AutoServiceApplication`. При первом запуске метод `initializeData` создаст тестовые записи в базе данных.

Необходимо также настроить базу данных в файле `application.properties` перед запуском приложения.

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/autoservice
spring.datasource.username=root
spring.datasource.password=password
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.hibernate.ddl-auto=update