package com.example.demo.entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Getter
abstract class BaseEntity {

    @CreatedDate //인스턴스가 생성되는 것을 감지하여 현재시간을 저장
    LocalDateTime regDate;

    @LastModifiedDate //인스턴스가 수정되는 것을 감지하여 현재시간을 저장
    LocalDateTime modDate;

}
