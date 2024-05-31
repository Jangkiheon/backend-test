package kr.co.polycube.backendtest.controller;

import kr.co.polycube.backendtest.dto.LottoDTO;
import kr.co.polycube.backendtest.dto.LottoResponse;
import kr.co.polycube.backendtest.service.LottoService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * LottoController 클래스 "/lottos" 엔드포인트에 대한 요청을 처리.
 * 로또 번호 생성 요청이 전송되면 해당 요청을 처리하고 응답을 반환.
 */
@RestController
@RequestMapping("/lottos")
public class LottoController {

    private final LottoService lottoService;

    /**
     * LottoController 생성자
     * @param lottoService 로또 서비스 객체
     */
    public LottoController(LottoService lottoService) {
        this.lottoService = lottoService;
    }

    /**
     * "/lottos" 엔드포인트로 POST 요청이 오면 호출.
     * 로또 번호를 생성, 생성된 번호를 LottoResponse 객체로 반환.
     *
     * @return 생성된 로또 번호를 포함한 응답 객체
     */
    @PostMapping
    public LottoResponse generateLottoNumbers() {
        List<Integer> lottoNumbers = lottoService.generateLottoNumbers();
        return new LottoResponse(lottoNumbers);
    }
}
