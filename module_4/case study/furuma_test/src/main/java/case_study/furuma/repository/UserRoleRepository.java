package case_study.furuma.repository;

import case_study.furuma.entity.AppUser;
import case_study.furuma.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole,Long> {
    List<UserRole>findByAppUser(AppUser appUser);
}
