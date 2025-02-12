package io.goorm;

import io.goorm.model.Member;
import io.goorm.service.Jpa;
import io.goorm.service.Jpql;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

//        Jpa jpa = new Jpa();
//        jpa.createMember();

        Jpql jpql = new Jpql();
        jpql.createJpql();

        Member member = new Member();
        member.setMemberName("testUser");

    }

}