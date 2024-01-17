package com.blogesporte.esportes.Repository;

import com.blogesporte.esportes.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
