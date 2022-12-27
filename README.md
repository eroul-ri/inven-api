##재고배송서비스팀 채용전형 과제


###1. 개발환경
- Spring Boot 2.6.1 ver
- JDK 8
- H2 Embeded
- data-JPA
- Spring Docs 1.6
- Git

###2. Linux 배포 방법
 **2.1. 준비환경**
 - 선행 : JDK8 설치, Git 설치, 8080 Port 허용
 - 프로젝트 Clone
   - 클론할 위치에서 아래 명령어 실행
     ```
     git clone https://github.com/eroul-ri/inven-api.git
     ```
   - clone한 디렉토리 ROOT 경로에 위치한 ***demo-0.0.1-SNAPSHOT.jar*** 을 배포할 위치로 이동 해주세요.

 **2.2 프로젝트 실행**
 - 아래 명령어로 jar 파일 실행
    ```
    java -jar demo-0.0.1-SNAPSHOT.jar
    ```

###3. API 정보
- Request URL : http://{IP}:8080/api/**
- SWAGGER URL : http://{IP}:8080/swagger-ui/index.html
- Content-Type : application/json
- **공통응답 예시**
```
{
  "code": "0000",
  "message": "성공",
  "contents": {
      "prdNm": "prd-a",
      "optnNm": "opt-aa",
      "prdQnty": 2
    }
}
```

 ####3.1 재고현황조회 API
- Request URL : /api/inven/{상품명}
- Method : GET
- QueryString : optnNm - 옵션명
- **Request Sample**
```
curl -X 'GET'
  'http://localhost:8080/api/inven/prd-a?optnNm=opt-aa'
  -H 'accept: application/json'
```

 ####3.2  재고수량 증가 API
- Request URL : /api/inven/{상품명}/increment
- Method : PUT
- **Request Sample**

```
curl -X 'PUT'
  'http://localhost:8080/api/inven/prd-a/decrement'
  -H 'accept: application/json'
  -H 'Content-Type: application/json'
  -d '{
  "prdNm": "prd-a",
  "optnNm": "opt-aa",
  "prdQnty": 1
}'
```

 ####3.3  재고수량 감소 API
- Request URL : /api/inven/{상품명}/decrement
- Method : PUT
- **Request Sample**

```
curl -X 'PUT'
  'http://localhost:8080/api/inven/prd-a/decrement'
  -H 'accept: application/json'
  -H 'Content-Type: application/json'
  -d '{
  "prdNm": "prd-a",
  "optnNm": "opt-aa",
  "prdQnty": 1
}'
```