# 요구사항

- 로또 구입 금액을 입력하면 구입 금액에 해당하는 로또를 발급해야 한다.
- 로또 1장의 가격은 1000원이다.

## 프로그래밍 요구사항

- 모든 기능을 TDD로 구현해 단위 테스트가 존재해야 한다. 단, UI(System.out, System.in) 로직은 제외

## 요구사항 명세

### InputView
- [X] 구입 금액 입력
- [X] 당첨 번호 입력
- [X] 수동으로 생성할 로또 개수 입력
- [X] 수동으로 생성할 로또 개수만큼 로또 번호 입력
- [X] 보너스 번호 입력

### OutputView
- [X] 구입한 로또 개수 출력
- [X] 로또 티켓 출력
- [X] 당첨 통계 출력
  - [X] 일치하는 로또 당첨 번호에 따른 로또 개수 출력
  - [X] 수익률 출력

### Money
- [X] 입력값에 대한 검증
  - 1000원 이상인가

### LottoNumber
- [X] 입력값에 대한 검증
  - 로또 번호가 1~45사이인가

### BonusLottoNumber
- [X] 보너스 번호 생성

### Lotto
- [X] 6개의 로또 당첨 번호를 가짐
  - 로또 리스트 크기가 6인가
  - 로또 번호가 몇개 일치하는가 판단
  - 로또 리스트에 중복된 값이 있는가

### WinningLotto
- [X] 로또 당첨 번호 입력값에 대한 검증
  - 로또 리스트 크기가 6인가
  - 로또 리스트에 중복된 값이 있는가
- [X] WinningLotto에 보너스볼이 포함되어있는지 검증

### LottoTicket
- [X] 로또들과 당첨 로또 비교
  - 로또 한줄에 일치하는 로또 번호 개수가 몇개 인지 반환
  - 보너스볼 일치 여부 반환
  - 일치하는 개수에 따른 보상 반환

### LottoGame
- [X] Money에 따른 로또 구입 개수 계산
- [X] 로또 티켓 생성
- [X] 당첨 통계(수익률) 계산
- [] 2등 판정 로직(번호 5개 일치 && 보너스 번호 일치)
- [X] 수동으로 생성한 로또와 자동으로 생성한 로또 관리

### Rank
- [X] 로또 당첨 번호와 일치하는 자동 로또의 등수 및 보너스볼 일치 여부 확인
- [X] 보상 반환

### StringParsingUtils
- [X] `,`을 기준으로 구분

### AutoLottoGenerator
- [X] 랜덤 로또 번호로 이루어진 로또 생성


## 문제상황
1. calculateEarningRatio를 테스트하기 위해서 당첨 통계값이 채워진 상태여야 한다. 
2. 하지만 자동 로또 티켓을 생성하기 때문에 당첨 로또와 자동 로또의 일치 여부를 판단 후 만들어진 통계값은 예상할 수 없다.
3. calculateEarningRatio를 어떻게 테스트해야 할 것 인가?

AS_IS
```java
    public LottoTicket generateLottoTicket() {
        List<Lotto> lottos = new ArrayList<>();
        for(int i = 0; i < lottoCount; i++) {
            lottos.add(AutoLottoGenerator.generate());
        }
        return lottoTicket = new LottoTicket(lottos);
    }
```

TO_BE
```java
public LottoTicket generateAutoLottoTicket() {
        List<Lotto> lottos = new ArrayList<>();
        for(int i = 0; i < lottoCount; i++) {
            lottos.add(AutoLottoGenerator.generate());
        }
        return generateLottoTicket(lottos);
    }
    
    private LottoTicket generateLottoTicket(List<Lotto> lottos) {
        return lottoTicket = new LottoTicket(lottos);
    }
```

private 접근 지정자로 선언된 generateLottoTicket에 Reflection을 통해 접근해서 수행하고, 직접 선언한 List<Lotto>를 채워서 LottoGame 클래스의 로또 티켓을 초기화 시킨다.
테스트를 위한 winningLotto를 생성하고 calcuateRankStatistics를 실행 뒤, calculateEarningRatio를 테스트하면 예상한 기대값으로 테스트가 가능하다.
