package lotto.domain.winning;

import static lotto.utils.Constants.LOTTO_SIZE;

import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.grade.Grade;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoNumber;
import lotto.error.exception.SizeExceedLottoException;

public class WinningNumbers {

    private final Lotto winningNumbers;

    private final LottoNumber bonusNumber;


    public WinningNumbers(Lotto winningNumbers, LottoNumber bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public static WinningNumbers fromValues(final List<Integer> values, LottoNumber bonusNumber) {
        if (values.size() != LOTTO_SIZE) {
            throw new SizeExceedLottoException(values.size());
        }

        List<LottoNumber> lottoNumbers = values.stream()
            .map(LottoNumber::fromInt)
            .collect(Collectors.toList());
        return new WinningNumbers(new Lotto(lottoNumbers), bonusNumber);
    }

    public Grade confirmWinning(final Lotto lotto) {
        int matchCount = winningNumbers.calculateMatchingLottoCount(lotto);
        boolean hasBonusNumber = lotto.contains(bonusNumber);

        return Grade.from(matchCount, hasBonusNumber);
    }

    public int size() {
        return winningNumbers.size();
    }
}
