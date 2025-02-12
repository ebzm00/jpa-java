package io.goorm.model;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "member")
public class Member {

    public Member() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_seq")
    private Long memberSeq;

    @Column(name = "member_name", nullable = false)
    private String memberName;

    private String name;

    @CreationTimestamp
    @Column(name = "create_at")
    private LocalDateTime createAt;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "member_seq") // VIDEO 테이블에 외래키(member_seq) 생성
    private List<Video> videos = new ArrayList<>();// VIDEO 테이블에 외래키(member_seq) 생성

    public Long getMemberSeq() {
        return memberSeq;
    }

    public void setMemberSeq(Long memberSeq) {
        this.memberSeq = memberSeq;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public LocalDateTime getCreateAt() {
        return createAt;
    }

    public void setCreateAt(LocalDateTime createAt) {
        this.createAt = createAt;
    }

    public List<Video> getVideos() {
        return videos;
    }

    public void setVideos(List<Video> videos) {
        this.videos = videos;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
