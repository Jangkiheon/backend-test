package kr.co.polycube.backendtest.service;

import kr.co.polycube.backendtest.dto.LottoDTO;
import kr.co.polycube.backendtest.dto.WinnerDTO;
import kr.co.polycube.backendtest.entity.Lotto;
import kr.co.polycube.backendtest.entity.Winner;
import kr.co.polycube.backendtest.repository.LottoRepository;
import kr.co.polycube.backendtest.repository.WinnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.hibernate.internal.util.collections.ArrayHelper.contains;

/**
 * LottoService 클래스 로또의 비즈니스 로직을 처리하는 서비스.
 */
@Service
public class LottoService {

    @Autowired
    private LottoRepository lottoRepository;

    @Autowired
    private WinnerRepository winnerRepository;

    /**
     * 로또 번호를 생성하여 반환.
     *
     * @return 생성된 로또 번호 리스트
     */
    public List<Integer> generateLottoNumbers() {
        // 1부터 45까지의 숫자를 리스트에 추가
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= 45; i++) {
            numbers.add(i);
        }

        // 리스트를 섞고, 앞에서 6개의 숫자를 선택하여 반환
        Collections.shuffle(numbers);
        return numbers.subList(0, 6);
    }

    /**
     * 모든 로또 정보를 조회.
     *
     * @return 모든 로또 정보 리스트
     */
    public List<Lotto> findAllLottos() {
        return lottoRepository.findAll();
    }

    /**
     * 당첨자를 선정 후 저장
     *
     * @param winningNumbers 당첨 번호 리스트
     */
    public void selectWinnersAndSave(List<Integer> winningNumbers) {
        // 모든 로또 정보 조회
        List<Lotto> allLottos = findAllLottos();

        // 각 로또에 대해 당첨 여부를 확인하고, 당첨자 정보를 저장
        for (Lotto lotto : allLottos) {
            int rank = calculateRank(lotto, winningNumbers);

            if (rank > 0) {
                Winner winner = new Winner();
                winner.setLottoId(lotto.getId());
                winner.setRank(rank);
                winnerRepository.save(winner);
            }
        }
    }

    /**
     * 로또의 당첨 등수를 계산
     *
     * @param lotto          로또 정보
     * @param winningNumbers 당첨 번호 리스트
     * @return 당첨 등수
     */
    private int calculateRank(Lotto lotto, List<Integer> winningNumbers) {
        // 로또 번호를 리스트로 변환
        List<Integer> lottoNumbers = List.of(
                lotto.getNumber1(),
                lotto.getNumber2(),
                lotto.getNumber3(),
                lotto.getNumber4(),
                lotto.getNumber5(),
                lotto.getNumber6()
        );

        // 당첨 번호와 일치하는 번호의 개수를 세고, 당첨 등수를 반환
        int matchCount = (int) lottoNumbers.stream()
                .filter(winningNumbers::contains)
                .count();

        return switch (matchCount) {
            case 6 -> 1;
            case 5 -> 2;
            case 4 -> 3;
            case 3 -> 4;
            case 2 -> 5;
            default -> 0;
        };
    }
}
