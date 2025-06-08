package umc.study.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import umc.study.apiPayload.ApiResponse;
import umc.study.converter.MarketConverter;
import umc.study.domain.Mission;
import umc.study.domain.mapping.Review;
import umc.study.dto.MarketResponseDTO;
import umc.study.service.MarketService.MarketQueryService;
import umc.study.validation.annotation.ExistMarket;
import umc.study.validation.annotation.ValidPage;

@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping("/markets")
public class MarketMissionRestController {

    private final MarketQueryService marketQueryService;

    @GetMapping("/{marketId}/missions")
    @Operation(summary = "특정 가게의 미션 목록 조회 API", description = "특정 가게의 미션들의 목록을 조회하는 API이며, 페이징을 포함합니다.query String으로 page 번호를 주세요")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200",description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003",description = "access 토큰을 주세요! ", content = @Content(schema = @Schema(implementation = ApiResponse.class)) ),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004",description = "access 토큰 만료",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006",description = "access 토큰 모양이 이상해",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
    @Parameters({
            @Parameter(name="marketId", description = "가게의 아이디, path variable입니다.")
    })

    public ApiResponse<MarketResponseDTO.MissionPreviewListDTO> getMissionList(@ExistMarket @PathVariable(name="marketId") Long marketId,
                                                                               @ValidPage Integer page) {
        Page<Mission> missionList= marketQueryService.getMissionList(marketId, page);
        return ApiResponse.onSuccess(MarketConverter.missionPreviewListDTO(missionList));

    }
}
