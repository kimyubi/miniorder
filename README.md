# miniorder

스프링 부트로 만든 간단한 상품/주문 API 프로젝트입니다.  
Postman 없이도 바로 확인할 수 있게 Swagger를 붙여뒀고, 도커로도 바로 실행할 수 있게 맞춰뒀습니다.

## 실행 방법

### Docker로 실행

```bash
docker compose up --build
```

실행되면 아래 주소로 들어가면 됩니다.

- Swagger UI: `http://localhost:8080/swagger-ui.html`
- H2 Console: `http://localhost:8080/h2-console`

종료는 아래 명령어로 합니다.

```bash
docker compose down
```

## 빠르게 테스트하는 순서

Swagger UI에 들어가서 아래 순서대로 보면 됩니다.

1. `POST /api/products`로 상품 하나 등록
2. 등록한 상품 ID로 `POST /api/orders` 호출
3. `GET /api/products`
4. `GET /api/orders/{id}`

예시 요청값은 아래처럼 넣으면 됩니다.

상품 생성:

```json
{
  "name": "아메리카노",
  "price": 4500
}
```

주문 생성:

```json
{
  "productId": 1,
  "quantity": 2
}
```

## 사용한 기술

- Java 25
- Spring Boot 4
- Spring Data JPA
- H2 Database
- Springdoc OpenAPI (Swagger UI)
- Gradle
- Docker / Docker Compose

## 참고

- H2는 메모리 DB라서 애플리케이션을 다시 띄우면 데이터는 초기화됩니다.
- 포트는 기본적으로 `8080`을 사용합니다.
