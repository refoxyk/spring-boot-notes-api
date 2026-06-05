# Spring Boot Notes API

Simple CRUD REST API for managing notes.

## Features

* Create note
* Get all notes
* Get note by ID
* Update note
* Delete note

## Tech Stack

* Java 21
* Spring Boot
* Spring Data JPA
* PostgreSQL
* Maven
## API Endpoints

Base URL:

```text
http://localhost:8080
```

---

### Create note

Creates a new note.

```http
POST /notes
```

Request body:

```json
{
  "title": "First note",
  "content": "Hello World"
}
```

Example PowerShell request:

```powershell
Invoke-RestMethod `
  -Method POST `
  -Uri "http://localhost:8080/notes" `
  -ContentType "application/json" `
  -Body '{"title":"First note","content":"Hello World"}'
```

Example response:

```json
{
  "id": 1,
  "title": "First note",
  "content": "Hello World",
  "createdDateTime": "2026-06-05T12:52:55.737813",
  "updateDateTime": "2026-06-05T12:52:55.737813"
}
```

---

### Get all notes

Returns all existing notes.

```http
GET /notes
```

Example PowerShell request:

```powershell
Invoke-RestMethod `
  -Method GET `
  -Uri "http://localhost:8080/notes"
```

Example response:

```json
[
  {
    "id": 1,
    "title": "First note",
    "content": "Hello World",
    "createdDateTime": "2026-06-05T12:52:55.737813",
    "updateDateTime": "2026-06-05T12:52:55.737813"
  },
  {
    "id": 2,
    "title": "Second note",
    "content": "Another note",
    "createdDateTime": "2026-06-05T12:53:33.889094",
    "updateDateTime": "2026-06-05T12:53:33.889094"
  }
]
```

---

### Get note by ID

Returns a single note by its ID.

```http
GET /notes/{id}
```

Example:

```http
GET /notes/1
```

Example PowerShell request:

```powershell
Invoke-RestMethod `
  -Method GET `
  -Uri "http://localhost:8080/notes/1"
```

Example response:

```json
{
  "id": 1,
  "title": "First note",
  "content": "Hello World",
  "createdDateTime": "2026-06-05T12:52:55.737813",
  "updateDateTime": "2026-06-05T12:52:55.737813"
}
```

---

### Update note

Updates an existing note by ID.

```http
PUT /notes/{id}
```

Example:

```http
PUT /notes/1
```

Request body:

```json
{
  "title": "Updated title",
  "content": "Updated content"
}
```

Example PowerShell request:

```powershell
Invoke-RestMethod `
  -Method PUT `
  -Uri "http://localhost:8080/notes/1" `
  -ContentType "application/json" `
  -Body '{"title":"Updated title","content":"Updated content"}'
```

Example response:

```json
{
  "id": 1,
  "title": "Updated title",
  "content": "Updated content",
  "createdDateTime": "2026-06-05T12:52:55.737813",
  "updateDateTime": "2026-06-05T13:10:21.112450"
}
```

---

### Delete note

Deletes an existing note by ID.

```http
DELETE /notes/{id}
```

Example:

```http
DELETE /notes/1
```

Example PowerShell request:

```powershell
Invoke-RestMethod `
  -Method DELETE `
  -Uri "http://localhost:8080/notes/1"
```

Example response:

```text
No content
```

After deleting, the note will no longer appear in:

```http
GET /notes
```

## Database Configuration

Environment variables:

```text
DB_USERNAME
DB_PASSWORD
```

Example:

```powershell
$env:DB_USERNAME="postgres"
$env:DB_PASSWORD="your_password"
```

## Run Project

```bash
./mvnw spring-boot:run
```
