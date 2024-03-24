# 로또
## 진행 방법
* 로또 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

## 기능 요구사항
### LottoNumber
**[기능]**
* 1번부터 45번까지의 숫자를 가질 수 있습니다.

**[테스트]**
* LottoNumber는 1부터 45까지의 범위의 값만 가질수 있습니다
* LottoNumber가 1부터 45의 범위가 아닌 경우 예외가 발생합니다
* 유효한 로또번호를 입력받으면 로또번호를 반환해야합니다
* 자동 생성을 통해 생성된 LottoNumber의 크기는 6이어야 합니다
* createRandomLottoNumbers를 수행해서 생성한 LottoNumbers는 길이가 6인 LottoNumbers를 반환해야한다

### Lotto
**[기능]**
* LottoNumber 6개가 모여 Lotto가 됩니다
* 구매한 로또번호 6개를 가지고 있습니다.

**[테스트]**
* 로또번호는 6개만 가질 수 있습니다
* Lotto는 7개 이상의 LottoNumber를 가질 경우 Exception이 발생한다.
* createAutoLottos는 구매 횟수 만큼 로또번호를 생성해야합니다.
* Lotto는 어떤 LottoNumber가 전달될 경우 LottoNumber가 Lotto에 포함될 경우 참을 반환합니다.
* Lotto는 자신의 크기를 반환합니다.


### WinningNumbers
**[기능]**
* 당첨번호 6개를 가지고 있습니다.
* 로또를 전달받을 경우 로또가 당첨번호인지 확인해줍니다.

**[테스트]**
* WinningNumbers는 당첨번호를 가지고 있다
* 전달 받은 로또번호가 3개가 일치할 경우 4등을 반환합니다.
* 전달 받은 로또번호가 4개가 일치할 경우 3등을 반환합니다.
* 전달 받은 로또번호가 5개가 일치할 경우 2등을 반환합니다
* 전달 받은 로또번호가 7개가 일치할 경우 1등을 반환합니다

### LottoMachine
[기능]
* 구매금액을 전달받아 수행해야할 횟수에 맞게 수행합니다.
* WinningNumbers를 사용하여 Lotto가 WinningNumbers와 같은지 비교합니다
* 3개가 일치할 경우 5,000원의 당첨금을 반환합니다
* 4개가 일치할 경우 50,000원의 당첨금을 반환합니다
* 5개가 일치할 경우 1,500,000 당첨금을 반환합니다
* 6개가 일치할 경우 2,000,000,000 당첨금을 반환합니다

[테스트]
* 구매금액을 전달받아 수행해야할 횟수가 일치하는지 확인해야 합니다.
* 0개가 일치할 경우 0원의 당첨금을 반환합니다
* 1개가 일치할 경우 0원의 당첨금을 반환합니다
* 2개가 일치할 경우 0원의 당첨금을 반환합니다
* 3개가 일치할 경우 5,000원의 당첨금을 반환합니다
* 4개가 일치할 경우 50,000원의 당첨금을 반환합니다
* 5개가 일치할 경우 1,500,000 당첨금을 반환합니다
* 6개가 일치할 경우 2,000,000,000 당첨금을 반환합니다
* LottoMachine은 autoLottos와 WinningNuber를 사용하여 당첨통계(WinningStatistice)를 반환합니다

### PurchaseAmount
**[기능]**
* 구매금액을 의미합니다
* 구매금액은 1000원 단위로만 가능합니다.

**[테스트]**
* 구매금액이 1000원 단위로 생성되어야 합니다
* 구매금액이 1000으로 안나눠지는 경우 예외가 발생해야한다.

### WinningStatistic
**[기능]**
* Grade를 사용하여 각 등수를 카운팅 합니다.
* 수익률을 계산합니다.

**[테스트]**
* WinningStatistic은 Grade를 통해 각 등수를 계산해야합니다.
* WinningStatistic은 수익률을 계산해야 합니다.
* WinningStatistic은 존재하지 않는 Grade를 조회할 경우 예외를 발생합니다.

### Grade
**[기능]**
* 등수를 나타내는 enum입니다.
* 로또를 맞춘 개수를 사용하여 Grade로 변환합니다.

**[테스트]**
* correctingCount(맞춘 개수)가 같을 경우 참을, 아닐 경우 거짓을 반환합니다
* 맞춘 로또 번호 개수가 전달될 경우 Grade로 변경되어야 합니다.

### Input
**[기능]**
* 구매금액을 전달 받아 구매객체에게 값을 전달합니다.

**[테스트]**
* 요구사항으로 인한 테스트 제외

### Output
**[기능]**
* 당첨 결과와 수익률을 전달 받아 출력합니다.

**[테스트]**
* 요구사항으로 인한 테스트 제외
