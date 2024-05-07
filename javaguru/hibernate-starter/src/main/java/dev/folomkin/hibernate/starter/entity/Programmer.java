package dev.folomkin.hibernate.starter.entity;


import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@DiscriminatorValue("programmer")
public class Programmer extends User{
    private Language language;

    @Builder
    public Programmer(
            Long id,
            String username,
            PersonalInfo personalInfo,
            Role role,
            Company company,
            Profile profile,
            List<UsersChat> userChats,
            Language language
    ) {
        super(
                id,
                username,
                personalInfo,
                role,
                company,
                profile,
                userChats);
        this.language = language;
    }
}
