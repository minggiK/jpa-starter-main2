package com.springboot.audit;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

//Auditable 엔티티클래스를 BaseClass로 정의
//공통적으로 필요한 생성일자, 수정일자를 자동으로 관리하는 기능
@Getter
//Auditiable 클래스를 상속받는 클래스가 Entity로 설정
//테이블에 매핑되지 않고, 상속한 클래스들에서만 컬럼을 상속받아 사용가능
@MappedSuperclass
//엔티티 생명주기 이벤트(생성, 수정, 삭제)에 리스너를 지정함
//해당 클래스가 실행될 수 있도록 관리, 영속성 상태변화도 감지
@EntityListeners(AuditingEntityListener.class)
public class Auditable {

    //엔티티가 처음 저장되는 시간으로 자동 설정
    @CreatedDate
    //name 은 컬럼에 어떻게 매핑될지 정의
    @Column(name = "CREATE_AT", updatable = false)
    private LocalDateTime createdAt;

    //엔티티가 수정되는 시간으로 자동 설정
    @LastModifiedDate
    @Column(name = "LAST_MODIFIED_AT")
    private LocalDateTime modifiedAt;

}
