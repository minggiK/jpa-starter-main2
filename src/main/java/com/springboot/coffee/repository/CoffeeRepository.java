package com.springboot.coffee.repository;


import com.springboot.coffee.entity.Coffee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface CoffeeRepository extends JpaRepository<Coffee, Long> {
    //coffeeCode로 커피 entity를 조회하는 메서드
     //JAP가 메서드 이름 분석하여 적절한 쿼리를 자동으로 생성
      //findBy + 속성명 : 조건(WHERE)추가하여 해당값과 일치하는 것 조회
        //Optional :있을수도 있고 없을 수도 있고,  NPE 방지 -> 없으면 Optional.empty() 반환
    Optional<Coffee> findByCoffeeCode(String coffeeCode);

    //메서드 이름만으로 coffeeId로 쿼리를 작성할 수 없기 때문에 coffeeId로 coffee를 조회하는 쿼리를 명시적으로 지정
    @Query(value = "SELECT c FROM Coffee c WHERE c.coffeeId = : coffeeId")
    //coffeeId로 기존에 등록되어있는 커피 조회
    Optional<Coffee> findByCoffee(long coffeeId);
}
