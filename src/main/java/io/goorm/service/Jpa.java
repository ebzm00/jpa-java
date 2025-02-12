package io.goorm.service;

import io.goorm.model.Member;
import io.goorm.util.JPAConnectionUtil;
import jakarta.persistence.EntityManager;

public class Jpa {


    public void createMember() {

        EntityManager em  = JPAConnectionUtil.getEntityManager();

        try {
            em.getTransaction().begin();

            Member member = new Member();
            member.setMemberName("testUser");

            em.persist(member);

            //조회 테스트
            System.out.println("##################################before-find");
            Member exsistMember = em.find(Member.class, 3L);
            System.out.println("##################################after-find");

            em.clear();

            System.out.println("##################################before-find2");
            Member exsistMember2 = em.find(Member.class, 3L);
            System.out.println("##################################after-find2");

            // 수정 테스트
            System.out.println("##################################before-update");
            exsistMember.setMemberName("testupdate77777");
            System.out.println("##################################after-update");

            //flush 테스트
            System.out.println("##################################before-flush");
            em.flush();
            System.out.println("##################################after-flush");

//            em.getTransaction().rollback();


            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback(); // 트랜잭션 롤백
            }
            e.printStackTrace(); // 예외 출력
        } finally {
            em.close();
        }

    }
}
