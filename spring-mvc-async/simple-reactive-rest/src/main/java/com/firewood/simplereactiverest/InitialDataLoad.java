package com.firewood.simplereactiverest;

import com.firewood.simplereactiverest.notice.domain.Notice;
import com.firewood.simplereactiverest.notice.domain.repository.NoticeRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InitialDataLoad {

    @Bean
    public ApplicationRunner memoDataInit(NoticeRepository noticeRepository) {
        return args -> {
            noticeRepository.save(new Notice("[EBS 직업 유튜브 구독 이벤트 당첨 안내]", "<EBS직업 유튜브 구독 이벤트> 구독 및 댓글 이벤트에 참여해주셔서 감사합니다.\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "이벤트 상품에 당첨되신 분들은 아래와 같습니다."));
            noticeRepository.save(new Notice("EBS 무료 이용 안내", "1. 서비스 대상 및 내용\n" +
                    "1) 서비스 대상 : 기초생활수급자, 국가 유공자, 장애인 각 본인만 해당\n" +
                    "2) 서비스 내용\n" +
                    "가. EBS 방송 VOD/AOD 무료 이용 가능합니다.\n" +
                    "나. 중학 프리미엄 무료 이용 가능합니다.\n" +
                    "다. EBS 명품 공인중개사, 공무원 온라인 강좌 50% 할인됩니다."));
            noticeRepository.save(new Notice("EBS 사이트 시스템 점검 안내 (02월 18일)", "안녕하세요 EBS입니다.\n" +
                    "\n" +
                    "EBS를 이용해 주시는 회원 여러분께 진심으로 감사 드립니다.\n" +
                    "\n" +
                    "EBS 사이트 안정화를 위해 서비스 점검을 아래와 같이 계획하고 있습니다.\n" +
                    "\n" +
                    "서비스 이용에 불편을 드린 점 양해를 부탁드립니다. (일부 일정은 변동될 수 있습니다.)"));
            noticeRepository.save(new Notice(" [공지] EBS 개인정보처리방침 변경 안내", "안녕하세요. EBS입니다.\n" +
                    "\n" +
                    " \n" +
                    "\n" +
                    "EBS 인터넷서비스를 이용해주셔서 감사드리며, 개인정보처리방침 변경에 관한 안내 말씀 드립니다.\n" +
                    "\n" +
                    "EBS는 고객 여러분의 개인정보를 무엇보다 소중하게 처리하고 있으며, 어떤 사안보다 우선하여 안전하게 관리하고 있습니다. 고객 여러분께서는 새롭게 바뀐 개인정보처리방침의 변경사항을 확인하시어 서비스 이용에 참고하시기 바랍니다."));
            noticeRepository.save(new Notice(" 상표권 침해 사업자(주식회사 잡스쿨) 관련 안내", "EBS와 (주)잡스쿨이 공동 추진했던 \"EBS잡스쿨\" 사업은 2018.4. 계약 해지로 인해 중단되었으며, \n" +
                    "\n" +
                    "계약 해지 이후 '잡스쿨' 명칭(EBS잡스쿨, EBS잡스쿨배곧센터, EBS잡스쿨아이 등)으로 추진되는 사업은 EBS에서 추진하는 사업이 아니며, EBS는 이와 무관함을 알려드립니다."));
        };
    }
}
