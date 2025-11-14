# Global Solution 2025 — Plataforma de Monitoramento de Bem-Estar e Saúde Mental (API)
## Integrantes
- Eduardo Lima RM554804
- Matheus Hostim RM556517
- Guilherme Ulacco RM558418
## Descrição
API RESTful em Java + Spring Boot para monitoramento de bem-estar e saúde mental. Suporta cadastro de pacientes e registros diários (humor, ansiedade, sono). Projeto alinha-se ao tema "Futuro do Trabalho" e contribui para ODS relacionados à saúde e trabalho decente.

## Tecnologias / Versões usadas no meu ambiente
- **Java:** 21.0.9 (Eclipse Adoptium)
- **Maven:** 3.9.11
- **Spring Boot:** 3.1.4
- Principais dependências: Spring Web, Spring Data JPA, H2, Bean Validation
- Build: Maven

## Como executar localmente (VSCode / linha de comando)
1. Pré-requisitos:
   - Java 21 instalado e `JAVA_HOME` configurado.
   - Maven instalado (`mvn` disponível).
   - VSCode (recomendado) com Extension Pack for Java.

2. Abrir o projeto:
   - Abra a pasta do projeto (`globalsolution`) no VSCode.

3. Compilar e executar:
```bash
mvn clean package
mvn spring-boot:run

A API estará disponível em:
http://localhost:8080

H2 Console 

URL: http://localhost:8080/h2-console

JDBC URL: jdbc:h2:mem:gsdb

Usuário: sa

Senha: (vazia)

Endpoints principais

Base path: /api

Pacientes (CRUD)

GET /api/pacientes — listar todos

GET /api/pacientes/{id} — buscar por id

POST /api/pacientes — criar

PUT /api/pacientes/{id} — atualizar

DELETE /api/pacientes/{id} — remover

{
  "nome": "João Silva",
  "email": "joao.silva@example.com",
  "dataNascimento": "1990-07-21"
}

Registros Diários (CRUD)

GET /api/registros — listar todos

GET /api/registros/{id} — buscar por id

GET /api/registros/paciente/{pacienteId} — listar registros de um paciente

POST /api/registros — criar

PUT /api/registros/{id} — atualizar

DELETE /api/registros/{id} — remover

Payload exemplo (POST / PUT):

{
  "dataRegistro": "2025-11-11T09:00:00",
  "nivelHumor": 4,
  "nivelAnsiedade": 2,
  "horasSono": 6.5,
  "pacienteId": 1
}

Validações implementadas (Bean Validation)

Paciente: nome obrigatório, email obrigatório e formato válido, dataNascimento no passado.

RegistroDiario: dataRegistro obrigatório, nivelHumor e nivelAnsiedade entre 1 e 5, pacienteId obrigatório.

Erros de validação retornam 400 Bad Request com JSON detalhando os campos.

Seeds

Ao iniciar a aplicação o CommandLineRunner cria automaticamente dois pacientes e dois registros para testes.

Testes rápidos (curl — em bash / Linux / macOS / Git Bash)

Listar pacientes:

curl http://localhost:8080/api/pacientes


Criar paciente:

curl -X POST http://localhost:8080/api/pacientes \
  -H "Content-Type: application/json" \
  -d '{"nome":"Test User","email":"test.user@example.com","dataNascimento":"1995-01-01"}'


Criar registro (use um pacienteId existente, ex: 1):

curl -X POST http://localhost:8080/api/registros \
  -H "Content-Type: application/json" \
  -d '{"dataRegistro":"2025-11-11T09:00:00","nivelHumor":4,"nivelAnsiedade":2,"horasSono":6.5,"pacienteId":1}'


Nota: se estiver usando PowerShell (Windows), use Invoke-RestMethod em vez de curl -H ...:

Invoke-RestMethod -Uri "http://localhost:8080/api/pacientes" -Method Post -ContentType "application/json" -Body '{"nome":"Teste","email":"t@ex.com","dataNascimento":"1990-01-01"}'
