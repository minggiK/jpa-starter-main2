package com.springboot.coffee.service;

import com.springboot.coffee.entity.Coffee;
import com.springboot.coffee.repository.CoffeeRepository;
import com.springboot.exception.BusinessLogicException;
import com.springboot.exception.ExceptionCode;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CoffeeService {

    private final CoffeeRepository coffeeRepository;

    public CoffeeService(CoffeeRepository coffeeRepository) {
        this.coffeeRepository = coffeeRepository;
    }

    //1. create
    public Coffee createCoffee(Coffee coffee) {
        //coffeeCode로 중복 여부 확인
        String coffeeCode = coffee.getCoffeeCode().toUpperCase();

        verifyExistCoffee(coffeeCode);
        //새로 등록되면 저장
        return coffeeRepository.save(coffee);
    }

    //2. update
    public Coffee updateCoffee(Coffee coffee) {
        //기존의 coffee가 있는지 coffeeId로 조회
        Coffee findCoffee = findVerifiedCoffeeByQuery(coffee.getCoffeeId());

        //null을 안전하게 처리하면서 조건에 따라 필드를 업데이트
            //Optional -> null을 직접 비교하는 대신, ifPresent() 메서드를 이용해, 값이 있을 때만 동작이 실행
        Optional.ofNullable(coffee.getKorName())
                .ifPresent(korName -> findCoffee.setKorName(korName));
        Optional.ofNullable(coffee.getEngName())
                .ifPresent(engName -> findCoffee.setEngName(engName));
        Optional.ofNullable(coffee.getPrice())
                .ifPresent(price -> findCoffee.setPrice(price));
        Optional.ofNullable(coffee.getCoffeeStatus())
                .ifPresent(coffeeStatus -> findCoffee.setCoffeeStatus(coffeeStatus));

        return coffeeRepository.save(findCoffee);
    }

    //3. get(특정 커피)
    public Coffee findCoffee (long coffeeId) {
        return findVerifiedCoffeeByQuery(coffeeId);
    }

    //4. 전체조회
    public Page<Coffee> findCoffees (int page, int size) {
       return coffeeRepository.findAll(PageRequest.of(page, size,
                Sort.by("coffeeId").descending()));
    }

    //5. 삭제
    public void deleteCoffee(long coffeeId) {
        //coffeeId로 coffee 찾기
        Coffee coffee = findVerifiedCoffeeByQuery(coffeeId);
        coffeeRepository.delete(coffee);
    }

    //1-1. coffeeCode로 coffee 존재여부 조회
    public void verifyExistCoffee(String coffeeCode) {

       Optional<Coffee> coffee = coffeeRepository.findByCoffeeCode(coffeeCode);
       if(coffee.isPresent()) {
           //coffee가 이미 존재한다면, 예외처리
           throw new BusinessLogicException(ExceptionCode.COFFEE_CODE_EXISTS);

       }
    }

    //2-1, 3-1, 5-1 기존의 coffee가 있는지 coffeeId로 확인
    public Coffee findVerifiedCoffeeByQuery(long coffeeId) {
        Optional<Coffee> optional = coffeeRepository.findByCoffee(coffeeId);
        //기존의 coffeeId 없으면 예외처리
        Coffee findCoffee =
                optional.orElseThrow(()-> new BusinessLogicException(ExceptionCode.COFFEE_NOT_FOUND));

        return findCoffee;
    }

}
