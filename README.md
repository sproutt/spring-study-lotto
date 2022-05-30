# 요구사항

- 로또 구입 금액을 입력하면 구입 금액에 해당하는 로또를 발급해야 한다.
- 로또 1장의 가격은 1000원이다.

## 프로그래밍 요구사항

- 모든 기능을 TDD로 구현해 단위 테스트가 존재해야 한다. 단, UI(System.out, System.in) 로직은 제외

## 요구사항 명세

### InputView
- [ ] 구입 금액 입력
- [ ] 당첨 번호 입력

### ResultView
- [ ] 구입한 로또 개수 출력
- [ ] 랜덤 로또 번호 출력
- [ ] 당첨 통계 출력
  - [ ] 일치하는 로또 당첨 번호에 따른 로또 개수 출력
  - [ ] 수익률 출력

### Money
- [X] 입력값에 대한 검증
  - 1000원 이상인가
  - 1000원 단위인가

### LottoNumber
- [X] 입력값에 대한 검증
  - 로또 번호가 1~45사이인가

### Lotto
- [ ] 6개의 로또 당첨 번호를 가짐
  - 로또 리스트 크기가 6인가
- [ ] WinningLotto와 Lotto 비교하는 작업을 통해 일치하는 개수를 알아내는 것

### WinningLotto
- [ ] 로또 당첨 번호 입력값에 대한 검증

### LottoTicket
- [ ] 구입 금액에 따른 개수의 로또를 갖음

### LottoMachine
- [ ] 랜덤 로또 번호 생성
- [ ] Money에 따른 로또 구입 개수 계산

### LottoGame
- [ ] 일치하는 로또 당첨 번호에 따른 로또 개수 계산
- [ ] 수익률 계산

### Rank
- [ ] 로또 번호 일치 개수 반환
- [ ] 보상 반환

### StringParsingUtils
- [ ] `,`을 기준으로 구분