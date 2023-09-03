# Video Games Store (E-Commerce Backend)
E-Commerce Rest APIs, Features Games Retrival and Edition, Price Filtering and Category Filtring, User Creation and Authntication using JWT.
Built Using Spring Boot 2.7.15.

## Technologies
- Springboot 2.7.15.
- MySql DataBase.
- Lombok for boilerplate code.
- Json web token.
- spring security.
- Maven for dependacies.

## Features
- Retrieve Games.
- Adding Games.
- Editing Games Data.
- Removing Game.
- Adding Categories.
- Removing Categories.
- Adding Category to Game.
- Registering User.
- Login.
- Token Generation and Authentication.
- Adding Games To user Cart.
- Removing Games From user Cart.
- Adding Games to user Library.

## APIs Documentation

POST
Save Game
`http://localhost:8080/api/v1/games`
﻿
Body
raw (json)
`
{
    "title" : "Middle-earth™: Shadow of Mordor",
    "description" : "Fight through Mordor and uncover the truth of the spirit that compels you, discover the origins of the Rings of Power.",
    "price" : 2.99,
    "coverImage" : "https://cdn.cloudflare.steamstatic.com/steam/apps/241930/header.jpg?t=1633983562",
    "categories" : [
        { "name" : "Open-world" },
        { "name" : "RPG" },
        { "name" : "Single-player" }
    ]
}`


POST
Authenticate
`http://localhost:8080/api/v1/auth/login`
﻿
Body
raw (json)
`
{
    "email" : "abdobebo1998@gmail.com",
    "password" : "123456789"
}`


POST
Register
`http://localhost:8080/api/v1/auth/register`

Body
raw (json)
`
{
   "firstName" : "Abdo",
   "lastName" : "Ayman",
   "userName" : "DizzySkipper",
   "email" : "abdo_2100@gamil.com",
   "password" : "123456"
}`


GET
Get Games
`http://localhost:8080/api/v1/games?minPrice=0&maxPrice=10000`
﻿
Query Params
minPrice
0
maxPrice
10000


GET
Get Users
`http://localhost:8080/api/v1/users/`

Authorization
Bearer Token
Token
<token>


POST
Save Category
`http://localhost:8080/api/v1/categories/`
﻿
Body
raw (json)
`
{
    "name" : "Open-world"
}`


POST
update user Cart
`http://localhost:8080/api/v1/users/cart`
﻿
Authorization
Bearer Token
Body
raw (json)
`
{
    "title" : "Fortnite",
    "description" : "open World Free to play",
    "price" : 20.99,
    "coverImage" : "assets/fortnite.jpg"
}`


POST
Add Category to game
`http://localhost:8080/api/v1/categories/addtogame`

Body
raw (json)
`
{
    "gameTitle" : "Fortnite",
    "categoryName" : "Open-world"
}`


GET
Get Categories
`http://localhost:8080/api/v1/categories`

## Setup
- Download Source code.
- Make Sure Database service is running.
- Edit database settings in `application.properties` file.
- Compile and Run code using `JDK 11`.
 
