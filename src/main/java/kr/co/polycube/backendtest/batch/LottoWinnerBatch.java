package kr.co.polycube.backendtest.batch;

import kr.co.polycube.backendtest.service.LottoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * LottoWinnerBatch 클래스는 스케줄러를 사용하여 매주 일요일 0시에 로또 당첨자를 선정하고
 * 저장하는 배치 작업을 수행합니다.
 */
@Component
public class LottoWinnerBatch {

    private final LottoService lottoService;

    /**
     * LottoWinnerBatch 생성자입니다.
     * @param lottoService 로또 서비스 객체
     */
    @Autowired
    public LottoWinnerBatch(LottoService lottoService) {
        this.lottoService = lottoService;
    }

    /**
     * selectWinnersAndSave 메서드는 매주 일요일 0시에 실행,
     * 랜덤하게 로또 번호를 생성 및 당첨자를 선정 후 저장.
     */
    @Scheduled(cron = "0 0 0 * * SUN") // 매주 일요일 0시에 실행
    public void selectWinnersAndSave() {
        List<Integer> winningNumbers = lottoService.generateLottoNumbers();
        lottoService.selectWinnersAndSave(winningNumbers);
    }
}
