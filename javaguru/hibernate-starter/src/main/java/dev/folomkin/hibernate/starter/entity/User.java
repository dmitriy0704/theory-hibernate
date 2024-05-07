package dev.folomkin.hibernate.starter.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = {"company", "profile","userChats"})
@EqualsAndHashCode(of = "username")
@Builder
@Entity
@Table(name = "users", schema = "public")
public class User {

    @Id
    @GeneratedValue(generator = "user_gen", strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Embedded
    private PersonalInfo personalInfo;

    @Enumerated(EnumType.STRING)
    private Role role;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id")
    private Company company;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Profile profile;

    @Builder.Default
    @OneToMany(mappedBy = "user")
    private List<UsersChat> userChats = new ArrayList<>();

}
