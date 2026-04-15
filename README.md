# miniorder

Spring Boot로 만든 간단한 상품/주문 API 과제 프로젝트입니다.

## 실행 전에

가장 편한 방법은 Docker로 실행하는 방식입니다.

## Docker로 실행하는 방법

### 1. 프로젝트 가져오기

터미널에서 원하는 폴더로 먼저 이동한 다음 저장소를 clone 받으면 됩니다.

예시:

```bash
cd Desktop
git clone <여기에-깃허브-저장소-주소>
```

clone이 끝나면 프로젝트 폴더로 들어갑니다.

```bash
cd miniorder
```

윈도우에서 경로 예시로 보면 이런 느낌입니다.

```powershell
cd C:\Users\사용자이름\Desktop
git clone <여기에-깃허브-저장소-주소>
cd miniorder
```

### 2. Docker 실행

`miniorder` 폴더 안에서 아래 명령어를 실행하면 됩니다.

```bash
docker compose up --build
```

중요한 건 `docker-compose.yml` 파일이 있는 경로에서 실행해야 한다는 점입니다.  
즉, `miniorder` 폴더 안에서 실행하면 됩니다.

### 3. 실행 후 접속 주소

애플리케이션이 정상 실행되면 아래 주소로 들어가면 됩니다.

- Swagger UI: `http://localhost:8080/swagger-ui.html`
- H2 Console: `http://localhost:8080/h2-console`

### 4. 종료 방법

실행을 끝내고 싶으면 `Ctrl + C`로 종료하거나, 백그라운드 실행 중이면 아래 명령어를 쓰면 됩니다.

```bash
docker compose down
```

## 빠르게 테스트하는 순서

Swagger UI에 들어가서 아래 순서대로 보면 됩니다.

1. `POST /api/products`로 상품 하나 등록
2. 등록한 상품 ID로 `POST /api/orders` 호출
3. `GET /api/products`로 상품 목록 확인
4. `GET /api/orders/{id}`로 주문 조회

## 예시 요청값

상품 생성 요청:

```json
{
  "name": "아메리카노",
  "price": 4500
}
```

주문 생성 요청:

```json
{
  "productId": 1,
  "quantity": 2
}
```

## 사용 기술

- Java 25
- Spring Boot 4
- Spring Data JPA
- H2 Database
- Springdoc OpenAPI (Swagger UI)
- Gradle
- Docker / Docker Compose

## 참고

- H2는 메모리 DB라서 애플리케이션을 다시 실행하면 데이터는 초기화됩니다.
- 기본 포트는 `8080`입니다.
- 만약 `8080` 포트를 이미 다른 프로그램이 쓰고 있으면 실행이 안 될 수 있습니다.
