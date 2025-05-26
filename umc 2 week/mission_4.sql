select
    member.name, -- 사용자 닉네임
    member.email, -- 사용자 이메일
    case 
        when member.phone_number is null then '미인증'
        else member.phone_number
    end as phone_number,
    member.point
from member
where member.id = 1; 