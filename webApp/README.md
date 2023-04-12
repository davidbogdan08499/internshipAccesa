In this application user can:
- Login
- Register
- View profile (tokens, personal data, badges)
- Create a quest
- View live quests based on his ranking

To access the project please go to: http://localhost:8082/

If you do not have an account you can use the predefined credentials:
  - User:admin & Password:admin

If you want to create an account you can use registration flow.

Application has 4 different user statuses based on their tokens:
- Enthusiast - 50->75
- Discoverer - 80->95
- Influencer - 100->115
- Champion - 120->135

Minimum badge required to create quests is influencer.
The current user status can be seen in his profile.

Database configuration:

spring.datasource.url=jdbc:mysql://localhost:3306/test
spring.datasource.username=root
spring.datasource.password=root
server.port=8082

From application.properties you can change them.

The database exported scripts can be seen in /db-scripts dir. On your local environment please import them before using the application.

