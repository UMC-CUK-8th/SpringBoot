package umc.study.converter;

import umc.study.apiPayload.code.status.ErrorStatus;
import umc.study.apiPayload.exception.handler.PreferencesHandler;
import umc.study.domain.enums.Gender;
import umc.study.domain.enums.Statuses;
import umc.study.domain.mapping.UserMissionPointcounter;
import umc.study.dto.usermissionpointcounterDTO.UserMissionPointCounterRequestDTO;
import umc.study.dto.usermissionpointcounterDTO.UserMissionPointCounterResponseDTO;

import java.time.LocalDateTime;

public class UserMissionPointCounterConverter {

    public static UserMissionPointCounterResponseDTO.JoinResultDTO joinResultDTO(UserMissionPointcounter userMissionPointcounter){
        return UserMissionPointCounterResponseDTO.JoinResultDTO.builder()
                .createdAt(LocalDateTime.now())
                .phonenumberMissionid(userMissionPointcounter.getPhonenumberMissionid())
                .build();
    }

    public static UserMissionPointcounter toUserMissionPointCounter(UserMissionPointCounterRequestDTO.JoinDTO request){
        Statuses statuses = null;
        /*// Long -> long -> int 변환 (값이 int 범위 내여야 함)
        //Long타입으로 진행하는 이유는 service에서 findBy를 하기 위함이다.
        long statusesLong = request.getStatuses();
        int statusInt = (int) statusesLong;*/

        switch (request.getStatuses()){
            case 1:
                statuses = Statuses.challenging;
                break;
            case 2:
                statuses = Statuses.completed;
                break;
            case 3:
                statuses = Statuses.nonstart;
                break;
            default: throw new PreferencesHandler(ErrorStatus.STATUSES_CATEGORY_NOT_FOUND);
        }
        return UserMissionPointcounter.builder()
                .status(statuses)
                .build();
    }
}
