재고배송서비스팀 채용전형 과제
=============

 ## 1. 개발환경
- Spring Boot 2.6.1 ver
- JDK 8
- H2 Embeded
- Spring Docs 1.6

 ## 2. API 정보
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

 ### 2.1 재고현황조회 API
- Request URL : /api/inven/{상품명}
- Method : GET
- QueryString : optnNm - 옵션명
- **Request Sample**
```
curl -X 'GET'
  'http://localhost:8080/api/inven/prd-a?optnNm=opt-aa'
  -H 'accept: application/json'
```

 ### 2.2  재고수량 증가 API
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

 ### 2.3  재고수량 감소 API
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
