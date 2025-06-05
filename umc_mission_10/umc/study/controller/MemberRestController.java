package umc.study.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import umc.study.apiPayload.ApiResponse;
import umc.study.converter.MemberConverter;
import umc.study.domain.Member;
import umc.study.domain.mapping.Review;
import umc.study.domain.mapping.UserMissionPointcounter;
import umc.study.dto.member.MemberRequestDTO;
import umc.study.dto.member.MemberResponseDTO;
import umc.study.service.MemberService.MemberCommandService;
import umc.study.service.MemberService.MemberQueryService;
import umc.study.validation.annotation.ExistMembers;
import umc.study.validation.annotation.ZeroBasedPage;

@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
@Validated
public class MemberRestController {

    private final MemberQueryService memberQueryService;
    private final MemberCommandService memberCommandService;

    @PostMapping("/")
    public ApiResponse<MemberResponseDTO.JoinResultDTO> join(@RequestBody @Valid MemberRequestDTO.JoinDto request){
        Member member = memberCommandService.joinMember(request);
        return ApiResponse.onSuccess(MemberConverter.toJoinResultDTO(member));
    }

    @PostMapping("/members/signup")
    public String joinMember(@ModelAttribute("memberJoinDto") MemberRequestDTO.JoinDto request, // 협업시에는 기존 RequestBody 어노테이션을 붙여주시면 됩니다!
                             BindingResult bindingResult,
                             Model model) {

        if (bindingResult.hasErrors()) {
            bindingResult.getAllErrors().forEach(error -> {
                System.out.println("에러: " + error.getDefaultMessage());
            });
            model.addAttribute("memberJoinDto", request);
            return "signup";
        }

        if (bindingResult.hasErrors()) {
            // 뷰에 데이터 바인딩이 실패할 경우 signup 페이지를 유지합니다.
            model.addAttribute("memberJoinDto", request);  // 폼 데이터를 다시 뷰에 전달
            return "signup";
        }


        try {
            memberCommandService.joinMember(request);
            return "redirect:/login";
        } catch (Exception e) {
            // 회원가입 과정에서 에러가 발생할 경우 에러 메시지를 보내고, signup 페이디를 유지합니다.
            e.printStackTrace(); // 로그 찍기
            model.addAttribute("error", e.getMessage());
            model.addAttribute("memberJoinDto", request);  // 에러 시에도 폼 데이터 유지
            return "signup";
        }

    }


    @GetMapping("/{memberId}/reviews")
    @Operation(summary = "특정 회원의 리뷰 목록 조회 API",description = "특정 회원의 리뷰들의 목록을 조회하는 API이며, 페이징을 포함합니다. query String 으로 page 번호를 주세요")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200",description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "acess 토큰 만료",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "acess 토큰 모양이 이상함",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
    @Parameters({
            @Parameter(name = "memberId", description = "회원의 아이디, path variable 입니다!")
    })
    public ApiResponse<MemberResponseDTO.ReviewPreViewListDTO> getReviewList(@ExistMembers @PathVariable(name = "memberId") Long memberId,
                                                                             @ZeroBasedPage Integer page){
        memberQueryService.getReviewList(memberId,page);

        Page<Review> reviewList = memberQueryService.getReviewList(memberId,page);
        return ApiResponse.onSuccess(MemberConverter.reviewPreViewListDTO(reviewList));
    }


    @GetMapping("/{memberId}/challengingMission")
    @Operation(summary = "특정 회원의 진행중인 미션 목록 조회 API",description = "특정 회원의 진행중인 미션 목록을 조회하는 API이며, 페이징을 포함합니다. query String 으로 page 번호를 주세요")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200",description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "acess 토큰 만료",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "acess 토큰 모양이 이상함",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
    @Parameters({
            @Parameter(name = "memberId", description = "회원의 아이디, path variable 입니다!"),
            @Parameter(name = "page", description = "페이지 번호 (1부터 시작)", in = ParameterIn.QUERY, required = true)
    })
    public ApiResponse<MemberResponseDTO.challengingMissionPreViewListDTO> getChallengingMissionList(
            @ExistMembers @PathVariable(name = "memberId") Long memberId,
             /*@RequestParam(name = "page")*/ @ZeroBasedPage Integer page
    ){
        System.out.println("컨트롤러에 들어온 page: " + page);
        memberQueryService.getChallengingMissionList(memberId,page);

        Page<UserMissionPointcounter> challengingMissionList = memberQueryService.getChallengingMissionList(memberId, page);
        return ApiResponse.onSuccess(MemberConverter.challengingMissionPreViewListDTO(challengingMissionList));
    }

}