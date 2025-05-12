package org.example.study.usermissionRepository;



import org.example.study.domain.mapping.Usermissions;
import org.springframework.data.jpa.repository.JpaRepository;


public interface usermissionRepository extends JpaRepository<Usermissions, Long>, usermissionRepositoryCustom {
}