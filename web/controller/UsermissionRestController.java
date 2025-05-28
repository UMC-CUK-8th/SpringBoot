package umcstudy.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import umcstudy.apiPayload.ApiResponse;
import umcstudy.converter.StoreConverter;
import umcstudy.converter.UsermissionConverter;
import umcstudy.service.UsermissionCommandService.UsermissionCommandService;
import umcstudy.study.domain.Missions;
import umcstudy.study.UsermissionService.UsermissionQueryService;
import umcstudy.study.domain.mapping.Usermissions;
import umcstudy.validation.annotation.ExistPage;
import umcstudy.validation.annotation.ExistStore;
import umcstudy.web.dto.MissionRequestDTO;
import umcstudy.web.dto.MissionResponseDTO;
import umcstudy.web.dto.UsermissionResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user-missions")
public class UsermissionRestController {

    private final UsermissionCommandService usermissionCommandService;

    @PatchMapping("/challenge")
    public ApiResponse<MissionResponseDTO.MissionResultDTO> challengeMission(
            @RequestBody @Valid MissionRequestDTO.MissionDto request) {

        MissionResponseDTO.MissionResultDTO resultDTO = usermissionCommandService.visitingStore(request);

        return ApiResponse.onSuccess(resultDTO);
    }

    private final UsermissionQueryService usermissionQueryService;

    @GetMapping("/{storeId}/missions")
    @Operation(summary = "사용자의 진행중인 미션 조회 API",description = "사용자의 진행중인 미션들의 목록을 조회하는 API이며, 페이징을 포함합니다. query String 으로 page 번호를 주세요")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200",description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "acess 토큰 만료",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "acess 토큰 모양이 이상함",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
    @Parameters({
            @Parameter(name = "MemberId", description = "회원의 아이디, path variable 입니다!")
    })
    public ApiResponse<UsermissionResponseDTO.IngMissionPreViewListDTO> getIngMissionList(@PathVariable(name = "MemberId") Long memberId, @ExistPage @RequestParam(name = "page") Integer page){
        Page<Usermissions> ingmissionList = usermissionQueryService.getIngMissionList(memberId,page-1);
        return ApiResponse.onSuccess(UsermissionConverter.ingmissionPreViewListDTO(ingmissionList));
    }
}