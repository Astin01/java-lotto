package lotto.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.ArrayList;
import java.util.List;
import lotto.model.Lotto;

public class InputView {
    public int moneyInput() {
        int money = 0;
        System.out.println("구입금액을 입력해 주세요.");
        try {
            money = Integer.parseInt(readLine().trim());
            isCorrectMoney(money);
        } catch (IllegalArgumentException error) {
            System.out.println("[ERROR] 구입금액은 1,000원 단위로 입력해주세요.");
            moneyInput();
        }
        return money;
    }

    public int calculateLottoNum(int money) {
        int lottoNum = 0;
        try {
            lottoNum = money / 1000;
        } catch (NumberFormatException error) {
            System.out.println("[ERROR] 올바른 형식의 입력값이 아닙니다. 다시 입력해 주십시오.");
        }
        return lottoNum;
    }

    public Lotto answerInput() {
        List<Integer> convertAnswer = new ArrayList<>();
        System.out.println("당첨 번호를 입력해 주세요.");
        Lotto lotto = null;
        try {
            String[] answer = readLine().split(",");
            StringToInt(answer, convertAnswer);
            lotto = new Lotto(convertAnswer);
        } catch (IllegalArgumentException error) {
            System.out.println("[ERROR] 당첨번호는 6자리여야 하며 중복되지 않아야 합니다.");
            answerInput();
        }
        return lotto;
    }

    private void StringToInt(String[] strList, List<Integer> intList) {
        for (String s : strList) {
            intList.add(Integer.valueOf(s));
        }
    }

    public int bonusInput() {
        System.out.println("보너스 번호를 입력해 주세요.");
        return Integer.parseInt(readLine().trim());
    }
}
