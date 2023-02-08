# Helloboot

인프런 토비의 스프링 부트 - 이해와 원리 강의노트

인프런 [토비의 스프링 부트 - 이해와 원리] 강의의 예제 코드입니다.

JDK 11, SpringBoot 2.7.6을 사용합니다.

설치 방법과 코드에 대한 설명은 강의를 참고하세요.

SpringBoot 3.0에서 동작하는 예제는 springboot3 브랜치를 참고해주세요.

# 강의노트

## 스프링 부트 소개

스프링 부트는 스프링을 기반으로 실무 환경에 사용 가능한 수준의 독립실행형 애플리케이션을 복잡한 고민 없이 빠르게 작성할 수 있게 도와주는 여러가지 도구의 모음이다.

[스프링부트 학습페이지 공식](https://spring.io/learn)

[스프링의 시작](https://github.com/spring-projects/spring-framework/issues/14521)

## Containerless

- 컨테이너가 없다? => 서버리스라는 뜻
    - 서버설치 및 관리를 하지 않고 서버 애플리케이션을 개발할 수 있다는 뜻
- 컨테이너는?
    - 스프링의 IoC 컨테이너인가? => 서블릿 컨테이너
    - 서블릿 컨테이너를 배우고 설정하는게 아주 어렵다.
- 서블릿 컨테이너에 대한 학습이나 설정을 하지않고 하고 싶다는 뜻

## Opinionated

- 자기주장을 고집하는
- (스프링부트가) 다 정해줄께 일단 개발만 해

## sdkman

java sdk 를 설치/관리해주는 툴 

[https://sdkman.io/](https://sdkman.io/)

## 프로젝트 생성하기

```bash
# springboot cli 시작
$ spring shell
# springboot 프로젝트 만들기
$ init -b 2.7.6 -d web -g tobyspring -j 11 -n helloboot -x helloboot
$ cd helloboot
$ ./gradlew bootRun
```

## Hello API 테스트

HTTP 요청을 만들고 응답을 확인하는데 사용되는 도구

- 웹 브라우저 개발자 도구
- curl
- HTTPie: 추천
  - [https://httpie.io/](https://httpie.io/)
  - 명령어 예시 http -v ":8080/hello?name=Spring"
- Intellij IDEA Ultimate - http request
- Postman API Platform
- JUnit Test
- API 테스트 도구

## HTTP 요청과 응답

- HTTP
  - Request
    - Request Line: Method, Path, HTTP Version
    - Headers
    - Message Body
  - Response
    - Status Line: HTTP Version, Status Code, Status Text
    - Headers
    - Message Body

요청/응답 예시

```text

```